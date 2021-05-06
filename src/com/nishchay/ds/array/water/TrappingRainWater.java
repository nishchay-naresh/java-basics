package com.nishchay.ds.array.water;

/*
 * https://www.geeksforgeeks.org/trapping-rain-water/
 * Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * Examples:
 *      Input: arr[]   = {2, 0, 2}
 *      Output: 2
 *	    Input: arr[]   = {3, 0, 2, 0, 4}
 *	    Output: 7
 *	    Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 *	    Output: 6
 *
 *------------------------------------------------------------
 * Algorithm :
 *	getTotalWaterVolume(H) :
 *		total_water = 0;
 *		for i = 1 to n :
 *
 *			Lmax = max(H[1],..H[i - 1]);
 *			Rmax = max(H[i + 1,...H[n]]);
 *			water_building = min(Lmax, Rmax);
 *			water_i = water_building - H[i];
 *			total_water = total_water + water_i;
 *		return total_water;
 *
 * https://afteracademy.com/blog/rain-water-trapping
 *
 * */

public class TrappingRainWater {


    public static void main(String[] args) {
        // -------------
        int[] nums = {0, 1, 2, 4, 5, 7, 9, 8, 6, 3, 2, 1};  // 0
        System.out.println(getTotalWaterVolume1(nums));

//        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};   // 6
//        int[] arr = {1, 3, 2, 4, 6, 1};                   // 1
//        int[] arr = {1, 3, 2, 1, 4, 6, 7, 3, 1};          // 3
//        int[] arr = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 };     // 25
        int[] arr = {5, 6, 7, 12, 2, 10, 17, 5, 3};       // 12
        System.out.print(getTotalWaterVolume(arr));


    }

    private static int getTotalWaterVolume(int[] arr) {
        int totalWater = 0;
        int len = arr.length;

        // For every element of the array except first and last element
        for (int i = 1; i < len - 1; i++) {

            // Find maximum element on its left
            int left = arr[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            // Find maximum element on its right
            int right = arr[i];
            for (int j = i + 1; j < len; j++) {
                right = Math.max(right, arr[j]);
            }

            int ithWater = Math.min(left, right) - arr[i];
            totalWater = totalWater + ithWater;
        }


        return totalWater;

    }
    /*
     * Time Complexity: O(n2).
     * Space Complexity: O(1).
     * */

     private static int getTotalWaterVolume1(int[] arr) {

         int n = arr.length;
         // left[i] contains height of tallest bar to the left of i'th bar including itself
         int[] left = new int[n];

         // right[i] contains height of tallest bar to the right of ith bar including itself
         int[] right = new int[n];

         // Initialize result
         int water = 0;

         // Fill left array
         left[0] = arr[0];
         for (int i = 1; i < n; i++)
             left[i] = Math.max(left[i - 1], arr[i]);

         // Fill right array
         right[n - 1] = arr[n - 1];
         for (int i = n - 2; i >= 0; i--)
             right[i] = Math.max(right[i + 1], arr[i]);

         // Calculate the accumulated water element by element
         // consider the amount of water on i'th bar, the
         // amount of water accumulated on this particular
         // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
            water += Math.min(left[i], right[i]) - arr[i];

         return water;
     }
}

