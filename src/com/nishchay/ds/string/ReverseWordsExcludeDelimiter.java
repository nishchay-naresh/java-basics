package com.nishchay.ds.string;


/*
 * Input: “This|| pandemic ;/? will ?? be // over;; soon//?/”
 * Output: “sihT|| cimednap ;/? lliw ?? eb // revo;; noos//?/“
 * */
public class ReverseWordsExcludeDelimiter {

    public static void main(String[] args) {

        System.out.println("---main----");

        String mainString = "This|| pandemic ;/? will ?? be // over;; soon//?/";
        System.out.println("mainString    = " + mainString);
        System.out.println("reverseString = " + reverseWords(mainString));

    }

    private static String reverseWords(String mainString) {

        StringBuilder resultString = new StringBuilder();
        char[] charArray = mainString.toCharArray();

        int start, end;
        int i = start = end = 0;
        while (i < charArray.length) {

            if (i == 0 || isDelimiter(charArray[i - 1])) {
                start = i;
                while (i < charArray.length && !isDelimiter(charArray[i])) {
                    i++;
                }
                end = i - 1;
            }

            String revWords = reverse(charArray, start, end);
            resultString.append(revWords);
            while (i < charArray.length && isDelimiter(charArray[i])) {
                resultString.append(charArray[i]);
                i++;
            }

        }

        return resultString.toString();
    }


    private static boolean isDelimiter(char c) {
        //  0-9 && a-z &&A-Z
        if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c >= 'A' && c <= 'Z') {
            return false;

        }
        return true;
    }

    private static String reverse(char[] arr, int start, int end) {
        StringBuilder revWords = new StringBuilder();
        for (int i = end; i >= start; i--) {
            revWords = revWords.append(arr[i]);
        }
        return revWords.toString();
    }
}
