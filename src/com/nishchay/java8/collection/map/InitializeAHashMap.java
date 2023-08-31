package com.nishchay.java8.collection.map;


import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
*
* https://www.baeldung.com/java-initialize-hashmap
* */
public class InitializeAHashMap {

    public static void main(String[] args) {
        doubleBraceSyntax();
        usingCollection();
        toMap();
        streamOfEntry();
    }

    /*
    *
    * ========  Problem ===========
    *  Note that we must try to avoid this initialization technique because it creates an anonymous extra class at every usage,
    *  holds hidden references to the enclosing object, and might cause memory leak issues.
    *
    * */
    private static void doubleBraceSyntax() {
        Map<String, String> doubleBraceMap  = new HashMap<String, String>() {{
            put("key1", "value1");
            put("key2", "value2");
            System.out.println("this - " + this);
        }};
        System.out.println("doubleBraceMap = " + doubleBraceMap);
    }


    /*
     *
     * ========  Using Java Collections ===========
     * Collections.singletonMap() - create a singleton immutable map with a single entry
     *                              if we try to add more entries, it'll throw UnsupportedOperationException
     *
     * Collections.emptyMap() - create an immutable empty map
     * */
    private static void usingCollection() {
        Map<String, String> singletonMap = Collections.singletonMap("username1", "password1");
        System.out.println("singletonMap = " + singletonMap);

        Map<String, String> emptyMap = Collections.emptyMap();
        System.out.println("emptyMap = " + emptyMap);
    }


    /*
     *
     * ========  Java 8 Way ===========
     *  Collectors.toMap()
     *  Stream of Map.Entry
     *
     * */
    private static void toMap() {
        Map<String, String> map1 = Stream.of(new String[][] {
                { "Hello", "World" },
                { "foo", "bar" },
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        System.out.println("map1 = " + map1);

        Map<String, Integer> map2 = Stream.of(new Object[][] {
                { "key1", 100 },
                { "key2", 200 },
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
        System.out.println("map2 = " + map2);
    }

    private static void streamOfEntry(){
        Map<String, Integer> map1 = Stream.of(
                        new AbstractMap.SimpleEntry<>("key1", 100),
                        new AbstractMap.SimpleEntry<>("key2", 200))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("map1 = " + map1);

        Map<String, Integer> map2 = Stream.of(
                        new AbstractMap.SimpleImmutableEntry<>("key1", 100),
                        new AbstractMap.SimpleImmutableEntry<>("key2", 200))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("map2 = " + map2);
    }
}
