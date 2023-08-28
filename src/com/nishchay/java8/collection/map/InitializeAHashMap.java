package com.nishchay.java8.collection.map;


import java.util.HashMap;
import java.util.Map;

/*
*
* https://www.baeldung.com/java-initialize-hashmap
* */
public class InitializeAHashMap {

    public static void main(String[] args) {

        doubleBraceSyntax();

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



}
