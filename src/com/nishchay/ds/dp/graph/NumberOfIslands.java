package com.nishchay.ds.dp.graph;

/*
 *	===========Number of islands===========
 *
 * Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
 * such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 *
 * Examples :
 *				Input : mat[][] = {{1, 1, 0, 0, 0},
 *				                   {0, 1, 0, 0, 1},
 *				                   {1, 0, 0, 1, 1},
 *				                   {0, 0, 0, 0, 0},
 *				                   {1, 0, 1, 0, 1}
 *				Output : 5
 *
 * What is an island?
 * A group of connected 1s forms an island. For example, the below matrix contains 4 islands
 *
 * https://www.geeksforgeeks.org/find-number-of-islands/
 * https://gist.github.com/SuryaPratapK/a494ad5194ea33ee83b343698c1fa98e
 *
 * */
public class NumberOfIslands {

    // No of rows and columns
    private static final int ROW = 5, COL = 5;

    public static void main(String[] args) {
        int[][] M = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        NumberOfIslands I = new NumberOfIslands();
        System.out.println("Number of islands is: " + I.countIslands(M));
    }

    // A function to check if a given cell (row, col) can
    // be included in DFS
    private boolean isSafe(int[][] M, int row, int col, boolean[][] visited) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    private void DFS(int[][] M, int row, int col, boolean[][] visited) {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int[] rowNbr = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNbr = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    // The main function that returns count of islands in a given
    // boolean 2D matrix
    private int countIslands(int[][] M) {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean[][] visited = new boolean[ROW][COL];

        // Initialize count as 0 and traverse through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with
                { // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(M, i, j, visited);
                    ++count;
                }

        return count;
    }

}
