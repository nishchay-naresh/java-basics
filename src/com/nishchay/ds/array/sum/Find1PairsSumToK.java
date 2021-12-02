package com.nishchay.ds.array.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 *==============1. Array Two Sum====================
 * Given an Array of integers, return all the pairs which sum up to a specific integer.
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order. - Assuming one one pair is there
 *
 *	Example 1:
 *		Input: nums = [2,7,11,15], target = 9
 *		Output: [0,1]
 *		Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 *	Example 2:
 *		Input: nums = [3,2,4], target = 6
 *		Output: [1,2]
 *
 *	Example 3:
 *		Input: nums = [3,3], target = 6
 *		Output: [0,1]
 *
 * https://leetcode.com/problems/two-sum/
 * https://www.tutorialcup.com/leetcode-solutions/two-sum-leetcode-solution.htm
 * https://redquark.org/leetcode/0001-two-sum/
 *
 * ################################################ PENDING ###################################
 *	Example 2:
 *		Input: nums = [-5, 1, -40, 20, 6, 8, 7], target = 15
 *		Output: [-5, 20], [7, 8]
 *
 *	Example 3:
 *		Input: nums = [1,2,3,4,5,6], target = 7
 *		Output: [1, 6],[2, 5],[3, 4]
 *
 * if no is sorted - can apply 2 pointer approach
 *
 * */
public class Find1PairsSumToK {

    public static void main(String[] args) {

        getPairsDemo();

        System.out.println("---------------------------------------------");

        twoSumDemo();
    }

    private static void getPairsDemo() {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = getPairs(arr, target);
        System.out.println("res = " + Arrays.toString(res));//{ 0, 1}

        arr = new int[]{3, 2, 1, 4};
        target = 6;
        res = getPairs(arr, target);
        System.out.println("res = " + Arrays.toString(res));//{ 1, 3}

        arr = new int[]{3, 2, 1, 4};
        target = 8;
        res = getPairs(arr, target);
        System.out.println("res = " + Arrays.toString(res));//{ -1, -1}
    }

    private static void twoSumDemo() {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(arr, target);
        System.out.println("res = " + Arrays.toString(res));//{ 0, 1}

        arr = new int[]{3, 2, 1, 4};
        target = 6;
        res = twoSum(arr, target);
        System.out.println("res = " + Arrays.toString(res));//{ 1, 3}

        arr = new int[]{3, 2, 1, 4};
        target = 8;
        res = twoSum(arr, target);
        System.out.println("res = " + Arrays.toString(res));//{ -1, -1}
    }
    /*
     * Approach 1 - Brute Force
     *
     *	1. Run a loop to maintain the first index of the solution in the array
     *	2. Run another loop to maintain a second index of the solution for every first integer
     *	3. If at any point, the sum of values of two indices is equal to the target
     *		 Print its indices
     *
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     *
     * */
    private static int[] getPairs(int[] arr, int target) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (arr[i] + arr[j] == target)
                    return new int[]{i, j};

        return new int[]{-1, -1};
    }

    /*
     *    Loop through the array
     *        Check if we have encountered with (current element)its pair
     *            If we have, we will return the index of this element and the index of its pair from HM
     *            If we haven’t, the we will save the no with its index in HM.
     *        Repeat the process
     *
     * Time complexity - O(n)
     * Space complexity - O(n)
     *
    * */
    private static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[]{-1,-1};
        Map<Integer, Integer> map = new HashMap<>();
        int pair;

        for (int i = 0; i < numbers.length; i++) {
            pair = target - numbers[i];
            if (map.containsKey(pair)) {
                result[1] = i;
                result[0] = map.get(pair);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

}
