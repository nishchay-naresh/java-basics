package com.nishchay.ds.array;

import java.util.Arrays;

/*
 * Rearrange Positive and Negative Values of Given Array
 * [-1,2,8,-5,1,-4] => [-1,-5,-4,2,8,1]
 *
 * */
class RearrangeArrayElements {

    public static void main(String args[]) {

        int[] intArr = {2, 4, -6, 8, -5, -10};

        System.out.print("Array before re-arranging : ");
        System.out.println("intArr - " + Arrays.toString(intArr));

        reArrange(intArr);

        System.out.print("Array after rearranging :   ");
        System.out.println("intArr - " + Arrays.toString(intArr));
    }


    public static void reArrange(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {   // if negative number found
                if (i != j) {   // swapping with leftmost positive
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    } //end of reArrange()

}