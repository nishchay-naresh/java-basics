package com.nishchay.ds.dp.lcs;

/*
 *	===========Minimum number of deletion in a string to make it a palindrome===========
 *
 * Given a string of size ‘n’. The task is to remove or delete the minimum number of characters from the string
 * so that the resultant string is a palindrome.
 *
 *  Examples :
 *
 *		Input : aebcbda
 *		Output : 2
 *		Remove characters 'e' and 'd'
 *		Resultant string will be 'abcba'
 *		which is a palindromic string
 *
 * https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
 *
 * */
public class MinNoOfDeletionForPalindrome {

    public static void main(String[] args) {

        MinNoOfDeletionForPalindrome ref = new MinNoOfDeletionForPalindrome();

        String str1 = "aebcbda";
        System.out.println("Minimum number of deletions = "+ ref.minimumNumberOfDeletions(str1)); //2

        str1 = "geeksforgeeks";
        System.out.println("Minimum number of deletions = "+ ref.minimumNumberOfDeletions(str1)); //8


    }

    /*
    *  min # of deletion for deletion = s.length() - LPS(s)
    *  Time Complexity: O(n^2), n - length of the string
    * */
    private int minimumNumberOfDeletions(String str){

        int strLength = str.length();

        // find lps
        LongestPalindromicSubsequence ref = new LongestPalindromicSubsequence();
        int lpsCount = ref.lps(str);

        // After removing characters other than the lps, we get palindrome.
        return (strLength - lpsCount);
    }

}
