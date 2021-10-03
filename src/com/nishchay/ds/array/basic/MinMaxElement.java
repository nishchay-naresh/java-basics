package com.nishchay.ds.array.basic;

/*
 * Find Smallest and Largest Number in Unsorted Array – O(n) Time
 *
 * */
public class MinMaxElement {

    public static void main(String[] args) {

        int[] intArray = {2, 4, 7, 6, 5, 1, 3, 10};
        minMaxPrint(intArray);

        System.out.println("---------------------------------");

        intArray = new int[]{3, 13, 14, 7, 6, 15, 9, 21, 10};
        minMaxPrint(intArray);

    }

    private static void minMaxPrint(int[] intArray) {

        int min, max;
        //initialize max and min with 0th element intArray[0]
        min = max = intArray[0];

        for (int i = 1; i < intArray.length; i++) {
            //if the current element is greater than the max, then set max to current element
            if (intArray[i] > max) {
                max = intArray[i];
            }
            //if the current element is lesser than the min, then set min to current element
            if (intArray[i] < min) {
                min = intArray[i];
            }
        }

        System.out.println("smallest element : " + min);
        System.out.println("largest element : " + max);
    }

}
