package com.nishchay.ds.array.sort;

import java.util.Arrays;

/*
 * TODO - https://medium.com/enjoy-algorithm/quicksort-one-the-fastest-sorting-algorithms-2685fb0910c5
 * https://medium.com/enjoy-algorithm/merge-sort-algorithm-1a32258d81f5
 * */
public class MergeSort {

    // Driver code
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original Array - " + Arrays.toString(arr));

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("Sorted array - " + Arrays.toString(arr));
    }

    /*
     *	void mergeSort(int A[], int l, int r){
     *	    if(l >= r)
     *	        return
     *
     *	    int mid = (l + r) /2
     *      // Sort first and second halves
     *	    mergeSort(A, l, mid)
     *	    mergeSort(A, mid + 1, r)
     *	    // Merge the sorted halves
     *      merge(A, l, mid, r)
     *	}
     *
     * */
    public void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}
