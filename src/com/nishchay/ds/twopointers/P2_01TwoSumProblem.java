package com.nishchay.ds.twopointers;

import java.util.ArrayList;
import java.util.List;

/*
 *============== Two Sum Problem ====================
 *
 * Given an array A[] and a number x, check for pair in A[] with sum as x (aka Two Sum)
 *
 * Given an array of integers, return the two numbers whose sum is equal to a given target.
 *
 * Examples - 1
 *			Input : Given nums = [2, 7, 11, 15], target = 9.
 *			Output : [2, 7]
 *					 Explanation : Because  2 + 7 = 9.
 *
 * Examples - 2
 *			Input : arr[] = {0, -1, 2, -3, 1}, target = -2.
 *			Output : [-3, 1]
 *					Explanation : Because  -3 + 1 = -2.
 *
 * Examples - 3
 *			Input : arr[] = {1, -2, 1, 0, 5}, target = 0.
 *			Output : []
 *					Explanation : No valid pair exists for 0.
 *
 * Examples - 4
 *			Input : arr[] = {3, 5, 2, -4, 8, 11}, target = 7.
 *			Output : [5, 2],[-4, 11]
 *					Explanation : Because because 2 + 5 = 7 and 11 + -4 = 7.
 *
 *
 * https://www.callicoder.com/two-sum-problem/
 * https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
 *
 * */
public class P2_01TwoSumProblem {

    public static void main(String[] args) {

/*
        bruteforceWay();
        System.out.print("\n-----------------------------");
        hashingWay();
        System.out.print("\n-----------------------------");
        twoPointersWay();
*/

    }

    /*
     * ========= naive/bruteforce approach =========
     *
     *	Approach:
     *	1. 	Run two nested loops with loop counter i, j
     *	2. 	The first loops will run from 0 to n-1 and
     *          second loop from i+1 to n and
     *	3. 	Check if the sum of elements at i’th, j’th is equal to sum/target value or not.
     *
     * Time Complexity: O(n^2).
     * Auxiliary Space: O(1).
     *
     * */
    private static List<int[]> findPair_bruteforce(int[] arr, int sum) {

        int n = arr.length;
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == sum) {
                    pairs.add(new int[]{arr[i], arr[j]});
                }
            }
        }
        return pairs;
    }


}
