package com.nishchay.core.collection;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {

        hashMapNullPut();
    }

    private static void hashMapNullPut() {

        Map<Integer, String> map = new HashMap<>();
        map.put(11, "audi");
        map.put(null, "bmw");
        map.put(12, null);
        map.put(null, null);

//        System.out.println("map = " + map);

/*
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
*/

        map.forEach((key, value) -> System.out.println(key + "-> " + value));

    }
}
