package com.nishchay.ds.bit.appearonce;

import java.util.HashSet;
import java.util.Set;

/*
 * Find the element that appears once in an array where every other element appears twice
 *
 * Given an array of integers. All numbers occur twice except one number which occurs once.
 * Find the number in O(n) time & constant extra space.
 *
 * Example :
 * 		Input:  ar[] = {7, 3, 5, 4, 5, 3, 4}
 * 		Output: 7
 *
 * https://www.geeksforgeeks.org/find-element-appears-array-every-element-appears-twice/
 *
 * */
class ElementAppearsOnceInPairs {

	public static void main (String[] args) {

		int[] nums = {7, 3, 5, 4, 5, 3, 4};
		System.out.println("Element occurring once is - " + findSingleInPairs(nums));//7

		int[] arr = {7, 3, 5, 9, 4, 7, 5, 3, 4, 1};
		System.out.println("Element occurring once is - " + findSingle(arr));//9

	}


	// complexity : time -  O(n), space - O(n/2)
	 private static int findSingleInPairs(int[] arr) {
		Set<Integer> duplicates = new HashSet<>();
		for (int x :  arr ) {
			if (!duplicates.contains(x))
				duplicates.add(x);
			else
				duplicates.remove(x);
		}
		return duplicates.iterator().next();
	}

	// complexity : time -  O(n), space - O(1)

	/*
	 * Let us consider the above example.
	 * Let ^ be xor operator as in C and C++.
	 *
	 * res = 7 ^ 3 ^ 5 ^ 8 ^ 4 ^ 5 ^ 8 ^ 3 ^ 4
	 *
	 * Since XOR is associative and commutative, above
	 * expression can be written as:
	 * res = 7 ^ (3 ^ 3) ^ (4 ^ 4) ^ (5 ^ 5) ^ (8 ^ 8)
	 *     = 7 ^ 0 ^ 0 ^ 0
	 *     = 7 ^ 0
	 *     = 7
	 *
	 * time complexity of this solution is O(n) and it requires O(1) extra space
	 * */
	private static int findSingle(int[] arr) {
		// Do XOR of all elements and return
		int res = arr[0];
		for (int i = 1; i < arr.length; i++)
			res = res ^ arr[i];

		return res;
	}

}
