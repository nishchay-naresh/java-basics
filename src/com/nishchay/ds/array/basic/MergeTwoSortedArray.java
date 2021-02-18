package com.nishchay.ds.array.basic;

import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {


        int[] arr1 = {46, 47, 86, 89, 92, 95, 101, 111};
        int[] arr2 = {15, 30, 42, 55, 63};

        System.out.println("arr1 - " + Arrays.toString(arr1));
        System.out.println("arr2 - " + Arrays.toString(arr2));

        int[] arr3 = mergeArray(arr1, arr2);
        System.out.println("arr3 - " + Arrays.toString(arr3));
    }

    /*
     * Merging of two sorted array to third one in sorted order
     */
    public static int[] mergeArray(int[] arr1, int[] arr2) {

        int i, j, k;
        final int n1 = arr1.length;
        final int n2 = arr2.length;
        int[] r = new int[n1 + n2];

        i = j = k = 0;
        while (i < n1 && j < n2) {

            if (arr1[i] < arr2[j]) {
                r[k] = arr1[i];
                i++;
            } else {
                r[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            r[k] = arr1[i];
            k++;
            i++;

        }

        while (j < n2) {
            r[k] = arr2[j];
            k++;
            j++;

        }
        return r;
    }

}
