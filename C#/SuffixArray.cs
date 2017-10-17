/////////////////////////////////////////////////////////////////////
//      File Name          : SuffixArray.cs
//      Created            : 28 8 2013   20:55
//      Author             : Costin S
//
/////////////////////////////////////////////////////////////////////
using System.Collections.Generic;
using System.Linq;

namespace TextIndexing
{
    using Dictionary = Dictionary<char, ISuffixNode>;
    using SortedList = SortedList<char, ISuffixNode>;
    using SortedDictionary = SortedDictionary<char, ISuffixNode>;

    public class SuffixArray
    {
        #region Public Methods        

        /// <summary>
        /// Creates the suffix array in O(n) time from the given text.
        /// The last character in argument 'text' must be the unique $ char. see remarks..
        /// </summary>
        /// <param name="text">The text.</param>
        /// <returns>
        /// $ happens to sort nicely in front of other normal chars.. so reversing the children collection when parsing the tree to build up the suffix array just works
        /// small change if you need to terminate your text with other unique char..
        /// </returns>
        public static int[] Create(string text)
        {
            var suffixTree = SuffixTree.Create<SortedList>(text);
            if (suffixTree != null)
                return Create(suffixTree);
            else return null;
        }

        /// <summary>
        /// Creates the suffix array given an already built instance of a suffix tree.
        /// </summary>
        /// <param name="suffixTree">The suffixTree.</param>
        /// <returns></returns>
        public static int[] Create(ISuffixTree suffixTree)
        {
            if (suffixTree == null)
            {
                return null;
            }

            var stack = new Stack<ISuffixNode>();
            stack.Push(suffixTree.Root);

            int textLength = suffixTree.Text.Length;
            var sufarray = new int[textLength];

            int k = 0;

            while (stack.Count > 0)
            {
                var node = stack.Pop();

                if (node.IsLeaf)
                {
                    sufarray[k++] = node.LeafNumber;
                }
                else
                {
                    foreach (var kvp in node.Children.Reverse())
                    {
                        stack.Push(kvp.Value);
                    }
                }
            }

            return sufarray;
        }

        #endregion
    }
}