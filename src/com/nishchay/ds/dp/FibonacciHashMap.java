package com.nishchay.ds.dp;

import java.util.HashMap;
import java.util.Map;

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
 *	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765 ...
 *----------------
 *  n 	=	0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	...
 * xn 	=	0	1	1	2	3	5	8	13	21	34	55	89	144	233	377	...
 *
 * */
public class FibonacciHashMap {

    public static void main(String[] args) {


//        int n = 7 ; // 13
//        int n = 8 ; // 21
//        int n = 12 ; // 144
//        int n = 25; // 75025
        int n = 32; // 2178309

        fibonacciRecursionEx(n);
        fibonacciDPTopDown(n);
        fibonacciDPBottomUp(n);

    }


    private static void fibonacciRecursionEx(int n) {

        long start = System.currentTimeMillis();
        int res = fibonacciRecursion(n);
        long time = System.currentTimeMillis() - start;

        System.out.println("Recursion \t res = " + res + " \t time - " + time);
    }

    private static void fibonacciDPTopDown(int n) {

        Map<Integer, Integer> table = new HashMap<>();
        table.put(1, 0);
        table.put(2, 1);

        long start = System.currentTimeMillis();
        int res = fibonacciMemoization(n, table);
        long time = System.currentTimeMillis() - start;

        System.out.println("Memoization \t res = " + res + " \t time - " + time);
    }

    private static void fibonacciDPBottomUp(int n) {

        Map<Integer, Integer> table = new HashMap<>();

        long start = System.currentTimeMillis();
        int res = fibonacciTabulation(n, table);
        long time = System.currentTimeMillis() - start;

        System.out.println("Tabulation \t res = " + res + " \t time - " + time);
    }

    // fibonacci series - using recursion
    private static int fibonacciRecursion(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    // TOP-DOWN Approach : fibonacci series - using DP- Memoization
    private static int fibonacciMemoization(int n, Map<Integer, Integer> memo) {

        if (n < 2)
            return n;
        if (memo.containsKey(n))
            return memo.get(n);

        memo.put(n, fibonacciMemoization(n - 1, memo) + fibonacciMemoization(n - 2, memo));
        return memo.get(n);
    }

    // BOTTOM-UP Approach : fibonacci series - using DP- Tabulation
    private static int fibonacciTabulation(int n, Map<Integer, Integer> table) {

        if (n == 0) return 0;

        //base cases
        table.put(0, 0);
        table.put(1, 1);

        for (int i = 2; i <= n; i++)
            table.put(i, table.get(i - 1) + table.get(i - 2));

        return table.get(n);
    }

}
/*
 * o/p =>
 *	Recursion 	 res = 75025 	 time - 5
 *	Memoization 	 res = 75025 	 time - 0
 *	Tabulation 	 res = 75025 	 time - 0
 *	-------
 *	Recursion 	 res = 2178309 	 time - 93
 *	Memoization 	 res = 2178309 	 time - 0
 *	Tabulation 	 res = 2178309 	 time - 0
 *
 * */