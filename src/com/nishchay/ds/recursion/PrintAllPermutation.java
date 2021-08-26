package com.nishchay.ds.recursion;

/*
 * Java program to print all permutations of a given string.
 * Print all permutations of a given string
 * Str - ABC  {ABC, ACB, BAC, BCA, CAB, CBA}
 *
 * */
public class PrintAllPermutation {

    public static void main(String[] args) {
        String str = "ABC";
        int len = str.length();
        strPermute(str, 0, len - 1);
    }


    /**
     * permutation function
     *
     * @param str   string to calculate permutation for
     * @param start starting index
     * @param end   end index
     */
    private static void strPermute(String str, int start, int end) {
        if (start == end)
            System.out.println(str);
        else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i); // first swap -> to find combination.
                strPermute(str, start + 1, end);
                str = swap(str, start, i); //swap back for backtracking
                // since we are modifying the actual string. So we need to put it back after printing the desired combination
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
