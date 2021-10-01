package com.nishchay.ds.array.search.Nno;

import java.util.Arrays;

/*
 *
 * Given an unsorted array of size n. Array elements are in the range from 1 to n.
 * One number from set {1, 2, …n} is missing and one number occurs twice in the array.
 * Find these two numbers.
 *
 *	Input: arr[] = {3, 1, 3}
 *	Output: Missing = 2, Repeating = 3
 *
 *	Input: arr[] = {4, 3, 6, 2, 1, 1}
 *	Output: Missing = 5, Repeating = 1
 *
 * */
class FindRepeatingMissingElementIn1_N {

    public static void main(String[] args) {
        int[] arr = {7, 3, 4, 5, 5, 6, 2};
        System.out.println("arr - " + Arrays.toString(arr));
        findRepeatingMissing(arr);
    }

    private static void findRepeatingMissing(int[] arr) {
        int size = arr.length;
        int[] tempArray = Arrays.copyOf(arr, size);

        System.out.print("Repeating - ");

        for (int i = 0; i < size; i++) {
            int absCurrVal = Math.abs(tempArray[i]);
            if (tempArray[absCurrVal - 1] > 0)
                tempArray[absCurrVal - 1] = -tempArray[absCurrVal - 1];
            else
                System.out.print(absCurrVal);
        }


        System.out.print("\t Missing - ");
        for (int i = 0; i < size; i++) {
            if (tempArray[i] > 0)
                System.out.print(i + 1);
        }

    }


}