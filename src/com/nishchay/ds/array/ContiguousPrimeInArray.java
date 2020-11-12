package com.nishchay.ds.array;

public class ContiguousPrimeInArray {

    public static void main(String[] args) {

        int arr[] = {8, 4, 2, 1, 3, 5, 7, 9, 12, 11, 21 , 5, 19, 17, 83, 79, 12};
//        int arr[] = {8, 4, 2, 1, 3, 5, 7, 9, 12};
        System.out.println("Maximum no. of contiguous Prime Numbers in an array:  " + primeSubarrayCount(arr));

    }

    private static int primeSubarrayCount(int[] intArr) {
        int maxCountSoFar, currentCount;
        maxCountSoFar = currentCount = 0;
        for (int i = 0; i < intArr.length; i++) {
            if (isPrime(intArr[i])) {
                currentCount++;
                maxCountSoFar = currentCount > maxCountSoFar ? currentCount : maxCountSoFar;
            }else {
                currentCount = 0;
            }
        }
        return maxCountSoFar;
    }

    private static boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        } else if (n <= 3) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

}
