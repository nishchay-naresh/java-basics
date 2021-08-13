package com.nishchay.ds.dp.knapsackunbound;


/*
 *	===========Unbounded Knapsack (Repetition of items allowed)===========

 *	You are given ‘N’ items with certain ‘PROFIT’ and ‘WEIGHT’ and a knapsack with weight capacity ‘W’.
 *	You need to fill the knapsack with the items in such a way that you get the maximum profit.
 *	You are allowed to take one item multiple times.
 *
 *	For Example
 *			Let us say we have 'N' = 3 items and a knapsack of capacity 'W' =  10
 *			'PROFIT' = { 5, 11, 13 }
 *			'WEIGHT' = { 2, 4, 6 }
 *
 *			We can fill the knapsack as:
 *
 *			1 item of weight 6 and 1 item of weight 4.  = 13 + 11 = 24
 *			1 item of weight 6 and 2 items of weight 2. = 13 + 2*5 = 23
 *			2 items of weight 4 and 1 item of weight 2. = 11*2 + 5 = 27
 *			5 items of weight 2.                        =  5*5 = 25
 *
 *			The maximum profit will be from case 3 i.e ‘27’. Therefore maximum profit = 27.
 *
 *			Input : W = 8
 *					val[] = {10, 40, 50, 70}
 *					wt[]  = {1, 3, 4, 5}
 *			Output : 110
 *			We get maximum value with one unit of
 *			weight 5 and one unit of weight 3.
 *
 * https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
 * https://iq.opengenus.org/unbounded-knapsack-problem/
 *
 * */
public class UnboundedKnapsack {

    public static void main(String[] args) {

        knapsackDPBottomUp();

    }


    private static void knapsackDPBottomUp() {

        UnboundedKnapsack ks = new UnboundedKnapsack();
        int[] values = {10, 40, 50, 70};
        int[] weights = {1, 3, 4, 5};
        int W = 8;

        int maxProfit = ks.unboundedKnapsackTabulation(W, values, weights); //110
        System.out.println("Total knapsack profit ---> " + maxProfit);

        values = new int[]{5, 11, 13};
        weights = new int[]{2, 4, 6};
        W = 10;
        maxProfit = ks.unboundedKnapsackTabulation(W, values, weights); // 27
        System.out.println("Total knapsack profit ---> " + maxProfit);

        values = new int[]{10, 30, 20};
        weights = new int[]{5, 10, 15};
        W = 100;
        maxProfit = ks.unboundedKnapsackTabulation(W, values, weights); //300
        System.out.println("Total knapsack profit ---> " + maxProfit);

        values = new int[]{15, 14, 10, 45, 30};
        weights = new int[]{2, 5, 1, 3, 4};
        W = 7;
        maxProfit = ks.unboundedKnapsackTabulation(W, values, weights); //100
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    /*
     *	Dynamic Programming Approach
     *	We use dynamic programming approach to solve this problem, similar to what we did in classical knapsack problem.
     *	The only difference is we would use a single dimensional array instead of 2-D one used in the classical one.
     *	This is because we have infinite supply of every element available to us and hence,
     *	we don't need to keep a track of which elements have been used.
     *
     *  Thus, our array would be dp[W+1] , where dp[i] indicates the maximum profit we can achieve with a knapsack capacity of i.
     *  Here, W is the total knapsack capacity, hence our answer would be dp[W]
     *          dp[i] = maximum profit we can achieve with a knapsack capacity of i
     *
     * our dp equation would look something like-
     *      dp[i] = max(dp[i], dp[i-wt[j]] + val[j]) if wt[j] < i (item j is taken)
     *
     *	dp[i] = 0 , i varies from 0 to W+1 // initialization
     *
     *	dp[c] = max(dp[c], dp[c-wt[j]] + val[j]
     *	                   where j varies from 0 to n-1 such that:
     *	                   wt[j] <= i
     *          // we need to take max(dp[c]), bcus these dp[c] gets updated for each iteration of j, need to take max of all
     *	result = d[W]
     *
     * */

    private int unboundedKnapsackTabulation(int W, int[] val, int[] wt) {

        // dp[i] is going to store maximum value with knapsack capacity i.
        int[] dp = new int[W + 1];
        dp[0] = 0;

        // we need to take max(dp[c]), bcus these dp[c] gets updated for each iteration of j, need to take max of all
        for (int c = 1; c <= W; c++) {
            for (int j = 0; j < val.length; j++) {
                if (wt[j] <= c) {
                    dp[c] = Math.max(dp[c], dp[c - wt[j]] + val[j]);
                }
            }
        }
        return dp[W];
    }



/*
    private int unboundedKnapsackTabulation(int capacity, int[] val, int[] wt) {

        // dp[i] is going to store maximum value
        // with knapsack capacity i.
        int[] dp = new int[capacity + 1];
        dp[0] =0;

        // Fill dp[] using above recursive formula
        for (int bagc = 1; bagc <= capacity; bagc++) {
            int max = 0;
            for (int i = 0; i < val.length; i++) {

                if (wt[i] <= bagc) {
//                    dp[bagc] =  Math.max(dp[bagc], dp[bagc - wt[j]] + val[j]);
                    int remainBagCapacity = bagc - wt[i];
                    int remainBagValue = dp[remainBagCapacity];
                    int totalBagValue = remainBagValue + val[i];

                    if (totalBagValue > max) {
                        max = totalBagValue;
                    }
                }

            }
            dp[bagc] = max;
        }
        return dp[capacity];
    }
*/


}
/*
 * O/P =>
 *	Total knapsack profit ---> 110
 *	Total knapsack profit ---> 27
 *	Total knapsack profit ---> 300
 *	Total knapsack profit ---> 100
 * */