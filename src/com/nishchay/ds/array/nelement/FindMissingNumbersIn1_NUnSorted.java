package com.nishchay.ds.array.nelement;

import java.util.*;

/*
 *	=========== Find All Numbers Disappeared in an Array ===========
 *
 *	Given an array nums of n integers where nums[i] is in the range [1, n],
 *  return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 *
 *	Example 1:
 *		Input: nums = [4,3,2,7,8,2,3,1]
 *		Output: [5,6]
 *
 *	Example 2:
 *		Input: nums = [1,1]
 *		Output: [2]
 *
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * Find All Numbers Disappeared in an Array:
 * test:[1,5, 3, 4, 7]
 * ans: [2, 6]
 * The solution must be in JAVA
 *
 * */
public class FindMissingNumbersIn1_NUnSorted {

    public static void main(String[] args) {

        int[] nums;

        nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Missing numbers = " + findDisappearedNumbers(nums));

        nums = new int[]{1, 1};
        System.out.println("Missing numbers = " + findDisappearedNumbers(nums));
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> missingNums = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        // adding them in set will remove the duplicates, set will have 1 to N
        for (int curr : nums )
            set.add(curr);

        for (int i = 1; i <= n; i++)
            if (!set.contains(i))
                missingNums.add(i);

        return missingNums;

    }

}
