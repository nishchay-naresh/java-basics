package com.nishchay.ds.dp.knapsack01;


/*
 *	Partition a set into two subsets such that the difference of subset sums is minimum
 *
 *	Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
 *	If there is a set S with n elements,
 *	 then if we assume Subset1 has m elements,
 *	 Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 *
 *	Example:
 *
 *	Input:  arr[] = {1, 6, 11, 5}
 *	Output: 1
 *	Explanation:
 *	Subset1 = {1, 5, 6}, sum of Subset1 = 12
 *	Subset2 = {11}, sum of Subset2 = 11
 *
 * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 * */
public class MinimumSubsetSumDifference {


    public static void main(String[] args) {

        is2SubsetWithEqualSumDPBottomUp();

    }

    private static void is2SubsetWithEqualSumDPBottomUp() {

        MinimumSubsetSumDifference ref = new MinimumSubsetSumDifference();

        int[] arr = {1, 6, 11, 5};
        System.out.println("The minimum difference between 2 sets is - " + ref.findMinSubsetSumTabulation(arr)); // 1

        arr = new int[]{1, 2, 7};
        System.out.println("The minimum difference between 2 sets is - " + ref.findMinSubsetSumTabulation(arr)); // 4

        arr = new int[]{3, 1, 4, 2, 2, 1};
        System.out.println("The minimum difference between 2 sets is - " + ref.findMinSubsetSumTabulation(arr)); // 1
    }

    /*
     *	 The problem can be solved using dynamic programming when the sum of the elements is not too big.
     *	 sum = sum(arr[1..n])
     *	 We can create a 2D array dp[n+1][sum+1]
     *	 We can construct the solution in a bottom-up manner.
     *
     *	 then come to the last row of this DP 2d matrix
     *
     *	 arr[] = {1,2,7}
     *
     *	 min -> max
     *	 sum = 0 . . . . . . . . . . . 10
     *		{}							{1,2,7}
     *							mid
     *	 sum =	0	1	2	3	|	7	8	9	10
     *
     *	 sum=10
     *		s1 = 1		|	s2 = 10 - 2 * 1 = 8
     *		s2 = 2		|	s2 = 10 - 2 * 2 = 6
     *		s2 = 3		|	s2 = 10 - 2 * 3 = 4
     *	 take min(all s2 values ) = 4 ans
     *
     *
     *	 // Initialize difference of two sums.
     *	        int diff = Integer.MAX_VALUE;
     *
     *
     *		for (int j = 0; j <= sum / 2; j++) {
     *
     *	            if (dp[n][j] == true) {
     *	                currDiff = sum - 2 * j;
     *	                diff = Math.min(diff,currDiff);
     *	            }
     *	        }
     *
     * */

    private int findMinSubsetSumTabulation(int[] arr) {

        int n = arr.length;

        // Calculate sum of the elements in array
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // Create an array to store
        // results of subproblems
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialize first column as true.
        // 0 sum is possible  with all elements.
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        // Initialize top row, except dp[0][0],
        // as false. With 0 elements, no other
        // sum except 0 is possible
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        // Fill the partition table
        // in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If i'th element is excluded
                dp[i][j] = dp[i - 1][j];

                // If i'th element is included
                if (arr[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
            }
        }

        // Initialize difference of two sums.
        int diff = Integer.MAX_VALUE;

        for (int j = 0; j <= sum / 2; j++) {
            if (dp[n][j]) {
                int currDiff = sum - 2 * j;
                diff = Math.min(diff, currDiff);
            }
        }
        return diff;

    }

    /*
     * Time Complexity: O(n*sum)
     * Auxiliary Space: O(sum)
     * */
}

/*
 * O/P =>
 *	The minimum difference between 2 sets is - 1
 *	The minimum difference between 2 sets is - 4
 *	The minimum difference between 2 sets is - 1
 *
 * */