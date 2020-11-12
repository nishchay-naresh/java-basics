package com.nishchay.ds.array;

import java.util.Scanner;

public class ArrRerverse {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // read the array size
        int length = s.nextInt();
        int[] intArr = new int[length];

        // read array element
        for (int i = 0; i < length; i++) {
            intArr[i] = s.nextInt();
        }

        System.out.println("----------Actual Array-----------");
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }


        System.out.println("----------Printing Array in reverse order-----------");
        for (int i = intArr.length - 1; i >= 0; i--) {
            System.out.println(intArr[i]);
        }
    }
}
