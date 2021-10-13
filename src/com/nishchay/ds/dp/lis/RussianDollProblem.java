package com.nishchay.ds.dp.lis;

import java.util.Arrays;

/*
 *	Russian Doll Problem
 *	Number of visible dolls after putting all the smaller one in to big one
 *	But only one stacking is allowed
 *
 *	Example
 *		arr [] = {2, 3, 2, 3}
 *		Ans => 2->3 & 2 & 3 : 1 + 1 + 1= 3
 *
 *		arr [] = {1, 2, 2, 8, 6, 4, 5}
 *		Ans => 1 -> 2 -> 4 -> 5 -> 6 -> 8 & 2 : 1 + 1 = 2
* */
public class RussianDollProblem {

    public static void main(String[] args) {

        int[] dolls = new int[]{2, 3, 2, 3};
        System.out.println("Length of lis is - " + dollStack(dolls)); //3

        dolls = new int[]{1, 2, 2, 8, 6, 4, 5};
        System.out.println("Length of lis is - " + dollStack(dolls)); //2

    }

    private static int dollStack(int[] arr) {

        Arrays.sort(arr);
        // get lis count
        LongestIncreasingSubsequence ref = new LongestIncreasingSubsequence();
        int stackDollCount = ref.lisBasic(arr);

        int restDoll = arr.length - stackDollCount;

        return restDoll + 1;
    }
}
