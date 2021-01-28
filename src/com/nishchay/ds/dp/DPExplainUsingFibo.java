package com.nishchay.ds.dp;

import java.util.HashMap;
import java.util.Map;

public class DPExplainUsingFibo {

    public static void main(String[] args) {

//        int n = 8 ; // 34
//        int n = 12 ; // 233
        int n = 20 ; // 10946

        fibonacciRecursionEx(n);
        fibonacciDPEx(n);
        fibonacciDPEx1(n);

    }


    private static void fibonacciRecursionEx(int n) {

        long start = System.currentTimeMillis();
        int res = fibonacciRecursion(n);
        long end = System.currentTimeMillis();
        long time = end-start;

        System.out.println("res = " + res + " \t time - " + time);
    }

    private static void fibonacciDPEx(int n) {

        Map<Integer, Integer> table = new HashMap<>();
        table.put(1, 1);
        table.put(0, 1);

        long start = System.currentTimeMillis();
        int res = fibonacciMemoization(n, table);
        long end = System.currentTimeMillis();
        long time = end-start;

        System.out.println("res = " + res + " \t time - " + time);
    }

    private static void fibonacciDPEx1(int n) {

        Map<Integer, Integer> table = new HashMap<>();
        table.put(1, 1);
        table.put(0, 1);

        long start = System.currentTimeMillis();
        int res = fibonacciTabulation(n, table);
        long end = System.currentTimeMillis();
        long time = end-start;

        System.out.println("res = " + res + " \t time - " + time);
    }

    // fibonacci series - using recursion
    private static int fibonacciRecursion(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;

        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    // TOP-DOWN Approach : fibonacci series - using DP- Memoization
    private static int fibonacciMemoization(int n, Map<Integer, Integer> table) {

        if(!table.containsKey(n))
            table.put(n,fibonacciMemoization(n-1, table) + fibonacciMemoization(n-2, table) );

        // this is O(1) constant time complexity
        return table.get(n);
    }

    // BOTTOM-UP Approach : fibonacci series - using DP- Tabulation
    private static int fibonacciTabulation(int n, Map<Integer, Integer> table) {

        // this is O(n) linear time complexity
        for (int i = 2; i <= n ; i++)
            table.put(i, table.get(i-1) + table.get(i-2));

        return table.get(n);
    }

}
/*
* o/p =>
* res = 10946 	 time - 8
* res = 10946 	 time - 0
* res = 10946 	 time - 0
*
* */