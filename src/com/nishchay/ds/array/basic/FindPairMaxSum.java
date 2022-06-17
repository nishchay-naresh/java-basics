package com.nishchay.ds.array.basic;


/*
 * ======================= Pair With Max Sum ============================
 *
 *  Given an un-sorted of distinct integers, find the largest pair sum in it.
 *  For example, the largest pair sum in {12, 34, 10, 6, 40} is 74.
 *
 * This is the use-case -> for the problem find largest & secondLargest element in an array
 *
 *
 *	Input: arr[] = {8, 2, 14, 6, 3, 7, 1}
 *	Output: 22
 *	Explanation: pair = 14, 8
 *
 *	Input: arr[] = {12, 34, 10, 6, 40}
 *	Output: 74
 *	Explanation: pair = 40, 34
 *
 *	Input: arr[] = {-2, 3}
 *	Output: 1
 *	Explanation: pair = 3,-2
 *
 *	Input: arr[] = {-2}
 *	Output: -2
 *	Explanation: pair = -2
 *
 * https://www.geeksforgeeks.org/find-the-largest-pair-sum-in-an-unsorted-array/
 *
 * */

public class FindPairMaxSum {

    public static void main(String[] args) {

        findLargestSumPairEx();

    }


    private static void findLargestSumPairEx() {
        int[] arr;

        arr = new int[]{8, 2, 14, 6, 3, 7, 1};
        System.out.println("Pair with max sum : " + findLargestSumPair(arr)); // 22

        arr = new int[]{12, 34, 10, 6, 40};
        System.out.println("Pair with max sum : " + findLargestSumPair(arr)); // 74

        arr = new int[]{-2, 3};
        System.out.println("Pair with max sum : " + findLargestSumPair(arr)); // 1

        arr = new int[]{-2};
        System.out.println("Pair with max sum : " + findLargestSumPair(arr)); // -2
    }


    private static int findLargestSumPair(int[] arr) {

        int length = arr.length;
        if(length == 1){
            return arr[0];
        }else if(length == 2){
            return (arr[0] + arr[1]);
        }

        int largest, secondLargest;
        if (arr[0] > arr[1]) {
            largest = arr[0];
            secondLargest = arr[1];
        } else {
            largest = arr[1];
            secondLargest = arr[0];
        }

        for (int i = 2; i < length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }else if (arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        return (largest + secondLargest);
    }

}
