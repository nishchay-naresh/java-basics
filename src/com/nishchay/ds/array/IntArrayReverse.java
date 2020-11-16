package com.nishchay.ds.array;

import java.util.Arrays;
import java.util.Scanner;

public class IntArrayReverse {

    public static void main(String[] args) {


//        int arr[] = readArrayFromConsole();

//        arrayReversePrint();

        intArrayReverse();

    }


    private static int[] readArrayFromConsole() {

        Scanner s = new Scanner(System.in);

        // read the array size
        int length = s.nextInt();
        int[] intArr = new int[length];

        // read array element
        for (int i = 0; i < length; i++) {
            intArr[i] = s.nextInt();
        }
        return intArr;
    }

    private static void arrayReversePrint() {

        int intArr[] = {10, 20, 30, 40, 50};

        System.out.println("----------Actual Array-----------");
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }

        System.out.println("----------Printing Array in reverse order-----------");
        for (int i = intArr.length - 1; i >= 0; i--) {
            System.out.println(intArr[i]);
        }
    }

    private static void intArrayReverse() {

        int intArr[] = {10, 20, 30, 40, 50, 60};
        System.out.println("Actual Array : " + Arrays.toString(intArr));

        int i, j, t;
        i = 0;
        j = intArr.length - 1;
        while (i < j) {
            // swap ith & jth element
            t = intArr[i];
            intArr[i] = intArr[j];
            intArr[j] = t;
            i++;
            j--;
        }

        System.out.println("Reversed Array : " + Arrays.toString(intArr));
    }

}
