package com.nishchay.ds.array.basic;

import java.util.Arrays;

public class IntArrayReverse {

    public static void main(String[] args) {

        arrayReversePrint();

        intArrayReverse();

    }



    private static void arrayReversePrint() {

        int[] intArr = {10, 20, 30, 40, 50};

        System.out.println("----------Actual Array-----------");
        for (int value : intArr) {
            System.out.println(value);
        }

        System.out.println("----------Printing Array in reverse order-----------");
        for (int i = intArr.length - 1; i >= 0; i--) {
            System.out.println(intArr[i]);
        }
    }

    private static void intArrayReverse() {

        int[] intArr = {10, 20, 30, 40, 50, 60};

        System.out.println("Actual Array : " + Arrays.toString(intArr));
        ArrayUtils.reverseArray(intArr);
        System.out.println("Reversed Array : " + Arrays.toString(intArr));
    }

}
