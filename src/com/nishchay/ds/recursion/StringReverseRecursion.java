package com.nishchay.ds.recursion;

public class StringReverseRecursion {

    public static void main(String[] args) {

          String str = "abcdefg";
//        String str = "MALAYALAM";


        System.out.println("str = " + str);
        // String to charArray
        char charArray[] = str.toCharArray();
        reverseStr(charArray, 0, str.length() - 1);
        // charArray to String
        String revStr = String.valueOf(charArray);
        System.out.println("revStr = " + revStr);

    }


    // String Reverse Using Recursion
    private static void reverseStr(char[] str, int i, int j) {

        if(i < j){
            char t = str[i] ;
            str[i] = str[j];
            str[j] = t;
            reverseStr(str, ++i, --j);
        }
    }

}
