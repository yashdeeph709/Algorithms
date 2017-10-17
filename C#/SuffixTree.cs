/////////////////////////////////////////////////////////////////////
//      File Name          : SuffixTree.cs
//      Created            : 28 8 2013   20:54
//      Author             : Costin S
//
/////////////////////////////////////////////////////////////////////
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Text;

namespace TextIndexing
{
    using Dictionary = Dictionary<char, ISuffixNode>;
    using SortedList = SortedList<char, ISuffixNode>;
    using SortedDictionary = SortedDictionary<char, ISuffixNode>;

    public interface IEdgeLabel
    {
        int Start 
        { get; }

        int End 
        { get; }
    }

    public interface ISuffixTree
    {
        #region Properties

        string Text 
        { get; }

        ISuffixNode Root 
        { get; }

        #endregion

        #region Methods

        bool Contains(string text);
        bool Search(string text, out List<int> matchList);

        #endregion
    }

    public interface ISuffixNode
    {
        #region Properties

        ISuffixNode Link
        { get; }

        ISuffixNode Parent
        { get; }

        IDictionary<char, ISuffixNode> Children
        { get; }

        IEdgeLabel Edge
        { get; }

        bool IsLeaf
        { get; }

        int LeafNumber
        { get; }

        #endregion
    }

    /// <summary>
    /// Ukkonen's O(n) online suffix tree construction.
    /// </summary>
    public class SuffixTree
    {
        #region C'tor
        
        private SuffixTree()
        {
        }

        #endregion

        #region Public Methods

        /// <summary>
        /// Creates a suffix tree for the given text.
        /// Make sure the last character in 'text' is unique; im using $..
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="text">The text.</param>
        /// <returns>if the argument 'text' is empty or null string, function returns null !!</returns>
        public static ISuffixTree Create<T>(string text)
            where T : IDictionary<char, ISuffixNode>, new()
        {
            return SuffixTreeImpl<T>.Create(text);
        }

        /// <summary>
        /// Creates a suffix tree for the given text. 
        /// Make sure the last character in 'text' is unique; im using $..
        /// </summary>
        /// <param name="text">The text.</param>
        /// <returns>if the argument 'text' is empty or null string, function returns null !!</returns>
        public static ISuffixTree Create(string text)
        {
            return SuffixTreeImpl<Dictionary>.Create(text);
        }

        #endregion

        #region Nested Classes

