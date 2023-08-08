package com.nishchay.test.blueyonder;

import java.util.ArrayList;
import java.util.List;

/*
 *	Given an unsorted array, find all elements in output which are greater than all other elements to its right side
 *		input : {1, 20, 17, 5,13, 8, 16, 0}
 *		output : {20, 17, 16, 0}
 *
 *	Hint - traverse array from right to left, keep finding the max
 *	        each max is our result
 *	        edge case, arr[n-1] is the max , so its one result
 *
 * */
public class GreaterElementFromRightSide {
    public static void main(String[] args) {

        int[] intArr = new int[]{1, 20, 17, 5, 13, 8, 16, 0};
        List<Integer> res = getGreaterElements(intArr);
        System.out.println("res = " + res); // res = [0, 16, 17, 20]
    }

    private static List<Integer> getGreaterElements(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int length = arr.length;
        int max = arr[length - 1];
        list.add(max);

        for (int i = length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                list.add(arr[i]);
                max = arr[i];
            }
        }
        return list;
    }
    /*
     * Time complexity - O(n)
     * Space complexity - O(1)
     * */
}
