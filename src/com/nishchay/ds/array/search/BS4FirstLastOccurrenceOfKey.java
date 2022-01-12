package com.nishchay.ds.array.search;

/*
 *============== Find first and last positions of an element in a sorted array ====================
 *
 * Given a sorted array with possibly duplicate elements,
 * The task is to find indexes of first and last occurrences of an element x in the given array.
 *
 *
 * Examples - 1
 *			Input : arr[] = {1, 3, 5, 5, 5, 5, 6, 6, 7, 123, 125}
 *			        key = 5
 *			Output : First Occurrence = 2
 *			         Last Occurrence = 5
 *
 * Examples - 2
 *			Input : arr[] = {1, 3, 5, 5, 5, 5, 6, 6, 7, 123, 125}
 *			        key = 7
 *			Output : First Occurrence = 8
 *			         Last Occurrence = 8
 *
 * Examples - 3
 *			Input : arr[] = {2, 2, 5, 5, 6, 6, 8, 9, 9, 9}
 *			key = 9
 *			Output : First Occurrence = 7
 *			         Last Occurrence = 9
 * Examples - 4
 *			Input : arr[] = {2, 2, 5, 5, 6, 6, 8, 9, 9, 9}
 *			key = 2
 *			Output : First Occurrence = 0
 *			         Last Occurrence = 1
 *
 * Examples - 5
 *			Input : arr[] = {2, 2, 5, 5, 6, 6, 8, 9, 9, 9}
 *			key = 4
 *			Output : First Occurrence = -1
 *			         Last Occurrence = -1
 *
 * Examples - 6
 *			Input : arr[] = {101,101}
 *			key = 101
 *			Output : First Occurrence = 0
 *			         Last Occurrence = 1
 *
 * Discussed solution approaches
 * 	1. A brute force approach using linear search
 * 	2. An efficient approach by applying binary search twice
 *
 * A brute force approach using a linear search
 * 	The straightforward approach is to traverse the array and track the index of the first and last occurrence of the target.
 * 	This approach is inefficient because we did not take advantage of the fact that the given array is sorted.
 *
 * An efficient approach using binary search
 * 	The idea is simple: we can use binary search twice to solve the problem.
 * 		The first binary search is to find the first occurrence of the target and
 * 		the second binary search is to find the last occurrence of the target.
 *
 *
 * https://www.enjoyalgorithms.com/blog/first-and-last-positions-of-element-in-sorted-array
 * https://www.techiedelight.com/find-first-or-last-occurrence-of-a-given-number-sorted-array/
 * https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
 * */
public class BS4FirstLastOccurrenceOfKey {
    public static void main(String[] args) {

        bruteForceApproach();
        System.out.printf("----------------------------------------------%n");
        binarySearchApproach();

    }

    private static void bruteForceApproach() {
        int[] arr = {1, 3, 5, 5, 5, 5, 6, 6, 7, 123, 125};

        int key = 5;
        int[] firstLast = findFirstAndLast(arr, key);
        System.out.printf("First Occurrence = %d\tLast Occurrence = %d%n", firstLast[0], firstLast[1]);

        key = 7;
        firstLast = findFirstAndLast(arr, key);
        System.out.printf("First Occurrence = %d\tLast Occurrence = %d%n", firstLast[0], firstLast[1]);

        arr = new int[]{2, 2, 5, 5, 6, 6, 8, 9, 9, 9};

        key = 9;
        firstLast = findFirstAndLast(arr, key);
        System.out.printf("First Occurrence = %d\tLast Occurrence = %d%n", firstLast[0], firstLast[1]);

        key = 2;
        firstLast = findFirstAndLast(arr, key);
        System.out.printf("First Occurrence = %d\tLast Occurrence = %d%n", firstLast[0], firstLast[1]);

        key = 4;
        firstLast = findFirstAndLast(arr, key);
        System.out.printf("First Occurrence = %d\tLast Occurrence = %d%n", firstLast[0], firstLast[1]);

        arr = new int[]{101, 101};
        key = 101;
        firstLast = findFirstAndLast(arr, key);
        System.out.printf("First Occurrence = %d\tLast Occurrence = %d%n", firstLast[0], firstLast[1]);

    }

