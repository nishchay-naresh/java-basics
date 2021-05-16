package com.nishchay.ds.collection;

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
//        TreeMap<String, String> treeMap = new TreeMap<>((o1, o2) -> o1.compareToIgnoreCase(o2));
        TreeMap<String, String> treeMap = new TreeMap<>(String::compareToIgnoreCase);
        treeMap.putAll(hashMap);

        // Since we have pass the comparator to treeMap saying compare String by ignoring the case
        // so get will work on the same principle of ignoring the case
        System.out.println("treeMap = " + treeMap);

        System.out.println("HTTP Requester from treeMap - " + treeMap.get(key));
        System.out.println("HTTP Requester from treeMap - " + treeMap.get("SERVER1"));
        System.out.println("HTTP Requester from treeMap - " + treeMap.get("serveR1"));

    }
}
