package com.nishchay.core.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

    public static void main(String[] args) {

       hashMapPutEx();
        System.out.println("-----------------");
        hashMapNullPut();
        System.out.println("-----------------");
        hashMapStringPut();
        System.out.println("-----------------");
        treeMapExForSingleNullPut();
    }

    private static void hashMapPutEx() {

        Map<String, Integer> hashMap = new HashMap<>();

        // put as add
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        System.out.println("hashMap = " + hashMap);

        // put as update
        Integer old1 = hashMap.put("one", 100);
        Integer old2 = hashMap.put("two", 200);
        System.out.println("old1 = " + old1 + ", old2 = " + old2);
        System.out.println("hashMap = " + hashMap);

    }

    private static void hashMapNullPut() {

        Map<String, Integer> map = new HashMap<>();

        // null as key -  only one null can be there as a key
        // all subsequent put with null as a key, will be overridden
        map.put(null, 1);
        map.put(null, 2);
        map.put(null, 3);

        map.put("a", 10);
        map.put("b", 20);

        // null as value
        map.put("c", null);
        map.put("d", null);
        map.put("e", null);

        // hashMap printing logic

        System.out.println("map = " + map);

/*        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }*/

//        map.forEach((key, value) -> System.out.println(key + "-> " + value));

    }

    private static void hashMapStringPut() {
        String str1 = "java";
        String str2 = new String("java");
        Map<String, Integer> map = new HashMap<>();
        map.put(str1,10);
        map.put(str2,20);
        map.put(str2.intern(),30);
        System.out.println("size - " + map.size());

        String str3 = new String("java");
        System.out.println(map.get(str3));
        System.out.println(map.get(str3.intern()));
    }

    private static void treeMapExForSingleNullPut() {

        Map<String, Integer> treeMap =  new TreeMap<>();
        treeMap.put(null, 100);
//        treeMap.put("20", 100);
        System.out.println("treeMap = " + treeMap);

    }

}
