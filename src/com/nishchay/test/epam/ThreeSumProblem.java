package com.nishchay.test.epam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ===================== Find all Triplets with zero sum =============================
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
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
 **/

public class ThreeSumProblem {

    public static void main(String[] args) {

//        m1();
        m2();

    }


    private static void m1() {
        int[] intArr = new int[] {-1,0,1,2,-1,-4};

        List<int[]> res = findTriplet(intArr);

        System.out.print("res = ");
        for (int[] curr : res)
            System.out.print(Arrays.toString(curr));
    }

    private static void m2() {

        int[] intArr;
        List<int[]> triplets;

        intArr = new int[] {-5, 3, 2, -3, 1};
        System.out.println("\narray - " + Arrays.toString(intArr));
        triplets = findThreeSum_BruteForce(intArr,0);
        System.out.print("triplets = ");
        for (int[] curr : triplets)
            System.out.print(Arrays.toString(curr)); // [-5, 3, 2] [2, -3, 1]

        intArr = new int[] {-1, -1, 2, -1, -1, 2, -1, -1, 2};
        System.out.println("\narray - " + Arrays.toString(intArr));
        triplets = findThreeSum_BruteForce(intArr,0);
        System.out.print("triplets = ");
        for (int[] curr : triplets)
            System.out.print(Arrays.toString(curr));  // [-1, -1, 2]

    }


    private static List<int[]> findTriplet(int[] nums) {

        List<int[]> triplets = new ArrayList<>();

        int i,j,k;
        
        for (int x = 0; x < nums.length-4; x++) {
//            do{
                i=x;
                j=i+1;
                k=j+1;
                if (nums[i] + nums[j] + nums[k] == 0){
                    triplets.add(new int[]{nums[i],nums[j],nums[k]});
                }
//            }while(k < nums.length-1);

        }

        return triplets;
    }


    // Time complexity: O(n^3)
    private static List<int[]> findThreeSum_BruteForce(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        result.add(new int[] { nums[i], nums[j], nums[k] });
                    }
                }
            }
        }
        return result;
    }

}