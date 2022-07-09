package com.nishchay.ds.twopointers;

import java.util.ArrayList;
import java.util.List;

/*
 *============== Three Sum Problem - Distinct ====================
 *
 * Given an array of integers, find all triplets in the array that sum up to a given target value.
 *
 * In other words, given an array arr and a target value target, return all triplets a, b, c such that a + b + c = target.
 *
 * Examples - 1
 *			Input : array: [7, 12, 3, 1, 2, -6, 5, -8, 6], target = 0
 *			Output : [7, 1, -8]	[3, 5, -8]	[1, -6, 5]	[2, -8, 6]
 *
 * Examples - 2
 *			Input : arr[] = {2, 7, 4, 0, 9, 5, 1, 3}, target = 6
 *			Output : {0, 1, 5}, {0, 2, 4}, {1, 2, 3}
 *
 * Examples - 3
 *			Input : arr[] = {12, 3, 4, 1, 6, 9}, target = 24
 *			Output : {12, 3, 9}
 *
 * Examples - 4
 *			Input : arr[] = {1, 2, 3, 4, 5}, target = 9
 *			Output : {5, 3, 1}, {2, 3, 4}
 *
 *
 * https://www.callicoder.com/three-sum-problem/
 *
 * */
public class P2_02ThreeSumProblem {

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
     *	1. 	Run three nested loops with loop counter i, j, k
     *	2. 	The first loops will run from 0 to n-3 and
     *          second loop from i+1 to n-2 and
     *          the third loop from j+1 to n-1.
     *	3. 	Check if the sum of elements at i’th, j’th, k’th is equal to zero or not.
     *
     * Time Complexity: O(n3).
     * Auxiliary Space: O(1).
     *
     * */
    private static List<int[]> findTriplets_bruteforce(int[] arr, int sum) {

        int n = arr.length;
        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == sum) {
                        triplets.add(new int[]{arr[i], arr[j], arr[k]});
                    }
                }
            }
        }
        return triplets;
    }

}
