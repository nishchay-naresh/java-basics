package com.nishchay.ds.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *============== Find all triplets with zero sum - With Duplicate ====================
 *
 * Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.
 *
 * Examples - 1
 *			Input : arr[] = {-2, 0, 1, 1, 2}
 *			Output : [-2, 0, 2], [-2, 1, 1]
 *
 * Examples - 2
 *			Input : arr[] = {1, -1, 2, 0, -2, 4, -2, -2, 4}
 *			Output : [1, -1, 0], [4, -2, -2], [2, -2, 0]
 *
 * Examples - 3
 *			Input: a[] = {-1, 0, 1, 2, -1, -4}
 *			Output: [-1, 0, 1],[-1, -1, 2]
 *
 * Examples - 4
 *			Input: a[] = {-1, -1, 2, -1, -1, 2, -1, -1, 2}
 *			Output: [-1, -1, 2]
 *
 * https://www.callicoder.com/find-triplets-with-zero-sum/
 * https://afteracademy.com/blog/triplet-with-zero-sum
 *
 * */
public class P2TripletsWithZeroSumDuplicates {

    public static void main(String[] args) {

        twoPointersWay();

    }

    /*
     * ========= sorting then two pointers approach =========
     *
     *	Approach:
     *	1.	Create arr hashmap to store arr key-value pair.
     *	2.	Run arr nested loop with two loops, the outer loop from 0 to n-2 and the inner loop from i+1 to n-1
     *	3.	Check if the sum of ith and jth element multiplied with -1 is present in the hashmap or not
     *	4.	If the element is present in the hashmap, print the triplet else insert the j’th element in the hashmap.
     *
     * Time Complexity: O(n^2).
     * Auxiliary Space: O(1).
     *
     */
    private static List<int[]> findTriplets_duplicates_twoPointers(int[] arr) {

        List<int[]> triplets = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            // Skip duplicates
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            // Fix one number
            int curr = arr[i];

            // Use Two-sum approach to get the other two numbers
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int sum = curr + arr[left] + arr[right];
                if (sum == 0) {
                    triplets.add(new int[]{curr, arr[left], arr[right]});
                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right && arr[left] == arr[left - 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }

    private static void twoPointersWay() {

        validateEdgeCase_twoPointers();

        int[] intArr;
        List<int[]> triplets;

        intArr = new int[]{-2, 0, 1, 1, 2};
        triplets = findTriplets_duplicates_twoPointers(intArr);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [-2, 0, 2], [-2, 1, 1]

        intArr = new int[]{1, -1, 2, 0, -2, 4, -2, -2, 4};
        triplets = findTriplets_duplicates_twoPointers(intArr);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [1, -1, 0], [4, -2, -2], [2, -2, 0]

        intArr = new int[]{-1, 0, 1, 2, -1, -4};
        triplets = findTriplets_duplicates_twoPointers(intArr);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr)); // [-1, 0, 1],[-1, -1, 2]

        intArr = new int[]{-1, -1, 2, -1, -1, 2, -1, -1, 2};
        triplets = findTriplets_duplicates_twoPointers(intArr);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr)); // 	[-1, -1, 2]

    }

    private static void validateEdgeCase_twoPointers() {
        List<int[]> output;
        List<int[]> inputs = Arrays.asList(new int[]{}, new int[]{0}, new int[]{0, 0}, new int[]{-1, 1});
        for (int[] input : inputs) {
            output = findTriplets_duplicates_twoPointers(input);
            if (output.size() > 0) {
                System.out.print("\nEdge cases test got failed....!!!");
            }
        }
        System.out.print("\nEdge cases test validated successfully");
    }

}