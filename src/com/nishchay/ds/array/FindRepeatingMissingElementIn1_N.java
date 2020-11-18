package com.nishchay.ds.array;

import java.util.Arrays;

class FindRepeatingMissingElementIn1_N {

    public static void main(String[] args) {
        int[] arr = {7, 3, 4, 5, 5, 6, 2};
        int n = arr.length;
        printTwoElements(arr, n);
    }

    static void printTwoElements(int[] arr, int size) {
        int i;
        System.out.print("The repeating element is - ");

        for (i = 0; i < size; i++) {
            int absCurrVal = Math.abs(arr[i]);
            if (arr[absCurrVal - 1] > 0)
                arr[absCurrVal - 1] = -arr[absCurrVal - 1];
            else
                System.out.println(absCurrVal);
        }
        System.out.println(Arrays.toString(arr));

        System.out.print("And the missing element is - ");
        for (i = 0; i < size; i++) {
            if (arr[i] > 0)
                System.out.println(i + 1);
        }

    }


}