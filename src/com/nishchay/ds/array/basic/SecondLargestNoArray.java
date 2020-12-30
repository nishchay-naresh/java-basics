package com.nishchay.ds.array.basic;

/*
 * Find Second largest element in an array
 *	Input: arr[] = {12, 35, 1, 10, 34, 1}
 *	Output: The second largest element is 34.
 *
 *	Input: arr[] = {10, 5, 10}
 *	Output: The second largest element is 5.
 *
 *	Input: arr[] = {10, 10, 10}
 *	Output: The second largest does not exist.
 *
 * */
public class SecondLargestNoArray {

    public static void main(String[] args) {

//        int[] arr = {12, 35, 1, 10, 34, 1};
        int[] arr = {10, 10, 10};
        print2largest(arr);

    }

    public static void print2largest(int[] arr) {

        int length = arr.length;
        int first, second;

        /* There should be atleast two elements */
        if (length < 2) {
            System.out.print(" Invalid Input ");
            return;
        }

        first = second = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            // if current element is smaller than first then update both first and second
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            }
             // if arr[i] is in between first and  second then update second
            else if (arr[i] > second && arr[i] != first)
                second = arr[i];
        }

        if (second == Integer.MIN_VALUE)
            System.out.print("There is no second largest"
                    + " element\n");
        else
            System.out.print("The second largest element"
                    + " is " + second);
    }
}
