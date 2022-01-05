package com.nishchay.ds.array.search;

/*
 *============== Search in Row wise And Column wise Sorted Array ====================
 *
 *
 * Given an m x n matrix and a key value, find the position of the key value in the matrix if it is present in it.
 * Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing order.
 *
 *	Example 1:
 *			Input: matrix[4][4] = { {10, 20, 30, 40},
 *			                      {15, 25, 35, 45},
 *			                      {27, 29, 37, 48},
 *			                      {32, 33, 39, 50}};
 *			              target = 29
 *			Output: Found at (2, 1)
 *			Explanation: Element at (2,1) is 29
 *
 *	Example 2:
 *			Input : matrix[4][4] = { {10, 20, 30, 40},
 *			                      {15, 25, 35, 45},
 *			                      {27, 29, 37, 48},
 *			                      {32, 33, 39, 50}};
 *			              target = 100
 *			Output : Element not found
 *			Explanation: Element 100 is not found
 *
 *
 * https://www.callicoder.com/binary-search-row-wise-column-wise-sorted-matrix/
 * https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 * https://www.educative.io/edpresso/how-to-search-in-a-row-wise-and-column-wise-sorted-matrix
 *
 * */
public class BS18SearchInRowWiseColWiseSortedArray {

    public static void main(String[] args) {

        int[][] matrix = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };

        int key = 29;

        int[] result = searchInSortedMatrix(matrix, key);

        if(result[0] != -1 && result[1] != -1) {
            System.out.printf("%d is found at (%d, %d)%n", key, result[0], result[1]);
        } else {
            System.out.printf("Element not found");
        }

        key = 100;

        result = searchInSortedMatrix(matrix, key);

        if(result[0] != -1 && result[1] != -1) {
            System.out.printf("%d is found at (%d, %d)%n", key, result[0], result[1]);
        } else {
            System.out.printf("Element not found");
        }
    }

    private static int[] searchInSortedMatrix(int[][] matrix, int key) {

        if (matrix.length == 0) {
            return new int[]{-1, -1};
        }

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int i = 0;
        int j = numCols - 1;
        while (i >= 0 && i < numRows && j >= 0 && j < numCols) {
            if (key == matrix[i][j]) {
                return new int[]{i, j};
            } else if (matrix[i][j] > key) {
                j--;  // search left
            } else {
                i++;  // search down.
            }
        }
        return new int[]{-1, -1};
    }

}