    /*
     * ===========Brute force approach==========
     *
     *  The Naive Approach is to run a for loop and check given elements in an array.
     *
     * 1. initialize firstLast[0], firstLast[1]  to -1
     * 2. Run a for loop and for i = 0 to n-1
     * 3. When we find element first time then we update firstLast[0] = i
     * 4. We always update firstLast[1] =i whenever we find the element.
     * 5. We return firstLast
     *
     * time complexity = O(n)
     * space complexity = O(1)
     *
     * */
    private static int[] findFirstAndLast(int[] arr, int key) {
        int[] firstLast = new int[]{-1, -1};

        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                if (firstLast[0] == -1)
                    firstLast[0] = i;
                firstLast[1] = i;
            }
        }
        return firstLast;
    }


    private static void binarySearchApproach() {

        int[] arr = {1, 3, 5, 5, 5, 5, 6, 6, 7, 123, 125};

        int key = 5;
        System.out.printf("First Occurrence = %d\tLast Occurrence = %d%n", firstOccurrence(arr, key), lastOccurrence(arr, key));

        key = 7;
        System.out.printf("First Occurrence = %d\tLast Occurrence = %d%n", firstOccurrence(arr, key), lastOccurrence(arr, key));

        arr = new int[]{2, 2, 5, 5, 6, 6, 8, 9, 9, 9};

        key = 9;
        System.out.printf("First Occurrence = %d\tLast Occurrence = %d%n", firstOccurrence(arr, key), lastOccurrence(arr, key));

        key = 2;
        System.out.printf("First Occurrence = %d\tLast Occurrence = %d%n", firstOccurrence(arr, key), lastOccurrence(arr, key));

        key = 4;
        System.out.printf("First Occurrence = %d\tLast Occurrence = %d%n", firstOccurrence(arr, key), lastOccurrence(arr, key));

        arr = new int[]{101, 101};
        key = 101;
        System.out.printf("First Occurrence = %d\tLast Occurrence = %d%n", firstOccurrence(arr, key), lastOccurrence(arr, key));
    }


    /*
     * ===========binary search approach==========
     * 	Applying binary search twice :
     * 		To find the first occurrence  - first binary search
     * 		To find the last occurrence  -  second binary search
     *
     *  Slightly change in the condition :
     *
     *  condition to get first occurrence
     *  if (arr[mid] == key){
     *       result = mid;
     *       right = mid - 1; // moving left for the first occurrence
     *  }
     *
     *  condition to get last occurrence
     *  if (arr[mid] == key){
     *       result = mid;
     *       left = mid + 1; // moving right for the last occurrence
     *  }
     *
     *  Time Complexity : O(log n)
     *  Auxiliary Space : O(1)
     * */

    static int firstOccurrence(int[] arr, int key) {

        int left, right, mid;
        left = 0;
        right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] == key) {
                result = mid;
                right = mid - 1; // moving left for the fist occurrence
            } else if (arr[mid] > key)
                right = mid - 1; // go left
            else
                left = mid + 1; // go right
        }
        return result;
    }

    static int lastOccurrence(int[] arr, int key) {

        int left, right, mid;
        left = 0;
        right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] == key) {
                result = mid;
                left = mid + 1; // moving right for the last occurrence
            } else if (arr[mid] > key)
                right = mid - 1; // go left
            else
                left = mid + 1; // go right
        }
        return result;
    }
}
/*
 * O/P =>
First Occurrence = 2	Last Occurrence = 5
First Occurrence = 8	Last Occurrence = 8
First Occurrence = 7	Last Occurrence = 9
First Occurrence = 0	Last Occurrence = 1
First Occurrence = -1	Last Occurrence = -1
First Occurrence = 0	Last Occurrence = 1
----------------------------------------------
First Occurrence = 2	Last Occurrence = 5
First Occurrence = 8	Last Occurrence = 8
First Occurrence = 7	Last Occurrence = 9
First Occurrence = 0	Last Occurrence = 1
First Occurrence = -1	Last Occurrence = -1
First Occurrence = 0	Last Occurrence = 1
 * */