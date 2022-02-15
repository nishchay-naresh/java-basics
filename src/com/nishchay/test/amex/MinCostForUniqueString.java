package com.nishchay.test.amex;

public class MinCostForUniqueString {

    public static void main(String[] args) {

        String str = "abccbd";
        int[] cost = new int[]{0, 1, 2, 3, 4, 5};
        System.out.printf(" %s , no two char dups min cost - %d%n", str, getMinCost(str, cost));

        str = "aabbcc";
        cost = new int[]{1, 2, 1, 2, 1, 2};
        System.out.printf(" %s , no two char dups min cost - %d%n", str, getMinCost(str, cost));

        str = "aaaa";
        cost = new int[]{3,4,5,6};
        System.out.printf(" %s , no two char dups min cost - %d%n", str, getMinCost(str, cost));

        str = "ababa";
        cost = new int[]{10,5,10,5,10};
        System.out.printf(" %s , no two char dups min cost - %d%n", str, getMinCost(str, cost));

    }

    private static int getMinCost(String str, int[] cost) {

        char[] charArr = str.toCharArray();

        int minCost = 0;
        for (int i = 0; i < charArr.length - 1; i++) {
            if (charArr[i] == charArr[i + 1]) {
                minCost = minCost + Math.min(cost[i], cost[i + 1]);
            }
        }
        return minCost;
    }

}
