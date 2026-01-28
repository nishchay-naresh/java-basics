package com.nishchay.java8.impvsdec;

import com.nishchay.util.Utils;

import java.util.stream.Stream;


public class SqrtCompute {

    public static void main(String[] args) {

        int n = 101;
        int k = 51;
        System.out.println(sqrtImperative(n, k));    // 770.34339268981
        System.out.println(sqrtDeclarative(n, k));   // 770.3433926898098

    }

    //Find the total Of sqrt Of first k primes starting with n
    public static double sqrtImperative(int n, int k) {
        double result = 0;
        int index = n;
        int count = 0;
        while (count < k) {
            if (Utils.isPrimeStream(index)) {
                result += Math.sqrt(index);
                count++;
            }
            index++;
        }
        return result;
    }

    public static double sqrtDeclarative(int n, int k) {
        return Stream.iterate(n, e -> e + 1)
                .filter(Utils::isPrimeStream)
                .mapToDouble(Math::sqrt)
                .limit(k)
                .sum();

    }
}
