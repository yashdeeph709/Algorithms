/////////////////////////////////////////////////////////////////////
//      File Name          : BurrowsWheelerTransform.cs
//      Created            : 28 8 2013   21:02
//      Author             : Costin S
//
/////////////////////////////////////////////////////////////////////
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TextIndexing
{
    using Dictionary = Dictionary<char, ISuffixNode>;
    using SortedList = SortedList<char, ISuffixNode>;
    using SortedDictionary = SortedDictionary<char, ISuffixNode>;    

    public class BurrowsWheelerTransform
    {
        #region Public Methods        

        /// <summary>
        /// Computes the BurrowsWheelerTransform in O(n) time..
        /// </summary>
        /// <param name="text">The text.</param>
        /// <returns></returns>
        public static string Build(string text)
        {
            if(string.IsNullOrEmpty(text))
                return string.Empty;

            var suffixTree = SuffixTree.Create<SortedList>(text);
            var suffixArray = SuffixArray.Create(suffixTree);

            var bwt = new StringBuilder();

            for (int k = 0; k < suffixArray.Length; ++k)
            {
                bwt.Append(suffixArray[k] != 0 ? text[suffixArray[k] - 1] : text[text.Length - 1]);
            }

            return bwt.ToString();
        }

        #endregion
    }
}