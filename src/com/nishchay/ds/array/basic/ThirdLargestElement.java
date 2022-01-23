package com.nishchay.ds.array.basic;

/*
 *	=========== Third largest element in an array of distinct elements ===========
 *
 * Given an array of n integers, find the third largest element. All the elements in the array are distinct integers.
 *
 *	Example 1:
 *		Input: arr[] = {1, 14, 2, 16, 10, 20}
 *		Output: The third Largest element is 14
 *		Explanation: Largest element is 20, second largest element is 16 and third largest element is 14
 *
 *	Example 2:
 *		Input: arr[] = {19, -10, 20, 14, 2, 16, 10}
 *		Output: The third Largest element is 16
 *		Explanation: Largest element is 20, second largest element is 19 and third largest element is 16
 *
 * https://www.geeksforgeeks.org/third-largest-element-array-distinct-elements/
 *
 * */
public class ThirdLargestElement {

    public static void main(String[] args) {

        int[] arr;

        arr = new int[]{1, 14, 2, 16, 10, 20};
        System.out.printf("The third Largest element is %d%n", get3rdLargestBruteForce(arr)); // 14
        System.out.printf("The third Largest element is %d%n", get3rdLargest(arr)); // 14

        arr = new int[]{19, -10, 20, 14, 2, 16, 10};
        System.out.printf("The third Largest element is %d%n", get3rdLargestBruteForce(arr)); // 16
        System.out.printf("The third Largest element is %d%n", get3rdLargest(arr)); // 16

    }

    /*
    *  Algorithm:
    * First, iterate through the array and find maximum.
    * Now traverse the whole array again and find the second max
    * Finally traverse the array the third time and find the third largest element
    *
    * Time Complexity: O(n).
    * Space complexity: O(1).
    *  But here we are iterating array thrice
    * */
    private static int get3rdLargestBruteForce(int[] arr) {

        int arr_size = arr.length;

        if (arr_size < 3) {
            System.out.println(" Invalid Input ");
            return -1;
        }

        // Find first largest element
        int first = arr[0];
        for (int i = 1; i < arr_size; i++)
            if (arr[i] > first)
                first = arr[i];

        // Find second largest element
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < arr_size; i++)
            if (arr[i] > second && arr[i] < first)
                second = arr[i];

        // Find third largest element
        int third = Integer.MIN_VALUE;
        for (int i = 0; i < arr_size; i++)
            if (arr[i] > third && arr[i] < second)
                third = arr[i];

        return third;
    }

    /*
     *  Algorithm:
     * First, iterate through the array and find maximum.
     * Now traverse the whole array again and find the second max
     * Finally traverse the array the third time and find the third largest element
     *
     * Time Complexity: O(n).
     * Space complexity: O(1).
     *  But here we are iterating array only once
     * */
    private static int get3rdLargest(int[] arr ) {

        int arr_size = arr.length;

        if (arr_size < 3) {
            System.out.println("Invalid Input ");
            return -1;
        }

        // Initialize first, second and third Largest element
        int first = arr[0], second = Integer.MIN_VALUE,
                third = Integer.MIN_VALUE;

        // Traverse array elements to find the third Largest
        for (int i = 1; i < arr_size; i++) {
            /* If current element is greater than first,
        then update first, second and third */
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } /* If arr[i] is in between first and second */
            else if (arr[i] > second) {
                third = second;
                second = arr[i];
            } /* If arr[i] is in between second and third */
            else if (arr[i] > third) {
                third = arr[i];
            }
        }
        return third;
    }


}
