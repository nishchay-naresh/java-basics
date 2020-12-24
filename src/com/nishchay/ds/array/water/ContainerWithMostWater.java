package com.nishchay.ds.array.water;


// https://leetcode.com/problems/container-with-most-water/

public class ContainerWithMostWater {

    public static void main(String[] args) {

//        int[] barArray = {1,8,6,2,5,4,8,3,7};
        int[] barArray = {1,1};
//        int[] barArray = {4, 3, 2, 1, 4};
//        int[] barArray = {1,2,1};

//        int[] barArray = {1,3,2,4,6,1}; // 1
//        int[] barArray = {1,3,2,4,6,1}; // 1
        System.out.println("maxArea - " + maxArea(barArray));
    }

    private static int maxArea(int[] barArray) {
        int i = 0;
        int j = barArray.length - 1;
        int maxArea = 0;
        int height, length, currentArra;

        while (i < j) {

            height = Math.min(barArray[i], barArray[j]);
            length = j - i;
            currentArra = height * length;
            maxArea = Math.max(maxArea, currentArra);

            if (barArray[i] < barArray[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }


}
