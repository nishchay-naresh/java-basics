package com.nishchay.ds.dp;

/*
*
sum = 4
coins[1,2,3], unlimited no of coins

o/p => (1111),(112),(22),(13)
* */


import java.util.Arrays;

public class CoinChangeProblem {

    public static void main(String[] args) {
        int sum = 4;
        int[] coins = {1, 3, 2};

        int soln[] = new int[50];

        sortCoins(coins);
//        System.out.println("coins = " + Arrays.toString(coins));

//        int maxCoinSoln = sum / coins[0];


        int j = 0;
        for (int i = 1; i < 10; i++) {

            if (i == 1) {
                if (search(coins, sum)) {
                    soln[j] = sum;
                    j++;
                }
            } else if (i == 2) {
                // find pairs
                int k = sum - coins[0];
                if (search(coins, k)) {
                    soln[j] = sum;
                    j++;
                }
            }


        }

        System.out.println("soln = " + Arrays.toString(soln));

    }

// insertion sort
    private static void sortCoins(int[] coins) {
        int len = coins.length;
        for (int i = 1; i < len - 1; i++) {
            for (int j = 0; j < len - i; j++) {
                if (coins[j] > coins[j + 1]) {
                    int t = coins[j + 1];
                    coins[j + 1] = coins[j];
                    coins[j] = t;
                }
            }
        }
    }

    // linear search
    private static boolean search(int[] coins, int key) {

/*        int i = 0 ;
        int j = coins.length;
        int c = i + j /2;
        while ( i < j && coins[c] != key){
            if(c > i){

            }
        }*/
        int i = 0;
        while (i < coins.length && coins[i] != key) {
            i++;
        }

        if (i < coins.length) {
            return true;
        }
        return false;
    }


}
