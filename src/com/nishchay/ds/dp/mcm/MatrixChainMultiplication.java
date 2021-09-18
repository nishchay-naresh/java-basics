package com.nishchay.ds.dp.mcm;


import java.util.Arrays;

/*
 *	===========Matrix Chain Multiplication===========
 *
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together.
 * The problem is not actually to perform the multiplications,
 * but merely to decide in which order to perform the multiplications.
 *
 * Examples :
 *		Input: p[] = {40, 20, 30, 10, 30}
 *		Output: 26000
 *		There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
 *		Let the input 4 matrices be A, B, C and D.  The minimum number of
 *		multiplications are obtained by putting parenthesis in following way
 *		(A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
 *
 *		Input: p[] = {10, 20, 30, 40, 30}
 *		Output: 30000
 *		There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30.
 *		Let the input 4 matrices be A, B, C and D.  The minimum number of
 *		multiplications are obtained by putting parenthesis in following way
 *		((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30
 *
 *		Input: p[] = {10, 20, 30}
 *		Output: 6000
 *		There are only two matrices of dimensions 10x20 and 20x30. So there
 *		is only one way to multiply the matrices, cost of which is 10*20*30

 *
 * https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
 *
 * */
public class MatrixChainMultiplication {


    private static int[][] dp = new int[100][100];

    static{

/*
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                dp[i][j] = -1;
            }
        }
*/

        for (int[] row : dp)
            Arrays.fill(row, -1);

    }

    public static void main(String[] args) {

        System.out.println("------------Recursion-------------");
        mcmRecursionEx();
        System.out.println("------------TopDown-------------");
        mcmDPTopDown();
        System.out.println("------------BottomUp-------------");
        mcmDPBottomUp();

    }



    private static void mcmRecursionEx() {

        MatrixChainMultiplication ref = new MatrixChainMultiplication();

        int[] arr = {40, 20, 30, 10, 30};
        System.out.println("Minimum number of multiplications is - " + ref.mcmRecursive(arr, 1, arr.length - 1)); // 26000

        arr = new int[]{10, 20, 30, 40, 30};
        System.out.println("Minimum number of multiplications is - " + ref.mcmRecursive(arr, 1, arr.length - 1)); // 30000

        arr = new int[]{10, 20, 30};
        System.out.println("Minimum number of multiplications is - " + ref.mcmRecursive(arr, 1, arr.length - 1)); // 6000

    }

    private static void mcmDPTopDown() {

        MatrixChainMultiplication ref = new MatrixChainMultiplication();

        int[] arr = {40, 20, 30, 10, 30};
        System.out.println("Minimum number of multiplications is - " + ref.mcmMemoization(arr, 1, arr.length - 1)); // 26000

        arr = new int[]{10, 20, 30, 40, 30};
        System.out.println("Minimum number of multiplications is - " + ref.mcmMemoization(arr, 1, arr.length - 1)); // 30000

        arr = new int[]{10, 20, 30};
        System.out.println("Minimum number of multiplications is - " + ref.mcmMemoization(arr, 1, arr.length - 1)); // 6000
    }

    private static void mcmDPBottomUp() {

        MatrixChainMultiplication ref = new MatrixChainMultiplication();

        int[] arr = {40, 20, 30, 10, 30};
        System.out.println("Minimum number of multiplications is - " + ref.mcmTabulation(arr)); // 26000

        arr = new int[]{10, 20, 30, 40, 30};
        System.out.println("Minimum number of multiplications is - " + ref.mcmTabulation(arr)); // 30000

        arr = new int[]{10, 20, 30};
        System.out.println("Minimum number of multiplications is - " + ref.mcmTabulation(arr)); // 6000
    }


    private int mcmRecursive(int[] intArr, int left, int right) {

        if (left >= right)
            return 0;

        int minCost = Integer.MAX_VALUE;

        for (int k = left; k < right; k++) {
            int currCost = mcmRecursive(intArr, left, k) // left
                    + mcmRecursive(intArr, k + 1, right) // right
                    + intArr[left - 1] * intArr[k] * intArr[right]; // current cost

            if (currCost < minCost)
                minCost = currCost;
        }

        // Return minimum count
        return minCost;
    }




    /*
     *	Dynamic Programming Solution
     *	Following is the implementation of the Matrix Chain Multiplication problem using Dynamic Programming Memoization
    * */
    private int mcmMemoization(int[] intArr, int left, int right) {

        if (left >= right)
            return 0;

        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        int minCost = Integer.MAX_VALUE;

        for (int k = left; k < right; k++) {
            int currCost = mcmMemoization(intArr, left, k) // left
                    + mcmMemoization(intArr, k + 1, right) // right
                    + intArr[left - 1] * intArr[k] * intArr[right]; // current cost

            if (currCost < minCost)
                minCost = currCost;
        }

        // Return minimum count
        return dp[left][right] = minCost;
    }


    /*
     *	Dynamic Programming Solution
     *	Following is the implementation of the Matrix Chain Multiplication problem using Dynamic Programming Tabulation
     * code - https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
     * Explain - https://www.youtube.com/watch?v=eTL-lqbBbEw&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=42&ab_channel=TECHDOSE
     * */
    private int mcmTabulation(int[] intArr ) {

        int len = intArr.length;

        /* For simplicity of the
        program, one extra row and
        one extra column are allocated in m[][].  0th row
        and 0th column of m[][] are not used */
        int[][] m = new int[len][len];

        int i, j, k, L, q;

        /* m[i, j] = Minimum number of scalar
        multiplications needed to compute the matrix
        A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */

        // cost is zero when multiplying one matrix.
        for (i = 1; i < len; i++)
            m[i][i] = 0;

        // L is chain length.
        for (L = 2; L < len; L++)
        {
            for (i = 1; i < len - L + 1; i++)
            {
                j = i + L - 1;
                if (j == len)
                    continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k + 1][j]
                            + intArr[i - 1] * intArr[k] * intArr[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][len - 1];
    }


}
