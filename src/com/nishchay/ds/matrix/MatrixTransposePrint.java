package com.nishchay.ds.matrix;


/*
 *	----------original matrix-----------
 *
 *	2	5	6
 *	8	9	3
 *	1	4	7
 *
 *	-----printing in desired order-----
 *
 *	6	3	7
 *	5	9	4
 *	2	8	1
 *
 *	-----
 *	 [
 *	 c0,2	c1,2	c2,2
 *	 c0,1	c1,1	c2,1
 *	 c0,0	c1,0	c2,0
 *	 ]
 *
 *
 * */

public class MatrixTransposePrint {

    public static void main(String[] args) {

        int[][] matrix = {{2, 5, 6}, {8, 9, 3}, {1, 9, 7}};
        int noOfRows = 3;
        int noOfCols = 3;

        // printing
        System.out.print("\n----------original matrix-----------");
        for (int i = 0; i < noOfRows; i++) {
            System.out.print("\n");
            for (int j = 0; j < noOfCols; j++) {
                System.out.print(matrix[i][j] + "\t");

            }
        }

        System.out.print("\n----------printing in desired order-----------");
        for (int j = noOfCols - 1; j >= 0; j--) {
            System.out.print("\n");
            for (int i = 0; i < noOfRows; i++) {
                System.out.print(matrix[i][j] + "\t");

            }
        }

        System.out.println("\n....After transposing the elements are...");
        for (int i = 0; i < noOfRows; i++) {
            System.out.println("");
            for (int j = 0; j < noOfCols; j++) {
                System.out.print(matrix[j][i] + " ");
            }

        }
    }

}
