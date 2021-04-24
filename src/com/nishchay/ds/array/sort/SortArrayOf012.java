package com.nishchay.ds.array.sort;

import java.util.Arrays;

/*
 * Given an array a[] consisting of 0s, 1s, and 2s.
 * Write a program to sort the array of 0’s, 1’s, and 2’s in ascending order.
 *
 * */
public class SortArrayOf012 {

    public static void main(String[] args) {

//        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int len = arr.length;
        System.out.println("len = " + len);
        System.out.println("Original array = " + Arrays.toString(arr));

        sort012_count(arr);
//        sort012_count_1(arr);
//        sort012_partition(arr);
        System.out.println("  Sorted array = " + Arrays.toString(arr));
    }

    private static void sort012_count(int[] nums) {
        int count0, count1, count2;
        count0 = count1 = count2 = 0;
        for (int e : nums) {
            if (e == 0) count0++;
            if (e == 1) count1++;
            if (e == 2) count2++;
        }

        int k = 0;
        while (count0 > 0) {
            nums[k] = 0;
            k++;
            count0--;
        }
        while (count1 > 0) {
            nums[k] = 1;
            k++;
            count1--;
        }
        while (count2 > 0) {
            nums[k] = 2;
            k++;
            count2--;
        }
    }



}
