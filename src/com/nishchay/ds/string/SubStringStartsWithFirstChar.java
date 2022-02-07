package com.nishchay.ds.string;

/*
 * Program to print all substrings of a given string
 *
 *	Given a string as an input. We need to write a program
 *  that will print all substrings of that given string starting with the first starting char
 *
 *	Examples :
 *
 *	Input :  bdca
 *	Output :    1 -> b
 *              2 -> bd, bc, ba
 *              3 -> bdc, bda
 *              4 -> bdca
 *
 * */
public class SubStringStartsWithFirstChar {

    public static void main(String[] args) {

        printSubStr("bdca");
        System.out.println("------------------------------");
        printSubStr("qwerty");
    }

    private static void printSubStr(String Str) {
        String leftPart = "";
        // char to String
        String temp = Character.toString(Str.charAt(0));
        System.out.println("substr = " + temp);

        for (int i = 1; i <= Str.length(); i++) {
            leftPart = Str.substring(0, i - 1);
            for (int j = i - 1; j > 0 && j < Str.length(); j++) {
                temp = leftPart + Str.charAt(j);
                System.out.println("substr = " + temp);
            }
        }
    }

}