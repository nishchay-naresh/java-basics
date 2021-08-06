package com.nishchay.ds.dp.knapsack01;

import java.util.HashMap;
import java.util.Map;

/*
 *	Subset Sum
 *	Given a set of non-negative integers, and a value sum,
 *	determine if there is a subset of the given set with sum equal to given sum.
 *
 *	Example:
 *
 *	Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 *	Output: True
 *	There is a subset (4, 5) with sum 9.
 *
 *	Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
 *	Output: False
 *	There is no subset that add up to 30.
 *
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 * https://www.techiedelight.com/subset-sum-problem/
 * */
public class SubsetSumPossible {

    public static void main(String[] args) {

/*
        System.out.println("------------Recursion-------------");
        isSubsetSumRecursionEx();
*/
        System.out.println("------------TopDown-------------");
        isSubsetSumDPTopDown();
        System.out.println("------------BottomUp-------------");
        isSubsetSumDPBottomUp();
    }


    private static void isSubsetSumRecursionEx() {

        SubsetSumPossible ssp = new SubsetSumPossible();

        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(ssp.isSubsetSumRecursive(set, set.length, sum)); // true

        set = new int[]{3, 34, 4, 12, 5, 2};
        sum = 30;
        System.out.println(ssp.isSubsetSumRecursive(set, set.length, sum)); // false

        System.out.println(ssp.isSubsetSumRecursive(new int[]{2, 3, 5}, 3, 8)); // true
        System.out.println(ssp.isSubsetSumRecursive(new int[]{2, 3}, 2, 7)); // false
        System.out.println(ssp.isSubsetSumRecursive(new int[]{5, 3, 4, 7}, 4, 7)); // true
        System.out.println(ssp.isSubsetSumRecursive(new int[]{2, 4}, 2, 7));    // false
        System.out.println(ssp.isSubsetSumRecursive(new int[]{1, 5, 3, 7, 4}, 5, 12)); // true
        System.out.println(ssp.isSubsetSumRecursive(new int[]{7, 14}, 2, 300)); // false
    }

    private static void isSubsetSumDPTopDown() {

        SubsetSumPossible ssp = new SubsetSumPossible();
        Map<String, Boolean> lookup = new HashMap<>();

        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(ssp.isSubsetSumMemoization(set, set.length, sum, lookup)); // true

        set = new int[]{3, 34, 4, 12, 5, 2};
        sum = 30;
        System.out.println(ssp.isSubsetSumMemoization(set, set.length, sum, lookup)); // false

        System.out.println(ssp.isSubsetSumRecursive(new int[]{2, 3, 5}, 3, 8)); // true
        System.out.println(ssp.isSubsetSumMemoization(new int[]{2, 3}, 2, 7, lookup)); // false
        System.out.println(ssp.isSubsetSumMemoization(new int[]{5, 3, 4, 7}, 4, 7, lookup)); // true
        System.out.println(ssp.isSubsetSumMemoization(new int[]{2, 4}, 2, 7, lookup));    // false
        System.out.println(ssp.isSubsetSumMemoization(new int[]{1, 5, 3, 7, 4}, 5, 12, lookup)); // true
        System.out.println(ssp.isSubsetSumMemoization(new int[]{7, 14}, 2, 300, lookup)); // false
    }


    private static void isSubsetSumDPBottomUp() {

        SubsetSumPossible ssp = new SubsetSumPossible();

        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(ssp.isSubsetSumTabulation(set, sum)); // true

        set = new int[]{3, 34, 4, 12, 5, 2};
        sum = 30;
        System.out.println(ssp.isSubsetSumTabulation(set, sum)); // false

        System.out.println(ssp.isSubsetSumTabulation(new int[]{2, 3, 5}, 8)); // true
        System.out.println(ssp.isSubsetSumTabulation(new int[]{2, 3}, 7)); // false
        System.out.println(ssp.isSubsetSumTabulation(new int[]{5, 3, 4, 7}, 7)); // true
        System.out.println(ssp.isSubsetSumTabulation(new int[]{2, 4}, 7));    // false
        System.out.println(ssp.isSubsetSumTabulation(new int[]{1, 5, 3, 7, 4}, 12)); // true
        System.out.println(ssp.isSubsetSumTabulation(new int[]{7, 14}, 300)); // false
    }

