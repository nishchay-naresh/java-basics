package com.nishchay.ds.array.search.Nno;


/*
 *  Find the only repetitive element between 1 to n-1
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

class FindOnlyRepetitiveElementIn1_N {

    // Driver code
    public static void main(String[] args) {
        int[] arr = {9, 8, 2, 6, 1, 8, 5, 3, 4, 7};
        int n = arr.length;
        System.out.println(findRepeatingElement(arr, n));
    }

    static int findRepeatingElement(int[] arr, int n) {

        // res is going to store value of 
        // 1 ^ 2 ^ 3 .. ^ (n-1) ^
        // arr[0] ^ arr[1] ^ .... arr[n-1]
        int res = 0;
        for (int i = 0; i < n - 1; i++)
            res = res ^ (i + 1) ^ arr[i];
        res = res ^ arr[n - 1];

        return res;
    }


} 