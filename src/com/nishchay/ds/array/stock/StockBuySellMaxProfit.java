package com.nishchay.ds.array.stock;

/*
 *	=========== Stock Buy Sell to Maximize Profit ===========
 *
 * The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days.
 * You can only do one buy and sell
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * For example,
 *		if the given array is {100, 180, 260, 310, 40, 535, 695},
 *			the maximum profit can earned by buying on day 0, selling on day 3. => 310 - 100 =  210
 *			Again buy on day 4 and sell on day 6. => 695 - 40 = 655
 *			If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 *
 *	Example 1:
 *
 *	Input: prices = [7,1,5,3,6,4]
 *	Output: 5
 *	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *	Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * https://java2blog.com/stock-buy-sell-to-maximize-profit/
 * https://www.youtube.com/watch?v=4YjEHmw1MX0&t=56s&ab_channel=Pepcoding
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * */
public class StockBuySellMaxProfit {

    public static void main(String[] args) {

        int[] arr = {14, 12, 70, 15, 99, 65, 21, 90};
        System.out.println("Maximum profit : " + calculateMaxProfit(arr)); // 87
        System.out.println("Maximum profit : " + calculateMaxProfit1(arr)); // 87

        arr = new int[] {7,1,5,3,6,4};
        System.out.println("Maximum profit : " + calculateMaxProfit(arr)); // 5

        arr = new int[] {7,6,4,3,1};
        System.out.println("Maximum profit : " + calculateMaxProfit(arr)); // 0

    }

    /*
     * ==Stock Buy Sell to Maximize Profit Algorithm==
     *
     *	Lets say we have array arr[] of stock prices.
     *	We will track two variables :lowestPriceTillThatDay and maxProfit.
     *
     *		- lowestPriceTillThatDay will be initialise to arr[0].
     *		- Iterate over stock price array arr[]
     *		- If current element is greater than lowestPriceTillThatDay
     *				calculate profit.
     *				If profit is greater than maxProfit then update the maxProfit.
     *		- If current element is lesser than lowestPriceTillThatDay
     *				update lowestPriceTillThatDay with current element.
     *		- We will get maxProfit in the end.
     *
     * */
    private static int calculateMaxProfit(int[] arr) {
        int lowestPriceTillThatDay = arr[0];
        int maxProfit = 0;
        int currIndexProfit;

        for (int i = 0; i < arr.length; i++) {
            currIndexProfit = 0;
            if (arr[i] > lowestPriceTillThatDay) {
                currIndexProfit = arr[i] - lowestPriceTillThatDay;
                if (currIndexProfit > maxProfit) {
                    maxProfit = currIndexProfit;
                }
            } else {
                lowestPriceTillThatDay = arr[i];
            }
        }
        return maxProfit;
    }

    private static int calculateMaxProfit1(int[] arr) {
        int lowestPriceTillThatDay = arr[0];
        int maxProfit = 0;
        int currIndexProfit;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < lowestPriceTillThatDay) {
                lowestPriceTillThatDay = arr[i];
            }
            currIndexProfit = arr[i] - lowestPriceTillThatDay;
            if (currIndexProfit > maxProfit) {
                maxProfit = currIndexProfit;
            }
        }
        return maxProfit;
    }
}
