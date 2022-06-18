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

        findMinDiffEx();
        System.out.println("------------------------");
        findMinDiffSortEx();

    }

    private static void findMinDiffEx() {

        int[] arr;

        arr = new int[]{1, 5, 3, 19, 18, 25};
        System.out.println("Pair with min diff : " + findMinDiff(arr)); // 1

        arr = new int[]{8, 2, 14, 6, 3, 7, 1};
        System.out.println("Pair with min diff : " + findMinDiff(arr)); // 1

        arr = new int[]{-2, 3};
        System.out.println("Pair with min diff : " + findMinDiff(arr)); // -5

        arr = new int[]{-2};
        System.out.println("Pair with min diff : " + findMinDiff(arr)); // -2
    }

    /*
    * ============= bruteforce approach - 2 nested loop =====================
    * A simple solution is to use two nexted loops.
    * time complexity - O(n2)
     * */
    private static int findMinDiff(int[] arr){
        int n = arr.length;
        if(n == 1){
            return arr[0];
        }else if(n == 2){
            return (arr[0] - arr[1]);
        }
        int diff = Integer.MAX_VALUE;

        // Diff by comparing difference of all possible pairs in given array
        for (int i=0; i<n-1; i++)
            for (int j=i+1; j<n; j++)
                if (Math.abs((arr[i] - arr[j]) )< diff)
                    diff = Math.abs((arr[i] - arr[j]));

        return diff;
    }

    private static void findMinDiffSortEx() {
        int[] arr;

        arr = new int[]{1, 5, 3, 19, 18, 25};
        System.out.println("Pair with min diff : " + findMinDiffSort(arr)); // 1

        arr = new int[]{8, 2, 14, 6, 3, 7, 1};
        System.out.println("Pair with min diff : " + findMinDiffSort(arr)); // -1

        arr = new int[]{-2, 3};
        System.out.println("Pair with min diff : " + findMinDiffSort(arr)); // -5

        arr = new int[]{-2};
        System.out.println("Pair with min diff : " + findMinDiffSort(arr)); // -2
    }

    /*
     * ============= sorting approach - =====================
     * A simple solution is to use two nexted loops.
     * time complexity - O(n2)
     * */
    private static int findMinDiffSort(int[] arr){
        int n = arr.length;
        if(n == 1){
            return arr[0];
        }else if(n == 2){
            return (arr[0] - arr[1]);
        }

        Arrays.sort(arr);
        int minDiff = arr[1]-arr[0];
        for (int i = 2 ; i != arr.length ; i++) {
            minDiff = Math.min(minDiff, arr[i]-arr[i-1]);
        }
        return minDiff;
    }


}
