package com.nishchay.ds.array.nelement;


/*
 *  ================= Find the only repetitive element between 1 to n-1 ================
 *
 *  We are given an array arr[] of size n. Numbers are from 1 to (n-1) in random order.
 *  The array has only one repetitive element. We need to find the repetitive element.
 *
 *	Examples:
 *      	Input  : a[] = {1, 3, 2, 3, 4}
 *	        Output : 3
 *
 *	        Input  : a[] = {1, 5, 1, 2, 3, 4}
 *	        Output : 1
 *
 * This problem can be seen as 1-N numbers are there in array + one duplicate is there
 * bcus of this duplicate size of array N + 1;
 *
 *      	Input  : a[] = {1, 3, 2, 3, 4} = { 1, 2, 3, 4 } + { 2 }
 *	        Output : 3
 *
 * Solutions : this 1-N can be computed, for sum or XOR
 *
 *
 *
 * https://www.geeksforgeeks.org/find-repetitive-element-1-n-1/
 * */

class FindOnlyRepetitiveElementIn1_N {

    public static void main(String[] args) {

        int[] arr;

        arr = new int[]{1, 2, 3, 2, 4}; // n-5, dup-2, missing-5
        System.out.println(findOnlyRepeatingElement_xor(arr)); // 2

        arr = new int[]{9, 8, 2, 6, 1, 8, 5, 3, 4, 7}; // n-10, dup-8, missing-10
        System.out.println(findOnlyRepeatingElement_xor(arr)); // 8

        arr = new int[]{1, 2, 3, 1, 5, 4}; // n-6, dup-1, missing-6
        System.out.println(findOnlyRepeatingElement_xor(arr)); // 1

//        arr = new int[]{1, 4, 3, 3, 2, 6}; // n-6, dup-3, missing-5
//        System.out.println(findOnlyRepeatingElement_sum(arr));

        System.out.println("---------------------------------------");

        arr = new int[]{1, 2, 3, 2, 4}; // n-5, dup-2, missing-5
        System.out.println(findOnlyRepeatingElement_sum(arr)); // 2

        arr = new int[]{9, 8, 2, 6, 1, 8, 5, 3, 4, 7}; // n-10, dup-8, missing-10
        System.out.println(findOnlyRepeatingElement_sum(arr)); // 8

        arr = new int[]{1, 2, 3, 1, 5, 4}; // n-6, dup-1, missing-6
        System.out.println(findOnlyRepeatingElement_sum(arr)); // 1

    }

    /*
     * Method 1 - bit wise XOR operator
     * Logic : (XOR of first n-1 natural numbers)   XOR     (XOR of all element in arr)
     *          1 ^ 2 ^ 3 .. ^ (n-1)    ^       arr[0] ^ arr[1] ^ .... arr[n-1] -  ans
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     *	Example:
     *	N=5
     *	arr[5]={1,2,3,2,4}
     *	XOR PROPERTY : 2 XOR 2 =0 i.e XOR of same no. is 0.
     *	now what is happening in algo 2?
     *	XOR of 1st N-1 natural no. X1=1^2^3^4
     *  N-1, bcus N no are there in array, +1 is the no which is repeated
     *	XOR of array elements X2=1^2^3^2^4
     *	X1 XOR X2 = 1^2^3^4^1^2^3^2^4= 1^1^2^2^2^3^3^4^4=2
     *
     * */
    private static int findOnlyRepeatingElement_xor(int[] arr) {

        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++)
            res = res ^ (i + 1) ^ arr[i];
        res = res ^ arr[n - 1];

        return res;
    }

    /*
     * Method 2 - sum of first n natural numbers
     *
     * Logic :
     *          sumOfN = (n * (n + 1)) / 2;
     *          sumOfNPlusDup = sum of all element in arr
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static int findOnlyRepeatingElement_sum(int[] arr) {

        int n = arr.length - 1;
        int sumOfN = (n * (n + 1)) / 2;

        int sumOfNPlusDup = 0;
        for (int curr : arr)
            sumOfNPlusDup += curr;

        return (sumOfNPlusDup - sumOfN);
    }

}