package com.nishchay.ds.recursion.prac;

public class PrintNNumbers {

    public static void main(String[] args) {
        int n = 8;

        System.out.println("\n ------------printing  1 to n-------------");
        printN(n);
        System.out.println("\n------------printing  n to 1-------------");
        printN_rev(n);
    }

    /*
     * recursive solution
     * printing 1 to n
     * */
    private static void printN(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printN(n - 1);
        System.out.print(n + " ");
    }

    /*
     * recursive solution
     * printing  n to 1
     * */
    private static void printN_rev(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printN_rev(n - 1);
    }
}
