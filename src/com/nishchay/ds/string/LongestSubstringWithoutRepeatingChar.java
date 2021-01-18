package com.nishchay.ds.string;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingChar {

    static final int NO_OF_CHARS = 256;

    static int longestUniqueSubStr(String str) {
        int n = str.length();

        int res = 0; // result 

        // last index of all characters is initialized 
        // as -1 
        int[] lastIndex = new int[NO_OF_CHARS];
        Arrays.fill(lastIndex, -1);

        // Initialize start of current window 
        int i = 0;

        // Move end of current window 
        for (int j = 0; j < n; j++) {

            // Find the last index of str[j] 
            // Update i (starting index of current window) 
            // as maximum of current value of i and last 
            // index plus 1 
            i = Math.max(i, lastIndex[str.charAt(j)] + 1);

            // Update result if we get a larger window 
            res = Math.max(res, j - i + 1);

            // Update last index of j. 
            lastIndex[str.charAt(j)] = j;
        }
        return res;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("The input string is " + str);
        int len = longestUniqueSubStr(str);
        System.out.println("The length of "
                + "the longest non repeating character is " + len);
    }
} 