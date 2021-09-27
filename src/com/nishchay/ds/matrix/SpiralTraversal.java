package com.nishchay.ds.matrix;

import java.util.Stack;

/*
 *	=========== Print spiral matrix traversal ===========
 *
 * Given a 2D matrix, print it in spiral form.
 *
 *	For Example
 *
 *		For example, consider the following 4 X 4 input matrix.
 *
 *		A00 A01 A02 A03
 *		A10 A11 A12 A13
 *		A20 A21 A22 A23
 *		A30 A31 A32 A33
 *		spiral matrix traversal  -  A00, A01, A02, A03, A13, A23, A33, A32, A31, A30, A20, A10, A11, A12, A22, A21,
 *
 *			Input:  1    2   3   4
 *			        5    6   7   8
 *			        9   10  11  12
 *			        13  14  15  16
 *			Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 *			Explanation: The output is matrix in spiral format.
 *
 *			Input:  1   2   3   4  5   6
 *			        7   8   9  10  11  12
 *			        13  14  15 16  17  18
 *			Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 *			Explanation :The output is matrix in spiral format.
 *
 * https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * https://www.youtube.com/watch?v=1ZGJzvkcLsA&ab_channel=TECHDOSE
 *
 * */
public class SpiralTraversal {

    public static void main(String[] args) {

        spiralEx();

        reverseSpiralEx();

    }

    private static void spiralEx() {
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.print("Spiral Traversal is  :- ");
        spiralTraversal(m);

        m = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };

        System.out.print("Spiral Traversal is  :- ");
        spiralTraversal(m);
    }

    /*
     *
     *
     * Time Complexity: O(m*n). To traverse the matrix O(m*n) time is required.
     * Space Complexity: O(1). No extra space is required
     *
     * */
    private static void spiralTraversal(int[][] matrix) {

        int M = matrix.length; // noOfRows
        int N = matrix[0].length; // noOfCols

        int left, right, top, bottom, dir;

        left = 0;
        right = N - 1;
        top = 0;
        bottom = M - 1;
        dir = 0; // starting condition is - left

        int i;
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                // left to right - row
                for (i = left; i <= right; i++)
                    System.out.print(matrix[top][i] + " ");
                top++;
                // top to bottom - col
            } else if (dir == 1) {
                for (i = top; i <= bottom; i++)
                    System.out.print(matrix[i][right] + " ");
                right--;
                // right to left - row
            } else if (dir == 2) {
                for (i = right; i >= left; i--)
                    System.out.print(matrix[bottom][i] + " ");
                bottom--;
                // bottom to top - col
            } else if (dir == 3) {
                for (i = bottom; i >= top; i--)
                    System.out.print(matrix[i][left] + " ");
                left++;
            }
            dir = (dir + 1) % 4;
        }

    }


    /*
     *  =========== Reverse spiral traversal of matrix ===========
     *
     * Input:
     *         1    2   3   4
     *         5    6   7   8
     *         9   10  11  12
     *         13  14  15  16
     *
     * Output:  10 11 7 6 5 9 13 14 15 16 12 8 4 3 2 1
     *
     * Input:
     *         1   2   3   4  5   6
     *         7   8   9  10  11  12
     *         13  14  15 16  17  18
     *
     * Output: 11 10 9 8 7 13 14 15 16 17 18 12 6 5 4 3 2 1
     *
     * https://www.geeksforgeeks.org/print-given-matrix-reverse-spiral-form/
     * https://www.geeksforgeeks.org/print-matrix-antispiral-form/
     * */

    private static void reverseSpiralEx() {

        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.print("Reverse Spiral Traversal is  :- ");
        antiSpiralTraversal(m);

        m = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };

        System.out.print("Reverse Spiral Traversal is  :- ");
        antiSpiralTraversal(m);

    }

    private static void antiSpiralTraversal(int[][] matrix) {

        int M = matrix.length; // noOfRows
        int N = matrix[0].length; // noOfCols

        Stack<Integer> stack = new Stack<Integer>();

        int left, right, top, bottom, dir;

        left = 0;
        right = N - 1;
        top = 0;
        bottom = M - 1;
        dir = 0; // starting condition is - left

        int i;
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                // left to right - row
                for (i = left; i <= right; i++)
                    stack.push(matrix[top][i]);
                top++;
                // top to bottom - col
            } else if (dir == 1) {
                for (i = top; i <= bottom; i++)
                    stack.push(matrix[i][right]);
                right--;
                // right to left - row
            } else if (dir == 2) {
                for (i = right; i >= left; i--)
                    stack.push(matrix[bottom][i]);
                bottom--;
                // bottom to top - col
            } else if (dir == 3) {
                for (i = bottom; i >= top; i--)
                    stack.push(matrix[i][left]);
                left++;
            }
            dir = (dir + 1) % 4;
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}
