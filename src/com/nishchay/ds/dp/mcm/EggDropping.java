package com.nishchay.ds.dp.mcm;

/*
 *	===========Egg Dropping Problem===========
 *
 * You are given F floor and E eggs.
 * You have to minimize the number of times you have to drop the eggs to find the critical floor
 * where critical floor means the floor beyond which eggs start to break.
 *
 * Assumptions of the problem:
 * 	a. If egg breaks at ith floor then it also breaks at all greater floors.
 * 	b. If egg does not break at ith floor then it does not break at all lower floors.
 * 	c. Unbroken egg can be used again.
 * Note: You have to find minimum trials required to find the critical floor not the critical floor.
 *
 *  1 <= F <= 1000
 *  1 <= E <= 100
 *
 * Examples :
 *		   Input:
 *		    10
 *		    2
 *
 *		    Output:
 *		    Number of trials  : 4
 *
 *		    Input:
 *		    36
 *		    2
 *
 *		    Output:
 *		    Number of trials : 8
 *
 * https://www.includehelp.com/algorithms/egg-dropping-problem-using-dynamic-programming.aspx
 * https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
 *
 * */
public class EggDropping {

    public static void main(String[] args) {

        System.out.println("------------Recursion-------------");
        eggDropRecursionEx();
        System.out.println("------------BottomUp-------------");
        eggDropDPBottomUp();

    }

    private static void eggDropRecursionEx() {

        EggDropping ref = new EggDropping();

        int f = 10; // floor
        int e = 2;   // egg
        System.out.println("Minimum number of trials in worst case with "
                + e + " eggs and " + f + " floors is - " + ref.eggDropRecursive(e, f)); // 4

        f = 4; // floor
        e = 2;   // egg
        System.out.println("Minimum number of trials in worst case with "
                + e + " eggs and " + f + " floors is - " + ref.eggDropRecursive(e, f)); //3

/*
       f = 36; // floor
        e = 2;   // egg
        System.out.println("Minimum number of trials in worst case with "
                + e + " eggs and " + f + " floors is - " + ref.eggDropRecursive(e, f)); //8
*/

    }


    private static void eggDropDPBottomUp() {

        EggDropping ref = new EggDropping();

        int f = 10; // floor
        int e = 2;   // egg
        System.out.println("Minimum number of trials in worst case with "
                + e + " eggs and " + f + " floors is - " + ref.eggDropDP(e, f)); // 4

        f = 4; // floor
        e = 2;   // egg
        System.out.println("Minimum number of trials in worst case with "
                + e + " eggs and " + f + " floors is - " + ref.eggDropDP(e, f)); //3


        f = 36; // floor
        e = 2;   // egg
        System.out.println("Minimum number of trials in worst case with "
                + e + " eggs and " + f + " floors is - " + ref.eggDropDP(e, f)); //8

    }


    private int eggDropRecursive(int e, int f) {

        // If there are no floors, then no trials needed. OR
        // if there is one floor, one trial needed.
        if (f == 1 || f == 0)
            return f;

        // We need f trials for one egg and f floors - worst case scenario
        if (e == 1)
            return f;

        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= f; k++) {
            // doing 1 + max bcus taking reading for the worst case scenario of sub-problem
            int curr = 1 + Math.max(eggDropRecursive(e - 1, k - 1),
                    eggDropRecursive(e, f - k));
            min = Math.min(min, curr);
        }

        return min;
    }

    /*
     * DP - BottomUp Approach
     *
     * Formally for filling DP[i][j] state where ‘i’ is the number of eggs and ‘j’ is the number of floors:
     * We have to traverse for each floor ‘x’ from ‘1’ to ‘j’ and find minimum of:
     *
     * 	DP[i][j] = (1 + max( DP[i-1][j-1], DP[i][j-x] )).
     *
     * */
    private int eggDropDP(int e, int f) {


        int[][] dp = new int[e + 1][f + 1];
        int res;


        // We need one trial for one floor and
        // 0 trials for 0 floors
        for (int i = 1; i <= e; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        // We always need j trials for one egg
        // and j floors.
        for (int j = 1; j <= f; j++)
            dp[1][j] = j;


        // Fill rest of the entries in table using
        // optimal substructure property
        for (int i = 2; i <= e; i++) {
            for (int j = 2; j <= f; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = 1; k <= j; k++) {
                    res = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
                    if (res < dp[i][j])
                        dp[i][j] = res;
                }
            }
        }

        return dp[e][f];
    }


}
