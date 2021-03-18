package com.nishchay.ds.number;


/*
*   A positive number is called armstrong number
*   if it is equal to the sum of cubes of its digits for example 0, 1, 153, 370, 371, 407 etc.
*
* */
public class ArmstrongNumber {

    public static void main(String[] args) {

        System.out.println("isArmStrong(1) - " +  isArmStrong(1));
        System.out.println("isArmStrong(153) - " +  isArmStrong(153));
        System.out.println("isArmStrong(370) - " +  isArmStrong(370));
        System.out.println("isArmStrong(371) - " +  isArmStrong(371));
        System.out.println("isArmStrong(407) - " +  isArmStrong(407));
        System.out.println("isArmStrong(512) - " +  isArmStrong(512));

    }

    private static boolean isArmStrong(int number) {
        int result = 0;
        int orig = number;
        while (number != 0) {
            int remainder = number % 10;
            result = result + remainder * remainder * remainder;
            number = number / 10;
        }
        return orig == result;
    }

}
