package com.nishchay.ds.array.appearonce;

import java.util.HashSet;
import java.util.Set;

/*
* Java program to find the element that appears only once in array
* Input:  arr[] = {7, 3, 5, 4, 5, 3, 4}
* Output: 7
*
* */
class ElementAppearsOnceInPairs {

	public static void main (String[] args) {

		int[] nums = {7, 3, 5, 4, 5, 3, 4};
		System.out.println("Element occurring once is - " + findSingleInPairs1(nums));

		int[] arr = {7, 3, 5, 9, 4, 7, 5, 3, 4};
		System.out.println("Element occurring once is - " + findSingleInPairs(arr));

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
	private static int findSingleInPairs1(int[] arr) {
		// Do XOR of all elements and return
		int res = arr[0];
		for (int i = 1; i < arr.length; i++)
			res = res ^ arr[i];
		return res;
	}

}
