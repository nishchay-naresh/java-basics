package com.nishchay.ds.string;

/*
 * Java program to print all permutations of a given string.
 * Print all permutations of a given string
 * Str - ABC  {ABC, ACB, BAC, BCA, CAB, CBA}
 *
 * */
public class PrintAllPermutation {

    public static void main(String[] args) {
        String str = "ABCD";
        int n = str.length();
        strPermute(str, 0, n - 1);
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
                str = swap(str, start, i);
                strPermute(str, start + 1, end);
                str = swap(str, start, i);
            }
        }
    }

    private static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
