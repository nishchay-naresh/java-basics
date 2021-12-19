package com.nishchay.ds.array.search;

public class BitonicArrayMax {

    // find max in bitonic array - an array whose element are increasing then decreasing

    public static void main(String[] args) {

       int[] arr = new int[]{4,10,15,20,45,35,29,17,10}; //increasing then decreasing
       int[] arr1 = new int[]{4,10,15,20,45}; // only increasing
       int[] arr2 = new int[]{4,100,99,60,45,10,5,3}; // only increasing
       int[] arr3 = new int[]{4,100}; // only increasing
//       int[] arr2 = new int[]{4,10,10,15,20,45}; // - not bitonic array
//       int[] arr3 = new int[]{4,10,15,20,45,35,29,55,66,44,24}; // - not bitonic array, only 1 increasing and 1 decreasing shd have


//        System.out.println(" res - " + findMax(arr));
//        System.out.println(" res - " + findMax(arr1));
        System.out.println(" res - " + findMax(arr3));

    }


    private static int findMax(int[] arr){
        int left, right, mid;
        left =0;
        right =arr.length-1;

        while(left <= right){

            mid = (left + right)/2;

            if(mid == 0 || mid==arr.length-1 ){
                return arr[mid];
            }if( arr[mid] > arr[mid-1]  &&  arr[mid] > arr[mid+1] ){
                return arr[mid];
            }else if(arr[mid] < arr[mid+1]){ // go right
                left = mid +1;
            }else if(arr[mid] > arr[mid+1]){ // go left
                right = mid -1;
            }

        }
        return -1;
    }
}
