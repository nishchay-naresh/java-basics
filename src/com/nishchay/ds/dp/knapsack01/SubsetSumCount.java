package com.nishchay.ds.dp.knapsack01;


import java.util.HashMap;
import java.util.Map;

/*
 * Count number of subsets with sum equal to k
 *	Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.
 *
 *	Examples:
 *
 *	Input: arr[] = {2, 3, 5, 6, 8, 10}, X = 10
 *	Output: 3
 *	Explanation:
 *	All possible subsets with sum 10 are {2, 3, 5}, {2, 8}, {10}
 *
 *	Input: arr[] = {1, 2, 3, 3}, X = 6
 *	Output: 3
 *	All the possible subsets are {1, 2, 3},
 *	{1, 2, 3} and {3, 3}
 *
 *	Input: arr[] = {1, 1, 1, 1}, X = 1
 *	Output: 4
 *
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 * https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
 *
 * */
public class SubsetSumCount {

    public static void main(String[] args) {

        System.out.println("------------Recursion-------------");
        subsetCountRecursionEx();
        System.out.println("------------TopDown-------------");
        subsetCountDPTopDown();
        System.out.println("------------BottomUp-------------");
        subsetCountDPBottomUp();

    }

    private static void subsetCountRecursionEx() {

        SubsetSumCount ref = new SubsetSumCount();

        int[] set = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println(ref.subsetCountRecursive(set, set.length, sum)); // 3

        set = new int[]{1, 2, 3, 3};
        sum = 6;
        System.out.println(ref.subsetCountRecursive(set, set.length, sum)); // 3

        set = new int[]{1, 1, 1, 1};
        sum = 1;
        System.out.println(ref.subsetCountRecursive(set, set.length, sum)); // 4

        System.out.println(ref.subsetCountRecursive(new int[]{3, 3, 3, 3}, 4, 6)); // 6
        System.out.println(ref.subsetCountRecursive(new int[]{1, 2, 3, 4, 5}, 5, 7)); // 3
        System.out.println(ref.subsetCountRecursive(new int[]{5, 3, 4, 7}, 4, 7)); // 2
        System.out.println(ref.subsetCountRecursive(new int[]{2, 4}, 2, 7));    // 0
        System.out.println(ref.subsetCountRecursive(new int[]{1, 5, 3, 7, 4}, 5, 12)); // 3 {5,7},{3,4,5},{1,4,7}
        System.out.println(ref.subsetCountRecursive(new int[]{7, 14}, 2, 300)); // 0
        System.out.println(ref.subsetCountRecursive(new int[]{2, 4, 1, 8, 5}, 5, 9)); // 2 {4,5},{-1,10}

    }

    private static void subsetCountDPTopDown() {

        SubsetSumCount ref = new SubsetSumCount();
        Map<String, Integer> lookup = new HashMap<>();

        int[] set = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println(ref.subsetCountMemoization(set, set.length, sum, lookup)); // 3

        set = new int[]{1, 2, 3, 3};
        sum = 6;
        System.out.println(ref.subsetCountMemoization(set, set.length, sum, lookup)); // 3

        set = new int[]{1, 1, 1, 1};
        sum = 1;
        System.out.println(ref.subsetCountMemoization(set, set.length, sum, lookup)); // 4

        System.out.println(ref.subsetCountMemoization(new int[]{3, 3, 3, 3}, 4, 6, lookup)); // 6
        System.out.println(ref.subsetCountMemoization(new int[]{1, 2, 3, 4, 5}, 5, 7, lookup)); // 3
        System.out.println(ref.subsetCountMemoization(new int[]{5, 3, 4, 7}, 4, 7, lookup)); // 2
        System.out.println(ref.subsetCountMemoization(new int[]{2, 4}, 2, 7, lookup));    // 0
        System.out.println(ref.subsetCountMemoization(new int[]{1, 5, 3, 7, 4}, 5, 12, lookup)); // 3 {5,7},{3,4,5},{1,4,7}
        System.out.println(ref.subsetCountMemoization(new int[]{7, 14}, 2, 300, lookup)); // 0
        System.out.println(ref.subsetCountMemoization(new int[]{2, 4, 1, 8, 5}, 5, 9, lookup)); // 2 {4,5},{-1,10}

    }

