package com.nishchay.ds.dp.lcs;


/*
 *	===========Printing Longest Common Subsequence===========
 *
 * Given two sequences, print the longest subsequence present in both of them.
 *
 *		Examples:
 *		LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 *		LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 *         s1 = “abcde” s2 = “bdgek”,  LCS - “bde”
 *
 * https://www.geeksforgeeks.org/printing-longest-common-subsequence/
 * https://www.tutorialcup.com/interview/string/print-longest-common-subsequence.htm
 *
 * */
public class LongestCommonSubsequencePrint {

    public static void main(String[] args) {

        System.out.println("------------BottomUp-------------");
        lcsDPBottomUp();

    }


    private static void lcsDPBottomUp() {
        LongestCommonSubsequencePrint ref = new LongestCommonSubsequencePrint();

        String seq1 = "ABCBDAB", seq2 = "BDCABA";
        System.out.println("LCS of " + seq1 + " and " + seq2 + " is - " + ref.lcsTabulation(seq1, seq2, seq1.length(), seq2.length())); //BDAB


        seq1 = "abcde";
        seq2 = "bdgek";
        System.out.println("LCS of " + seq1 + " and " + seq2 + " is - " + ref.lcsTabulation(seq1, seq2, seq1.length(), seq2.length())); //bde

        seq1 = "ABC";
        seq2 = "XYZ";
        System.out.println("LCS of " + seq1 + " and " + seq2 + " is - " + ref.lcsTabulation(seq1, seq2, seq1.length(), seq2.length())); //empty

        seq1 = "MZJAWXU";
        seq2 = "XMJYAUZ";
        System.out.println("LCS of " + seq1 + " and " + seq2 + " is - " + ref.lcsTabulation(seq1, seq2, seq1.length(), seq2.length()));//MJAU

        seq1 = "AGGTAB";
        seq2 = "GXTXAYB";
        System.out.println("LCS of " + seq1 + " and " + seq2 + " is - " + ref.lcsTabulation(seq1, seq2, seq1.length(), seq2.length()));//GTAB

    }


    /*
     *      Like other typical Dynamic Programming(DP) problems, re-computation of same sub-problems can be avoided
     *      by constructing a temporary array dp[][] in bottom-up manner.
     *
     *	            | 0                                        if i == 0 or j == 0
     *	LCS[i][j] = | LCS[i – 1][j – 1] + 1                    if X[i-1] == Y[j-1]
     *	            | longest(LCS[i – 1][j], LCS[i][j – 1])    if X[i-1] != Y[j-1]
     *
     *   Time complexity = O(l1l2) , polynomial time complexity.
     *   Space Complexity = O(l1l2), polynomial space complexity.
     * */
    private String lcsTabulation(String seq1, String seq2, int l1, int l2) {

        // first we will populate dp 2D array, using lcs dp solution
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                // initialisation - if either of the sequence is empty - first row & first column
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (seq1.charAt(i - 1) == seq2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Once we have 2D array dp populated with data, we will get the LCS string using this 2D array dp
        // Following code is used to print LCS
        int lcsCount = dp[l1][l2];
        char[] lcsString = new char[lcsCount + 1];

        // Start from the last cell of dp[] and process diagonally and store characters in lcsString[]
        int i = l1;
        int j = l2;
        while (i > 0 && j > 0) {

            // If current character is same for i & j in both of the string
            // then current character is part of lcsString
            if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
                // Put current character in result
                lcsString[lcsCount - 1] = seq1.charAt(i - 1);
                lcsCount--;
                // reduce values of i, j and index
                i--;
                j--;
            }
            // If not same, then find the larger of two and go in the direction of larger value
            else if (dp[i - 1][j] > dp[i][j - 1])
                i--; // moving up
            else
                j--; // moving left
        }

        return String.valueOf(lcsString);
    }

}
