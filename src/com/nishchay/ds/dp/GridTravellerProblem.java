package com.nishchay.ds.dp;

import java.util.HashMap;
import java.util.Map;

public class GridTravellerProblem {

    public static void main(String[] args) {

//        gridTravelRecursionEx();
        gridTravelDPEx();

    }

    private static void gridTravelRecursionEx() {
        System.out.println(gridTravelRecursion(1, 0)); // 0
        System.out.println(gridTravelRecursion(1, 1)); // 1
        System.out.println(gridTravelRecursion(2, 3)); // 3
        System.out.println(gridTravelRecursion(3, 2)); // 3
        System.out.println(gridTravelRecursion(3, 3)); // 6
        System.out.println(gridTravelRecursion(10, 10)); //48620
        System.out.println(gridTravelRecursion(15, 15)); //40116600
    }

    private static int gridTravelRecursion(int m, int n) {
        // if there is grid of 1, so no of path will be only 1
        if (m == 1 && n == 1) {
            return 1;
        // if there is grid of 0, so no of path will be 0
        } else if (m == 0 || n == 0) {
            return 0;
        }
        // down                             // right
        return gridTravelRecursion(m - 1, n) + gridTravelRecursion(m, n - 1);
    }

    private static void gridTravelDPEx() {

        // memo object
        Map<String, Integer> table = new HashMap<>();
        table.put("1,1", 1);
        System.out.println(gridTravelMemoization(1, 1, table)); // 1
        System.out.println(gridTravelMemoization(2, 3, table)); // 3
        System.out.println(gridTravelMemoization(3, 2, table)); // 3
        System.out.println(gridTravelMemoization(3, 3, table)); // 6
        System.out.println(gridTravelMemoization(10, 10, table)); //48620
        System.out.println(gridTravelMemoization(15, 15, table)); //40116600

    }

    private static int gridTravelMemoization(int m, int n, Map<String, Integer> memoize) {
        String key = m + "," + n;
        if (m == 1 && n == 1) {
            return 1;
        } else if (m == 0 || n == 0) {
            return 0;
        }
        if (!memoize.containsKey(key)) {
            memoize.put(key, gridTravelMemoization(m - 1, n, memoize) + gridTravelMemoization(m, n - 1, memoize));
        }
        return memoize.get(key);

    }
}
