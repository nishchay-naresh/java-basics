package com.nishchay.ds.dp.knapsackunbound;


/*
 *	#########Find minimum number of coins that make a given value#########
 *
 *	Finding the minimum number of coins, of certain denominations, required to make a given sum.
 *	Given a sum , and infinite supply of each of C = { C1, C2, .. , Cm} valued coins,
 *	what is the minimum number of coins to make the sum
 *	If it’s not possible to make change, print -1.

 *	Example -
 *	coins =  {1, 3, 6}, unlimited no of coins
 *	amount / sum  = 7
 *	what minimum number of coins to obtain the sum.
 * o/p => {1,1,1,1,1,1,1}, {1,3,3}, and {1,6}
 * So the minimum number of coins required are 2, i.e. {1,6}.
 *
 *
 *
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * https://www.educative.io/edpresso/coin-change-problem-1-in-javafinding-the-minimum-number-of-coins
 * https://gist.github.com/SuryaPratapK/665ea0e02c1560c7d70346ed4ae794bc
 * */
public class CoinChangeMinCoin {


    public static void main(String[] args) {

        coinChangeProblemMinCoinDPBottomUp();

    }

    private static void coinChangeProblemMinCoinDPBottomUp() {

        CoinChangeMinCoin ref = new CoinChangeMinCoin();

        int[] coins = {9, 6, 5, 1};
        int sum = 11;
        System.out.println("At least " + ref.coinChangeMinCoin(coins, sum) + " coins are required to make a value of " + sum); //2

        coins = new int[]{1, 3, 6};
        sum = 7;
        System.out.println("At least " + ref.coinChangeMinCoin(coins, sum) + " coins are required to make a value of " + sum); //2

        coins = new int[]{3, 4, 6};
        sum = 5;
        System.out.println("At least " + ref.coinChangeMinCoin(coins, sum) + " coins are required to make a value of " + sum); //-1

        coins = new int[]{5, 7, 8, 9};
        sum = 49;
        System.out.println("At least " + ref.coinChangeMinCoin(coins, sum) + " coins are required to make a value of " + sum);// 6

    }

    /*
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
     *
     * */
    private int coinChangeMinCoin(int[] coins, int sum) {

        int totalCoins = coins.length;

        int[][] dp = new int[totalCoins + 1][sum + 1];

        // Initialising first row with +ve infinity
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = 99999; // say 99999 as +infinitive
        }

        // Initialising first column with 0
        for (int i = 1; i <= totalCoins; i++) {
            dp[i][0] = 0;
        }

        // Implementing the recursive solution
        for (int i = 1; i <= totalCoins; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    int excludeLastItem = dp[i - 1][j];
                    int includeLastItem = dp[i][j - coins[i - 1]] + 1;
                    dp[i][j] = Math.min(excludeLastItem, includeLastItem);
                }
            }
        }

        if(dp[totalCoins][sum]==99999)
            return -1;
        return dp[totalCoins][sum];
    }

}

/*
 * O/P =>
 *	At least 2 coins are required to make a value of 11
 *	At least 2 coins are required to make a value of 7
 *	At least -1 coins are required to make a value of 5
 *	At least 6 coins are required to make a value of 49
 * */