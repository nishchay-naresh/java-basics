package com.nishchay.ds.array.nelement;

/*
 *	=========== find multiple duplicate numbers in an array ===========
 *
 * Find duplicates in O(n) time and O(1) extra space.
 *
 * Given an array of n elements that contains elements from 0 to n-1, with any of these numbers appearing any number of times.
 * Find these repeating numbers in O(n) and using only constant memory space.
 *
 *	We are given a 2D array where all elements in any individual row or column are sorted.
 * 	In such a matrix, we have to search or find the position of, a given key.
 *
 *	For Example
 *		Input : n = 7 and array[] = {1, 2, 3, 6, 3, 6, 1}
 *		Output: 1, 3, 6
 *
 *		Explanation: The numbers 1 , 3 and 6 appears more
 *		than once in the array.
 *
 *		Input : n = 5 and array[] = {1, 2, 3, 4 ,3}
 *		Output: 3
 *
 *		Explanation: The number 3 appears more than once
 *		in the array.
 *
 *
 * https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 * https://medium.com/solvingalgo/solving-algorithmic-problems-find-a-duplicate-in-an-array-3d9edad5ad41
 *
 * */
public class FindManyRepetitiveElementIn1_N {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 1, 3, 6, 6};

        printRepeating(arr);
    }

    /*
     * Function to print duplicates in O(n) time
     *
     * Input: [2, 3, 3, 1]
     *   Index 0:
     *     Absolute value = 2
     *     Put a minus sign to a[2] => [2, 3, -3, 1]
     *   Index 1:
     *     Absolute value = 3
     *     Put a minus sign to a[3] => [2, 3, -3, -1]
     *   Index 2:
     *     Absolute value = 3
     *     As a[3] is already negative, it means 3 is a duplicate
     *
     * */
    private static void printRepeating(int[] arr) {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < arr.length; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0)
                arr[j] = -arr[j];
            else
                System.out.print(j + " ");
        }
    }

}
