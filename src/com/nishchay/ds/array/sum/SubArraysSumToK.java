package com.nishchay.ds.array.sum;


import java.util.HashMap;

/*
 *	=========== Number of subarrays having sum exactly equal to k ===========
 *
 * No of subArrays with sum = k
 * Given an unsorted array of integers, find the number of subarrays having sum exactly equal to a given number k.
 *
 *	For Example
 *
 *		Input : arr[] = {10, 2, -2, -20, 10},
 *		        k = -10
 *		Output : 3
 *		Subarrays: arr[0...3], arr[1...4], arr[3..4]
 *		have sum exactly equal to -10.
 *
 *		Input : arr[] = {9, 4, 20, 3, 10, 5},
 *		            k = 33
 *		Output : 2
 *		Subarrays : arr[0...2], arr[2...4] have sum
 *		exactly equal to 33.
 *
 *
 * https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
 * https://www.youtube.com/watch?v=HbbYPQc-Oo4&ab_channel=TECHDOSE
 *
 * */
public class SubArraysSumToK {

    public static void main(String[] args) {

//        subArraysSum_bruteForce();
        findSubArraySumEx();

    }


    /*
     *	Naive Solution –
     *	A simple solution is to traverse all the subarrays and calculate their sum.
     *	If the sum is equal to the required sum then increment the count of subarrays. Print final count of subarray.
     *
     *	Time Complexity: O(n^2)
     *	Auxiliary Space: O(1)
     * */
    private static void subArraysSum_bruteForce() {

        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        int n = arr.length;
        int res = 0;

        // calculate all subarrays
        for (int i = 0; i < n; i++) {

            int sum = 0;
            for (int j = i; j < n; j++) {

                // calculate required sum
                sum += arr[j];

                // check if sum is equal to
                // required sum
                if (sum == k)
                    res++;
            }
        }
        System.out.println(res);
    }

    private static void findSubArraySumEx() {
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println(findSubArraySum(arr, arr.length, k)); //3

        arr = new int[]{3, 4, 7, 2, -3, 1, 4, 2};
        k = 7;
        System.out.println(findSubArraySum(arr, arr.length, k)); //4
    }

    /*
     *
     *				0, 1, 2, 3,  4, 5, 6, 7
     *				3, 4, 7, 2, -3, 1, 4, 2
     *				^  ^  ^  ^   ^  ^  ^  ^
     *				3  7  14 16  13 14 18 20
     *
     *              k =7
     *
     *			if(currSum== k)
     *			 count +=1;
     *			if(myMap.find(currSum - k))
     *			 count += myMap[currSum - k]
     *
     *			myMap
     *			k | count
     *			------------
     *			3  -> 1
     *			7  -> 1
     *			14 -> 1/2
     *			16 -> 1
     *			13 -> 1
     *			18 -> 1
     *			20 -> 1
     *
     *			count = 0/1/2/3/4
     *
     *	Time Complexity: O(n^2)
     *	Auxiliary Space: O(1)
     *
     * */
    static int findSubArraySum(int[] arr, int n, int k) {

        HashMap<Integer, Integer> prevSum = new HashMap<>();

        int totalCount = 0;

        // Sum of elements so far.
        int currSum = 0;

        for (int i = 0; i < n; i++) {

            currSum += arr[i];

            // If currSum is equal to desired k, then a new subarray is found.
            if (currSum == k)
                totalCount++;

            // currSum exceeds given k by currSum
            //  - k. Find number of subarrays having
            // this k and exclude those subarrays
            // from currSum by increasing totalCount by
            // same amount.
            if (prevSum.containsKey(currSum - k))
                totalCount += prevSum.get(currSum - k);

            // Add currSum value to totalCount of
            // different values of k.
            Integer count = prevSum.get(currSum);
            if (count == null)
                prevSum.put(currSum, 1);
            else
                prevSum.put(currSum, count + 1);
        }

        return totalCount;
    }
}
