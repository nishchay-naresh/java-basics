package com.nishchay.core.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapKeyCaseSensitiveTest {

    public static void main(String[] args) {

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("server1", "Req is coming from server1");
        hashMap.put("server2", "Req is coming from server2");

        //String key = "server1";
        String key = "Server1";

        //Soln -1
        System.out.println("HTTP Requester from hashMap - " + hashMap.get(key.toLowerCase()));

        //Soln -2
        TreeMap<String, String> treeMap = new TreeMap<>((o1, o2) -> o1.compareToIgnoreCase(o2));
        treeMap.putAll(hashMap);

        System.out.println("HTTP Requester from treeMap - " + treeMap.get(key));
    }
}
