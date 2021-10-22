package com.nishchay.core.string;

public class StringOnlineTest {

    public static void main(String[] args) {

        stringsQuiz1();

    }

    private static void stringsQuiz1() {

        String str1 = "Java";
        String str2 = "Java";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.hashCode() == str2.hashCode());
        System.out.println("Java" == new String("Java"));//false
        System.out.println("java".toUpperCase() == "JAVA");//false

        String str3 = "Java";
        String str4 = str3.intern();
        System.out.println(str3 == str4); // true
        System.out.println(str3.equals(str4)); // true
        System.out.println(str3.hashCode() == str4.hashCode()); // true

        String s1 = new String("JAVA");
        String s2 = new String("JAVA");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2.intern());
        System.out.println(s1.intern() == s2);
        System.out.println(s1.intern() == s2.intern());
    }


}
