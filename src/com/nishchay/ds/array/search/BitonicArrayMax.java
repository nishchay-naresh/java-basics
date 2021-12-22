package com.nishchay.ds.array.search;

public class BitonicArrayMax {

    // find max in bitonic array - an array whose element are increasing then decreasing

    public static void main(String[] args) {


        int[] arr;

        arr = new int[]{4, 10, 15, 20, 45, 35, 29, 17, 10}; //increasing then decreasing
        System.out.printf("max = %d%n", findMax(arr)); // 45

        arr = new int[]{4, 10, 15, 20, 45}; // only increasing
        System.out.printf("max = %d%n", findMax(arr)); // 45

        arr = new int[]{100, 85, 60, 45, 10, 5, 3}; // only decreasing
        System.out.printf("max = %d%n", findMax(arr)); // 100

        arr = new int[]{100, 200}; // only increasing
        System.out.printf("max = %d%n", findMax(arr)); // 100

        arr = new int[]{200, 100}; // only decreasing
        System.out.printf("max = %d%n", findMax(arr)); // 100

        arr = new int[]{100}; // only increasing
        System.out.printf("max = %d%n", findMax(arr)); // 100

//       int[] arr3 = new int[]{4,10,15,20,45,35,29,55,66,44,24}; // - not bitonic array, only 1 increasing and 1 decreasing shd be there


    }


    private static int findMax(int[] arr) {

        if (arr.length == 1) {
            return arr[0];
        }

        int left, right, mid, size;
        left = 0;
        right = arr.length - 1;
        size = arr.length;
        while (left <= right) {

            mid = (left + right) / 2;

            if (0 < mid && mid < size - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return arr[mid];
                } else if (arr[mid] < arr[mid + 1]) { // go right
                    left = mid + 1;
                } else{ // go left
                    right = mid - 1;
                }
            // edge case
            } else if (mid == 0) {
                return Math.max(arr[0], arr[1]);
            } else if (mid == size - 1) {
                return Math.max(arr[size - 1], arr[size - 2]);
            }
        }
        return -1;
    }
}
