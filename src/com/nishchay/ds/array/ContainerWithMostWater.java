package com.nishchay.ds.array;


// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

    public static void main(String[] args) {

//        int[] barArray = {1,8,6,2,5,4,8,3,7};
//        int[] barArray = {1,1};
        int[] barArray = {4,3,2,1,4};
//        int[] barArray = {1,2,1};

        System.out.println("maxArea - " + maxArea(barArray));
    }

    private static int maxArea(int[] barArray) {
        int i=0;
        int j= barArray.length-1;
        int maxArea, currentArra;

        maxArea = currentArra = 0;
        while(i<j){
            currentArra = Math.min(barArray[i] , barArray[j]) * (j-i) ;
            maxArea = Math.max(maxArea, currentArra );

            if( barArray[i] < barArray[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxArea;
    }


}
