/////////////////////////////////////////////////////////////////////
//      File Name          : LCPArray.cs
//      Created            : 28 8 2013   21:20
//      Author             : Costin S
//
/////////////////////////////////////////////////////////////////////

namespace TextIndexing
{
    public class LCPArray
    {
        #region Public Methods

        /// <summary>
        /// Creates the LCP array in O(n) time from the given text.
        /// The last character in argument 'text' must be the unique $ char. Refer to SuffixArray class remarks..
        /// </summary>
        /// <param name="text">The text.</param>
        /// <returns></returns>
        public static int[] Build(string text)
        {
            var suffixArray = SuffixArray.Create(text);
            if (suffixArray != null)
            {
                var suffixArrayReverse = new int[suffixArray.Length];
                for (int k = 0; k < suffixArray.Length; ++k)
                    suffixArrayReverse[suffixArray[k]] = k;

                var lcpArray = new int[suffixArray.Length];
                lcpArray[0] = -1;
                
                int m = 0;
                for (int i = 0; i < suffixArray.Length - 1; i++)
                {
                    int j = suffixArray[suffixArrayReverse[i] - 1];

                    while (text[m + i] == text[m + j]) ++m;
                    lcpArray[suffixArrayReverse[i]] = m;

                    if (m > 0) --m;                    
                }

                return lcpArray;
            }
            else return null;
        }        

        #endregion
    }
}