package com.nishchay.core.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class CollectionsMethodDemo {

    public static void main(String[] args) {

        swapEx();
//        nCopiesEx();

    }


    private static void swapEx() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");
        System.out.println("At index 1 & 2 = " + list.get(1) + " " + list.get(2));
        Collections.swap(list, 1, 2);
        System.out.println("At index 1 & 2 = " + list.get(1) + " " + list.get(2));
    }




}

