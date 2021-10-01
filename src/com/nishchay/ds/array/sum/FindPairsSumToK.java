package com.nishchay.ds.array.sum;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FindPairsSumToK {

    /*
    * Given an Array of integers, return all the pairs which sum up to a specific integer.
    * [1,2,3,4,5,6] , sum=7  o/p=>  [1, 6],[2, 5],[3, 4]
    *
    *Did Following Assumption :
    * Non - Duplicate
    * Sorted
    * Non - negative
    *
    *[-5, 1, -40, 20, 6, 8, 7 ], sum=15 o/p=> [-5, 20], [7, 8]
    *
    */

    public static void main(String[] args) {

//        int[] arr =  new int[] {1,2,3,4,5,6}; int sum = 7 ;
//        int[] arr =  new int[] {1,6,2,5,3,4}; int sum = 7 ;
        int[] arr =  new int[] {-5, 1, -40, 20, 6, 8, 7 };  int sum = 15 ;

        printPairs(arr, sum);
//        printPairsFirstApproach(arr, sum);

    }

    // Test Case
    //  evaluate the output for only containing pairs
    //  output pair should only belong to input array

    // Test Cases for Main functionality
    // 1. take any random output pair -  will evaluate it against of key
    // 2. negative scenario for the above one

    //

   // time complexity - O(n)
    private static void printPairs(int[] arr, int sum){

        int curr, pair;
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        for(int i = 0; i < arr.length; i++){
            curr = arr[i];
            pair = sum - curr;
            set.remove(curr);
            if(set.contains(pair)){
                System.out.println("[" + curr + ", " + pair + "]");
            }
        }


    }


    // time complexity - O(n * n)
    private static void printPairsFirstApproach(int[] arr, int sum){

        for (int i = 0; i < arr.length-1; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] + arr[j] == sum)
                    System.out.println("[" + arr[i] + ", " + arr[j] + "]");

    }



}
