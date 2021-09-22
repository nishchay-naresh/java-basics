package com.nishchay.ds.matrix;

/*
 *	=========== Upper Triangular Matrix amd Lower Triangular Matrix of a sqare Matrix===========
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
 *		Upper Triangular Matrix:
 *								1 2 3 4
 *								0 3 2 1
 *								0 0 9 6
 *								0 0 0 3
 *		Lower Triangular Matrix:
 *								1 0 0 0
 *								4 3 0 0
 *								7 8 9 0
 *								6 5 4 3
 * https://www.geeksforgeeks.org/java-program-to-display-upper-triangular-matrix/
 * https://www.geeksforgeeks.org/java-program-to-display-lower-triangular-matrix/
 *
 * */
public class TriangularMatrix {

    public static void main(String[] args) {

        int[][] m = {
                {1 ,2 ,3 ,4},
                {4 ,3 ,2 ,1},
                {7 ,8 ,9 ,6},
                {6 ,5 ,4 ,3}
        };

        System.out.println("Original Matrix is  :-");
        printMatrix(m);

//        printUpperTriangularMatrix(m);
        printLowerTriangularMatrix(m);

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
     * Upper Triangular Matrix:
     *      						A00 A01 A02 A03
     *      						0   A11 A12 A13
     *      						0   0   A22 A23
     *      						0   0   0   A33
     * Condition for Upper Triangular Matrix:
     *				  if (i > j) {
     *                    matrix[i][j] = 0;
     *                }
     *
     * Lower Triangular Matrix:
     *      						A00 0   0   0
     *      						A10 A11 0   0
     *      						A20 A21 A22 0
     *      						A30 A31 A32 A33
     * Condition for Lower Triangular Matrix:
     *				  if (i < j) {
     *                    matrix[i][j] = 0;
     *                }
     * */

    private static void printUpperTriangularMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // if number of rows and
        // columns are not equal,then
        // return back
        if (row != col) {
            System.out.println("Matrix should be a Square Matrix");
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i > j) {
                        matrix[i][j] = 0;
                    }
                }
            }

            System.out.println("Upper Triangular Matrix is  :-");

            // printing the upper triangular matrix
            printMatrix(matrix);
        }
    }

    private static void printLowerTriangularMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // if number of rows and columns are not equal,
        // then return back
        if (row != col) {
            System.out.println("Matrix should be a Square Matrix");
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i < j) {
                        matrix[i][j] = 0;
                    }
                }
            }

            System.out.println("Lower Triangular Matrix is  :-");
            // printing the lower triangular matrix
            printMatrix(matrix);
        }
    }

    private  static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
}
