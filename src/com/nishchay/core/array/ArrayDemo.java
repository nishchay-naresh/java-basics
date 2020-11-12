package com.nishchay.core.array;

import java.util.Arrays;

public class ArrayDemo {

    public static void main(String[] args) {


		arrayEx();
        arrayCopyDemo();

    }

    public static void arrayEx() {
        int[] intArray = new int[5];

        intArray[0] = 8;
        intArray[1] = -5;
        intArray[2] = 13;
        intArray[3] = 2;
        intArray[4] = 3;

        for (int x : intArray) {
            System.out.println(x);
        }
    }


    public static void arrayCopyDemo() {
        int[] intArr = new int[]{5, 10, 15, 20, 25, 30};
        int[] copyArray = Arrays.copyOf(intArr, 4);

        System.out.println("intArr = " + intArr);
        System.out.println("copyArray = " + copyArray);

        System.out.println("intArr[] = " + Arrays.toString(intArr));
        System.out.println("copyArray[] = " + Arrays.toString(copyArray));
    }

}
