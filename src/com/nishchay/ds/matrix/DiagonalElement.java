package com.nishchay.ds.matrix;

/*
 *	=========== print Diagonals of a Matrix===========
 *
 * Given a 2D square matrix, print the Principal and Secondary diagonals.
 *
 *	For Example
 *
 *		Input: 4
 *
 *		1 2 3 4
 *		4 3 2 1
 *		7 8 9 6
 *		6 5 4 3
 *		Output:
 *		Principal Diagonal: 1, 3, 9, 3
 *		Secondary Diagonal: 4, 2, 8, 6
 *
 * https://www.geeksforgeeks.org/program-to-print-the-diagonals-of-a-matrix/
 *
 * */
public class DiagonalElement {

    public static void main(String[] args) {

        int n = 4;
        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };

        printPrincipalDiagonal(a, n);
        printSecondaryDiagonal(a, n);

    }

    /*
     *
     * For example, consider the following 4 X 4 input matrix.
     *
     *      A00 A01 A02 A03
     *      A10 A11 A12 A13
     *      A20 A21 A22 A23
     *      A30 A31 A32 A33
     *
     * The primary diagonal is formed by the elements A00, A11, A22, A33.
     * Condition for Principal Diagonal: row == column
     *
     * The secondary diagonal is formed by the elements A03, A12, A21, A30.
     * Condition for Secondary Diagonal:  row + col = numberOfRows -1
     *
     * */
    // Function to print the Principal Diagonal
    private static void printPrincipalDiagonal(int[][] mat, int n) {
        System.out.print("Principal Diagonal : ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Condition for principal diagonal
                if (i == j) {
                    System.out.print(mat[i][j] + ", ");
                }
            }
        }
        System.out.println("");
    }

    // Function to print the Secondary Diagonal
    private static void printSecondaryDiagonal(int[][] mat, int n) {
        System.out.print("Secondary Diagonal : ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Condition for secondary diagonal
                if ((i + j) == (n - 1)) {
                    System.out.print(mat[i][j] + ", ");
                }
            }
        }
        System.out.println("");
    }

}