    /*
     *	Following is the recursive formula for isSubsetSum() problem.
     *	isSubsetSum(set, n, sum)
     *			= isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum-set[n-1])
     *	Base Cases:
     *	isSubsetSum(set, n, sum) = false, if sum > 0 and n == 0
     *	isSubsetSum(set, n, sum) = true, if sum == 0
     * */
    private boolean isSubsetSumRecursive(int[] set, int n, int sum) {
        // return true if the sum becomes 0 (subset found)
        if (sum == 0)
            return true;
        // base case: no items lef
        if (n == 0)
            return false;

        // If last element is greater than sum, then ignore it
        if (set[n - 1] > sum)
            return isSubsetSumRecursive(set, n - 1, sum);
        else {
            //check if sum can be obtained by any of the following
            //Case 1. Include the current item `set[n]` in the subset and recur for the remaining items `n-1` with the remaining total `sum-set[n]`
            //Case 2. Exclude the current item `set[n]` from the subset and recur for the remaining items `n-1` with total `sum`
            boolean excludeLastItem = isSubsetSumRecursive(set, n - 1, sum);
            boolean includeLastItem = isSubsetSumRecursive(set, n - 1, sum - set[n - 1]);
            return excludeLastItem || includeLastItem;
        }
    }
    /*
     *	Complexity Analysis: The above solution may try all subsets of given set in worst case.
     *	Therefore time complexity of the above solution is exponential.
     *	The problem is in-fact NP-Complete (There is no known polynomial time solution for this problem).
     * */

    private boolean isSubsetSumMemoization(int[] set, int n, int sum, Map<String, Boolean> memoize) {

        // return true if the sum becomes 0 (subset found)
        if (sum == 0)
            return true;
        // base case: no items left, or sum becomes negative
        if (n == 0)
            return false;

        int currItemIndex = n - 1;
        // construct a unique map key from dynamic elements of the input
        String key = currItemIndex + "|" + sum;

        if (memoize.containsKey(key))
            return memoize.get(key);

        // If last element is greater than sum, then ignore it
        if (set[n - 1] > sum)
            memoize.put(key, isSubsetSumRecursive(set, n - 1, sum));
        else {
            //check if sum can be obtained by any of the following
            //Case 1. Exclude the current item `set[n]` from the subset and recur for the remaining items `n-1` with total `sum`
            //Case 2. Include the current item `set[n]` in the subset and recur for the remaining items `n-1` with the remaining total `sum-set[n]`
            boolean excludeLastItem = isSubsetSumRecursive(set, n - 1, sum);
            boolean includeLastItem = isSubsetSumRecursive(set, n - 1, sum - set[n - 1]);
            memoize.put(key, excludeLastItem || includeLastItem);
        }
        return memoize.get(key);
    }
    /*
     *	Time Complexity: O(sum*n), where sum is the ‘target sum’ and ‘n’ is the size of array.
     *	Auxiliary Space: O(sum*n), as the size of 2-D array is sum*n.
     * */


    /*
     *  Initialization (s=0 true, n=0 false)
     *      dp[0][0] = true
     *      dp[1-n][0] = true // first column
     *      dp[0][1-s] = false // first row
     *
     *        if (set[i-1] > j)
     *          dp[i][j] = dp[i-1][j]
     *        else
     *          dp[i][j] = dp[i-1][j] OR dp[i-1][j-set[i-1]]
     *
     *      return dp[len][sum];
     * */
    boolean isSubsetSumTabulation(int[] set, int sum) {

        int len = set.length;
        boolean[][] dp = new boolean[len + 1][sum + 1];

        // If sum is 0, then answer is true - first column
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }

        // if 0 items in the list - first row
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        // Build table dp[][] in bottom up manner
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {

                // don't include the i'th element if `j-set[i-1]` is negative
                if (set[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    boolean excludeLastItem = dp[i - 1][j];
                    boolean includeLastItem = dp[i - 1][j - set[i - 1]];
                    dp[i][j] = excludeLastItem || includeLastItem;
                }
            }
        }
        // return last element of the table - result
        return dp[len][sum];
    }
    /*
     *	Time Complexity: O(sum*n), where sum is the ‘target sum’ and ‘n’ is the size of array.
     *	Auxiliary Space: O(sum*n), as the size of 2-D array is sum*n.
     * */


    /*
     * ====================================================================================================================
     * Other video tutorial code. which is following bottom up approach
     * */
    private static boolean possibleSumRecursion(int targetSum, int[] numbers) {

        // if targetSum is 0, then possible sum is there, which is an empty set {}
        if (targetSum == 0) {
            return true;
            // if targetSum is -ve, then possible sum is not possible
        } else if (targetSum < 0) {
            return false;
        }

        for (int e : numbers) {
            int remainder = targetSum - e;
            if (true == possibleSumRecursion(remainder, numbers)) {
                return true;
            }
        }
        return false;
    }

    private static boolean possibleSumTabulation(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {

        // if targetSum is 0, then possible sum is there
        if (targetSum == 0) {
            return true;
            // if targetSum is -ve, then possible sum is not possible
        } else if (targetSum < 0) {
            return false;
        }

        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }

        for (int e : numbers) {
            int remainder = targetSum - e;
            if (true == possibleSumTabulation(remainder, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

}
