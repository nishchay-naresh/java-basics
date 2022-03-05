package com.nishchay.test.epam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
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
 **/

public class Test2 {

    public static void main(String[] args) {

        int[] intArr = new int[] {-1,0,1,2,-1,-4};

        List<int[]> res = findTriplet(intArr);

        System.out.print("res = ");
        for (int[] curr : res)
            System.out.print(Arrays.toString(curr));

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
}