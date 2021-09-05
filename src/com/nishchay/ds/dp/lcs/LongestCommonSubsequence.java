package com.nishchay.ds.dp.lcs;

import java.util.HashMap;
import java.util.Map;

/*
 *	===========Longest Common Subsequence Problem===========
 *
 * The Longest Common Subsequence (LCS) problem is finding the longest subsequence present in given two sequences in the same order,
 * i.e., find the longest sequence which can be obtained from the first original sequence by deleting some items
 * and from the second original sequence by deleting other items.
 *
 *	For Example
 *		X: ABCBDAB
 *		Y: BDCABA
 *
 *		The length of the LCS is 4
 *		LCS are BDAB, BCAB, and BCBA
 *--------------------
 *		input : str1 = "AGCA", str2 = "GAC"
 *		sol   : longest common subsequence (LCA) = "GA"
 *		        length of LCA = 2
 *		output: 2
 *
 *		input : str1 = "ABC", str2 = "XYZ"
 *		sol   : No common character found
 *		        length of LCA = 0
 *		output: 0
 *
 *		input : str1 = "MZJAWXU", str2 = "XMJYAUZ"
 *		sol   : longest common subsequence (LCA) = "MJAU"
 *		        length of LCA = 4
 *		output: 4
 *
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * https://www.techiedelight.com/longest-common-subsequence/
 * https://www.tutorialcup.com/interview/dynamic-programming/longest-common-subsequence.htm
 *
 * */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        System.out.println("------------Recursion-------------");
        lcsRecursionEx();
        System.out.println("------------TopDown-------------");
        lcsDPTopDown();
        System.out.println("------------BottomUp-------------");
        lcsDPBottomUp();

    }

    private static void lcsRecursionEx() {

        LongestCommonSubsequence ref = new LongestCommonSubsequence();
        String seq1 = "ABCBDAB", seq2 = "BDCABA";

        System.out.println("The length of the LCS is - " +
                ref.lcsRecursive(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length()));//4

        seq1 = "AGCA";
        seq2 = "GAC";
        System.out.println("The length of the LCS is - " +
                ref.lcsRecursive(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length()));//2

        seq1 = "ABC";
        seq2 = "XYZ";
        System.out.println("The length of the LCS is - " +
                ref.lcsRecursive(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length()));//0

        seq1 = "MZJAWXU";
        seq2 = "XMJYAUZ";
        System.out.println("The length of the LCS is - " +
                ref.lcsRecursive(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length()));//4
    }

    private static void lcsDPTopDown() {
        LongestCommonSubsequence ref = new LongestCommonSubsequence();
        Map<String, Integer> table = new HashMap<>();
        String seq1 = "ABCBDAB", seq2 = "BDCABA";

        System.out.println("The length of the LCS is - " +
                ref.lcsMemoization(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length(), table));//4

        seq1 = "AGCA";
        seq2 = "GAC";
        System.out.println("The length of the LCS is - " +
                ref.lcsMemoization(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length(), table));//2

        seq1 = "ABC";
        seq2 = "XYZ";
        System.out.println("The length of the LCS is - " +
                ref.lcsMemoization(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length(), table));//0 // 2

        seq1 = "MZJAWXU";
        seq2 = "XMJYAUZ";
        System.out.println("The length of the LCS is - " +
                ref.lcsMemoization(seq1.toCharArray(), seq2.toCharArray(), seq1.length(), seq2.length(), table));//4
    }

    private static void lcsDPBottomUp() {
        LongestCommonSubsequence ref = new LongestCommonSubsequence();
        String seq1 = "ABCBDAB", seq2 = "BDCABA";

        System.out.println("The length of the LCS is - " + ref.lcsTabulation(seq1, seq2, seq1.length(), seq2.length()));//4

        seq1 = "AGCA";
        seq2 = "GAC";
        System.out.println("The length of the LCS is - " + ref.lcsTabulation(seq1, seq2, seq1.length(), seq2.length()));//2

        seq1 = "ABC";
        seq2 = "XYZ";
        System.out.println("The length of the LCS is - " + ref.lcsTabulation(seq1, seq2, seq1.length(), seq2.length()));//0

        seq1 = "MZJAWXU";
        seq2 = "XMJYAUZ";
        System.out.println("The length of the LCS is - " + ref.lcsTabulation(seq1, seq2, seq1.length(), seq2.length()));//4
    }


    /*
     *       Method 1: Recursion by Brute-Force algorithm
     *
     *       if (l1 == 0 || l2 == 0) // either of the seq is empty
     *           return 0;
     *       if (seq1[l1 - 1] == seq2[l2 - 1]) //  last char matches form both seq,
     *           return 1 + lcsRecursive(seq1, seq2, l1 - 1, l2 - 1);  //  then recursive call for smaller problem
     *       else
     *           int reducing leg1 = lcsRecursive(seq1, seq2, l1 - 1, l2)
     *           int reducing leg2 = lcsRecursive(seq1, seq2, l1, l2 - 1)
     *           max(leg1,leg2);
     */
    private int lcsRecursive(char[] seq1, char[] seq2, int l1, int l2) {
        if (l1 == 0 || l2 == 0)
            return 0;
        if (seq1[l1 - 1] == seq2[l2 - 1])
            return 1 + lcsRecursive(seq1, seq2, l1 - 1, l2 - 1);
        else
            return Math.max(lcsRecursive(seq1, seq2, l1 - 1, l2), lcsRecursive(seq1, seq2, l1, l2 - 1));
    }

    /*
     *      Method 2: This method uses Memoization Technique (an extension of recursive approach).
     *                  memoization (recursion + tabulation)
     *      Flow would be same like recursive one
     *      if(sub-problem is already been solved & result is there in lookup)
     *          use this result
     *      else
     *          compute the result using same recursive call and store the result in lookup
     */
    private int lcsMemoization(char[] seq1, char[] seq2, int l1, int l2, Map<String, Integer> lookup) {

        if (l1 == 0 || l2 == 0)
            return 0;

        // construct a unique map key from dynamic elements of the input
        String key = l1 + "|" + l2;

        if (lookup.containsKey(key))
            return lookup.get(key);

        if (seq1[l1 - 1] == seq2[l2 - 1])
            lookup.put(key, 1 + lcsMemoization(seq1, seq2, l1 - 1, l2 - 1, lookup));
        else {
            int leg1 = lcsMemoization(seq1, seq2, l1 - 1, l2, lookup);
            int leg2 = lcsMemoization(seq1, seq2, l1, l2 - 1, lookup);
            lookup.put(key, Math.max(leg1, leg2));
        }
        return lookup.get(key);
    }

    /*
     *      Method 3: Like other typical Dynamic Programming(DP) problems, re-computation of same sub-problems can be avoided
     *      by constructing a temporary array dp[][] in bottom-up manner.
     *
     *	            | 0                                        if i == 0 or j == 0
     *	LCS[i][j] = | LCS[i – 1][j – 1] + 1                    if X[i-1] == Y[j-1]
     *	            | longest(LCS[i – 1][j], LCS[i][j – 1])    if X[i-1] != Y[j-1]
     *
     *   Time complexity = O(l1l2) , polynomial time complexity.
     *   Space Complexity = O(l1l2), polynomial space complexity.
     * */
    int lcsTabulation(String seq1, String seq2, int l1, int l2) {

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
        return dp[l1][l2];
    }

}
/*
 * O/P =>
 * ------------Recursion-------------
 * The length of the LCS is - 4
 * The length of the LCS is - 2
 * The length of the LCS is - 0
 * The length of the LCS is - 4
 * ------------TopDown-------------
 * The length of the LCS is - 4
 * The length of the LCS is - 2
 * The length of the LCS is - 2
 * The length of the LCS is - 4
 * ------------BottomUp-------------
 * The length of the LCS is - 4
 * The length of the LCS is - 2
 * The length of the LCS is - 0
 * The length of the LCS is - 4
 * */