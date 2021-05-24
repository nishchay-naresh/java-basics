package com.nishchay.ds.array.sort;

import java.util.Arrays;

/*
 * Given an array a[] consisting of 0s, 1s, and 2s.
 * Write a program to sort the array of 0’s, 1’s, and 2’s in ascending order.
 *
 * */
public class SortArrayOfPN {

    public static void main(String[] args) {

        int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int len = arr.length;
        System.out.println("len = " + len);
        System.out.println("Original array = " + Arrays.toString(arr));

//        sort012_count(arr);
//        sort012_count_1(arr);
        sort012_partition(arr);
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

    /*
     *	Complexity Analysis:
     *	Time Complexity: O(n).
     *	Only two traversals of the array is needed.
     *	Space Complexity: O(1).
     *	As no extra space is required.
     * */
    private static void sort012_count_1(int[] nums) {

        // count number of zeros, ones and twos
        int[] freq = countFreq(nums); // first pass

        // overwrite the array
        int lastFilledIndex = 0;

        // second pass
        for (int i = 0; i < 3; i++)  // fill 0, 1, 2
            lastFilledIndex = fill(nums, i, lastFilledIndex, freq[i]);
    }

    private static int[] countFreq(int[] nums) {
        int[] freq = new int[3];
        for (int x : nums) {
            if (x == 0) freq[0]++;
            else if (x == 1) freq[1]++;
            else freq[2]++;
        }
        return freq;
    }

    // return last filled index
    private static int fill(int[] nums, int e, int index, int freq) {
        int i = index;
        while (i < index + freq) {
            nums[i] = e;
            i++;
        }
        return i;
    }
    /*
     *  Here keeping 3 pointers (hi, low & mid), initializing them as
     *  lo = mid = 0,   high = n - 1
     *  mid is the traversing pointer
     *  if mid == 0,  swap(lo, mid); lo++; mid++;
     *  if mid == 1,  do nothing simply mid++;;
     *  if mid == 2,   swap(mid, high); high--;
     *  Only one traversals of the array is needed.
     * */
    private static void sort012_partition(int[] nums) {

        int lo, high, mid;
        lo = mid = 0;
        high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, lo, mid);
                lo++; mid++;
            }else if (nums[mid] == 1) {
                mid++;
            }else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
