package com.nishchay.core.string;

public class StringTest {

    public static void main(String[] args) {

        String one = "1";
        final String oneF = "1";
        String s0 = "java1";
        String s = "java1";
        String j = "java";
        String s1 = "java" + one;
        String s2 = "java" + 1;
        String s3 = j + one;
        String s4 = j + 1;
        String s5 = "java1" + "1";
        String s6 = j + oneF;



/*
    So, a = a + b is the equivalent of

    a = new StringBuilder()
        .append(a)
        .append(b)
        .toString();
*/


        System.out.println(s == s0);// t
        System.out.println(s == s1);// f
        System.out.println(s.equals(s1));// t
        System.out.println(s == s2);// t
        System.out.println(s == s3);// f
        System.out.println(s == s4);// f
        System.out.println(s == s5);// f
        System.out.println(s == s6);// f



    }
}
