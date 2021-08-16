package com.nishchay.ds.dp;

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
 * https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/
 * */
public class FibonacciArray {

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
        System.out.println("Recursion \t res = " + fibonacciRecursion(n));
    }

    private static void fibonacciDPTopDown(int n) {
        int[] memoize = new int[n+1];
        System.out.println("Memoization \t res = " + fibonacciMemoization(n, memoize));
    }

    private static void fibonacciDPBottomUp(int n) {
        System.out.println("Tabulation \t res = " +fibonacciTabulation(n));
    }

    /*
     *  fibonacci series - using recursion
     *      Time Complexity: O(2 ^ N).
     *	    Auxiliary Space: O(1).
     * */
    private static int fibonacciRecursion(int n) {
        if(n < 2)
            return n;
        return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
    }

    /*
     * TOP-DOWN Approach : fibonacci series - using DP- Memoization
     *      Time Complexity: O(N).
     *	    Auxiliary Space: O(N).
     * */
    private static int fibonacciMemoization(int n, int[] memoize) {

        if (n < 2)
            return n;
        // if we have already solved this subproblem, simply return the result from the cache
        if(memoize[n] != 0)
            return memoize[n];

        memoize[n] = fibonacciMemoization(n-1, memoize) + fibonacciMemoization(n-2, memoize);
        return memoize[n];
    }

    // BOTTOM-UP Approach : fibonacci series - using DP- Tabulation

    private static int fibonacciTabulation(int n) {

        if (n==0) return 0;
        int[] dp = new int[n+1];

        //base cases
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
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