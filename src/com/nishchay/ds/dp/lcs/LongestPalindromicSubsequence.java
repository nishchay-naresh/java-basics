package com.nishchay.ds.dp.lcs;

/*
 *	===========Longest Palindromic Subsequence (LPS)===========
 *
 * Given a sequence, find the length of the longest palindromic subsequence in it.
 *
 * Ex - str = "agbcba" find the LPS for it
 *
 * Subsequence  ->  Palindromic Subsequence  -> Longest
 *
 * Palindromic Subsequence => 	abcba
 * 								bcb
 * 								b
 *
 * LPS = abcba = 5
 * https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 *
 * */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

        LongestPalindromicSubsequence ref = new LongestPalindromicSubsequence();

        String str1 = "agbcba";
        System.out.println("The length of the LPS is - " +ref.lps(str1)); //5 //abcba

        str1 = "ABBDCACB";
        System.out.println("The length of the LPS is - " +ref.lps(str1)); //5 //BCACB

        str1 = "GEEKSFORGEEKS";
        System.out.println("The length of the LPS is - " +ref.lps(str1)); //5 //EEKEE, EESEE, EEFEE

    }

    /*
     *   LPS - Longest Palindromic Subsequence
     *   LPS(s)	=	LCS(s, s.reverse)
     *   Time Complexity: O(n^2), n - length of the string
     * */
    int lps(String str1) {
        String str2 =  new StringBuilder(str1).reverse().toString();

        // find lcs
        LongestCommonSubsequence ref = new LongestCommonSubsequence();
        int lcsCount = ref.lcsTabulation(str1, str2, str1.length(), str2.length());

        return lcsCount;
    }


}
