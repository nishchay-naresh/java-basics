package com.nishchay.ds.dp;

/*
 *	Finding sum of digits of a number until sum becomes single digit
 *
 *	Given a number n, we need to find the sum of its digits such that:
 *
 *		If n < 10
 *			digSum(n) = n
 *		Else
 *			digSum(n) = Sum(digSum(n))
 *	Examples :
 *
 *		Input : 1234
 *		Output : 1
 *		Explanation : The sum of 1+2+3+4 = 10,
 *					  digSum(x) == 10
 *					  Hence ans will be 1+0 = 1
 *
 *		Input : 5674
 *		Output : 4
 *
 * https://www.geeksforgeeks.org/finding-sum-of-digits-of-a-number-until-sum-becomes-single-digit/
 * */
public class FindingSumTillSingleDigit {

    public static void main(String[] args) {

        int n = 1234;
        System.out.println(digSumBasic(n));//1
        System.out.println(digSum(n));

        n = 9999;
        System.out.println(digSumBasic(n));//9
        System.out.println(digSum(n));

    }

    /*
     * brute force approach
     * time - O(l) l - no of digits in no
     * */
    private static int digSumBasic(int n) {

        int sum = 0;

        while (n > 0 || sum > 9) {
            // when done with the no, now need to process sum
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /*
     *  simple and elegant O(1) solution
     * time - O(1)
     * How does the above logic works?
     *
     *	If a number n is divisible by 9, then the sum of its digit until sum becomes single digit is always 9
     *	Let, n = 2880, Sum of digits = 2 + 8 + 8 = 18, 18 = 1 + 8 = 9
     *	A number can be of the form 9x or 9x + k. For the first case, answer is always 9.
     *	For the second case, and is always k.
     *
     *		If n == 0
     *		   return 0;
     *
     *		If n % 9 == 0
     *		    digSum(n) = 9
     *		Else
     *		    digSum(n) = n % 9
     * */
    private static int digSum(int n) {
        if (n == 0)
            return 0;
        if (n % 9 == 0)
            return 9;
        else
            return n % 9;
    }

}
