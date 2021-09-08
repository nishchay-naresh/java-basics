package com.nishchay.ds.dp.lcs;


/*
 *	===========Longest Common Substring Problem===========
 *
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 *
 *	For Example
 *		Input : X = “onlinetutorialhelp”, y = “DPtutorialbigners”
 *		Output : 8
 *		Explanation:
 *		The longest common substring is "tutorial" and is of length 8.
 *
 *		Input : X = “abcdxyz”, y = “xyzabcd”
 *		Output : 4
 *		Explanation:
 *		The longest common substring is “abcd” and is of length 4.
 *
 *		Input : X = “zxabcdezy”, y = “yzabcdezx”
 *		Output : 6
 *		Explanation:
 *		The longest common substring is “abcdez” and is of length 6.
 *
 * https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 *
 * */
public class LongestCommonSubstring {

    public static void main(String[] args) {

        System.out.println("------------Recursion-------------");
        lcSubstringDPBottomUp();

    }



    private static void lcSubstringDPBottomUp() {

        LongestCommonSubstring ref = new LongestCommonSubstring();
        String seq1 = "onlinetutorialhelp";
        String seq2 = "DPtutorialbigners";

        System.out.println("The length of the LCS is - " +
                ref.lcSubstringTabulation_String(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length()));//tutorial, 8

        seq1 = "abcdxyz";
        seq2 = "xyzabcd";
        System.out.println("The length of the LCS is - " +
                ref.lcSubstringTabulation_String(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length()));//abcd, 4

        seq1 = "abc";
        seq2 = "xyz";
        System.out.println("The length of the LCS is - " +
                ref.lcSubstringTabulation_String(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length()));//abcdez, 0

        seq1 = "zxabcdezy";
        seq2 = "yzabcdezx";
        System.out.println("The length of the LCS is - " +
                ref.lcSubstringTabulation_String(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length()));//6
    }


    /*
     *      Like other typical Dynamic Programming(DP) problems, re-computation of same sub-problems can be avoided
     *      by constructing a temporary array dp[][] in bottom-up manner.
     *
     *	            | 0                                        if i == 0 or j == 0
     *	LCS[i][j] = | LCS[i – 1][j – 1] + 1                    if X[i-1] == Y[j-1]
     *	            | 0                                        if X[i-1] != Y[j-1]
     *
     *   Time complexity = O(l1l2) , polynomial time complexity.
     *   Space Complexity = O(l1l2), polynomial space complexity.
     * */
    private int lcSubstringTabulation(char[] seq1, char[] seq2, int l1, int l2) {

        // To store length of the longest common substring
        int result = 0;

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                // initialisation - if either of the sequence is empty - first row & first column
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (seq1[i - 1] == seq2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }

                else
                    dp[i][j] = 0;
            }
        }
        return result;
    }

    private String lcSubstringTabulation_String(char[] seq1, char[] seq2, int l1, int l2) {

        // To store length of the longest common substring
        int count = 0;
        int endingIndex = l1;

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                // initialisation - if either of the sequence is empty - first row & first column
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (seq1[i - 1] == seq2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // update the maximum length and ending index
                    if (dp[i][j] > count) {
                        count = dp[i][j];
                        endingIndex = i;
                    }
                }

                else
                    dp[i][j] = 0;
            }
        }
        System.out.println("count = " + count);

        String result = String.copyValueOf(seq1, endingIndex - count, count);
        return result;
    }

}
