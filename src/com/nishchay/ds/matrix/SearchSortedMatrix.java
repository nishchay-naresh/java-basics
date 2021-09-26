package com.nishchay.ds.matrix;

/*
 *	=========== Search element in a sorted matrix ===========
 *
 * Given a sorted matrix mat[n][m](non square) and an element ‘x’. Find the position of x in the matrix if it is present, else print -1.
 * Matrix is sorted in a way such that all elements in a row are sorted in increasing order
 * Such that for row ‘i’, where 1 <= i <= n-1, the first element of row ‘i’ is greater than or equal to the last element of row ‘i-1’.
 *
 * ie each row elements are sorted in asc order
 * and last element of ith row <= first element of i+1th row
 *
 *	We are given a 2D array where all elements in any individual row or column are sorted.
 * 	In such a matrix, we have to search or find the position of, a given key.
 *
 *	For Example
 *		Input : mat[][] = { {1, 5, 9},
 *		                    {14, 20, 21},
 *		                    {30, 34, 43} }
 *		        x = 14
 *		Output : Found at (1, 0)
 *
 *		Input : mat[][] = { {1, 5, 9, 11},
 *		                    {14, 20, 21, 26},
 *		                    {30, 34, 43, 50} }
 *		        x = 42
 *		Output : -1
 *
 * https://www.educative.io/m/search-matrix
 * https://www.geeksforgeeks.org/search-element-sorted-matrix/
 *
 * */
public class SearchSortedMatrix {


    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 5, 45, 80, 81},
                {6, 7, 48, 82, 83},
                {20, 22, 49, 85, 86},
                {21, 23, 50, 90, 92}
        };

        verify_search(matrix);
    }

    /*
     * A Simple Solution is to one by one compare x with every element of the matrix. If matches, then return position. If we reach the end, return -1.
     *  The time complexity of this solution is O(n x m).
     * An efficient solution is to typecast a given 2D array to a 1D array, then apply binary search on the type casted array.
     *
     * However, there are better solutions with less time complexity that use the sorted property of matrix.
     *  We start from the upper right corner of the matrix and compare its value with the key.
     *  If they are equal, we have found the position of the key.
     *  If the key is smaller than the current element, we move one position to the left.
     *  If the key is larger than the current element, we move one position down.
     *
     *	Runtime Complexity : O(m+n) where ‘m’ is number of rows and ‘n’ is number of columns.
     *	Memory Complexity  : Constant, O(1).
     * */
    private static IntPair search_in_matrix(int[][] matrix, int key) {

        int M = matrix.length; //rows
        int N = matrix[0].length; // columns

        // Let's start searching from top right. - starting from matrix[0][N-1]
        // Alternatively, searching from bottom left - matrix[M-1][0] can also work.
        int i = 0, j = N - 1;
        while (i < M && j >= 0) {
            if (matrix[i][j] == key) {
                return new IntPair(i, j);
            } else if (key < matrix[i][j]) {
                // search left
                --j;
            } else {
                // search down.
                ++i;
            }
        }
        return new IntPair(-1, -1);
    }


    private static void verify_search(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print("\nVerifying at " + i + ", " + j);
                IntPair val_loc = search_in_matrix(matrix, matrix[i][j]);
                if (val_loc.first == i && val_loc.second == j)
                    System.out.print(" verification done");
            }
        }
    }

}

class IntPair {
    int first;
    int second;

    IntPair() {
        this.first = this.second = 0;
    }

    IntPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}