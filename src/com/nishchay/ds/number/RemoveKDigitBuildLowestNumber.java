package com.nishchay.ds.number;

import java.util.Stack;

/*
 *	===========Remove K digits | Build lowest number | Leetcode #402===========
 *
 * Given a string ‘str’ of digits and an integer ‘n’, build the lowest possible number by removing ‘k’ digits from the string
 * and not changing the order of input digits.
 *
 *
 * Examples :
 * 			Input: str = "4325043", n = 3
 * 			Output: "2043"
 *
 * 			Input: str = "765028321", n = 5
 * 			Output: "0221"
 *
 * 			Input: str = "121198", n = 2
 * 			Output: "1118"
 *
 * https://www.geeksforgeeks.org/build-lowest-number-by-removing-n-digits-from-a-given-number/
 * https://www.youtube.com/watch?v=3QJzHqNAEXs
 *
 * */
public class RemoveKDigitBuildLowestNumber {

    public static void main(String[] args) {

        System.out.println("removeKDigits(\"765028321\", 5) - " + removeKDigits("765028321", 5));
        System.out.println("removeKDigits(\"372181\", 2) - " + removeKDigits("372181", 2));
        System.out.println("removeKDigits(\"1001\", 2) - " + removeKDigits("1001", 2));
        System.out.println("removeKDigits(\"1234\", 1) - " + removeKDigits("1234", 1));
        System.out.println("removeKDigits(\"14301620\", 4) - " + removeKDigits("14301620", 4));
        System.out.println("removeKDigits(\"1230987\", 2) - " + removeKDigits("1230987", 2)); //10987
        System.out.println("removeKDigits(\"1230987\", 3) - " + removeKDigits("1230987", 3)); //987

    }

    /*
    * case 1 : 5421 -> simply remove from the stack top
    * case 2 : in mix digit scenario
    *           without 0 - look for pick fall, remove element from the stack , till its greater than
    *           with 0 - skip 0 to push , apply logic to remove from stack based on pick fall
    *
    *  Time complexity: O(N)
    *  Space complexity: O(N)
    *
    * */
    private static String removeKDigits(String num, int k) {

        // We have to delete all digits
        if (k >= num.length()) {
            return "0";
        }
        // Nothing to delete
        if (k == 0) {
            return num;
        }

        StringBuilder result = new StringBuilder();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            // Removing all digits in stack that are greater
            // tha this digit(since they have higher weightage)
            while (!s.isEmpty() && k > 0 && s.peek() > c) {
                s.pop();
                k--;
            }
            // ignore pushing 0
            if (!s.isEmpty() || c != '0')
                s.push(c);
        }

        // If our k isn't 0 yet then we keep poping out the stack until k becomes 0
        // 8751 ->K-2 -> 51
        while (!s.isEmpty() && k > 0) {
            k--;
            s.pop();
        }
        if (s.isEmpty())
            return "0";

        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        String resultantNo = result.reverse().toString();

        return resultantNo;
    }


}
