package com.nishchay.ds.bit;


/*
 *	Count set bits in an integer
 *
 *	Write an efficient program to count the number of 1s in the binary representation of an integer.
 *
 *	Examples :
 *
 *		Input : n = 6
 *		Output : 2
 *		Binary representation of 6 is 110 and has 2 set bits
 *
 *		Input : n = 13
 *		Output : 3
 *		Binary representation of 13 is 1101 and has 3 set bits
 *
* */
public class CountSetBitsInNumber {

    public static void main(String[] args) {

        System.out.println("countSetBits(9) - " + countSetBits(9)); //2
        System.out.println("countSetBits(6) - " + countSetBits(6)); //2
        System.out.println("countSetBits(13) - " + countSetBits(13)); //3
        System.out.println("countSetBits(15) - " + countSetBits(15)); //4

    }



    /* Function to get no of set bits in binary representuhation of positive integer n */
    private static int countSetBits(int n) {
        int count = 0;
        int currBit = 0;
        while (n > 0) {
            currBit = n & 1;
            count = currBit + count;
            n = n >> 1;

        }
        return count;
    }

}
