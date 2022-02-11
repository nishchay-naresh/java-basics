package com.nishchay.ds.array.sum;

import java.util.*;

/*
 *==============1. Array Two Sum====================
 *
 * Given an Array of integers, return all the pairs which sum up to a specific integer.
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *	Example 2:
 *		Input: nums = [-5, 1, -40, 20, 6, 8, 7], target = 15
 *		Output: [-5, 20], [7, 8]
 *
 *	Example 3:
 *		Input: nums = [1,2,3,4,5,6], target = 7
 *		Output: [1, 6],[2, 5],[3, 4]
 *
 *
 * https://coderbyte.com/algorithm/two-sum-problem
 * https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
 * */
public class FindMPairsSumToK {

    public static void main(String[] args) {

        getPairsDemo();
        System.out.print("\n ---------------------------------------------");
        twoSumDemo();

    }

    private static void getPairsDemo() {
        int[] arr = new int[]{-5, 1, -40, 20, 6, 8, 7};
        int target = 15;
        List<int[]> res = getPairs(arr, target);

        System.out.print("\nres = ");
        for(int[] e : res){
            System.out.print(Arrays.toString(e));
        }


        arr = new int[]{1,2,3,4,5,6};
        target = 7;
        res = getPairs(arr, target);
        System.out.print("\nres = ");
        for(int[] e : res){
            System.out.print(Arrays.toString(e));
        }

        arr = new int[]{3, 2, 1, 4};
        target = 8;
        res = getPairs(arr, target);
        System.out.print("\nres = ");
        for(int[] e : res){
            System.out.print(Arrays.toString(e));
        }
    }


    private static void twoSumDemo() {
        int[] arr = new int[]{-5, 1, -40, 20, 6, 8, 7};
        int target = 15;
        List<int[]> res = twoSum(arr, target);

        System.out.print("\nres = ");
        for(int[] e : res){
            System.out.print(Arrays.toString(e));
        }


        arr = new int[]{1,2,3,4,5,6};
        target = 7;
        res = twoSum(arr, target);
        System.out.print("\nres = ");
        for(int[] e : res){
            System.out.print(Arrays.toString(e));
        }

        arr = new int[]{3, 2, 1, 4};
        target = 8;
        res = twoSum(arr, target);
        System.out.print("\nres = ");
        for(int[] e : res){
            System.out.print(Arrays.toString(e));
        }
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
    private static List<int[]> getPairs(int[] arr, int target) {

        int n = arr.length;
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (arr[i] + arr[j] == target)
                    res.add(new int[]{arr[i], arr[j]});

        if(res.size()==0){
            res.add(new int[]{-1, -1});
        }
        return res;
    }

    /*
     * ======== Approach 2 - Hashing ============
     *
     * Algorithm:
     * 	1. Initialize an empty hash table s.
     * 	2. Do following for each element A[i] in A[]
     * 		If s[x – A[i]] is set then print the pair (A[i], x – A[i])
     * 		Insert A[i] into s.
     *
     *
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
    private static List<int[]> twoSum(int[] numbers, int target) {

        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int pair;

        for (int i = 0; i < numbers.length; i++) {
            pair = target - numbers[i];
            if (map.containsKey(pair)) {
                result.add(new int[]{pair, numbers[i]});
            }
            map.put(numbers[i], i);
        }
        if(result.size()==0){
            result.add(new int[]{-1, -1});
        }
        return result;
    }


}
