package com.nishchay.test.blueyonder;

/*
 *
 * 	k = no times one can do a buy & sell = 1
 * 	2 times
 * 	price [] = {2,8,9,1,10,11};
 * 	try to gain the maxProfilt
 *
 * 	int k = 2;
 * 	int[] price = { 5, 17, 5, 88, 55, 90 };
 *
 * */
public class StockBuySellKTimes {

    public static void main(String[] args) {

        int[] prices = new int[]{2, 8, 9, 1, 10, 11};
        int times = 1;

        System.out.println("maxProfit - " + maxProfit(prices, times));

    }

    private static int maxProfit(int[] prices, int times) {

        int curProfit, maxProfit;
        curProfit = maxProfit = 0;

        int buyPrice, sellPrice, currPrice;
        buyPrice = sellPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            currPrice = prices[i];
            if (i == 0) {
                buyPrice = prices[i];
            } else if (i == prices.length - 1) {
                sellPrice = prices[i];
            }
            if (currPrice > sellPrice) {
                sellPrice = currPrice;
            }
            if (currPrice < buyPrice) {
                buyPrice = currPrice;
            }
            curProfit = buyPrice - sellPrice;
            maxProfit = Math.max(curProfit, maxProfit);

        }

        return maxProfit;
    }
}

