package com.nishchay.ds.array.Nno;

/*
 *   You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in the list.
 *  One of the integers is missing in the list. Write an efficient code to find the missing integer.
 *
 *	Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
 *	Output: 5
 *	Explanation: The missing number from 1 to 8 is 5
 *
 *	Input: arr[] = {1, 2, 3, 5}
 *	Output: 4
 *	Explanation: The missing number from 1 to 5 is 4
 * */
class FindMissingNumberIn1_N {

    /* program to test above function */
    public static void main(String[] args) {

        int[] nums = {8, 2, 4, 6, 3, 7, 1};
        System.out.println(getMissingNoSum(nums));

        int[] arr =  { 10, 5, 9, 4, 2, 7, 8, 3, 1 };
        System.out.println(getMissingNoXOR(arr));


    }

    /*
    * Function to find missing number -  by first having the sum of First N Numbers
    * Time Complexity: O(n)
    * Space Complexity: O(1)
    * */
    private static int getMissingNoSum(int[] nums) {
        int n = nums.length;
        int sum; // sum of First N Numbers
        sum = (n + 1) * (n + 2) / 2;

        for (int num : nums)
            sum -= num;
        return sum;
    }


    /*
     * Function to find missing number -  by doing XOR of First N Numbers
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static int getMissingNoXOR(int[] nums) {

        int n = nums.length;
        int x1 = 1;
        // For xor of all the elements from 1 to n+1
        for (int i = 2; i <= n + 1; i++)
            x1 = x1 ^ i;

        int x2 = nums[0];
        /* do a xor of each array element*/
        for (int i = 1; i < n; i++)
            x2 = x2 ^ nums[i];

        return (x1 ^ x2);
    }


}