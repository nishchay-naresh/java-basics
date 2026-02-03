package com.nishchay.ds.dp.diagonal;

/*
 *	===========Longest Palindromic Substring===========
 *
 * Given a string, find the longest substring which is palindrome.
 *
 * For example -
 *
 * 				Input: Given string :"forgeeksskeegfor",
 * 				Output: "geeksskeeg"
 *
 * 				Input: Given string :"Geeks",
 * 				Output: "ee"
 *
 * 				Input: Given string :"aaaabbaa",
 * 				Output: "aabbaa"
 *
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * https://www.youtube.com/watch?v=UflHuQj6MVA&ab_channel=TECHDOSE
 *
 * */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        System.out.println("------------Brute Force-------------");
        longestPalSubstrEx();
        System.out.println("------------BottomUp-------------");
        longestPalSubstrDP();

    }

    private static void longestPalSubstrEx() {
        String str = "forgeeksskeegfor";
        System.out.println("Longest Palindromic Substring Length - " + longestPalSubstrBasic(str));

        str = "aaaabbaa";
        System.out.println("Longest Palindromic Substring Length - " + longestPalSubstrBasic(str));
    }

    private static void longestPalSubstrDP() {
        String str = "forgeeksskeegfor";
        System.out.println("Longest Palindromic Substring Length - " + longestPalSubstr(str));

        str = "aaaabbaa";
        System.out.println("Longest Palindromic Substring Length - " + longestPalSubstr(str));
    }

    /*
     * Brute Force approach
     *   first generate all possible substrings from main string - 2 nested loop required for this
     *   then check each substring whether it is palindrome or not - 1 inner loop to checks palindrome
     *
     * Time complexity: O(n^3)
     * Auxiliary complexity: O(1)
     * */
    private static int longestPalSubstrBasic(String str) {


        int longSubStrLen = 0;
        String longSubStr = "";

        //generate all possible substrings from main string
        StringBuilder sb = new StringBuilder();

        int length = str.length();
        for (int len = 1; len <= length; len++) {
            for (int j = 0; j <= length - len; j++) {

                for (int k = j; k < j + len; k++) {
                    sb.append(str.charAt(k));
                }
                String subStr = sb.toString();
                sb.setLength(0);

                // check each substring whether it is palindrome or not
                if (isPalindrome(subStr)) {
                    longSubStrLen = Math.max(longSubStrLen, subStr.length());
                    longSubStr = subStr;
                }

            }
        }

        System.out.println("longSubStr = " + longSubStr);
        System.out.println("longSubStrLen = " + longSubStrLen);
        return longSubStrLen;
    }


    /*
     * DP approach - bottom up
     * diagonal element will be true - bcus a string of length 1 is palindrome
     * diagonal - 1 => str[i] == str[j]
     * diagonal - 2  onward => str[i] == str[j]  &&  isPalindrom(str.substr(i+1,j-1)) == true
     *
     * Time complexity: O(n2)
     * Auxiliary Space: O(n2)
     * */
    private static int longestPalSubstr(String str){

        int n = str.length();

        int longSubStrLen = 0;
        String longSubStr = "";
        boolean[][] dp = new boolean[n][n];

        for (int gap = 0; gap < n; gap++) {
            // Pick starting point for current gap - which is always 0
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) { // always true
                    dp[i][j] = true;
                } else if (gap == 1) { // str[i] == str[j]
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? true : false;
                } else { //  str[i] == str[j]  &&  isPalindrom(str.substr(i+1,j-1)) == true
                    dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true ? true : false;
                }

                if(dp[i][j]){ // since gap is always getting increased, so it will gets updated
                    longSubStrLen = gap + 1;
                    longSubStr = str.substring(i, j);
                }
            }
        }
        System.out.println("longSubStr = " + longSubStr);
        System.out.println("longSubStrLen = " + longSubStrLen);
        return longSubStrLen;
    }

    private static boolean isPalindrome(String string) {
        char[] charArray = string.toCharArray();

        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            if(charArray[i] != charArray[j]){
                return false;
            }
        }
        return true;
    }

}
