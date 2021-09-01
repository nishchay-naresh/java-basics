package com.nishchay.ds.bit.appearonce;

import com.nishchay.ds.array.sort.MergeSort;

/*
 * Given an array where every element occurs three times, except one element which occurs only once.
 * Input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
 * Output: 2
 * In the given array all element appear three times except ‘2' which appears once
 * https://www.geeksforgeeks.org/find-the-element-that-appears-once/
 * */
class ElementAppearsOnceInTriplets {

    public static void main(String[] args) {

		int[] nums = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
		System.out.println("Element occurring once is - " + findSingleInTriplets1(nums));

//		int[] arr = {12, 1, 12, 3, 12, 1, 1, 14, 3, 3};
        int[] arr = {12, 1, 12, 3, 12, 1, 1, -2, 3, 3};
        System.out.println("Element occurring once is - " + findSingleInTriplets(arr));

    }

    // HASHMAP APPROACH (Freq Counting) - First sort the array then, find the smallest cluster
    // Iterate the array once, collect the frequency  of each element in hashMap
    // Complexity: time -  O(n log n), space - O(n)

    // CLUSTERING APPROACH (SORTING) - First sort the array then, find the smallest cluster
    // complexity -  O(n log n + n), space - O(0)
    // COUNTING SET BITS APPROACH log n <= 32 & n <= INT_MAX
    private static int findSingleInTriplets(int[] nums) {

        int n = nums.length;
        if (n < 3) {
            return nums[0];
        }
        // sorting array using merge sort
        MergeSort ref = new MergeSort();
        ref.sort(nums, 0, nums.length - 1);

        // finding the smallest cluster
        int i = 1;
        while (i < n) {
            if (nums[i] != nums[i - 1])
                return nums[i - 1];
            i += 3;
        }
        return nums[n - 1];

    }


    // BIT MANIPULATION APPROACH - Using XOR + AND combination
    // complexity : time -  O(n), space - O(2)
    private static int findSingleInTriplets1(int[] arr) {
        int ones; // hold the element until it has only one occurrence, resetting it to zero once getting 2nd occurrence
        int twos; // // hold the element until it has two occurrence, resetting it to zero once getting 3rd occurrence
        ones = twos = 0;
        for (int i = 1; i < arr.length; i++) {
            ones = (ones ^ arr[i]) & (~twos);
            twos = (twos ^ arr[i]) & (~ones);
        }
        return ones;
    }


}
