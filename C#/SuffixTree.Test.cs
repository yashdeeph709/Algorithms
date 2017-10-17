/////////////////////////////////////////////////////////////////////
//      File Name          : SuffixTree.Test.cs
//      Created            : 28 8 2013   21:20
//      Author             : Costin S
//
/////////////////////////////////////////////////////////////////////
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;

namespace TextIndexing
{
    using Dictionary = Dictionary<char, ISuffixNode>;
    using SortedList = SortedList<char, ISuffixNode>;
    using SortedDictionary = SortedDictionary<char, ISuffixNode>;
    using System.IO;

    class Program
    {
        static void Main(string[] args)
        {
            Debug.AutoFlush = true;

            TextWriterTraceListener consoleTrace = new TextWriterTraceListener(System.Console.Out);
            Debug.Listeners.Add(consoleTrace);

            CreateSuffixTree("ababbaabbbababbaabababbaabbbababbaa$");

            //// alternatively, uncomment the following code to execute a randomized test .. you might need to change the path of the output file, I'm using "D:\Tmp\Output.txt"!
            //// call RandomTest specifying the number of random strings to be generated, the range of characters in those strings, and the maximum length for them

            //var outputFile = @"D:\Tmp\Output.txt";
            //if (File.Exists(outputFile))
            //    File.Delete(outputFile);
       
            //TextWriterTraceListener fileTrace = new TextWriterTraceListener(File.CreateText(outputFile));
            //Debug.Listeners.Add(fileTrace);
            //Debug.Listeners.Remove(consoleTrace);

            //RandomTest(100, new Tuple<int, int>(97, 98), 1400);     // create 100 strings, containing a random sequence of {a, b} characters, of random length <= 1400
            //RandomTest(100, new Tuple<int, int>(97, 100), 1400);    // create 100 strings, containing a random sequence of {a, b, c, d} characters, of random length <= 1400
            //RandomTest(500, new Tuple<int, int>(97, 102), 200);     // create 500 strings, containing a random sequence of {a, b, c, d, e, f} characters, of random length <= 200
        }

        /// <summary>
        /// generate <stringCount> number of strings, 
        /// each string has a random length no greater than <maxStringLength>, 
        /// each string contains a random sequence of printable ascii characters in the range <charRange>, 
        /// each string ends with the unique char '$'
        /// </summary>
        /// <param name="stringCount">number of strings and suffix tree to generate and test</param>
        /// <param name="charRange">valid ascii char range is [32, 127]</param>
        /// <param name="maxStringLength">maximum number of strings length</param>
        private static void RandomTest(int stringCount, Tuple<int, int> charRange, int maxStringLength)
        {
            var random = new Random();

            for (int k = 0; k < stringCount; k++)
            {
                int length = 0;
                while ((length = random.Next(maxStringLength)) == 0) ;

                var newString = new StringBuilder(length+1);
                for (int i = 0; i < length; i++)
                {
                    char newChar;
                    while ((newChar = (char)random.Next(charRange.Item1, charRange.Item2 + 1)) == '$') ;

                    newString.Append(newChar);
                }
                newString.Append('$');

                CreateSuffixTree(newString.ToString());
            }
        }

        private static void CreateSuffixTree(string text)
        {
            Console.Write(".");
            Debug.WriteLine("");
            Debug.WriteLine("");
            Debug.WriteLine("");
            Debug.WriteLine("================================================================================================= ");
            Debug.WriteLine(text);
            Debug.WriteLine("");
            Debug.WriteLine("text length: {0}", text.Length);
            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();

            var t = SuffixTree.Create<SortedList>(text);

            stopWatch.Stop();
            Debug.WriteLine("total milliseconds: {0}", stopWatch.ElapsedMilliseconds);

            Diagnose(t);
        }

