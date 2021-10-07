package com.nishchay.ds.dp.diagonal;


/*
 *	===========Count Palindromic Substring===========
 * Count All Palindrome Sub-Strings in a String
 *
 *  Given a string, the task is to count all palindrome sub string in a given string.
 *  Length of palindrome sub string is greater than or equal to 2.
 *
 * For example -
 * 				Input : str = "abaab"
 * 				Output: 3
 * 				Explanation :
 * 				All palindrome substring are :
 * 				 "aba" , "aa" , "baab"
 *
 * 				Input : str = "abbaeae"
 * 				Output: 4
 * 				Explanation :
 * 				All palindrome substring are :
 * 				"bb" , "abba" ,"aea","eae"
 *
 * 				Input : str = "abccbc"
 * 				Output: 3 cc, cbc, bccb
 *
 * https://www.geeksforgeeks.org/count-palindrome-sub-strings-string/
 * https://www.youtube.com/watch?v=XmSOWnL6T_I&ab_channel=Pepcoding
 * */
public class CountPalindromicSubstring {


    public static void main(String[] args) {
        String str = "abaab";
        System.out.println("Palindromic Substring count - " + countPalSubstr(str)); //3

        str = "abbaeae";
        System.out.println("Palindromic Substring count - " + countPalSubstr(str)); //4

        str = "abccbc";
        System.out.println("Palindromic Substring count - " + countPalSubstr(str)); //3
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
    private static int countPalSubstr(String str){
        int n = str.length();

        boolean[][] dp = new boolean[n][n];
        int count = 0;
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

                if(gap != 0 && dp[i][j]){
                    count++;
                }
            }
        }

        return count;
    }
}
