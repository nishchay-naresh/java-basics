package com.nishchay.ds.dp;

import java.util.Arrays;

/*
 *	===========Maximum profit from sale of wines===========
 *
 * Given n wines in a row, with integers denoting the cost of each wine respectively.
 * Each year you can sale the first or the last wine in the row. However, the price of wines increases over time.
 *
 * Constrain
 * Each year you have to sell 1 bottle
 * year strating value is from 1
 * one can only sell the bottle from either of the end
 * you should sell the bottles such a way to that you should get max profilts
 *
 *
 * Examples :
 *		Input: Price of wines: 2 4 6 2 5
 *		Output:  64
 *
 * https://www.geeksforgeeks.org/maximum-profit-sale-wines/
 * https://www.youtube.com/watch?v=f4jUEEzjEJw&ab_channel=TECHDOSE
 *
 * */
public class WineSellingForMaxProfit {

    public static void main(String[] args) {

        System.out.println("------------Recursion-------------");
        maxProfitRecursionEx();

        System.out.println("------------TopDown-------------");
        maxProfitDPTopDown();
    }



    private static void maxProfitRecursionEx() {

        WineSellingForMaxProfit ref = new WineSellingForMaxProfit();
        // Price array
        int[] price = {2, 4, 6, 2, 5};

        int ans = ref.maxProfitRecursive(price, 0, price.length - 1, 1);
        System.out.println("Maximum profit from sale of wines - " + ans); // 64
    }


    private static void maxProfitDPTopDown() {
        WineSellingForMaxProfit ref = new WineSellingForMaxProfit();

        // Price array
        int[] price = {2, 4, 6, 2, 5};
        int len = price.length + 1;

        int[][] lookup = new int[len+1][len+1];
        for (int[] row : lookup)
            Arrays.fill(row, -1);


        int ans = ref.maxProfitMemoization(price, 0, price.length - 1, 1, lookup);
        System.out.println("Maximum profit from sale of wines - " + ans); // 64

    }
    /*
    * Recursive solution
    * Time Complexity: O(2^n)
    * */
    private int maxProfitRecursive(int[] price, int start, int end, int yr) {

        if (start == end)
            return yr * price[start];

        int left = (yr * price[start]) + maxProfitRecursive(price, start + 1, end, yr + 1);
        int right = (yr * price[end]) + maxProfitRecursive(price, start, end - 1, yr + 1);

        return Math.max(left, right);
    }

    /*
     * DP - Memoization solution
     * Time Complexity: O(n^2)
     * */
    private int maxProfitMemoization(int[] price, int start, int end, int yr,  int[][] lookup) {

        if (start == end)
            return yr * price[start];

        if(lookup[start][end] != -1){
            return lookup[start][end];
        }

        int left = (yr * price[start]) + maxProfitRecursive(price, start + 1, end, yr + 1);
        int right = (yr * price[end]) + maxProfitRecursive(price, start, end - 1, yr + 1);

        return lookup[start][end]=Math.max(left, right);
    }

}
