package com.nishchay.ds.bit.basic;

public class BitwiseAlgorithms {

    public static void main(String[] args) {

        isPowerOf2Ex();
        System.out.println("---------------------------");
        isOddIsEvenEx();
        System.out.println("---------------------------");
        isKthBitSetEx();

    }

    private static void isPowerOf2Ex() {
        System.out.println("isPowerOf2(128) = " + isPowerOf2(128));
        System.out.println("isPowerOf2(4) = " + isPowerOf2(4));
        System.out.println("isPowerOf2(8) = " + isPowerOf2(8));
        System.out.println("isPowerOf2(65) = " + isPowerOf2(65));
        System.out.println("isPowerOf2(9) = " + isPowerOf2(9));
        System.out.println("isPowerOf2(2) = " + isPowerOf2(2));
        System.out.println("isPowerOf2(256) = " + isPowerOf2(256));
    }

    private static void isOddIsEvenEx() {
        System.out.println("isEven(128) = " + isEven(128));
        System.out.println("isEven(4) = " + isEven(4));
        System.out.println("isEven(8) = " + isEven(8));
        System.out.println("isOdd(65) = " + isOdd(65));
        System.out.println("isOdd(9) = " + isOdd(9));
        System.out.println("isOdd(21) = " + isOdd(21));
        System.out.println("isOdd(13) = " + isOdd(13));
    }

    private static void isKthBitSetEx() {
        System.out.println("isKthBitSet(9,4) = " + isKthBitSet(9, 4)); // true
        System.out.println("isKthBitSet(17,5) = " + isKthBitSet(17, 5)); // true
        System.out.println("isKthBitSet(52,3) = " + isKthBitSet(52, 3)); // true
        System.out.println("isKthBitSet(52,4) = " + isKthBitSet(52, 4)); // false
    }

    private static boolean isPowerOf2(int num) {
        int result = num & (num - 1);

        return 0 == result;
    }

    private static boolean isOdd(int num) {
        int result = num & 1;

        return 1 == result;
    }

    private static boolean isEven(int num) {
        int result = num & 1;
        return 0 == result;
    }

    private static boolean isKthBitSet(int num, int k) {
        int result = num & (1 << k);
        return 0 == result;
    }

}
