package com.nishchay.ds.array;

import java.util.HashSet;

/*
* leetcode-128. Longest Consecutive Sequence
* Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
* You must write an algorithm that runs in O(n) time.
*
* Input: nums = [102,4,100,1,101,3,2]
* Output: 4
* Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*
* */

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 8, 10, 4, 11, 2};
//        int[] arr = {102,4,100,1,101,3,2};
        System.out.println("LongestConsecutiveSequence Length - " + findLongestConsecutiveSeq(arr));
    }


    /*
    * Since need to get this done in - O(n)
    * collected all the element a hashSet/hashTable
    *
    * We always wanted to start the sequence counting from the starting element, else we will land up with O(n*n)
    * if(currentElement - 1 is not there in hashTable) // means at the starting element of the sequence
    *   then only we will proceed with the sequence counting
    *
    * Time complexity: O(n)
    * Auxiliary space: O(n)
    *
    * */
    private static int findLongestConsecutiveSeq(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int maxCountSoFar, currentCount;
        maxCountSoFar = 0;
        int len = arr.length;

        // Hash all the array elements
        for (int i = 0; i < len; ++i)
            set.add(arr[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < len; ++i) {
            // if current element is the starting element of a sequence
            if (!set.contains(arr[i] - 1)) {
                // Then check for next elements in the sequence
                int j = arr[i];
                while (set.contains(j))
                    j++;

                currentCount = j - arr[i];
                // update optimal length if this length is more
                if (maxCountSoFar < currentCount)
                    maxCountSoFar = currentCount;
            }
        }
        return maxCountSoFar;
    }

}
