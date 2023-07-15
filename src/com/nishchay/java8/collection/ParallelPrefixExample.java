package com.nishchay.java8.collection;

import java.util.Arrays;


/*
 *============== Arrays.parallelPrefix() Method ====================
 *
 *  The parallelPrefix method performs a given mathematical function on the elements of the array cumulatively, and then modifies the array concurrently.
 *
 *  performs operations on array elements with a current element and a previous element.
 *  more efficient than the loop when we need to perform operations on the whole array
 *
 *
 *	Why should we use parallelPrefix() when we can do it sequentially ?
 *		1. Parallel operations are much faster on larger size arrays, but it usually depends on the Machine.
 *		2. We use lambda while performing a parallel operation which reduces the number of lines in the code, making it more elegant and readable
 *
 *
 * https://www.geeksforgeeks.org/java-util-arrays-parallelprefix-java-8/
 * https://stackoverflow.com/questions/52961981/how-does-newly-introduced-arrays-parallelprefix-in-java-8-work
 *
 * */

public class ParallelPrefixExample {

    public static void main(String[] args) {

        basicEx();

    }

    private static void basicEx() {

        int[] arr = {2, 1, 7, 8, 4,};
        System.out.println("original array = " + Arrays.toString(arr));

        // applying mathematical function - multiply on the elements of the array cumulatively
        Arrays.parallelPrefix(arr, ParallelPrefixExample::multiply);
        System.out.println("arr = " + Arrays.toString(arr));

        // applying mathematical function - addition on the elements of the array cumulatively
        Arrays.parallelPrefix(arr, Integer::sum);
        System.out.println("applying  = " + Arrays.toString(arr));

    }

    static int multiply(int x, int y) {
        return x * y;
    }


}