        private static void Diagnose(ISuffixTree t)
        {
            Debug.WriteLine("");

            var diagnostics = new SuffixTreeDiagnostics(t);
            diagnostics.Run();

            Debug.WriteLine("");
            Debug.WriteLine("suffix links count: {0} ", diagnostics.InternalCount);
            Debug.WriteLine("----------------------- ");
            diagnostics.Display(SuffixTreeDiagnostics.DisplayInfo.DisplayContent | SuffixTreeDiagnostics.DisplayInfo.DisplaySuffixLinks);

            Debug.WriteLine("");
            Debug.WriteLine("suffix count (leaves): {0}", diagnostics.SuffixesCount);
            Debug.WriteLine("-------------------------- ");
            diagnostics.Display(SuffixTreeDiagnostics.DisplayInfo.DisplayContent | SuffixTreeDiagnostics.DisplayInfo.DisplaySuffixes);
        }
    }

    class SuffixTreeDiagnostics
    {
        #region Fields

        private SortedDictionary<int, ISuffixNode> suffixes = new SortedDictionary<int, ISuffixNode>();
        private List<ISuffixNode> internals = new List<ISuffixNode>();

        #endregion

        #region Enums

        [Flags]
        public enum DisplayInfo
        {
            DisplayContent = 0x1,
            DisplaySuffixLinks = 0x2,
            DisplaySuffixes = 0x4
        }

        #endregion

        #region C'tor

        public SuffixTreeDiagnostics(ISuffixTree tree)
        {
            this.Tree = tree;
        }

        #endregion

        #region Properties

        private ISuffixTree Tree { get; set; }
        public int SuffixesCount { get { return suffixes.Count; } }
        public int InternalCount { get { return internals.Count; } }

        #endregion

        #region Private Methods

        private void VerifyInternal(ISuffixNode p)
        {
            if (p != null && !p.IsLeaf && p != this.Tree.Root)
            {
                Debug.Assert(p.Link != null);

                var thisSuffix = this.Tree.GetNodeSuffix(p);
                var linkSuffix = this.Tree.GetNodeSuffix(p.Link);

                Debug.Assert(thisSuffix.Length - 1 == linkSuffix.Length);
                Debug.Assert(thisSuffix.Substring(1).Equals(linkSuffix));
            }
        }

        private void RunImpl(ISuffixNode p)
        {
            if (p.IsLeaf)
            {
                suffixes.Add(p.LeafNumber, p);
            }
            else
            {
                if (p.Parent != null)
                {
                    internals.Add(p);
                    VerifyInternal(p);
                }

                foreach (var kvp in p.Children)
                {
                    RunImpl(kvp.Value);
                }
            }
        }

        #endregion

        #region Public Methods

        public void Run()
        {
            RunImpl(this.Tree.Root);
        }

        public void Display(DisplayInfo displayInfo)
        {
            if (displayInfo.HasFlag(DisplayInfo.DisplaySuffixLinks))
            {
                foreach (var p in internals)
                {
                    if (p.Parent != null)
                    {
                        var thisSuffix = this.Tree.GetNodeSuffix(p);
                        var linkSuffix = this.Tree.GetNodeSuffix(p.Link);

                        if (displayInfo.HasFlag(DisplayInfo.DisplayContent))
                        {
                            Debug.Write(thisSuffix); Debug.Write(" | "); Debug.WriteLine(linkSuffix);
                        }
                        else
                        {
                            Debug.Write(thisSuffix.Length.ToString()); Debug.Write(" | "); Debug.WriteLine(linkSuffix.Length.ToString());
                        }
                    }
                }
            }

            if (displayInfo.HasFlag(DisplayInfo.DisplaySuffixes))
            {
                foreach (var p in suffixes.Values)
                {
                    var suffix = this.Tree.GetNodeSuffix(p);
                    string format = string.Format("leaf node {{0, 3}} -- Sx={{1, {0}}}", this.Tree.Text.Length);
                    Debug.WriteLine(string.Format(format, p.LeafNumber, displayInfo.HasFlag(DisplayInfo.DisplayContent) ? suffix : suffix.Length.ToString()));
                }
            }
        }

        #endregion
    }
}
