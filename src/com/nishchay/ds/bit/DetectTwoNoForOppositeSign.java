package com.nishchay.ds.bit;


/*
 *	Detect if two integers have opposite signs
 *
 *	Given two signed integers, write a function that returns true if the signs of given integers are different, otherwise false.
 *  The function should not use any of the arithmetic operators.
 *
 *	Examples :
 *
 *		Input : n1 = -1 & n2 = +100
 *		Output : true
 *
 *		Input : n1 = -100 & n2 = -200
 *		Output : false
 *
 *		Input : n1 = +5 & n2 = +10
 *		Output : false
 *
 * https://www.geeksforgeeks.org/detect-if-two-integers-have-opposite-signs/
 */
public class DetectTwoNoForOppositeSign {


    public static void main(String[] args) {

        System.out.println("oppositeSigns(-1, 100) - " + oppositeSigns(-1, 100));
        System.out.println("oppositeSigns(-100, -200) - " + oppositeSigns(-100, -200));
        System.out.println("oppositeSigns(5, 10) - " + oppositeSigns(5, 10));

    }

    /*
     * The sign bit is 1 in negative numbers, and 0 in positive numbers.
     * The XOR of x and y will have the sign bit as 1 iff they have opposite sign.
     * In other words, XOR of x and y will be negative number number iff x and y have opposite signs.
     * */
    private static boolean oppositeSigns(int x, int y) {
        return ((x ^ y) < 0);
    }

}
