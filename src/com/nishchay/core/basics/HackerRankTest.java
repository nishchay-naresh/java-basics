package com.nishchay.core.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/*
 *	=========== Ways to read input from console in Java ===========
 *
 *	1. Using Buffered Reader Class
 *	2. Using Scanner Class
 *	3. Using Console Class
 *	4. Using Command line argument
 *
 *
 * https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/
 *
 * */

public class HackerRankTest {

    public static void main(String[] args) throws IOException {

        usingBufferedReader();
        usingScanner();

        // not working with IDE
        // usingConsole();
    }

    /*
     *  1. Using Buffered Reader Class
     *      The input is buffered for efficient reading.
     *      input can have space
     * */
    private static void usingBufferedReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine(); // java is a prog language
        System.out.println("input = " + input);

        // To read other types, we use functions like Integer.parseInt(), Double.parseDouble().
        // To read multiple values, we use split().
    }

    /*
     *  1. Using Buffered Reader Class
     *    Convenient methods for parsing primitives (nextInt(), nextFloat(), …) from the tokenized input.
     *    input should be without space
     * */
    private static void usingScanner() throws IOException {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        System.out.println("You entered string - " + s);

        int a = in.nextInt();
        System.out.println("You entered integer - " + a);

        float b = in.nextFloat();
        System.out.println("You entered float - " + b);

        in.close();
    }


    /*
     *  1. Using Buffered Reader Class
     *    Reading password without echoing the entered characters.
     *    Does not work in non-interactive environment (such as in an IDE).
     * */
    private static void usingConsole() throws IOException {

        String name = System.console().readLine();
        System.out.println("You entered string " + name);
    }

}
