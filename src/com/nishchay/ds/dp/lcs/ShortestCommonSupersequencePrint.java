package com.nishchay.ds.dp.lcs;

/*
 *	===========Printing Shortest Common Supersequence===========
 *
 * Given two strings str1 and str2, print the shortest string that has both str1 and str2 as subsequences. If multiple shortest supersequence exists, print any one of them.
 *
 * Examples :
 *		Input: X = "AGGTAB",  Y = "GXTXAYB"
 *		Output: "AGXGTXAYB" OR "AGGXTXAYB"
 *		OR Any string that represents shortest
 *		supersequence of X and Y
 *
 *		Input: X = "HELLO",  Y = "GEEK"
 *		Output: "GEHEKLLO" OR "GHEEKLLO"
 *		OR Any string that represents shortest
 *		supersequence of X and Y

 *
 * https://www.geeksforgeeks.org/print-shortest-common-supersequence/
 *
 * */
public class ShortestCommonSupersequencePrint {

    public static void main(String[] args) {

        ShortestCommonSupersequencePrint ref = new ShortestCommonSupersequencePrint();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println("Length of the shortest supersequence is - " + ref.scsPrint(s1, s2)); //"AGXGTXAYB" OR "AGGXTXAYB"

        s1 = "HELLO";
        s2 = "GEEK";
        System.out.println("Length of the shortest supersequence is - " + ref.scsPrint(s1, s2)); //"GEHEKLLO" OR "GHEEKLLO" OR "HGELLOEK"

        s1 = "geek";
        s2 = "eke";
        System.out.println("Length of the shortest supersequence is - " + ref.scsPrint(s1, s2)); //geeke

    }

    /*
     *	This problem is closely related to longest common subsequence problem. Below are steps.
     *  We will refer the same logic of LCS string printing, which we doing using 2D array of dp
     *  printing logic will be = take all unique char from both string + take only one instance for lcs char
     *
     *	1) Find Longest Common Subsequence (lcs) of two given strings. and populate its 2D dp matrix
     *	2) Traverse this 2D array of dp, get the LCS string printing
     *
     *
     * */
    private String scsPrint(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        // first we will populate dp 2D array, using lcs dp solution
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                // initialisation - if either of the sequence is empty - first row & first column
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Once we have 2D array dp populated with data, we will get the LCS string using this 2D array dp
        // Following code is used to print LCS

        // string to store the shortest supersequence
        StringBuilder sb = new StringBuilder();

        // Start from the bottom right corner and one by one
        // push characters in output string
        int i = l1, j = l2;
        while (i > 0 && j > 0) {
            // If current character in X and Y are same, then
            // current character is part of shortest supersequence
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                // Put current character in result
                sb.append(str1.charAt(i - 1));

                // reduce values of i, j and index
                i--;
                j--;
            }
            // If current character in X and Y are different
            else if (dp[i - 1][j] > dp[i][j - 1]) {


                // Put current character of X in result
                sb.append(str1.charAt(i - 1));

                // reduce values of i and index
                i--;
            } else {
                // Put current character of Y in result
                sb.append(str2.charAt(j - 1));

                // reduce values of j and index
                j--;
            }

        }

        // If Y reaches its end, put remaining characters
        // of X in the result string
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }

        // If X reaches its end, put remaining characters
        // of Y in the result string
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        // reverse the string and return it
        String scsString = sb.reverse().toString();
        return scsString;
    }
}
/*
 * O/P =>
 * Length of the shortest supersequence is - AGGXTXAYB
 * Length of the shortest supersequence is - HGELLOEK
 * Length of the shortest supersequence is - geeke
 * */