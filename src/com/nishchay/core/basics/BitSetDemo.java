package com.nishchay.core.basics;

import java.util.BitSet;

/*
* https://www.geeksforgeeks.org/bitset-class-java-set-1/
* */
public class BitSetDemo {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet(5);

        for (int i = 0; i < 5; i++) {
            bitSet.set(i);
        }
        System.out.println("bitSet = " + bitSet);
        bitSet.clear(2);
        System.out.println("bitSet = " + bitSet);
    }
}
