package com.nishchay.ds.dp.knapsackunbound;

/*
 *
 *	############### Coin Change Problem - total no of ways #################
 *	Given a set of denominations of coins and an amount,
 *	we need to find - number of combinations in which we can arrange denominations to get the amount.
 *
 *	Example -
 *	coins = [1,2,3], unlimited no of coins
 *	amount / sum  = 4
 *	what are the total number of combinations of the coins you can arrange to obtain the sum.
 *
 *	output - 4 {1,1,1,1},{1,1,2},{2,2},{1,3}
 *--------------------------------------------------
 *	This problem is similar to subsetSumCount problem of 01Knapsack
 *	Again since here we can take 1 coin multiple times, so its unbounded in nature
 *
 * 	unbounded Knapsack code
 *		if(wt[j] <= c){
 *            dp[c] = Math.max(dp[c], dp[c - wt[j]] + val[j]);
 *        }
 *	code change
 *      - initialization
 *		- since its count kind of problem rather max profit, so Max will replaced with +
 *		- there is no wt[] array here , so + wt[j] will go off
 *
 *		if(wt[j] <= c){
 *     		dp[c] = dp[c] + dp[c - wt[j]]);
 *     	}
 *
 * https://www.geeksforgeeks.org/solve-dynamic-programming-problem/
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * https://www.youtube.com/watch?v=l_nR5X9VmaI&ab_channel=Pepcoding
 * */


public class CoinChangeTotalWays {

    public static void main(String[] args) {

        System.out.println("------------2D solution-------------");
        coinChangeCountDPBottomUp();
        System.out.println("------------1D solution-------------");
        coinChangeCountDPBottomUp_1D();
    }

    private static void coinChangeCountDPBottomUp() {

        CoinChangeTotalWays ref = new CoinChangeTotalWays();

        int[] coins = {1, 2, 3};
        int sum = 4;
        System.out.println("Total no of ways for CoinChange : " + ref.coinChange(sum, coins)); //4

        sum = 8;
        System.out.println("Total no of ways for CoinChange : " + ref.coinChange(sum, coins)); //10

        coins = new int[]{2, 3, 5};
        sum = 7;
        System.out.println("Total no of ways for CoinChange : " + ref.coinChange(sum, coins)); //2

        coins = new int[]{1, 5, 10};
        sum = 4;
        System.out.println("Total no of ways for CoinChange : " + ref.coinChange(sum, coins)); //1

    }


    /*
     *
     *	coins = [2,3,5] unlimited no of coins
     *	sum  = 7
     *	output - 2 {2,2,3},{2,5}
     *
     *	--------------2D solution-----------
     *
     *  Initialization (s=0 true, n=0 false)
     *      dp[0][0] = 1
     *      dp[1-n][0] = 1 // first column
     *      dp[0][1-s] = 0 // first row
     *
     *        if (set[i-1] > j)
     *          dp[i][j] = dp[i-1][j]
     *        else
     *          dp[i][j] = dp[i-1][j] + dp[i][j-set[i-1]]
     *
     *      return dp[len][sum];
     * */
    private int coinChange(int sum, int[] coins) {

        int len = coins.length;
        int[][] dp = new int[len + 1][sum + 1];

        // If sum is 0, then answer is true - first column
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }

        // if 0 items in the list - first row
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0;
        }

        // Build table dp[][] in bottom up manner
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    int excludeLastItem = dp[i - 1][j];
                    int includeLastItem = dp[i][j - coins[i - 1]];
                    dp[i][j] = excludeLastItem +  includeLastItem;
                }
            }
        }

        return dp[len][sum];
    }

    private static void coinChangeCountDPBottomUp_1D() {

        CoinChangeTotalWays ref = new CoinChangeTotalWays();

        int[] coins = {1, 2, 3};
        int sum = 4;
        System.out.println("Total no of ways for CoinChange : " + ref.coinChange_1D(sum, coins)); //4

        sum = 8;
        System.out.println("Total no of ways for CoinChange : " + ref.coinChange_1D(sum, coins)); //10

        coins = new int[]{2, 3, 5};
        sum = 7;
        System.out.println("Total no of ways for CoinChange : " + ref.coinChange_1D(sum, coins)); //2

        coins = new int[]{1, 5, 10};
        sum = 4;
        System.out.println("Total no of ways for CoinChange : " + ref.coinChange_1D(sum, coins)); //1

    }


    /*
     *
     *	coins = [2,3,5] unlimited no of coins
     *	sum  = 7
     *	output - 2 {2,2,3},{2,5}
     *
     *	--------------1D solution-----------
     *		 this loop will give us only combination not permutation ( no possibility of getting 3 ahead of 1/2)
     *		 we will get the sequence like 1,2,3
     *
     *		 outer loop will be over coins
     *		 inner loop, will start from the coin face value, will continue till the dp.length-1
     *			( bcus we can't do generate a sum < coins face value )
     *			we can't pay a sum of 1/2/3/4 using a coin of 5
     *
     *        for (int i = 0; i < coins.length; i++)
     *            for (int j = coins[i]; j < dp.length; j++)
     *                dp[j] = dp[j] + dp[j - coins[i]];
     *
     * */
    private int coinChange_1D(int sum, int[] coins) {

        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j < dp.length; j++)
                dp[j] = dp[j] + dp[j - coins[i]];

        return dp[sum];
    }
    /*
     *   Time complexity of this function: O(mn)
     *   Space Complexity of this function: O(n)
     * */

}
/*
 * O/P =>
 *	------------2D solution-------------
 *	Total no of ways for CoinChange : 4
 *	Total no of ways for CoinChange : 10
 *	Total no of ways for CoinChange : 2
 *	Total no of ways for CoinChange : 1
 *	------------1D solution-------------
 *	Total no of ways for CoinChange : 4
 *	Total no of ways for CoinChange : 10
 *	Total no of ways for CoinChange : 2
 *	Total no of ways for CoinChange : 1
 *
 * */