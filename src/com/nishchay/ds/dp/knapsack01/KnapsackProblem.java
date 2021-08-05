package com.nishchay.ds.dp.knapsack01;


/*
 * 0-1 Knapsack Problem
 *
 *
 *	Given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 *	Also given an integer W which represents knapsack capacity,
 *	find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 *	You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 *
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RM1BDv71V60
 * https://www.techiedelight.com/0-1-knapsack-problem/
 *
 * */
public class KnapsackProblem {

    public static void main(String[] args) {

/*
        System.out.println("------------Recursion-------------");
        knapsackRecursionEx();
*/
        System.out.println("------------TopDown-------------");
        knapsackDPTopDown();
        System.out.println("------------BottomUp-------------");
        knapsackDPBottomUp();

    }

    private static void knapsackRecursionEx() {
        KnapsackProblem ks = new KnapsackProblem();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int W = 7;
        int n = weights.length;

        int maxProfit = ks.knapsackRecursive(W, profits, weights, n); //22
        System.out.println("Total knapsack profit ---> " + maxProfit);
        W = 6;
        maxProfit = ks.knapsackRecursive(W, profits, weights, n); // 17
        System.out.println("Total knapsack profit ---> " + maxProfit);

        int[] profits1 = { 60, 100, 120 };
        int[] weights1 = { 10, 20, 30 };
        W = 50;
        n = weights1.length;
        maxProfit = ks.knapsackRecursive(W, profits1, weights1, n); //220
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    private static void knapsackDPTopDown() {

        KnapsackProblem ks = new KnapsackProblem();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int W = 7;
        int n = weights.length;

        int[][] memoize = getMemoize2D(n + 1, W + 1 );
        int maxProfit = ks.knapsackMemoization(W, profits, weights, n, memoize); //22
        System.out.println("Total knapsack profit ---> " + maxProfit);

        W = 6;
        memoize = getMemoize2D(n + 1, W + 1 );
        maxProfit = ks.knapsackMemoization(W, profits, weights, n, memoize); // 17
        System.out.println("Total knapsack profit ---> " + maxProfit);

        int[] profits1 = { 60, 100, 120 };
        int[] weights1 = { 10, 20, 30 };
        W = 50;
        n = weights1.length;
        memoize = getMemoize2D(n + 1, W + 1 );
        maxProfit = ks.knapsackMemoization(W, profits1, weights1, n, memoize); //220
        System.out.println("Total knapsack profit ---> " + maxProfit);

    }

    private static int[][] getMemoize2D(int m, int n) {

        int[][] memoize = new int[m][n];
        // Loop to initially filled the table with -1
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                memoize[i][j] = -1;

         return memoize;
    }

    private static void knapsackDPBottomUp() {

        KnapsackProblem ks = new KnapsackProblem();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int W = 7;
        int n = weights.length;

        int maxProfit = ks.knapsackTabulation(W, profits, weights); //22
        System.out.println("Total knapsack profit ---> " + maxProfit);

        W = 6;
        maxProfit = ks.knapsackTabulation(W, profits, weights); // 17
        System.out.println("Total knapsack profit ---> " + maxProfit);

        int[] profits1 = { 60, 100, 120 };
        int[] weights1 = { 10, 20, 30 };
        W = 50;
        n = weights1.length;
        maxProfit = ks.knapsackTabulation(W, profits1, weights1); //220
        System.out.println("Total knapsack profit ---> " + maxProfit);

    }

    /*
    * Method 1: Recursion by Brute-Force algorithm
    *
    * base case , W=0 when knapsack capacity is - 0
    *           n=0 when we don't have any items to pick
    *           =>  net profit will always be 0
    *
    * pick n-1th(last) element of array and proceeds like below
    *   if (weights[n - 1] > W)
    *       leave current element, exclude it from array
    *       recursively call the same method for shrink array
    *   else
    *       Return the maximum of below two profits:
    *           (1) computed profit when n-1th(last) element included
    *           2) computed profit when n-1th(last) element is not included
    *
    * */
    private int knapsackRecursive(int W, int[] profits, int[] weights, int n) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        if (weights[n - 1] > W)
            return knapsackRecursive(W, profits, weights, n - 1);
        else {
            int excludeLastItem = knapsackRecursive(W, profits, weights, n - 1);
            int includeLastItem = profits[n - 1] + knapsackRecursive(W - weights[n - 1], profits, weights, n - 1);
            return Math.max(excludeLastItem, includeLastItem);
        }
    }
    /*
     *	Time Complexity: O(2n). As there are redundant subproblems.
     *	Auxiliary Space :O(1). As no extra data structure has been used for storing values.
    * */


    /*
    * Method 2: This method uses Memoization Technique (an extension of recursive approach).
    * This method is basically an extension to the recursive approach so that we can overcome the problem of calculating redundant cases
    *  and thus increased complexity. We can solve this problem by simply creating a 2-D array that can store a particular state (n, w)
    *  if we get it the first time. Now if we come across the same state (n, w) again instead of calculating it in exponential complexity we can directly return its result stored in the table in constant time.
    * */
    private int knapsackMemoization(int W, int[] profits, int[] weights, int n, int [][]memoize) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        if (memoize[n][W] != -1)
            return memoize[n][W];

        // Store the value of function call, stack in table before return
        if (weights[n - 1] > W)
            return memoize[n][W] = knapsackMemoization(W, profits, weights, n - 1, memoize);

        else {
            int excludeLastItem = knapsackMemoization(W, profits, weights, n - 1, memoize);
            int includeLastItem = profits[n - 1] + knapsackMemoization(W - weights[n - 1], profits, weights, n - 1, memoize);
            return memoize[n][W] = Math.max(excludeLastItem, includeLastItem);
        }
    }
    /*
     *	Time Complexity: O(N*W). As redundant calculations of states are avoided.
     *	Auxiliary Space: O(N*W). The use of 2D array data structure for storing intermediate states.
    * */


    /*
    * Method 3: Like other typical Dynamic Programming(DP) problems, re-computation of same subproblems can be avoided
    *  by constructing a temporary array dp[][] in bottom-up manner. Following is Dynamic Programming based implementation.
    *
    * In a dp[][] table let’s consider all the possible weights from ‘0’ to ‘W’ as the columns and weights that can be kept as the rows.
    * dp[n+1][W+1] , n in Y axis, W in x axis
    *
    * First fill the 0th row & 0th column based on base case
    * then fill rest of the table(matrix) using the same recursive methods
    *
    * */
    private int knapsackTabulation(int W, int[] val, int[] wt) {

        int len = val.length;
        int[][] dp = new int[len + 1][W + 1];

        // Build table dp[][] in bottom up manner
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= W; j++) {
                 // initialisation
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    int excludeLastItem = dp[i - 1][j];
                    int includeLastItem = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                    dp[i][j] = Math.max(excludeLastItem, includeLastItem);
                }
            }
        }

        // return last element of the table - result
        return dp[len][W];
    }
}
