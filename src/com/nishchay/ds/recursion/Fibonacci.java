package com.nishchay.ds.recursion;

/*
 *	Fibonacci numbers, commonly denoted Fn, form a sequence, called the Fibonacci sequence.
 *	Such that each number is the sum of the two preceding ones, starting from 0 and 1.
 *	That is,
 *
 *	F0=0,F1=1,
 *	and
 *	Fn=Fn-1+Fn-2
 *	for n > 1
 *
 *	The beginning of the sequence is thus:
 *	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, ...
 *----------------
 *  n 	=	0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	...
 * xn 	=	0	1	1	2	3	5	8	13	21	34	55	89	144	233	377	...
 *
 * */
public class Fibonacci {

    public static void main(String[] args) {

        int n = 8; // 21


//        int n = 8 ; // 21
//        int n = 9 ; // 34
//        int n = 12 ; // 144
//        int n = 20 ; // 4181
//        int n = 22 ; // 10946


//        fibonacciIterative(n);
        System.out.println(fibonacciRecursion(n));
        System.out.println(fibonacciRecursion1(n));

    }

    private static int fibonacciRecursion(int n) {

        if (n <= 1)
            return n;
        else
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);

    }

    private static int fibonacciRecursion1(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return fibonacciRecursion1(n - 1) + fibonacciRecursion1(n - 2);
    }

    private static void fibonacciIterative(int n) {
        int t1, t2, t3;
        t1 = 0;
        t2 = 1;
        System.out.print("Series -  " + t1 + " " + t2);
        for (int i = 0; i < n - 2; i++) {
            t3 = t1 + t2;
            System.out.print(" " + t3);
            t1 = t2;
            t2 = t3;
        }
    }

}
