package com.nishchay.ds.array.nelement;

/*
 *	=========== Find the Missing Number in a sorted array ===========
 *
 *   Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list.
 *   One of the integers is missing in the list. Write an efficient code to find the missing integer.
 *
 * Examples:
 *
 * 	Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
 * 	Output : 5
 *
 * 	Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
 * 	Output : 7
 *
 * https://www.java67.com/2014/12/how-to-find-missing-number-in-sorted.html
 * https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
 * https://www.youtube.com/watch?v=fz40YQ8Fg_I
 * */
class FindMissingNumberIn1_NSorted {

    public static void main(String[] args) {

        int[] arr1 = {1, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 8, 9};

        System.out.println(getMissingNoLinearSearch(arr1)); // 2
        System.out.println(getMissingNoLinearSearch(arr2)); // 7

        System.out.println("--------------------------");
        System.out.println(missingNumberFromSortedArray(arr1)); // 2
        System.out.println(missingNumberFromSortedArray(arr2)); // 7

        System.out.println("--------------------------");
        System.out.println(getMissingNoBinarySearch(arr1)); // 2
        System.out.println(getMissingNoBinarySearch(arr2)); // 7


    }


    /*
     * If you analyse the problem statement, u will get two things :
     *   -   only one number is missing
     *   -   data is sorted in array
     *
     * just follow the first stmt : since array starting index is 0, starting Number is 1, so arr[i] == i+1
     * So our problem reduces to search in an array to find the first cell, whose value is not the same as its index + 1
     *      => get the first instance of arr[i] != i+1
     * this can be solve using sequential search - O(n)
     *
     * then we can improve the solution by using the sorted data properties - O(log n)
     *
     * */

    /*
     * Method 1 - Leaner Search
     * Logic : No == (index + 1) ?
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static int getMissingNoLinearSearch(int[] arr) {

        int n = arr.length;

        // staring from the left side , so will break the loop for the first instance of arr[i] != i+1
        int i = 0;
        while (i < n && i + 1 == arr[i]) {
            i++;
        }

        return i + 1;
    }

    /*
     * Method 2 - Binary Search
     *
     * condition to get the - first instance of arr[i] != i+1
     *   if (arr[mid] != mid+1 && arr[mid - 1] == mid)
     *
     * partition breaking / left & right logic :
     *
     *			if (arr[mid] != mid+1){
     *                  // index sequencing is not correct -  go left
     *                right = mid - 1;
     *            } else {
     *                  // index sequencing is correct -  go right
     *                left = mid + 1;
     *            }
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static int missingNumberFromSortedArray(int[] arr) {
        if (arr == null || arr.length <= 0) {
            throw new IllegalArgumentException("Null or Empty array not permitted");
        }
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (right + left) >> 1;

            if (arr[mid] != mid + 1 && arr[mid - 1] == mid) {
                return mid + 1;
            }
            if (arr[mid] != mid + 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        throw new RuntimeException("No missing number");
    }


    private static int getMissingNoBinarySearch(int[] arr) {

        int left = 0, right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            // got the first instance of arr[i] != i+1
            if (arr[mid] != mid + 1 && arr[mid - 1] == mid)
                return mid + 1;
            // index sequencing is not correct -  go left
            if (arr[mid] != mid + 1)
                right = mid - 1;
            else // index sequencing is correct -  go right
                left = mid + 1;
        }

        // Will reach here if no missing element found.
        return -1;
    }


}