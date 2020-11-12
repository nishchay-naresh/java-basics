package com.nishchay.ds.array;

import java.util.HashSet;

public class LongestConsecutiveSubsequenceInArray {

    public static void main(String args[]) {
        int arr[] = {1, 9, 3, 10, 4, 20, 2};
        System.out.println("Length of the Longest consecutive subsequence is " + findLongestConseqSubseq(arr));
    }


    static int findLongestConseqSubseq(int arr[]) {
        HashSet<Integer> set = new HashSet<Integer>();
        int maxCountSoFar, currentCount;
        maxCountSoFar = currentCount = 0;

        // Hash all the array elements
        for (int i = 0; i < arr.length; ++i)
            set.add(arr[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < arr.length; ++i) {
            // if current element is the starting element of a sequence
            if (!set.contains(arr[i] - 1)) {
                // Then check for next elements in the sequence
                int j = arr[i];
                while (set.contains(j))
                    j++;

                currentCount = j - arr[i];
                // update  optimal length if this length is more
                if (maxCountSoFar < currentCount)
                    maxCountSoFar = currentCount;
            }
        }
        return maxCountSoFar;
    }


}
