package com.nishchay.ds.array.basic;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 *
 *  Given an array of size n, return the majority element.
 *  The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 * Example 1:
 * 	Input: arr[] = [3,2,3]
 * 	Output: 3
 * 	Explanation: Element 3 appears 2 times. Since ⌊3/2⌋ = 1, and 2 > 1, it is the majority element.
 *
 * Example 2:
 * 	Input: arr[] = [2,2,1,1,1,2,2]
 * 	Output: 2
 * 	Explanation: Element 2 appears 4 times. Since ⌊7/2⌋ = 3, and 4 > 3, it is the majority element.
 *
 * Example 3:
 * 	Input: arr[] = [1, 1, 2, 1, 3, 5, 1]
 * 	Output: 1
 * 	Explanation: Element 1 appears 4 times. Since ⌊7/2⌋ = 3, and 4 > 3, it is the majority element.
 *
 * Example 4:
 * 	Input: arr[] = [7]
 * 	Output: 7
 * 	Explanation: Element 7 appears once. Since ⌊1/2⌋ = 0, and 1 > 0, it is the majority element.
 *
 * Example 5:
 * 	Input: arr[] = [2, 13]
 * 	Output: -1
 * 	Explanation: No element appears more than ⌊2/2⌋ = 1 time, so there is no majority element.
 *
 *
 *  https://www.geeksforgeeks.org/dsa/majority-element/
 *  https://leetcode.com/problems/majority-element/description/
 *
 * */
public class MajorityElement {

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 1, 3, 5, 1};
        System.out.println(majorityElement_hashing(arr));

        int[][] input2D = {
                {3, 2, 3},                              // 3
                {2, 2, 1, 1, 1, 2, 2},                  // 2
                {1, 1, 2, 1, 3, 5, 1},                  // 1
                {7},                                    // 7
                {2, 13},                                // -1
                {3, 3, 1, 3, 2, 3}                      // 3
        };

        int[] outputs = {3, 2, 1, 7, -1, 3};

        boolean result = true;
        for (int i = 0; i < input2D.length; i++) {
            result = result && majorityElement(input2D[i]) == (outputs[i]);
            if (!result)
                System.out.println("Test failed for: " + Arrays.toString(input2D[i]));
            else
                System.out.println("Test passed for: " + Arrays.toString(input2D[i]));
        }

    }

    /*
     * ============= Hashing approach =====================
     *
     * Initialize an empty hash map.
     * Traverse the array and update the count of each element.
     * After each update, check if the count exceeds n / 2.
     * If found, return that element immediately.
     * If no such element exists after the loop, return -1.
     *
     *
     * Time Complexity : O(n)
     * Space Complexity: O(n)
     *
     */
    private static int majorityElement_hashing(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            if (countMap.get(num) > n / 2) {
                return num;
            }
        }
        return -1;
    }


    /*
     * ============= Moore's Voting Algorithm =====================
     * [Expected Approach] Using Moore's Voting Algorithm - O(n) Time and O(1) Space
     *
     * Initialize a candidate variable and a count variable.
     * Traverse the array once:
     * -> If count is zero, set the candidate to the current element and set count to one.
     * -> If the current element equals the candidate, increment count.
     * -> If the current element differs from the candidate, decrement count.
     *
     * Traverse the array again to count the occurrences of the candidate.
     * If the candidate's count is greater than n / 2, return the candidate as the majority element.
     *
     *
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     *
     */

    private static int majorityElement(int[] arr) {

        int n = arr.length;
        int candidate = -1;
        int count = 0;

        // Find a candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            }
            else if (num == candidate) {
                count++;
            }
            else {
                count--;
            }
        }

        // Validate the candidate
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        // If count is greater than n / 2, return
        // the candidate; otherwise, return -1
        if (count > n / 2) {
            return candidate;
        } else {
            return -1;
        }
    }
}