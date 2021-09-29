package com.nishchay.ds.matrix;

/*
 *	=========== Print matrix in diagonal zigzag pattern ===========
 *
 * Given a matrix of n*n size, the task is to print its elements in a diagonal pattern.
 *
 *	For Example
 *
 *      M X N : 5 X 5
 *
 *      A00 A01 A02 A03 A04
 *      A10 A11 A12 A13 A14
 *      A20 A21 A22 A23 A24
 *      A30 A31 A32 A33 A34
 *		A40 A41 A42 A43 A44
 *
 *		printing diagonally strip wise ( bottom to up ) :
 *			A00, A01 A10, A20 A11 A02, A03 A12 A21 A30, A40 A31 A22 A13 A04, A14 A23 A32 A41, A42 A33 A24, A34 A43, A44
 *
 *      No of strip = M + N -1 = 5 + 5 -1 = 9
 *
 *  	strip 1 - A00
 *  	strip 2 - A01, A10
 *  	strip 3 - A20, A11, A02
 *  	strip 4 - A03, A12, A21, A30
 *  	strip 5 - A40, A31, A22, A13, A04
 *  	strip 6 - A14, A23, A32, A41
 *  	strip 7 - A42, A33, A24
 *  	strip 8 - A34, A43
 *  	strip 9 - A44
 *
 *
 *
 *
 *			Input:
 *					50 51 52 53 54
 *					19 15 16 17 18
 *					90 91 92 93 94
 *					10 11 12 13 14
 *					77 88 55 44 99
 *
 *			Diagonal printing of the above matrix is :
 *			50
 *			51 19
 *			90 15 52
 *			53 16 91 10
 *			77 11 92 17 54
 *			18 93 12 88
 *			55 13 94
 *			14 44
 *			99
 *
 * https://www.geeksforgeeks.org/print-matrix-diagonal-pattern/
 *
 * */
public class DiagonalZigZag {


    public static void main(String[] args) {

        int[][] m = {
                {50, 51, 52, 53, 54},
                {19, 15, 16, 17, 18},
                {90, 91, 92, 93, 94},
                {10, 11, 12, 13, 14},
                {77, 88, 55, 44, 99}
        };

/*       int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
           // output - 1,2,4,7,5,3,6,8,9
         diagonalZigzag(m);
*/

        System.out.println("ZigZag diagonals are  :-");
        diagonalZigzag(m);


    }

    private static void diagonalZigzag(int[][] mat) {

        int n = mat.length;
        int i = 0, j = 0;

        // Direction is initially from down to up
        boolean isUp = true;

        // Traverse the matrix till all elements get traversed
        for (int k = 0; k < n * n; ) {
            // If isUp = true then traverse from downward
            // to upward
            if (isUp) {
                for (; i >= 0 && j < n; j++, i--) {
                    System.out.print(mat[i][j] + " ");
                    k++;
                }

                // Set i and j according to direction for next diagonal
                if (i < 0 && j <= n - 1)
                    i = 0;
                if (j == n) {
                    i = i + 2;
                    j--;
                }
                System.out.println();
            }

            // If isUp = 0 then traverse up to down
            else {
                for (; j >= 0 && i < n; i++, j--) {
                    System.out.print(mat[i][j] + " ");
                    k++;
                }

                // Set i and j according to direction
                if (j < 0 && i <= n - 1)
                    j = 0;
                if (i == n) {
                    j = j + 2;
                    i--;
                }
                System.out.println();
            }
            // Revert the isUp to change the direction
            isUp = !isUp;
        }
    }



/*    private static void diagonalZigzag(int[][] matrix) {

        int M = matrix.length; // noOfRows
        int N = matrix[0].length; // noOfCols

        int[] arr = new int[M * N];
        boolean up = true;
        int row, col;
        row = col = 0;
        int i = 0;
        while (row < M && col < N) {

            // if diagonal is going up
            if (up) {
                while (row > 0 && col < N - 1) {
                    arr[i++] = matrix[row][col];
                    row--;
                    col++;
                }
                arr[i++] = matrix[row][col];
                if (col == N - 1) {
                    row++;
                } else {
                    col++;
                }
                // if diagonal is going down
            } else {
                while (col > 0 && row < M - 1) {
                    arr[i++] = matrix[row][col];
                    row++;
                    col--;
                }
                arr[i++] = matrix[row][col];
                if (row == M - 1) {
                    col++;
                } else {
                    row++;
                }
            }
            up = !up;
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }
*/

}
