package com.nishchay.ds.array.water;

import java.util.Stack;

/*
 *	=========== Largest Rectangular Area in a Histogram ===========
 *
 *
 *
 * Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars.
 * For simplicity, assume that all bars have same width and the width is 1 unit.
 *
 *
 *	For Example
 *	Cconsider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 1, 6}. The largest possible rectangle possible is 12
 *
 *		Explanation: The numbers 1 , 3 and 6 appears more
 *		than once in the array.
 *
 *		Input :  int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
 *		Output:  Maximum area is 12
 *
 *
 *
 * https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * https://www.youtube.com/watch?v=vcv3REtIvEo
 * https://www.danielleskosky.com/largest-rectangle-in-histogram/
 * TODO - https://medium.com/techtofreedom/algorithms-for-interview-2-monotonic-stack-462251689da8
 *
 * */
public class LargestRectangleArea {

    public static void main(String[] args) {

//        int[] hist = {2, 4, 8, 10, 8, 4, 2}; //12
        int[] hist = {2, 1, 5, 2, 1, 3}; //6
        //        int[] hist = {2, 4, 8, 10, 8, 4, 2}; // 24
        System.out.println("Maximum area is " + largestRectangleArea1(hist));


//        int[] input = {6, 2, 5, 4, 5, 1, 6};
//        System.out.println("Max rectangle area: " + largestRectangleArea(input));
    }

    /*
     * Time Complexity: O(n2).
     * Space Complexity: O(1).
     * */
    private static int largestRectangleArea_bruteForce(int[] heights) {
        int maxArea = 0;
        int length = heights.length;
        for (int i = 0; i < length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
    /*
     * Scan from left to right to compute left[], which represents the left most boundary of current height.
     * Scan from right to left to compute right[], which represents the right most boundary of current height.
     * Scan from left to right again to compute rectangle area based on the height of that each position.
     *
     * Time Complexity: O(n).
     * Space Complexity: O(n).
    * */
    private static int largestRectangleArea1(int[] heights) {
        // validate input
        if(heights == null || heights.length == 0) {
            return 0;
        }

        // init
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int result = 0;

        // build left
        left[0] = 0;
        for(int i = 1; i < n; i++) {
            int currentLeft = i-1;
            while(currentLeft >= 0 && heights[currentLeft] >= heights[i]) {
                currentLeft = left[currentLeft]-1;
            }

            left[i] = currentLeft+1;
        }

        // build right
        right[n-1] = n-1;
        for(int i = n-2; i >= 0; i--) {
            int currentRight = i+1;
            while(currentRight < n && heights[i] <= heights[currentRight]) {
                currentRight = right[currentRight]+1;
            }

            right[i] = currentRight-1;
        }

        // compare height
        for(int i = 0; i < n; i++) {
            result = Math.max(result, (right[i]-left[i]+1)*heights[i]);
        }

        // return
        return result;
    }

    /*
     * Using Stack
     *
     * Step 1 : First we will take two arrays left_smaller[] and right_smaller[] and initialize it with -1 and n respectively.
     *
     * Step 2 : For every element we will store
     * 		the index of previous smaller and next smaller element in left_smaller[] and right_smaller[] arrays respectively.
     * 		(It will take O(n) time).
     *
     * Step 3 : Now for every element we will calculate area
     * 		int height = heights[i];
     * 		int length = right_smaller[i] - left_smaller[i] + 1
     * 		ith area = height * length; // currArea
     * Step 4 : We can find the maximum of all the area calculated in step 3 to get the desired maximum area.
     *
     *
     * Time Complexity: O(n2).
     * Space Complexity: O(1).
     * */
    public static int largestRectangleArea(int[] heights) {
        int arraySize = heights.length;
        int[] left_smaller = new int[arraySize];
        int[] right_smaller = new int[arraySize];
        Stack<Integer> stack = new Stack<>();

        // filling out left_smaller array
        for (int i = 0; i < arraySize; i++) {
            if (stack.isEmpty()) {
                left_smaller[i] = 0;
            } else {
                while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                left_smaller[i] = stack.empty() ? 0 : stack.peek() + 1;
            }
            stack.push(i);
        }

        stack.clear();

        // filling out right_smaller array
        for (int i = arraySize - 1; i >= 0; i--) {
            if (stack.empty()) {
                right_smaller[i] = arraySize - 1;
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                right_smaller[i] = stack.isEmpty() ? arraySize - 1 : stack.peek() - 1;
            }
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < arraySize; i++) {
            int area = heights[i] * (right_smaller[i] - left_smaller[i] + 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

}
