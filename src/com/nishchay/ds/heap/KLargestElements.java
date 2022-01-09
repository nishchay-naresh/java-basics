package com.nishchay.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 *============== k largest(or smallest) elements in an unsorted array ====================
 *
 *
 *  Write an efficient program for printing k largest elements in an array. Elements in an array can be in any order.
 *
 *	Example 1
 *		Input: arr[] = {1, 23, 12, 9, 30, 2, 50}
 *		k = 4
 *		Output: {50, 30, 23, 12}
 *
 *	Example 2
 *		Input: arr[] = {7, 10, 4, 3, 20, 15}
 *		k = 3
 *		Output: {20, 15, 10}
 *
 *
 * https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 * */
public class KLargestElements {


    public static void main(String[] args){

        int[] arr, res;
        int k;

        arr = new int[] {1, 23, 12, 9, 30, 2, 50};
        k = 4;
        res = kLargestElements(arr, k);
        System.out.println("K largest elements " + Arrays.toString(res)); // 5

        arr = new int[] { 7, 10, 4, 3, 20, 15 };
        k = 3;
        res = kLargestElements(arr, k);
        System.out.println("K largest elements " + Arrays.toString(res)); // 5

    }

    /*
     * Time complexity - O(n logk)
     * Space complexity - O(k)
     * */
    private static int[] kLargestElements(int[] arr, int k) {

        int[] res = new int[k];

        // minHeap, bcus need largest element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int e : arr){
            minHeap.offer(e);
            if(minHeap.size() > k ){
                minHeap.poll();
            }
        }

        for (int i = k-1; i >= 0; i--)
            res[i] = minHeap.poll();

        return res;
    }

}
