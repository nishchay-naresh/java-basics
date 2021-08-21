package com.nishchay.core.string;

public class CharArrayToString {

    public static void main(String[] args) {

        m1();
        m2();
        m3();
    }

    private static void m1() {
        char[] charArray = { 'j', 'a', 'v', 'a' };
        String str = new String(charArray);
        System.out.println(str);//java
    }

    private static void m2() {
        char[] arr = {'p', 'e', 'r', 'l'};
        String str = String.valueOf(arr); // perl
        System.out.println(str);
    }

    private static void m3() {
        char[] arr = {'u', 'n', 'i', 'x'};
        String str = String.copyValueOf(arr, 1, 2);
        System.out.println(str); //ni
    }
}