        /// <summary>
        /// Algorithm implementation, parameterized on the collection used to store a node's children.. 
        /// Options other than the Dictionary, SortedDictionary and SortedList considered here do exist!
        /// </summary>
        /// <typeparam name="ChildrenCollectionType">The children collection type.</typeparam>
        private class SuffixTreeImpl<ChildrenCollectionType> : ISuffixTree
            where ChildrenCollectionType : IDictionary<char, ISuffixNode>, new()
        {
            #region Fields

            private SuffixNode theRoot;

            #endregion

            #region C'tor

            private SuffixTreeImpl()
            {
                this.theRoot = new SuffixNode() { Parent = null };
            }

            #endregion

            #region Properties

            public string Text
            { get; private set; }

            private int CurrentPhase
            { get; set; }

            public ISuffixNode Root
            {
                get
                {
                    return this.theRoot;
                }
            }

            #endregion

            #region Private Methods

            private int GetEdgeLength(IEdgeLabel e)
            {
                return (e.End != -1 ? e.End : this.CurrentPhase - 1) - e.Start + 1;
            }

            private char GetCharFromIndex(int index)
            {
                if (0 <= index && index < this.Text.Length)
                {
                    return this.Text[index];
                }
                else
                {
                    throw new ArgumentOutOfRangeException();
                }
            }
            
            private bool PreMatch(SuffixNode p, out SuffixNode target, out List<EdgeLabel> edges)
            {
                target = null;
                edges = new List<EdgeLabel>();

                Debug.Assert(p != this.theRoot);

                bool goDownFromRoot = true;
                var v = p.Parent;

                if (p.Link != null)
                {
                    target = p.Link;
                    edges = null;
                    goDownFromRoot = false;
                    return goDownFromRoot;
                }

                if (v != this.theRoot)
                {
                    if (v.Link == null)
                    {
                        var w = v.Parent;

                        if (w != this.theRoot)
                        {
                            Debug.Assert(w.Link != null);

                            edges.Add(EdgeLabel.Create(v.Edge.Start, v.Edge.End == -1 ? (this.CurrentPhase - 1) : v.Edge.End));
                            edges.Add(EdgeLabel.Create(p.Edge.Start, p.Edge.End == -1 ? (this.CurrentPhase - 1) : p.Edge.End));
                            target = w.Link;

                            goDownFromRoot = false;
                        }
                    }
                    else
                    {                   
                        Debug.Assert(v.Link != null);

                        edges.Add(EdgeLabel.Create(p.Edge.Start, p.Edge.End == -1 ? (this.CurrentPhase - 1) : p.Edge.End));
                        target = v.Link;

                        goDownFromRoot = false;
                    }
                }

                return goDownFromRoot;
            }
            
            private bool Match(SuffixNode p, List<EdgeLabel> edges, out SuffixNode child, out int firstUnmachedEdgeIndex)
            {
                if (edges == null || edges.Count <= 0)
                {
                    throw new ArgumentException();
                }

                firstUnmachedEdgeIndex = -1;

                int matchingToDo = 0;
                for (int i = 0; i < edges.Count; i++)
                {
                    matchingToDo += this.GetEdgeLength(edges[i]);
                }

                int matchingDone = 0;
                var parent = p;
                child = null;

                int matchingEdgeIndex = 0;
                var matchingEdge = edges[matchingEdgeIndex];
                int cursorNext = matchingEdge.Start;
                int edgeEnd = matchingEdge.End;

                child = this.TraverseEdge(parent, cursorNext);
                var treeEdgeLen = this.GetEdgeLength(child.Edge);

                do
                {
                    if (cursorNext + treeEdgeLen - 1 < edgeEnd)
                    {
                        matchingDone += treeEdgeLen;
                        cursorNext += treeEdgeLen;

                        Debug.Assert(matchingDone < matchingToDo);

                        parent = child;
                        child = this.TraverseEdge(parent, cursorNext);
                        treeEdgeLen = this.GetEdgeLength(child.Edge);
                    }
                    else if (cursorNext + treeEdgeLen - 1 == edgeEnd)
                    {
                        matchingDone += treeEdgeLen;

                        if (matchingEdgeIndex + 1 < edges.Count)
                        {
                            matchingEdge = edges[++matchingEdgeIndex];
                            cursorNext = matchingEdge.Start;
                            edgeEnd = matchingEdge.End;

                            parent = child;
                            child = this.TraverseEdge(parent, cursorNext);
                            treeEdgeLen = this.GetEdgeLength(child.Edge);
                        }
                    }
                    else
                    {
                        matchingDone += edgeEnd - cursorNext + 1;
                        var deltaUnmatched = cursorNext + treeEdgeLen - 1 - edgeEnd;

                        if (matchingEdgeIndex + 1 < edges.Count)
                        {
                            matchingEdge = edges[++matchingEdgeIndex];
                            cursorNext = matchingEdge.Start;
                            edgeEnd = matchingEdge.End;

                            treeEdgeLen = deltaUnmatched;
                        }
                        else
                        {
                            firstUnmachedEdgeIndex = (child.Edge.End == -1 ? (this.CurrentPhase - 1) : child.Edge.End) - deltaUnmatched + 1;
                        }
                    }
                }
                while (matchingDone < matchingToDo);

                return firstUnmachedEdgeIndex == -1;
            }

            private SuffixNode TraverseEdge(SuffixNode parent, int matchingStart)
            {
                SuffixNode child = parent.GetEdge(this.GetCharFromIndex(matchingStart));
                if (child == null)
                {
                    throw new ApplicationException("unexpected!");
                }

                return child;
            }

            private void FixupLeaves(SuffixNode p, int endIndex)
            {
                if (!p.IsLeaf)
                {
                    foreach (var c in p.Children)
                    {
                        this.FixupLeaves(c.Value as SuffixNode, endIndex);
                    }
                }
                else
                {
                    p.Edge.End = endIndex;
                }
            }

            /// <summary>
            /// Searches for the specified text.
            /// </summary>
            /// <param name="text">The text.</param>
            /// <param name="matchingList">The matching list.</param>
            /// <param name="child">The child.</param>
            /// <param name="firstUnmachedEdgeIndex">First index of the unmached edge.</param>
            /// <returns>number of characters successfully matched</returns>
            private int Search(string text, ref List<ISuffixNode> matchingList, out ISuffixNode child, out int firstUnmachedEdgeIndex)
            {
                child = null;
                firstUnmachedEdgeIndex = -1;

                if (string.IsNullOrEmpty(text))
                {
                    return 0;
                }

                var parent = this.Root;
                int length = text.Length;

                int k = 0, e = -1;
                while (parent.Children.TryGetValue(text[k], out child))
                {
                    e = child.Edge.Start;

                    if (child.IsLeaf)
                    {
                        // leaves haven't been fixed up
                        Debug.Assert(child.Edge.End != -1);
                    }

                    int end = child.Edge.End;

                    while (k < length && e <= end && text[k++] == this.Text[e++]) { }

                    if (k < length && e > end)
                    {
                        //good so far, keep going.. 
                        parent = child;
                        continue;
                    }
                    else break;
                }

		// did anything match?
                if (k <= 0) return 0;

                // did we agree on the last char?
                if (text[k - 1] == this.Text[e - 1])
                {
                    if (matchingList != null)
                    {
                        //find all leaves below and get your matching list..
                        var stack = new Stack<ISuffixNode>();
                        stack.Push(child);

                        matchingList = new List<ISuffixNode>();

                        while (stack.Count > 0)
                        {
                            var p = stack.Pop();
                            if (p.IsLeaf)
                            {
                                matchingList.Add(p);
                            }
                            else
                            {
                                foreach (var c in p.Children)
                                {
                                    stack.Push(c.Value);
                                }
                            }
                        }
                    }

                    return k;
                }
                else
                {
                    //well, wish you luck next time..
                    firstUnmachedEdgeIndex = e - 1;
                    return k - 1;
                }
            }

            #endregion

            #region Public Methods

            public static SuffixTreeImpl<ChildrenCollectionType> Create(string text)
            {
                if (string.IsNullOrEmpty(text))
                {
                    return null;
                }

                var tree = new SuffixTreeImpl<ChildrenCollectionType>();
                tree.Text = text;

                var root = tree.theRoot;
                int m = text.Length;

                var deep = root.AddEdge(tree.Text, 0, -1);
                deep.SetLeaf(0);

                SuffixNode prevExtEnd = deep;
                int lastCreatedLeaf = -1;

                for (int i = 1; i < m; i++)
                {
                    tree.CurrentPhase = i;

                    bool skipRemaining = false;
                    SuffixNode internCreatedPrevExt = null;

                    for (int j = 1; j < i && !skipRemaining; j++)
                    {
                        if (j < lastCreatedLeaf)
                        {
                            continue;
                        }
                        
                        List<EdgeLabel> edges = null;
                        SuffixNode found = null;
                        int edgecursor = -1;
                        bool matchEndedAtNode;

                        if (j == lastCreatedLeaf && j > 1)
                        {
                            if (!prevExtEnd.IsLeaf)
                            {
                                edges = new List<EdgeLabel>(new EdgeLabel[] { EdgeLabel.Create(i - 1, i - 1) });
                                matchEndedAtNode = tree.Match(prevExtEnd, edges, out found, out edgecursor);
                            }
                            else
                            {
                                found = prevExtEnd;
                                matchEndedAtNode = true;
                            }
                        }

                        if (found == null)
                        {
                            SuffixNode target = null;
                            if (tree.PreMatch(prevExtEnd, out target, out edges))
                            {
                                edges = new List<EdgeLabel>(new EdgeLabel[] { EdgeLabel.Create(j, i - 1) });
                                matchEndedAtNode = tree.Match(tree.theRoot, edges, out found, out edgecursor);
                            }
                            else
                            {
                                if (edges != null)
                                {
                                    matchEndedAtNode = tree.Match(target, edges, out found, out edgecursor);
                                }
                                else
                                {
                                    found = target;
                                    matchEndedAtNode = true;
                                }
                            }
                        }
                        else
                        {
                            matchEndedAtNode = true;
                        }

                        if (!matchEndedAtNode)
                        {
                            if (tree.Text[edgecursor] == tree.Text[i])
                            {
                                skipRemaining = true;
                                break;
                            }
                            else
                            {
                                var foundParent = found.Parent;

                                // there's no node here .. better create one..
                                foundParent.RemoveEdge(tree.GetCharFromIndex(found.Edge.Start));

                                // create new node..
                                var internalNode = foundParent.AddEdge(tree.Text, found.Edge.Start, edgecursor - 1);

                                // massage old node and add it back..
                                found.Parent = internalNode;
                                found.Edge.Start = edgecursor;
                                internalNode.AddEdge(tree.Text, found);

                                // fix up links if we need to ..
                                if (internCreatedPrevExt != null)
                                {
                                    internCreatedPrevExt.Link = internalNode;
                                }

                                internCreatedPrevExt = internalNode;

                                // create a new leaf and hang it here.. 
                                var newLeaf = internalNode.AddEdge(tree.Text, i, -1);
                                newLeaf.SetLeaf(j);
                                lastCreatedLeaf = j;

                                prevExtEnd = internalNode;
                            }
                        }
                        else
                        {
                            if (found.IsLeaf)
                            {
                                prevExtEnd = found;
                            }
                            else
                            {
                                if (internCreatedPrevExt != null)
                                {
                                    internCreatedPrevExt.Link = found;
                                }

                                internCreatedPrevExt = found.Link == null ? found : null;

                                if (found.GetEdge(tree.GetCharFromIndex(i)) == null)
                                {
                                    var newLeaf = found.AddEdge(tree.Text, i, -1);
                                    newLeaf.SetLeaf(j);
                                    lastCreatedLeaf = j;

                                    prevExtEnd = found;
                                }
                                else
                                {
                                    skipRemaining = true;
                                    break;
                                }
                            }
                        }
                    }

                    if (!skipRemaining)
                    {
                        var parent = root;
                        var child = parent.GetEdge(tree.GetCharFromIndex(i));
                        if (child == null)
                        {
                            var newLeaf = parent.AddEdge(tree.Text, i, -1);
                            newLeaf.SetLeaf(i);

                            lastCreatedLeaf = i;
                            prevExtEnd = newLeaf;
                        }

                        if (internCreatedPrevExt != null)
                        {
                            internCreatedPrevExt.Link = parent;
                            internCreatedPrevExt = null;
                        }
                    }
                }

                tree.FixupLeaves(tree.theRoot, tree.Text.Length - 1);
                return tree;
            }

            /// <summary>
            /// Determines whether [contains] [the specified text].
            /// </summary>
            /// <param name="text">The text.</param>
            /// <returns>
            ///   <c>true</c> if [contains] [the specified text]; otherwise, <c>false</c>.
            /// </returns>
            public bool Contains(string text)
            {
                ISuffixNode found = null;
                int firstUnmached = -1;
                List<ISuffixNode> matchList = null;

                int matchedOk = this.Search(text, ref matchList, out found, out firstUnmached);
                return matchedOk == text.Length;
            }

            /// <summary>
            /// Searches for specified text within the tree and returns the list of matching starting positions.
            /// </summary>
            /// <param name="text">The text.</param>
            /// <param name="matchList">The match list.</param>
            /// <returns></returns>
            public bool Search(string text, out List<int> matchList)
            {
                matchList = null;

                ISuffixNode found = null;
                int firstUnmached = -1;
                var matchNodeList = new List<ISuffixNode>();

                int matchedOk = this.Search(text, ref matchNodeList, out found, out firstUnmached);

                if (matchedOk == text.Length)
                {
                    matchList = new List<int>();
                    foreach (var n in matchNodeList)
                    {
                        matchList.Add(n.LeafNumber);
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }

            #endregion

            #region Nested Classes

            private class SuffixNode : ISuffixNode
            {
                #region Fields

                private ChildrenCollectionType _children;

                #endregion

                #region Properties

                public EdgeLabel Edge
                { get; set; }

                public SuffixNode Link
                { get; set; }

                public SuffixNode Parent
                { get; set; }

                public bool IsLeaf
                { get; set; }

                public int LeafNumber
                { get; set; }

                public IDictionary<char, ISuffixNode> Children
                {
                    get
                    {
                        if (this._children == null)
                        {
                            this._children = new ChildrenCollectionType();
                        }

                        return this._children;
                    }
                }

                #endregion

                #region Public Methods

                public SuffixNode GetEdge(char startChar)
                {
                    ISuffixNode child = null;
                    if (this.Children.TryGetValue(startChar, out child))
                    {
                        return (SuffixNode)child;
                    }
                    else
                    {
                        return null;
                    }
                }

                public SuffixNode AddEdge(string text, int startCharIndex, int endCharIndex)
                {
                    Debug.Assert(endCharIndex == -1 || (0 <= startCharIndex && startCharIndex <= endCharIndex && endCharIndex < text.Length));
                    Debug.Assert(!this.Children.ContainsKey(text[startCharIndex]));

                    var newChild = new SuffixNode()
                    {
                        Edge = EdgeLabel.Create(startCharIndex, endCharIndex),
                        Parent = this,
                        Link = null,
                        IsLeaf = false
                    };

                    this.Children.Add(text[startCharIndex], newChild);
                    return newChild;
                }

                public void AddEdge(string text, SuffixNode newChild)
                {
                    this.Children.Add(text[newChild.Edge.Start], newChild);
                }

                public SuffixNode RemoveEdge(char startChar)
                {
                    var removedNode = this.GetEdge(startChar);
                    if (removedNode != null)
                    {
                        this.Children.Remove(startChar);
                    }

                    return removedNode;
                }

                public void SetLeaf(int leafNumber)
                {
                    this.IsLeaf = true;
                    this.LeafNumber = leafNumber;
                }

                #endregion

                #region ISuffixNode implementation

                ISuffixNode ISuffixNode.Link
                {
                    get { return this.Link; }
                }

                ISuffixNode ISuffixNode.Parent
                {
                    get { return this.Parent; }
                }

                IEdgeLabel ISuffixNode.Edge
                {
                    get { return this.Edge; }
                }

                #endregion
            }

            /// <summary>
            /// represents a text fragment (i.e. consecutive sequence of characters)
            /// </summary>
            public class EdgeLabel : IEdgeLabel
            {
                public int Start 
                { get; set; }

                public int End 
                { get; set; }

                public static EdgeLabel Create(int s, int e)
                {
                    if (s < 0 || e < -1 || (e != -1 && s > e))
                    {
                        throw new ArgumentOutOfRangeException();
                    }

                    return new EdgeLabel() { Start = s, End = e };
                }
            }

            #endregion
        }

        #endregion
    }    

    public static class SuffixTreeExtensions
    {
        public static string GetNodeSuffix(this ISuffixTree t, ISuffixNode p)
        {
            var sb = new StringBuilder();
            GetNodeSuffixImpl(t, p, sb);
            return sb.ToString();
        }

        private static void GetNodeSuffixImpl(ISuffixTree t, ISuffixNode p, StringBuilder sb)
        {
            if (p.Parent != null)
            {
                GetNodeSuffixImpl(t, p.Parent, sb);

                int length = (p.IsLeaf ? t.Text.Length - 1 : p.Edge.End) - p.Edge.Start + 1;
                sb.Append(t.Text.Substring(p.Edge.Start, length));
            }
        }
    }
}
