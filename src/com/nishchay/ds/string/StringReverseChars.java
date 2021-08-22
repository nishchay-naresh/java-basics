package com.nishchay.ds.string;

/*
 * Reverse a String character wise - each character should be reversed in a string
 *       str = MALAYALAM, Output = MALAYALAM
 *       str = india, Output = aidin
 *
 * */
public class StringReverseChars {

    public static void main(String[] args) {

        System.out.println("---------stringReverseArrayWay-------");
        stringReverseArrayEx();
        System.out.println("---------stringReverseJavaWay-------");
        stringReverseJavaWayEx();
    }

    private static void stringReverseArrayEx(){

        StringReverseChars  ref = new  StringReverseChars();

        String str = "india";
        String revStr = ref.stringReverseArray(str);
        System.out.println("Original String : " + str);
        System.out.println("Reverse String  : " + revStr);

        str = "MALAYALAM";
        revStr = ref.stringReverseArray(str);
        System.out.println("Original String : " + str);
        System.out.println("Reverse String  : " + revStr);
    }

    private static void stringReverseJavaWayEx(){

        StringReverseChars  ref = new  StringReverseChars();

        String str = "india";
        String revStr = ref.stringReverseBuilder(str);
        System.out.println("Original String : " + str);
        System.out.println("Reverse String  : " + revStr);

        str = "MALAYALAM";
        revStr = ref.stringReverseBuilder(str);
        System.out.println("Original String : " + str);
        System.out.println("Reverse String  : " + revStr);
    }


    // string reverse -> char array -> array reverse -> string
    private String stringReverseArray(String str) {

        int len = str.length();
        char[] charArray = str.toCharArray();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            // swap ith & jth element
            char t = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = t;
        }

        // Convert array of strings into a string in Java 8
        String revStr = String.valueOf(charArray);
        return revStr;
    }

    /*
    * java way to reverse string
    * string reverse -> string builder -> using string builder reverse method -> string
    * */
    private String stringReverseBuilder(String str) {
        String revStr =  new StringBuilder(str).reverse().toString();
        return revStr;
    }
}
