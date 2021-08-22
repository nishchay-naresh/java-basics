package com.nishchay.ds.recursion;

public class PrintFibonacci {
    public static void main(String[] args) {

//        printFibo(10);

        printFibo(0, 1, 8);
    }

    /*
     * Fibonacci series using iteration
     * */
    private static void printFibo(int n) {

        int a = 0;
        int b = 1;
        int c;
        if (n <= 2) {
            System.out.print(a);
            System.out.print(b);
        }
        n = n - 2;

        for (int i = 1; i <= n; i++) {
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }

    }

    /*
     * Fibonacci series using recursion
     * */
    private static void printFibo(int a, int b, int n) {

        int c;
        if (n >= 2) {
            System.out.println(a);
            System.out.println(b);
            n = n - 2;
        }
        if (n > 1) {
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
            n = n - 1;

            printFibo(b, c, n);
        }
    }

}
