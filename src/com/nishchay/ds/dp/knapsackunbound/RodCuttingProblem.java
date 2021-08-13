package com.nishchay.ds.dp.knapsackunbound;

/*
 *	Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
 *	Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 *
 *	Example, if the length of the rod is 8 and the values of different pieces are given as the following,
 *	length   | 1   2   3   4   5   6   7   8
 *	--------------------------------------------
 *	price    | 1   5   8   9  10  17  17  20
 *
 *	then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 *
 *
 *	And if the prices are as following,
 *
 *	length   | 1   2   3   4   5   6   7   8
 *	--------------------------------------------
 *	price    | 3   5   8   9  10  17  17  20
 *
 *	then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 *
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 * */
public class RodCuttingProblem {

    public static void main(String[] args) {


        rodCuttingDPBottomUp();

    }

    private static void rodCuttingDPBottomUp() {

        RodCuttingProblem ref = new RodCuttingProblem();

        int[] arr = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Maximum Obtainable Value is " + ref.rodCutting(arr));//22

        arr = new int[]{3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Maximum Obtainable Value is " + ref.rodCutting(arr));//24
    }

    /*
     *	###########  unboundedKnapsackTabulation - code ################
     *	        only price array is given, we can extract below info
     *	         sum = arr.length = 8
     *	         val[] = {1, 5, 8, 9, 10, 17, 17, 20}
     *	          wt[] = {1, 2, 3, 4,  5,  6,  7,  8}
     *
     *  After getting all the info , this is the classical problem of unbounded knapsack
     *  so we can solve this using the same logic
     *
     *	    if(wt[j] <= c){
     *			dp[c] = Math.max(dp[c], dp[c - wt[j]] + val[j]);
     *		}
     *      since here wt[j] is nothing but the index, so only change required to do is wt[j] = j+1
     *      currWt = j + 1;
     *	    if(currWt <= c){
     *			dp[c] = Math.max(dp[c], dp[c - currWt] + val[j]);
     *		}
     * */
    private int rodCutting(int[] price) {

        int len = price.length;
        int sum = len;
        int[] dp = new int[sum + 1];
        dp[0] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int c = 1; c <= sum; c++) {
            for (int j = 0; j < len; j++)
                if ((j + 1) <= c) {
                    dp[c] = Math.max(dp[c], dp[c - (j + 1)] + price[j]);
                }

        }
        return dp[len];
    }


 /*   private int rodCutting(int[] price) {

        // only price array is given, we can extract below info
        // sum = arr.length = 8
        // wt[] = {1,2,3,4,5,6,7,8}

        int len = price.length;
        int[] val = new int[len + 1];
        val[0] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int c = 1; c <= len; c++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < c; j++)
                max_val = Math.max(max_val, price[j] + val[c - j - 1]);
            val[c] = max_val;
        }

        return val[len];
    }
*/

}
/*
 * O/P =>
 *   Maximum Obtainable Value is 22
 *   Maximum Obtainable Value is 24
 * */