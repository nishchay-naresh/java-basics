package com.nishchay.ds.number;

/*
 *==============1342. Number of Steps to Reduce a Number to Zero====================
 *
 * Given an integer num, return the number of steps to reduce it to zero.
 * step - if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 *
 *	Example 1:
 *
 *		Input: num = 14
 *		Output: 6
 *		Explanation:
 *		Step 1) 14 is even; divide by 2 and obtain 7.
 *		Step 2) 7 is odd; subtract 1 and obtain 6.
 *		Step 3) 6 is even; divide by 2 and obtain 3.
 *		Step 4) 3 is odd; subtract 1 and obtain 2.
 *		Step 5) 2 is even; divide by 2 and obtain 1.
 *		Step 6) 1 is odd; subtract 1 and obtain 0.
 *
 *	Example 3:
 *
 *		Input: num = 8
 *		Output: 4
 *
 *	Example 3:
 *
 *		Input: num = 123
 *		Output: 12
 *
 * https://leetcode.com/problems/shuffle-string/
 *
 * */
public class ReduceNumberToZero {

    public static void main(String[] args) {

        System.out.println("steps - " + numberOfSteps(14)); // 6
        System.out.println("steps - " + numberOfSteps(8)); // 4
        System.out.println("steps - " + numberOfSteps(123)); // 12
    }

    private static int numberOfSteps(int num) {
        int i = 0;
        for (; num > 0; i++) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num--;
            }
        }
        return i;
    }

}
