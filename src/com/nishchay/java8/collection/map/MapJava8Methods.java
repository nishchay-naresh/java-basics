package com.nishchay.java8.collection.map;

import java.util.HashMap;
import java.util.Map;

/*
 *  https://www.geeksforgeeks.org/hashmap-putifabsentkey-value-method-in-java-with-examples/
 *  https://www.geeksforgeeks.org/hashmap-computeifabsent-method-in-java-with-examples/
 *  https://stackoverflow.com/questions/48183999/what-is-the-difference-between-putifabsent-and-computeifabsent-in-java-8-map
 *
 * */
public class MapJava8Methods {

    public static void main(String[] args) {

        putIfAbsentDemo();
        computeIfAbsentDemo();
        putIfAbsentVsComputeIfAbsent();

    }

    /*
    * Return - returns null (if there was no mapping) else mapped value
    * */
    private static void putIfAbsentDemo() {
        System.out.println("---------------------putIfAbsentDemo----------------------");
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("key1", 100);
        hashMap.put("key2", 200);

        System.out.println(hashMap.putIfAbsent("key2", 500)); // 200
        System.out.println(hashMap.putIfAbsent("key5", 500)); // null

        System.out.println(hashMap.putIfAbsent("key4", 100 * 2 + 150 + 50)); // null
        if(400 == hashMap.putIfAbsent("key4", 0)){
            System.out.println(hashMap.putIfAbsent("key3", hashMap.get("key4") - 100)); // null
        }

        System.out.println("hashMap = " + hashMap);
    }

    /*
     * Return - returns the current (existing or computed) value associated with the specified key
     * */
    private static void computeIfAbsentDemo() {
        System.out.println("---------------------computeIfAbsentDemo----------------------");

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("key1", 100);
        hashMap.put("key2", 200);

        System.out.println(hashMap.computeIfAbsent("key2", MapJava8Methods::get500));//200 current value
        System.out.println(hashMap.computeIfAbsent("key5", MapJava8Methods::get500));//500 computed value
        System.out.println(hashMap.computeIfAbsent("key10", MapJava8Methods::get1000));//1000 computed value

        System.out.println("hashMap = " + hashMap);
    }

    private static Integer get500(String strKey) {
        if(strKey.equals("key5")){
            return 500;
        }
        return 0;
    }

    private static Integer get1000(String strKey) {
        if(strKey.equals("key10")){
            return 1000;
        }
        return null;
    }

    /*
    * some how closer to Optional.orElse() vs Optional.orElseGet()
    * */
    private static void putIfAbsentVsComputeIfAbsent() {

        System.out.println("---------------------putIfAbsentVsComputeIfAbsent----------------------");

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("key1", 100);
        hashMap.put("key2", 200);

        /*
         *	Difference #1
         *	putIfAbsent - takes the value directly
         *	computeIfAbsent - takes a mapping function, that is called to obtain the value
         * */
        hashMap.put("key3", 300);
        hashMap.computeIfAbsent("key5", MapJava8Methods::get500);

        /*
         *	Difference #2
         *	putIfAbsent - returns null (if there was no mapping) else mapped value
         *	computeIfAbsent - returns the current (existing or computed) value associated with the specified key
         * */
        System.out.println(hashMap.putIfAbsent("key5", 0)); // 500
        System.out.println(hashMap.computeIfAbsent("key10", MapJava8Methods::get1000));//1000 computed value

        /*
         * Difference #3
         * putIfAbsent - will put the value if the key is absent, even if the value is null.
         * computeIfAbsent - will not put a null value if the key is absent.
         * */

        System.out.println(hashMap.putIfAbsent("key4", null)); // null
        System.out.println(hashMap.computeIfAbsent("key11", MapJava8Methods::get1000));//null computed value

        System.out.println("hashMap = " + hashMap);
        //hashMap = {key1=100, key2=200, key5=500, key3=300, key4=null, key10=1000}
    }

}
