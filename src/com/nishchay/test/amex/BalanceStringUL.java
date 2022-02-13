package com.nishchay.test.amex;

import java.util.HashSet;
import java.util.Set;

public class BalanceStringUL {

    public static void main(String[] args) {

        String str = "CATattac";
        if(isBalance(str)){
            System.out.println("Balance String length - " + str.length());
        }

        str = "Madam";
        if(isBalance(str)){
            System.out.println("Balance String length - " + str.length());
        }
    }

    private static boolean isBalance(String str) {
        Set<Character> hashSet =  new HashSet<>();
        char[] chatArray = str.toCharArray();

        for (char curr : chatArray ) {
            hashSet.add(curr);
        }

        for (int i = 0; i < chatArray.length;i++ ) {
            if( Character.isUpperCase(chatArray[i]) && !hashSet.contains(Character.toLowerCase(chatArray[i])))
                return false;
        }
        return true;
    }
}
