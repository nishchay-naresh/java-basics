package com.nishchay.ds.twopointers;

import java.util.*;

/*
 *============== Find all triplets with zero sum - Without Duplicate/distinct elements ====================
 *
 * Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.
 *
 * Examples - 1
 *			Input : arr[] = {0, -1, 2, -3, 1}
 *			Output : [0, -1, 1]	[2, -3, 1]
 *					Explanation : The triplets with zero sum are
 *									0 + -1 + 1 = 0 and 2 + -3 + 1 = 0
 *
 * Examples - 2
 *			Input : arr[] = {1, -2, 1, 0, 5}
 *			Output : [1,-2, 1]
 *					Explanation : The triplets with zero sum is
 *									1 + -2 + 1 = 0
 *
 * Examples - 3
 *			Input: a[] = [-5, 3, 2, -3, 1]
 *			Output: [-5, 3, 2] [2, -3, 1]
 *			Example 2:
 *
 * Examples - 4
 *			Input: a[] = [-1, 0, 1, 2, -2, -4]
 *			Output: [-1, 0, 1]	[0, 2, -2]
 *
 *
 * https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
 *
 * ========================= Find all Triplets with zero sum =============================
 * Been asked in epam solutions
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1, 0, 1, 2, -2, -4]
 * Output: [-1, 0, 1]	[0, 2, -2]
 *
 * Example 2:
 * Input: nums = []
 * Output: []
 *
 *
 * Example 3:
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * */
public class P2TripletsWithZeroSumDistinct {

    public static void main(String[] args) {

        bruteforceWay();
        hashingWay();
//        twoPointersWay();

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
    private static List<int[]> findTriplets_bruteforce(int[] arr) {

        int n = arr.length;
        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        triplets.add(new int[]{arr[i], arr[j], arr[k]});
                    }
                }
            }
        }
        return triplets;
    }

    private static void bruteforceWay() {

        validateEdgeCase_bruteforce();

        int[] intArr;
        List<int[]> triplets;

        intArr = new int[]{0, -1, 2, -3, 1};
        triplets = findTriplets_bruteforce(intArr);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [0, -1, 1] [2, -3, 1]

        intArr = new int[]{1, -2, 1, 0, 5};
        triplets = findTriplets_bruteforce(intArr);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [0, -1, 1] [2, -3, 1]

        intArr = new int[]{-5, 3, 2, -3, 1};
        triplets = findTriplets_bruteforce(intArr);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr)); // [1,-2, 1]

        intArr = new int[]{-1, 0, 1, 2, -2, -4};
        triplets = findTriplets_bruteforce(intArr);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr)); // 	[-1, 0, 1]	[0, 2, -2]
    }

    private static void validateEdgeCase_bruteforce() {
        List<int[]> output;
        List<int[]> inputs = Arrays.asList(new int[]{}, new int[]{0}, new int[]{0, 0}, new int[]{-1, 1});
        for (int[] input : inputs) {
            output = findTriplets_bruteforce(input);
            if (output.size() > 0) {
                System.out.print("\nEdge cases test got failed....!!!");
            }
        }
        System.out.print("\nEdge cases test validated successfully");
    }

    /*
     * ========= hashing approach =========
     *
     *	Approach:
     *	1.	Create a hashmap to store a key-value pair.
     *	2.	Run a nested loop with two loops, the outer loop from 0 to n-2 and the inner loop from i+1 to n-1
     *	3.	Check if the sum of ith and jth element multiplied with -1 is present in the hashmap or not
     *	4.	If the element is present in the hashmap, print the triplet else insert the j’th element in the hashmap.
     *
     * Time Complexity: O(n^2).
     * Auxiliary Space: O(n).
     *
     * */
    private static List<int[]> findTriplets_hashing(int[] arr) {

        int n = arr.length;
        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            // Find all pairs with sum equals to "-arr[i]"
            Set<Integer> s = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int x = -(arr[i] + arr[j]);
                if (s.contains(x)) {
                    triplets.add(new int[]{x, arr[i], arr[j]});
                } else {
                    s.add(arr[j]);
                }
            }
        }
        return triplets;
    }

    private static void hashingWay() {

        validateEdgeCase_hashing();

        int[] intArr;
        List<int[]> triplets;

        intArr = new int[]{0, -1, 2, -3, 1};
        triplets = findTriplets_hashing(intArr);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [0, -1, 1] [2, -3, 1]

        intArr = new int[]{1, -2, 1, 0, 5};
        triplets = findTriplets_hashing(intArr);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [0, -1, 1] [2, -3, 1]

        intArr = new int[]{-5, 3, 2, -3, 1};
        triplets = findTriplets_hashing(intArr);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr)); // [1,-2, 1]

        intArr = new int[]{-1, 0, 1, 2, -2, -4};
        triplets = findTriplets_hashing(intArr);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr)); // 	[-1, 0, 1]	[0, 2, -2]
    }

    private static void validateEdgeCase_hashing() {
        List<int[]> output;
        List<int[]> inputs = Arrays.asList(new int[]{}, new int[]{0}, new int[]{0, 0}, new int[]{-1, 1});
        for (int[] input : inputs) {
            output = findTriplets_hashing(input);
            if (output.size() > 0) {
                System.out.print("\nEdge cases test got failed....!!!");
            }
        }
        System.out.print("\nEdge cases test validated successfully");
    }


}