package com.nishchay.ds.twopointers;

import java.util.*;

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

        bruteforceWay();
        System.out.print("\n-----------------------------");
        hashingWay();
        System.out.print("\n-----------------------------");
        twoPointersWay();

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

    private static void bruteforceWay() {

        int sum;
        int[] intArr;
        List<int[]> triplets;

        intArr = new int[]{7, 12, 3, 1, 2, -6, 5, -8, 6}; sum = 0;
        triplets = findTriplets_bruteforce(intArr, sum);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [7, 1, -8], [3, 5, -8], [1, -6, 5], [2, -8, 6]

        intArr = new int[]{2, 7, 4, 0, 9, 5, 1, 3}; sum = 6;
        triplets = findTriplets_bruteforce(intArr, sum);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [0, 1, 5], [0, 2, 4], [1, 2, 3]

        intArr = new int[]{12, 3, 4, 1, 6, 9}; sum = 24;
        triplets = findTriplets_bruteforce(intArr, sum);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [12, 3, 9]

        intArr = new int[]{1, 2, 3, 4, 5}; sum = 9;
        triplets = findTriplets_bruteforce(intArr, sum);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [5, 3, 1], [2, 3, 4]
    }

    /*
     * ========= hashing approach =========
     *
     *	Approach:
     *	You just need to iterate through the array,
     *  fix the first element, and then try to find the other two elements using the approach similar to the two sum problem.
     *
     * Time Complexity: O(n^2).
     * Auxiliary Space: O(n).
     *
     * */
    private static List<int[]> findTriplets_hashing(int[] arr, int sum) {

        int n = arr.length;
        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            // Find all pairs with sum equals to "-arr[i]"
            int currentTarget = sum - arr[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                if (set.contains(currentTarget - arr[j])) {
                    triplets.add(new int[]{arr[i], arr[j], currentTarget - arr[j]});
                } else {
                    set.add(arr[j]);
                }
            }
        }
        return triplets;
    }

    private static void hashingWay() {

        int sum;
        int[] intArr;
        List<int[]> triplets;

        intArr = new int[]{7, 12, 3, 1, 2, -6, 5, -8, 6}; sum = 0;
        triplets = findTriplets_hashing(intArr, sum);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [7, 1, -8], [3, 5, -8], [1, -6, 5], [2, -8, 6]

        intArr = new int[]{2, 7, 4, 0, 9, 5, 1, 3}; sum = 6;
        triplets = findTriplets_hashing(intArr, sum);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [0, 1, 5], [0, 2, 4], [1, 2, 3]

        intArr = new int[]{12, 3, 4, 1, 6, 9}; sum = 24;
        triplets = findTriplets_hashing(intArr, sum);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [12, 3, 9]

        intArr = new int[]{1, 2, 3, 4, 5}; sum = 9;
        triplets = findTriplets_hashing(intArr, sum);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [5, 3, 1], [2, 3, 4]
    }


    /*
     * ========= sorting then two pointers approach =========
     *
     *	Approach:
     *	1.	Sort the array in ascending order.
     *	2.	Traverse the array from start to end.
     *	3.	For every index i, create two variables left = i + 1 and right = n – 1
     *	4.	Run a loop until left is less than right if (array[i] +  array[left] + array[right]) == sum we got the triplet increment left, decrement right and continue the loop
     *	5.	If the sum < 0 then increment the value of left
     *		    , by increasing the value of left the sum will increase as array is sorted, so array[left+1] > array [left]
     *	6.	If the sum > 0 then decrement the value of right
     *          , by decreasing the value of right the sum will decrease as array is sorted, so array[right-1] < array [right].
     *
     * Time Complexity: O(n * log n).
     * Auxiliary Space: O(1).
     *
     * */
    private static List<int[]> findTriplets_twoPointers(int[] arr, int sum) {

        int n = arr.length;
        List<int[]> triplets = new ArrayList<>();

        // sort array elements
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {

            // initialize left and right
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (arr[i] + arr[left] + arr[right] == sum) {
                    triplets.add(new int[]{arr[i], arr[left], arr[right]});
                    left++;
                    right--;
                }

                // If sum of three elements is less than zero then increment in left
                else if (arr[i] + arr[left] + arr[right] < sum)
                    left++;
                    // if sum is greater than zero then decrement in right side
                else
                    right--;
            }
        }

        return triplets;
    }

    private static void twoPointersWay() {

        int sum;
        int[] intArr;
        List<int[]> triplets;

        intArr = new int[]{7, 12, 3, 1, 2, -6, 5, -8, 6}; sum = 0;
        triplets = findTriplets_twoPointers(intArr, sum);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [7, 1, -8], [3, 5, -8], [1, -6, 5], [2, -8, 6]

        intArr = new int[]{2, 7, 4, 0, 9, 5, 1, 3}; sum = 6;
        triplets = findTriplets_twoPointers(intArr, sum);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [0, 1, 5], [0, 2, 4], [1, 2, 3]

        intArr = new int[]{12, 3, 4, 1, 6, 9}; sum = 24;
        triplets = findTriplets_twoPointers(intArr, sum);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [12, 3, 9]

        intArr = new int[]{1, 2, 3, 4, 5}; sum = 9;
        triplets = findTriplets_twoPointers(intArr, sum);
        System.out.print("\ntriplets = ");
        for (int[] curr : triplets)
            System.out.print("\t" + Arrays.toString(curr));// [5, 3, 1], [2, 3, 4]

    }

}
