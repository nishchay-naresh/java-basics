package com.nishchay.test.epam;

/**
 * Longest Common Prefix
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 * 
 **/

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strArr = new String[]{"flower","flow","flight"};
//        String[] strArr = new String[]{"dog","racecar","car"};

        String res = longestCommonPrefix(strArr);
        System.out.println("res = " + res);

    }

    private static String longestCommonPrefix(String[] strArr) {

        char[] res = new char[strArr[0].length()];

        boolean filed = true;

        for (int i = 0; i < res.length && filed ; i++) {

            // comapring the first char
            if (i < strArr[0].length() && i<strArr[1].length() &&  strArr[0].charAt(i) == strArr[1].charAt(i)){
                // check for char first char in rest of the string
                if(testOthers(strArr,i)){
                    res[i] = strArr[0].charAt(i);
                }else {
                    filed = false;
                }
            }

        }
        return new String(res);
    }

    private static boolean testOthers(String[] strArr, int index) {

        char matchingChar = strArr[0].charAt(index);
        for (int i = 1; i < strArr.length ; i++) {
            if(matchingChar != strArr[i].charAt(index)){
                return false;
            }
        }
        return true;
    }

    // O(k * n)
    /*
    * Array length - 200
    * string length - 200
    * O(n)
    * (N * n)
    * n - length of the smallest string in array
    *
    * N - for finding the smallest in array
    * n * N - to find the prefix
    *
    * */

}
