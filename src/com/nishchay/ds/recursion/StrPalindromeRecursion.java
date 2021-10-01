package com.nishchay.ds.recursion;


/*
 *	=========== Recursive function to check if a string is palindrome===========
 * Given a string, write a recursive function that checks if the given string is a palindrome, else, not a palindrome.
 *
 *	For Example
 *
 *		Input : malayalam
 *		Output : Yes
 *		malayalam.
 *
 *		Input : max
 *		Output : No
 *
 * https://www.geeksforgeeks.org/recursive-function-check-string-palindrome/
 *
 * */
public class StrPalindromeRecursion {

    public static void main(String[] args) {

        System.out.println(" isPalindrome(\"malayalam\") - " + isPalindrome("malayalam"));
        System.out.println(" isPalindrome(\"max\") - " + isPalindrome("max"));
        System.out.println(" isPalindrome(\"nitin\") - " + isPalindrome("nitin"));
    }

    static boolean isPalindrome(String str) {
        int n = str.length();

        // An empty string is considered as palindrome
        if (n == 0)
            return true;

        return isPalRec(str, 0, n - 1);
    }

    /*
     *    The idea of a recursive function is simple:
     *        1) If there is only one character in string return true.
     *        2) Else compare first and last characters and recur for remaining substring.
     * */
    static boolean isPalRec(String str, int s, int e) {
        // If there is only one character
        if (s == e)
            return true;

        // If first and last characters do not match
        if ((str.charAt(s)) != (str.charAt(e)))
            return false;

        // If there are more than two characters, to go for next recursion
        if (s < e + 1)
            return isPalRec(str, s + 1, e - 1);

        return true;
    }
}
