package com.nishchay.ds.array.search;

/*
 *============== Find the Rotation Count in Rotated Sorted array ====================
 *
 * Consider an array of distinct numbers sorted in increasing order.
 * The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.
 *
 *
 *
 * Examples - 1
 *		Input : arr[] = {15, 18, 2, 3, 6, 12}
 *		Output: 2
 *		Explanation : Initial array must be {2, 3,6, 12, 15, 18}. We get the given array after rotating the initial array twice.
 *
 * Examples - 2
 *		Input : arr[] = {7, 9, 11, 12, 5}
 *		Output: 4
 *
 * Examples - 3
 *		Input: arr[] = {7, 9, 11, 12, 15};
 *		Output: 0
 *
 * https://www.youtube.com/watch?v=4qjprDkJrjY&ab_channel=mycodeschool
 * https://www.techiedelight.com/find-number-rotations-circularly-sorted-array/
 * https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 * */
public class BS6NumberOfRotations {


    public static void main(String[] args) {

        int[] arr = {15, 18, 2, 3, 6, 12};
        System.out.printf("Rotation Count = %d%n", findPivotIndex(arr)); // 2

        arr = new int[]{7, 9, 11, 12, 5};
        System.out.printf("Rotation Count = %d%n", findPivotIndex(arr)); // 4

        arr = new int[]{7, 9, 11, 12, 15};
        System.out.printf("Rotation Count = %d%n", findPivotIndex(arr)); // 0


    }


    /*
     *
     *	Input: a = [4, 6, 8, 10, 0, 1, 2]
     *	Output: 4
     *	Explanation: The original array would be [0, 1, 2, 4, 6, 8, 10] and it was rotated 4 times.
     *
     *	# of times array is been rotated = index of the smallest element
     *	-------
     *	Apply BS logic to get the smallest element in array
     *		1. index return logic
     *			already sorted - left
     *			pivot element index
     *
     *	    2. left / right movement logic
     *			skip sorted array, search next in unsorted array
     *	===============================================================
     *
     *	 2,3,5,8,11,12
     *	 ^			 |	// clock wise - 1 rotation
     *	 |----------<|
     *
     *	 12,2,3,5,8,11 => circular sorted array
     *
     *	 11,12,2,3,5,8 // clock wise - 2 rotation
     *
     *	 How many times the array has been rotated ?
     *	 # of times array is been rotated = index of the smallest element
     *
     *	Case -1 :
     *			// if array is already sorted (no rotations) - 0
     *			// found the minimum element arr[left]
     *			if (arr[left] <= arr[right]) {
     *				return left;
     *			}
     *
     *	11, 12, 15, 18, 2, 5, 6, 8
     *		            ^
     *
     *	pivot element property - next & prev both are greater
     *	// find the next and previous element of the `mid` element(in a circular manner)
     *	next = (mid + 1 )% n
     *	prev = (mid - 1 + n)% n
     *
     *	Case -2 :
     *			arr[mid] <= arr[next] && arr[mid] <= arr[prev]
     *				return mid;
     *	case -3 :
     *			if (arr[mid] <= arr[right])
     *	                right = mid - 1;
     *	case -4 :
     *			if (arr[mid] >= arr[left])
     *	                left = mid + 1;
     *
     * time complexity = O(n)
     * space complexity = O(1)
     * */
    static int findPivotIndex(int[] arr) {
        int left, right, mid, n;
        left = 0;
        right = arr.length - 1;
        n = arr.length;

        while (left <= right) {

            // if array is already sorted (no rotations) - 0
            // found the minimum element arr[left]
            if (arr[left] <= arr[right]) {
                return left;
            }

            mid = (left + right) / 2;

            // find the next and previous element of the `mid` element (in a circular manner)
            int next = (mid + 1) % n;
            int prev = (mid - 1 + n) % n;

            // pivot element property - next & prev both are greater
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            }

            // right is sorted - go left half
            else if (arr[mid] <= arr[right]) {
                right = mid - 1;
            }

            // left is sorted - go right half
            else if (arr[mid] >= arr[left]) {
                left = mid + 1;
            }
        }

        return 0;
    }

}