    private static void subsetCountDPBottomUp() {

        SubsetSumCount ref = new SubsetSumCount();

        int[] set = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println(ref.subsetCountTabulation(set, sum)); // 3

        set = new int[]{1, 2, 3, 3};
        sum = 6;
        System.out.println(ref.subsetCountTabulation(set, sum)); // 3

        set = new int[]{1, 1, 1, 1};
        sum = 1;
        System.out.println(ref.subsetCountTabulation(set, sum)); // 4

        System.out.println(ref.subsetCountTabulation(new int[]{3, 3, 3, 3}, 6)); // 6
        System.out.println(ref.subsetCountTabulation(new int[]{1, 2, 3, 4, 5}, 7)); // 3
        System.out.println(ref.subsetCountTabulation(new int[]{5, 3, 4, 7}, 7)); // 2
        System.out.println(ref.subsetCountTabulation(new int[]{2, 4}, 7));    // 0
        System.out.println(ref.subsetCountTabulation(new int[]{1, 5, 3, 7, 4}, 12)); // 3 {5,7},{3,4,5},{1,4,7}
        System.out.println(ref.subsetCountTabulation(new int[]{7, 14}, 300)); // 0
        System.out.println(ref.subsetCountTabulation(new int[]{2, 4, 1, 8, 5}, 9)); // 2 {4,5},{1,8}
    }

    private int subsetCountRecursive(int[] arr, int n, int sum) {

        // return 1 if the sum becomes 0 (subset found)
        if (sum == 0)
            return 1;
        // base case: no items left
        if (n == 0)
            return 0;

        if (arr[n - 1] > sum)
            return subsetCountRecursive(arr, n - 1, sum);
        else {
            int excludeLastItem = subsetCountRecursive(arr, n - 1, sum);
            int includeLastItem = subsetCountRecursive(arr, n - 1, sum - arr[n - 1]);
            return excludeLastItem + includeLastItem;
        }
    }

    private int subsetCountMemoization(int[] arr, int n, int sum, Map<String, Integer> memoize) {

        // return 1 if the sum becomes 0 (subset found)
        if (sum == 0)
            return 1;
        // base case: no items left
        if (n == 0)
            return 0;


        int currItemIndex = n - 1;
        // construct a unique map key from dynamic elements of the input
        String key = currItemIndex + "|" + sum;

        if (memoize.containsKey(key)) {
            return memoize.get(key);
        }

        if (arr[n - 1] > sum)
            memoize.put(key, subsetCountRecursive(arr, n - 1, sum));
        else {
            int excludeLastItem = subsetCountRecursive(arr, n - 1, sum);
            int includeLastItem = subsetCountRecursive(arr, n - 1, sum - arr[n - 1]);
            memoize.put(key, excludeLastItem + includeLastItem);
        }
        return memoize.get(key);
    }
    /*
     *	Time Complexity: O(sum*n), where the sum is the ‘target sum’ and ‘n’ is the size of the array.
     *	Auxiliary Space: O(sum*n), as the size of the 2-D array, is sum*n.
     * */

    /*
     *  Initialization (s=0 return 1, n=0 return 0)
     *      dp[0][0] = 1
     *      dp[1-n][0] = 1 // first column
     *      dp[0][1-s] = 0 // first row
     *
     *       if (set[i-1] > j)
     *          dp[i][j] = dp[i-1][j]
     *       else
     *          dp[i][j] = dp[i-1][j] + dp[i-1][j-set[i-1]]
     *
     *      return dp[len][sum];
     *
     * */
    private int subsetCountTabulation(int[] set, int sum) {

        int len = set.length;
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

                // don't include the i'th element if `j-set[i-1]` is negative
                if (set[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    int excludeLastItem = dp[i - 1][j];
                    int includeLastItem = dp[i - 1][j - set[i - 1]];
                    dp[i][j] = excludeLastItem + includeLastItem;
                }
            }
        }
        // return last element of the table - result
        return dp[len][sum];

    }

}

/*
 * O/P =>
 * Recursion	TopDown			BottomUp
 * 3  				3				3
 * 3  				3               3
 * 4  				4               4
 * 6  				3               6
 * 3  				3               3
 * 2  				2               2
 * 0  				0               0
 * 3  				3               3
 * 0  				0               0
 * 2  				2               2
 *
 * */