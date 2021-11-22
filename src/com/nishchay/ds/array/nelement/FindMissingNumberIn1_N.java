package com.nishchay.ds.array.nelement;

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
 *
 * https://www.geeksforgeeks.org/find-repetitive-element-1-n-1/
 * https://www.youtube.com/watch?v=6KHW7ZQwtCA
 * */
class FindMissingNumberIn1_N {

    /* program to test above function */
    public static void main(String[] args) {

        int[] arr1 =  { 10, 5, 9, 4, 2, 7, 8, 3, 1 };
        System.out.println(getMissingNoHashMap(arr1)); // 6

        int[] arr2 = {8, 2, 4, 6, 3, 7, 1};
        System.out.println(getMissingNoSum(arr2)); // 5

        int[] arr3 =  { 10, 5, 9, 4, 2, 7, 8, 3, 1 }; // 6
        System.out.println(getMissingNoXOR(arr3));

    }

    /*
     * Method 1 - Hashing / freq count
     * Function to find missing number -  by first having the sum of First N Numbers
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int getMissingNoHashMap(int[] nums) {

        int n = nums.length;
        // n + 1 , bcus n nos are there in array and 1 is missing so n+1
        // again we are not using index 0, so n + 2
        int freqArraySize = n + 2;
        boolean[] freq =  new boolean[freqArraySize];// all cells are initialized with false

        for (int i = 0; i < n; i++) {
            freq[nums[i]] = true;
        }
        int res = -1;
        for (int i = 1; i < freqArraySize; i++) {
            if(freq[i] == false)
                res = i;
        }
        return res;
    }

    /*
    * Method 2 - Sum formula
    * Function to find missing number -  by first having the sum of First N Numbers
    * Time Complexity: O(n)
    * Space Complexity: O(1)
    * Problem - since we ae keeping the sum in single int variable, we can run in overflow issue for a bigger array
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
     * Method 3 - XOR method
     * Function to find missing number -  by doing XOR of First N Numbers
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static int getMissingNoXOR(int[] nums) {

        int n = nums.length;
        int x1 = 1;
        // For xor of all the elements from 1 to n+1
        /// n+1 , bcus n nos are there in array and 1 is missing so n+1
        for (int i = 2; i <= n + 1; i++)
            x1 = x1 ^ i;

        int x2 = nums[0];
        /* do a xor of each array element*/
        for (int i = 1; i < n; i++)
            x2 = x2 ^ nums[i];

        return (x1 ^ x2);
    }


}