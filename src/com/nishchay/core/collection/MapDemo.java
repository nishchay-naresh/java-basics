package com.nishchay.core.collection;

import java.util.*;
import java.util.stream.Collectors;

public class MapDemo {

    public static void main(String[] args) {

        hashMapPutEx();
        System.out.println("-----------------");
        hashMapNullPut();
        System.out.println("-----------------");
        hashMapStringPut();

        System.out.println("-----------------");
        hashMapCASOperationEx();
        System.out.println("-----------------");
        treeMapExForSingleNullPut();

        mapFromListOfEntries();
//        getEntryEx();


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
        }
*/

//        map.forEach((key, value) -> System.out.println(key + "-> " + value));

    }

    private static void hashMapStringPut() {
        String str1 = "java";
        String str2 = new String("java");
        Map<String, Integer> map = new HashMap<>();
        map.put(str1, 10);
        map.put(str2, 20);
        map.put(str2.intern(), 30);
        System.out.println("size - " + map.size());

        String str3 = new String("java");
        System.out.println(map.get(str3));
        System.out.println(map.get(str3.intern()));
    }

    private static void hashMapCASOperationEx() {

        Map<String, Integer> map = new HashMap<>();
        System.out.println(map.putIfAbsent("java", 8));// null
        System.out.println(map.putIfAbsent("java", 9));// 8
        System.out.println(map.putIfAbsent("perl", 9));// null
        System.out.println(map.put("java", 11));// 8
        System.out.println(map.get("java"));// 11

        System.out.println(map.containsKey("java"));//true
        System.out.println(map.containsKey("java1"));//false
        System.out.println(map.containsKey("perl"));//true
        System.out.println(map.size());//2

        System.out.println("------------replace--------------");
        System.out.println(map.replace("java1", 18));//null
        System.out.println(map.replace("java", 18));//11
        System.out.println(map.replace("java", 11, 20));//false
        System.out.println(map.replace("java", 18, 20));//true

        System.out.println("------------remove--------------");
        System.out.println(map.remove("java"));//20
        System.out.println(map.remove("java"));//null
        System.out.println(map.remove("perl", 9));//true
        System.out.println(map.remove("perl", 9));//false

        System.out.println("------------computeIfAbsent--------------");

        // provide value for new key which is absent using computeIfAbsent method
        map.computeIfAbsent("key6", v -> 2 + 2 * 2);
        System.out.println(map.computeIfAbsent("key6", v -> 10));
        map.computeIfAbsent("key8", v -> (13 * 13 - 35 * 3) / 8);
        System.out.println(map.computeIfAbsent("key8", v -> 20));

        System.out.println(map.get("key6"));// 6
        System.out.println(map.get("key8"));// 8

    }

    private static void treeMapExForSingleNullPut() {

        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put(null, 100);
//        treeMap.put("20", 100);
        System.out.println(treeMap.size());
    }

    // Crating a List<Map.Entry<K, V>> then again creating a HashMap<K,V> from it
    private static void mapFromListOfEntries() {

        List<Map.Entry<String, Integer>> entries = Arrays.asList(
                new AbstractMap.SimpleEntry<>("four", 4),
                new AbstractMap.SimpleImmutableEntry<>("ten", 10),
                new AbstractMap.SimpleEntry<>("five", 5),
                new AbstractMap.SimpleEntry<>("eight", 8),

                // null as a key is allowed
                new AbstractMap.SimpleEntry<>(null, 8)

                // new AbstractMap.SimpleEntry<>("unknown", null) // null as value not allowed, causing NPE
                // new AbstractMap.SimpleImmutableEntry<>("key", null) // null as value not allowed, causing NPE
        );


        Map<String, Integer> mapFromList = entries.stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("mapFromList = " + mapFromList);
    }



}
