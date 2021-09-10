package com.nishchay.ds.dp.lcs;

/*
 *	===========Longest Repeated Subsequence===========
 *
 * Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position,
 *  i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
 *
 * Examples :
 *		Input: X = "AABEBCDD"
 *		Output: "ABD"
 *		The longest repeating subsequence is "ABD"
 *
 *		Input: X = "ATACTCGGA"
 *		Output: "ATCG"
 *		The longest repeating subsequence is "ATCG"
 *
 * https://www.geeksforgeeks.org/longest-repeated-subsequence/
 * https://www.techiedelight.com/longest-repeated-subsequence-problem/
 * */
public class LongestRepeatingSubsequence {


    public static void main(String[] args) {

        LongestRepeatingSubsequence ref = new LongestRepeatingSubsequence();

        String str = "AABEBCDD";
        System.out.println("Length of the Longest Repeating Subsequence is - " + ref.findLongestRepeatingSubSeqPrint(str)); //ABD

        str = "ATACTCGGA";
        System.out.println("Length of the Longest Repeating Subsequence is - " + ref.findLongestRepeatingSubSeqPrint(str)); //ATCG

    }

    /*
     *
     *	 This problem is just the modification of Longest Common Subsequence problem.
     *	 The idea is to find the LCS(str, str) where str is the input string with the restriction that when both the characters are same,
     *	 they shouldn’t be on the same index in the two strings.
     *
     * Sp we will utilise the same LSC logic, with little modification of i!=j
     *
     *	            | 0                                        if i == 0 or j == 0
     *	LCS[i][j] = | LCS[i – 1][j – 1] + 1                    if X[i-1] == Y[j-1] && i!=j
     *	            | longest(LCS[i – 1][j], LCS[i][j – 1])    if X[i-1] != Y[j-1]
     *
     *   Time complexity = O(n^2) , polynomial time complexity.
     *   Space Complexity = O(n^2), polynomial space complexity.
     * */
    private int findLongestRepeatingSubSeqCount(String str){

        int len = str.length();

        int[][] dp = new int[len + 1][len + 1];

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                // initialisation - if either of the sequence is empty - first row & first column
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                // If characters match and indexes are not same
                else if (str.charAt(i - 1) == str.charAt(j - 1) && i!=j )
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[len][len];
    }


    /*
    * How to print the subsequence? - The idea is similar to printing LCS.
    *
    * The above solution only finds length of subsequence. We can print the subsequence using dp[n+1][n+1] table built
    *   1) Find finds length of longest repeating subsequence for given string. and populate its 2D dp matrix
    *	2) Traverse this 2D array of dp, get the LongestRepeatingSubSeq string printing
    *
    * */
    private String findLongestRepeatingSubSeqPrint(String str){


        int len = str.length();

        int[][] dp = new int[len + 1][len + 1];

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                // initialisation - if either of the sequence is empty - first row & first column
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                    // If characters match and indexes are not same
                else if (str.charAt(i - 1) == str.charAt(j - 1) && i!=j )
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }


        // string to store the LongestRepeatingSubSeq
        StringBuilder sb = new StringBuilder();

        // Traverse dp[][] from bottom right
        int i = len, j = len;
        while (i > 0 && j > 0)
        {
            // If this cell is same as diagonally
            // adjacent cell just above it, then
            // same characters are present at
            // str[i-1] and str[j-1]. Append any
            // of them to result.
            if (dp[i][j] == dp[i - 1][j - 1] + 1)
            {
//                res = res + str.charAt(i - 1);
                sb.append(str.charAt(i - 1));
                i--;
                j--;
            }

            // Otherwise we move to the side
            // that that gave us maximum result
            else if (dp[i][j] == dp[i - 1][j])
                i--;
            else
                j--;
        }

        // reverse the string and return it
        String longestRepeatingSubSeqStr = sb.reverse().toString();
        return longestRepeatingSubSeqStr;
    }
}
