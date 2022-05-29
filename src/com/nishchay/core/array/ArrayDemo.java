package com.nishchay.core.array;

import java.util.Arrays;

public class ArrayDemo {

    public static void main(String[] args) {


		arrayEx();
        arrayCopyDemo();
        compareArrayEx();

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

        String copyStatus =  intArr==copyArray? "same copy" : "diff copy";
        System.out.println("two new array is having  = " + copyStatus);

        System.out.println("intArr[] = " + Arrays.toString(intArr));
        System.out.println("copyArray[] = " + Arrays.toString(copyArray));

        copyArray = Arrays.copyOf(intArr, intArr.length);
        System.out.println("identical copy - " + Arrays.equals(intArr, copyArray));
    }

    private static void compareArrayEx() {

        primitiveArrCompare();
        objectArrCompare();

    }

    private static void primitiveArrCompare() {

        int[] intArray1 = new int[] { 1, 2, 3, 4, 5 };
        int[] intArray2 = new int[] { 1, 2, 3, 4, 5 };

        // Comparing arrays with Arrays.equals() method
        boolean isSame = Arrays.equals(intArray1, intArray2);
        System.out.println("\nArray comparison with Arrays.equals(intArray1, intArray2)");
        if (isSame) {
            System.out.println("int array 1 and array 2 are same");
        } else {
            System.out.println("int array 1 and array 2 are not same");
        }
    }

    private static void objectArrCompare() {

        String[] stringArr1 = {"Rohit", "Shikhar", "Kohli", "Iyyar", "Dhoni"};
        String[] stringArr2 = {"Rohit", "Shikhar", "Kohli", "Iyyar", "Dhoni"};

        // Comparing arrays with Arrays.equals() method
        boolean isSame = Arrays.equals(stringArr1, stringArr2);
        System.out.println("\nArray comparison with Arrays.equals(intArray1, intArray2)");
        if (isSame) {
            System.out.println("String array 1 and array 2 are same");
        } else {
            System.out.println("String array 1 and array 2 are not same");
        }

    }



}
