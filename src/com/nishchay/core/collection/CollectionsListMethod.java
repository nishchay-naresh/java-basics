package com.nishchay.core.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// public static void swap(List<?> list, int i, int j)
public class CollectionsListMethod {

    public static void main(String[] args) {

        listDemo();

    }


    private static void listDemo() {

        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        System.out.println(list);
        Collections.swap(list, 1, 2);
        System.out.println(list);

    }

}

