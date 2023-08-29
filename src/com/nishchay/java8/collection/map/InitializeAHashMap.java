package com.nishchay.java8.collection.map;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
*
* https://www.baeldung.com/java-initialize-hashmap
* */
public class InitializeAHashMap {

    public static void main(String[] args) {

        doubleBraceSyntax();
        usingCollection();
//        toMap();
//        streamOfEntry();
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

}
