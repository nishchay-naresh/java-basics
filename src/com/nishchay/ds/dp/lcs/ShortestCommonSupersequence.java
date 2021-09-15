package com.nishchay.ds.dp.lcs;

/*
 *	===========Shortest Common Supersequence===========
 *
 * Given two strings str1 and str2, the task is to find the length of the shortest string that has both str1 and str2 as subsequences.
 *
 * Examples :
 * 		Input:   str1 = "geek",  str2 = "eke"
 * 		Output: 5
 * 		Explanation:
 * 		String "geeke" has both string "geek"
 * 		and "eke" as subsequences.
 *
 * 		Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
 * 		Output:  9
 * 		Explanation:
 * 		String "AGXGTXAYB" has both string
 * 		"AGGTAB" and "GXTXAYB" as subsequences.
 *
 * https://www.geeksforgeeks.org/shortest-common-supersequence/
 *
 * */
public class ShortestCommonSupersequence {


    public static void main(String[] args) {

        ShortestCommonSupersequence ref = new ShortestCommonSupersequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println("Length of the shortest supersequence is - " + ref.scs(s1, s2)); //9

        s1 = "geek";
        s2 = "eke";
        System.out.println("Length of the shortest supersequence is - " + ref.scs(s1, s2)); //5


    }

    /*
     *	This problem is closely related to longest common subsequence problem. Below are steps.
     *	1) Find Longest Common Subsequence (lcs) of two given strings. For example, lcs of “geek” and “eke” is “ek”.
     *	2) Insert non-lcs characters (in their original order in strings) to the lcs found above,
     *    and return the result. So “ek” becomes “geeke” which is shortest common supersequence.
     *
     *		Length of the shortest supersequence
     *			= (Sum of lengths of given two strings)
     *				- (Length of LCS of two given strings)
     *
     * */
    private int scs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // find lcs
        LongestCommonSubsequence ref = new LongestCommonSubsequence();
        int lcsCount = ref.lcsTabulation(str1, str2, str1.length(), str2.length());

        // Result is sum of input string lengths - length of lcs
        return (m + n - lcsCount);
    }
}
