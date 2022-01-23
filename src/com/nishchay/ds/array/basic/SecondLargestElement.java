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
public class SecondLargestElement {

    public static void main(String[] args) {

        int[] arr;

        arr = new int[]{12, 35, 1, 10, 34, 1};
        System.out.println("Second largest element = " + get2ndLargest(arr));

        arr = new int[]{10, 5, 10};
        System.out.println("Second largest element = " + get2ndLargest(arr));

        arr = new int[]{10, 10, 10};
        System.out.println("Second largest element = " + get2ndLargest(arr));

    }

    private static int get2ndLargest(int[] arr) {

        int length = arr.length;
        int first, second;

        if (length < 2) {
            System.out.println("Invalid Input ");
            return -1;
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

        if (second == Integer.MIN_VALUE){
            System.out.println("There is no second largest element");
            return -1;
        }

        return second;
    }
}
