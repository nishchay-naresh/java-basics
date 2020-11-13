package com.nishchay.java8.basic.methodref;

import java.util.Arrays;

public class ArraysSortDemo {

    public static void main(String[] args) {

        String[] stringArray = { "Steve", "Rick", "Andy", "Nathan", "Lucy", "Simon", "Jon"};

        Arrays.sort(stringArray, String::compareToIgnoreCase);

        for(String str: stringArray){
            System.out.println(str);
        }
    }

}
