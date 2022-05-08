package com.nishchay.core.string;

public class StringOnlineTest {

    public static void main(String[] args) {

//        stringsQuiz1();
//        stringsQuiz2();
        replaceBraceInLogger();
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


    private static void stringsQuiz2() {
        System.out.println("JavaScript".substring(4));// Script
        System.out.println("JavaScript".substring(0, 4));// Java
        System.out.println("smiles".substring(1, 5));// 1, n-1 => 1,4 =>mile

        String str = "java".replace('a', '0');
        System.out.println(str);

        System.out.println("Java"+1000+2000+3000); // Java100020003000 L-> R
        System.out.println(1000+2000+3000+"Java"); // 6000Java L-> R
        System.out.println(7.7+3.3+"Java"+3.3+7.7); // 11.0Java3.37.7
        System.out.println("ONE"+2+3+4+"FIVE"); //ONE234FIVE

        System.out.println("null"+null+1); //nullnull1
        //System.out.println(1+null+"null"); // CE

        String blanks = "    ";
        System.out.println(blanks.isEmpty()); // false
    }

    private static void replaceBraceInLogger() {
        // Initialising String
        String str = "Welcome to geeksforgeeks";

        System.out.println(str);
        str = str.replace('e', '#');
        System.out.println(str);

        str = "cache{}Name";
        System.out.println(str);
        str = str.replace("{", "\\\\{");
        System.out.println(str);
    }

}
