package com.nishchay.ds.array.basic;

import java.util.Arrays;

/*
 *======================= Find Pair With Min Diff ============================
 *
 *
 *  Given an unsorted array, find the minimum difference between any pair in given array.
 *
 * 	Example - 1
 * 		Input  : {1, 5, 3, 19, 18, 25};
 * 		Output : 1
 * 		Minimum difference is between 18 and 19
 *
 * 	Example - 2
 * 		Input  : {30, 5, 20, 9};
 * 		Output : 4
 * 		Minimum difference is between 5 and 9
 *
 * 	Example - 3
 * 		Input  : {1, 19, -4, 31, 38, 25, 100};
 * 		Output : 5
 * 		Minimum difference is between 1 and -4
 *
 * https://www.geeksforgeeks.org/find-minimum-difference-pair/
 *
 * Another approach could be, store them in hashMap<No,Index> - sort this entry based on no, then take first 2 entry
 * */
public class FindPairMinDiff {

    public static void main(String[] args) {

        int arr[] = new int[]{1, 5, 3, 19, 18, 25};
        System.out.println("Minimum difference is "+ findMinDiff(arr, arr.length));




    }

    private static void findMinDiffSort(int[] arr, int n){

        int[] a = new int[] {4, 9, 1, 32, 13};
        Arrays.sort(a);
        int minDiff = a[1]-a[0];
        for (int i = 2 ; i != a.length ; i++) {
            minDiff = Math.min(minDiff, a[i]-a[i-1]);
        }
        System.out.println(minDiff);
    }

    private static int findMinDiff(int[] arr, int n)
    {
        // Initialize difference as infinite
        int diff = Integer.MAX_VALUE;

        // Find the min diff by comparing difference
        // of all possible pairs in given array
        for (int i=0; i<n-1; i++)
            for (int j=i+1; j<n; j++)
                if (Math.abs((arr[i] - arr[j]) )< diff)
                    diff = Math.abs((arr[i] - arr[j]));

        // Return min diff
        return diff;
    }


    private static void findSmallestDiffPairEx() {
        int[] arr;

        arr = new int[]{8, 2, 14, 6, 3, 7, 1};
        System.out.println("Pair with min diff : " + findSmallestDiffPair(arr)); // -1

        arr = new int[]{12, 34, 10, 6, 40};
        System.out.println("Pair with min diff : " + findSmallestDiffPair(arr)); // -4

        arr = new int[]{-2, 3};
        System.out.println("Pair with min diff : " + findSmallestDiffPair(arr)); // -5

        arr = new int[]{-2};
        System.out.println("Pair with min diff : " + findSmallestDiffPair(arr)); // -2
    }


    private static int findSmallestDiffPair(int[] arr) {

        int length = arr.length;

        if(length == 1){
            return arr[0];
        }else if(length == 2){
            return (arr[0] - arr[1]);
        }

        int smallest, secondSmallest;
        if (arr[0] < arr[1]) {
            smallest = arr[0];
            secondSmallest = arr[1];
        } else {
            smallest = arr[1];
            secondSmallest = arr[0];
        }

        for (int i = 2; i < length; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            }else if (arr[i] < secondSmallest && arr[i] != smallest){
                secondSmallest = arr[i];
            }
        }
        return (smallest - secondSmallest);
    }


}
