package com.nishchay.ds.dp.catalan;

/*
 *
 *===========Find the number of valid parentheses expressions of given length===========
 *
 * Given a number n find the number of valid parentheses expressions of that length.
 *
 * You are given a number n, representing the number of opening brackets ( and closing brackets )
 * You are required to find the number of ways in which you can arrange the brackets
 *
 * if the closing brackets should never exceed opening brackets
 *	Example -
 *		for 1, answer is 1 - ()
 *		for 2, answer is 2 - ()(), (())
 *		for 3, asnwer is 5 - ()()(), () (()), (())(), (()()), ((()))
 *
 *
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-brackets-official/ojquestion
 * https://www.geeksforgeeks.org/find-number-valid-parentheses-expressions-given-length/
 *

 * */
public class CountValidParentheses {

    public static void main(String[] args) {

        System.out.println("----------------n=4-----------------");
        int n = 4; // 14
        // recursive way
        System.out.println("Total possible Parentheses count - " +  new CatalanSeries().catalan(n));
        // dp way
        System.out.println("Total possible Parentheses count # " +  countParentheses(n));
        System.out.println("----------------n=5-----------------");
        n = 5; // 42
        // recursive way
        System.out.println("Total possible Parentheses count - " +  new CatalanSeries().catalan(n));
        // dp way
        System.out.println("Total possible Parentheses count # " +  countParentheses(n));
    }


    /*
    * Dynamic programming ways- Bottom up approach
    * */
    private static int countParentheses(int n) {

        int[] dp = new int[n+1];
        //base case
        dp[0] =  dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            int inside = i-1;
            int outside = 0;
            while(inside >= 0){
                dp[i] += dp[inside] * dp[outside];
                inside--;
                outside++;
            }
        }

        return dp[n];
    }
}
