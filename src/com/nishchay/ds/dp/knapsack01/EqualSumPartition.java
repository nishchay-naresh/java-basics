package com.nishchay.ds.dp.knapsack01;


/*
 *	Partition problem | DP-18
 *	Partition problem is to determine whether a given set can be partitioned into two subsets
 *	such that the sum of elements in both subsets is the same.
 *
 *	Examples:
 *
 *	arr[] = {1, 5, 11, 5}
 *	Output: true
 *	The array can be partitioned as {1, 5, 5} and {11}
 *
 *	arr[] = {1, 5, 3}
 *	Output: false
 *	The array cannot be partitioned into equal sum sets.
 *
 *	arr[] = { 7, 3, 1, 5, 4, 8}
 *	Output: true
 *	The array can be partitioned as {7,3,4} and {1,5,8}
 *
 * https://www.geeksforgeeks.org/partition-problem-dp-18/
 * https://www.techiedelight.com/partition-problem/
* */
public class EqualSumPartition {

    public static void main(String[] args) {

        is2SubsetWithEqualSumDPBottomUp();

    }

    private static void is2SubsetWithEqualSumDPBottomUp () {

        EqualSumPartition ref = new EqualSumPartition();

        int[] arr = {1, 5, 11, 5};
        System.out.println(ref.is2SubsetWithEqualSum(arr)); // true

        arr = new int[]{1, 5, 3};
        System.out.println(ref.is2SubsetWithEqualSum(arr)); // false

        arr = new int[]{ 7, 3, 1, 5, 4, 8 };
        System.out.println(ref.is2SubsetWithEqualSum(arr)); // true

    }

    private boolean is2SubsetWithEqualSum(int[] arr){

        int n = arr.length;

        // Calculate sum of the elements in array
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // If sum is odd, there cannot be two subsets with equal sum
        if (sum % 2 != 0)
            return false;

        // Find if there is subset with sum equal to half of total sum
        return  new SubsetSumPossible().isSubsetSumTabulation(arr, sum / 2);
    }

}


