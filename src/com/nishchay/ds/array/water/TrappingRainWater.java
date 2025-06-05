package com.nishchay.ds.array.water;

/*
 *
 * Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Examples:
 *      Input: arr[] = {2, 0, 2}
 *      Output: 2
 *      Explanation: Will trap 0 + 2 + 0 = 2 units.
 *
 *	    Input: arr[] = {3, 0, 2, 0, 4}
 *	    Output: 7
 *      Explanation: Will trap 0 + 3 + 1 + 3 + 0 = 7 units.
 *
 *	    Input: arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
 *	    Output: 6
 *      Explanation: Will trap 0 + 0 + 1 + 0 + 1 + 2 + 1 + 0 + 0 + 1 + 0 + 0 = 6 units.
 *
 *	    Input: arr[] = {3, 0, 1, 0, 4, 0, 2}
 *	    Output: 10
 *	    Explanation: Will trap 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.
 *
 *      Input: arr[] = {3, 0, 2, 0, 4}
 *	    Output: 7
 *	    Explanation: Will trap 0 + 3 + 1 + 3 + 0 = 7 units.
 *
 *	    Input: arr[] = {1, 2, 3, 4}
 *	    Output: 0
 *	    Explanation: Cannot trap water as there is no height bound on both sides
 *
 *
 * https://www.geeksforgeeks.org/trapping-rain-water/
 * https://www.interviewbit.com/blog/trapping-rain-water/
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * */

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {

        int[][] input2D = {
                {2, 0, 2},                              // 2
                {3, 0, 2, 0, 4},                        // 7
                {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},   // 6
                {3, 0, 1, 0, 4, 0, 2},                  // 10
                {3, 0, 2, 0, 4},                        // 7
                {1, 2, 3, 4},                           // 0
                {1, 3, 2, 4, 6, 1},                     // 1
                {1, 3, 2, 1, 4, 6, 7, 3, 1},            // 3
                {7, 0, 4, 2, 5, 0, 6, 4, 0, 5},        // 25
                {5, 6, 7, 12, 2, 10, 17, 5, 3}          // 12
        };

        int[] outputs = {2, 7, 6, 10, 7, 0, 1, 3, 25, 12};

        boolean result = true;
        for (int i = 0; i < input2D.length; i++) {
            result = result && trappingWater_2PApproach(input2D[i]) == (outputs[i]);
            if (!result)
                System.out.println("Test failed for: " + Arrays.toString(input2D[i]));
            else
                System.out.println("Test passed for: " + Arrays.toString(input2D[i]));
        }

        int[] arr1 = {0, 1, 2, 4, 5, 7, 9, 8, 6, 3, 2, 1};  // 0
        System.out.println(trappingRainWater_bruteforce(arr1));

        int[] arr2 = {5, 6, 7, 12, 2, 10, 5, 17, 5, 3};        // 0,0,0,0,10,2,7,0,0,0 = 17
        System.out.println(trappingRainWater_DPApproach(arr2));
    }


    /*
     * ============= Bruteforce Approach =====================
     *
     *  ithWater = min(right_max, left_max) – arr[i]
     *
     *	Traverse the array arr[] from 1 to n-2 and for each element:
     *		Initialise left_max = right_max = arr[i]
     *		Traverse from arr[i] till the beginning of the array and update:
     *			left_max = max(left_max, arr[i])
     *		Similarly, traverse from arr[i] till the end of the array and update:
     *			right_max = max(right_max, arr[i])
     *      ithWater = min(leftMax, rightMax) - arr[i];
     *      totalWater = totalWater + ithWater;
     *
     *
     * Time Complexity : O(n^2) For each element, the left and right half are traversed.
     * Space Complexity: O(1)
     *
     */
    private static int trappingRainWater_bruteforce(int[] arr) {
        int len = arr.length;
        int leftMax, rightMax, ithWater, totalWater;
        totalWater = 0;

        // excluding the first and last element
        for (int i = 1; i < len - 1; i++) {

            // Find maximum element on its left
            leftMax = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, arr[j]);
            }

            // Find maximum element on its right
            rightMax = arr[i];
            for (int j = i + 1; j < len; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }

            ithWater = Math.min(leftMax, rightMax) - arr[i];
            totalWater = totalWater + ithWater;
        }
        return totalWater;
    }

    /*
     * ============= Dynamic Programming Approach =====================
     *
     *  The idea is to consider two arrays left_max[] and right_max[],
     *        left_max[i] will store the maximum height on the left until index i.
     *        right_max[i] will store the maximum height on the right until index i.
     *        ithWater = min(left_max[i], right_max[i]) - arr[i];
     *
     *
     *	Initialise two arrays left_max[] and right_max[] of size N.
     *	Consider a variable mx = 0.
     *	Traverse from left to right and for each index i,
     *		update mx = max(mx, A[i[) and
     *		assign left_max = mx.
     *
     *	Traverse a loop, N to 1 and for each index i,
     *		update mx = max(mx, A[i[) and
     *		assign right_max = mx.
     *
     *	totalWater = 0
     *	Traverse from 0 to N – 1. For each index i,
     *		ithWater = min(left_max[i], right_max[i]) - arr[i];
     *		totalWater = totalWater + ithWater
     *
     *
     * Time Complexity: O(N) + O(N) + O(N)  = O(N), since the array is traversed thrice.
     * Space Complexity: O(N) + O(N)        = O(N), since two arrays are needed.
     *
     */

     private static int trappingRainWater_DPApproach(int[] arr) {

         int n = arr.length;
         if (n == 0) {
             return 0;
         }

         int totalWater, ithWater;

         // left[i] contains height of the tallest bar to the left of ith bar including itself
         int[] leftMax = new int[n];

         // right[i] contains height of the tallest bar to the right of ith bar including itself
         int[] rightMax = new int[n];

         // Fill left array
         leftMax[0] = arr[0];
         for (int i = 1; i < leftMax.length; i++) {
             leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
         }

         // Fill right array
         rightMax[n - 1] = arr[n - 1];
         for (int j = rightMax.length - 2; j >= 0; j--) {
             rightMax[j] = Math.max(rightMax[j + 1], arr[j]);
         }

         totalWater = 0;
        for (int i = 0; i < n; i++){
            ithWater =  Math.min(leftMax[i], rightMax[i]) - arr[i];
            totalWater = totalWater + ithWater;
        }
         return totalWater;
     }

    /*
     * ============= Two Pointers Approach =====================
     *               ithWater = min(right_max, left_max) – arr[i]
     *
     * To optimize it further, if we know which is smaller out of right_max, left_max, we never need both of them, ====>  we only need one, the smaller one
     * we will never get both right_max, left_max in leaner traversal ---> or <----- . =====> we need to travel from both side
     * Why processing the smaller number first ====>  because we need the smaller one out of right_max, left_max
     * When this loops get terminated ===> When both left & right pointer to the largest no
     *
     *
     * while (left < right) {
     *    we will process the smaller number first
     *      based on left pointer movement, will find the leftMax
     *      if((arr[left] >= leftMax)
     *          will update the leftMax
     *      else
     *          will compute arr[left] water and add to total
     *
     *      based on right pointer movement, will find the rightMax
     *      if (arr[right] >= rightMax)
     *          will update the rightMax
     *      else
     *          will compute arr[right] water and add to total
     *
     * }
     *
     * Time Complexity: O(n).
     * Space Complexity: O(1).
     * Can't do better than this, because we at leased need to touch each element once
     * */
    public static int trappingWater_2PApproach(int[] arr) {

        int left, right, leftMax, rightMax, totalWater, ithWater;
        left = 0;
        right = arr.length - 1;
        leftMax = rightMax = totalWater = 0;


        while (left < right) {
            // processing the smaller number first
            if (arr[left] < arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else { // since we have processed the smaller number first, we are sure that leftMax < rightMax
                    ithWater = leftMax - arr[left];
                    totalWater = ithWater + totalWater;
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else { // since we have processed the smaller number first, now we are in else part we are sure that leftMax > rightMax
                    ithWater = rightMax - arr[right];
                    totalWater = ithWater + totalWater;
                }
                right--;
            }
        }
        return totalWater;
    }
}

