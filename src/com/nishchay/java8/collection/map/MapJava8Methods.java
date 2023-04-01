package com.nishchay.java8.collection.map;

import com.nishchay.util.pojo.Country;

import java.util.HashMap;
import java.util.Map;

/*
 *
 * ==== Additional Methods as of Java 8 ======
 *
 * Java 8 added several functional-style methods to HashMap
 *	1. forEach()
 *	2. getOrDefault()
 *	3. putIfAbsent()
 *	4. merge()
 *	5. replaceAll()
 *	6. replace(-,-)/replace(-,-,-)
 *	7. remove()
 *	8. compute()
 *	9. computeIfAbsent()
 *	10. computeIfPresent()
 *
 *
 *  https://www.programiz.com/java-programming/library/hashmap/putifabsent
 * */
public class MapJava8Methods {

    public static void main(String[] args) {


        forEachEx();
        getOrDefaultEx();
        putIfAbsentEx();
        mergeEx();
        replaceAllEx();
        replaceEx();
        putVsReplace();
        removeEx();
        computeEx();
        computeIfAbsentEx();
        computeIfPresentEx();

        putIfAbsentVsComputeIfAbsent();

    }


    private static Map<String, Country> getCountryMap() {

        Map<String, Country> hashMap = new HashMap<>();
        hashMap.put("IN", new Country("India", "INR"));
        hashMap.put("US", new Country("United States Of America", "USD"));
        hashMap.put("UK", new Country("United Kingdom", "EUR"));
        hashMap.put("AU", new Country("Australia", "AUS"));
        return hashMap;
    }

    private static void forEachEx() {
        System.out.println("---------------------forEachEx----------------------");
        //getCountryMap().forEach((key, value) -> System.out.println(key + "-> " + value));
        getCountryMap().forEach((key, country) -> System.out.println("Key:" + key + ", Value:" + country));
    }


    /*
     * getOrDefault - simple fetch
     *
     * Return - returns defaultValue (if there was no mapping) else mapped value
     * */
    private static void getOrDefaultEx() {

        System.out.println("---------------------getOrDefaultEx----------------------");

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("ten", 10);
        hashMap.put("forty", 40);
        System.out.println("Original map = " + hashMap);

        System.out.println(hashMap.getOrDefault("ten", 999)); // 10
        System.out.println(hashMap.getOrDefault("sixty", 999)); // 999
        System.out.println("Updated map = " + hashMap);

        HashMap<Integer, String> hashMap1 = new HashMap<>();

        hashMap1.put(1, "Java");
        hashMap1.put(2, "Python");
        hashMap1.put(3, "JavaScript");
        System.out.println("Original map = " + hashMap1);

        System.out.println(hashMap1.getOrDefault(1, "Not Found")); // Java
        System.out.println(hashMap1.getOrDefault(9, "Not Found")); // Not Found
        System.out.println("Updated map = " + hashMap1);
    }


    /*
     * putIfAbsent
     * inserts the specified key/value mapping to the hashmap if the specified key is absent in hashmap
     *
     * Return - returns the current value associated with the specified key or null (if there was no mapping)
     * */
    private static void putIfAbsentEx() {
        System.out.println("---------------------putIfAbsentEx----------------------");

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("key1", 100);
        hashMap.put("key2", 200);
        System.out.println("Original map = " + hashMap);

        System.out.println(hashMap.putIfAbsent("key2", 500)); // 200
        System.out.println(hashMap.putIfAbsent("key5", 500)); // null
        System.out.println("Updated map = " + hashMap);
    }


    /*
     * merge() - update exiting mapping, or remove it
     *
     * inserts the specified key/value mapping to the hashmap if the specified key is absent
     * If key is present, replaces the old value with the result of the specified function
     *
     *        V oldValue = map.get(key);
     *        V newValue = (oldValue == null) ? value : remappingFunction.apply(oldValue, value);
     *        if (newValue == null)
     *            map.remove(key);
     *        else
     *            map.put(key, newValue);
     *
     *  Return - new value / null
     * */
    private static void mergeEx() {
        System.out.println("---------------------mergeEx----------------------");
        HashMap<String, Integer> prices = new HashMap<>();

        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("Original map = " + prices);

        System.out.println("Price of Shirt: " +
                prices.merge("Shirt", 100, (oldValue, newValue) -> oldValue + newValue)); //100
        System.out.println("Price of Bag: " +
                prices.merge("Bag", 80, (oldValue, newValue) -> oldValue + newValue)); //380

        System.out.println("Updated map = " + prices);
    }

    /*
     *  replaceAll() - update all exiting mapping(only value not key) by applying function
     *                 function required both key, value to update the value
     *
     * replaces all mappings of the hashmap with the result from the specified function
     *
     *			for (Map.Entry<K, V> entry : map.entrySet())
     *				entry.setValue(function.apply(entry.getKey(), entry.getValue()));
     *
     *
     * */
    private static void replaceAllEx() {
        System.out.println("---------------------replaceAllEx----------------------");
        HashMap<Integer, String> languages = new HashMap<>();

        languages.put(1, "java");
        languages.put(2, "javascript");
        languages.put(3, "python");
        System.out.println("Original map = " + languages);

        languages.replaceAll((key, value) -> value.toUpperCase());
        System.out.println("Updated map = " + languages);

        languages.replaceAll((key, value) -> key + value.toLowerCase());
        System.out.println("Updated map = " + languages);
    }

    /*
     * replace() -  update exiting mapping with new one
     *
     * ====== default boolean replace(K key, V oldValue, V newValue) =======
     * Replaces the entry for the specified key only if currently mapped to the specified value
     *
     *
     *			if (map.containsKey(key) && Objects.equals(map.get(key), value)) {
     *				map.put(key, newValue);
     *				return true;
     *			} else {
     *				return false;
     *			}
     *
     * Return - true if the value was replaced
     *
     * ====== default boolean replace(K key, V oldValue) =======
     * Replaces the entry for the specified key only if it is currently mapped to some value
     *
     *        if (map.containsKey(key)) {
     *            return map.put(key, value);
     *        } else {
     *            return null;
     *        }
     *
     * Return - the previous value associated with the specified key, or null
     *
     * */
    private static void replaceEx() {

        System.out.println("---------------------replace(-,-,-)----------------------");
        // HashMap replace() with Old Value
        HashMap<String, String> countries = new HashMap<>();

        // insert items to the HashMap
        countries.put("Washington", "America");
        countries.put("Ottawa", "Canada");
        countries.put("Canberra", "Australia");
        System.out.println("                Countries = " + countries);

        // replace mapping {Washington -> America}
        System.out.println(countries.replace("Washington", "America", "USA"));  // true
        System.out.println(countries.replace("Canberra", "New Zealand", "Victoria"));  // false

        System.out.println("Countries after replace() = " + countries);

        System.out.println("---------------------replace(-,-)----------------------");
        HashMap<Integer, String> languages = new HashMap<>();

        languages.put(1, "Python");
        languages.put(2, "English");
        languages.put(3, "JavaScript");
        System.out.println("Original map = " + languages);

        System.out.println("Replaced Value : " + languages.replace(2, "Java"));
        System.out.println("Updated map = " + languages);
    }

    /*
     * Syntax for bth is same
     *       hashmap.put(key, value)
     *       hashmap.replace(key, value)
     *
     * when the hashmap contains the mapping for the specified key,
     *       then both the methods replace the value associated with the specified key
     *
     * However, if the hashmap does not contain any mapping for the specified key, then both method return null only
     *   -   the put() method inserts the new mapping for the specified key and value and return null
     *   -   the replace() method not doing insert and simply returns null
     *
     * */
    private static void putVsReplace() {

        HashMap<Integer, String> languages = new HashMap<>();

        // when key is absent
        System.out.println(languages.put(1, "Python"));
        System.out.println("map after put() = " + languages);
        System.out.println(languages.replace(2, "java"));
        System.out.println("map after replace() = " + languages);

        // when key is present
        System.out.println(languages.put(1, "Java"));
        System.out.println("map after put() = " + languages);
        System.out.println(languages.replace(1, "Go"));
        System.out.println("map after replace() = " + languages);
    }


    /*
     * ============= remove() with only Key ===================
     *  V remove(Object key)
     *
     *  Removes the mapping for a key from this map if it is present (optional operation)
     *
     * Returns - the previous value associated with key, or null if there was no mapping for key.
     *
     * remove(-,-) - Removes the entry for the specified key only if it is currently mapped to the specified value
     *
     *
     * ============= remove() with Key and Value ===================
     * default boolean remove(Object key, Object value)
     *
     *  Removes the entry for the specified key only if it is currently mapped to the specified value
     *
     *				if (map.containsKey(key) && Objects.equals(map.get(key), value)) {
     *					map.remove(key);
     *					return true;
     *				} else {
     *					return false;
     *				}
     *
     *  Return - true if the value was removed
     * */
    private static void removeEx() {

        System.out.println("---------------------remove(-)----------------------");
        HashMap<Integer, String> languages = new HashMap<>();

        // add mappings to HashMap
        languages.put(1, "Python");
        languages.put(2, "Go");
        languages.put(3, "Java");
        System.out.println("Languages: " + languages);

        System.out.println(languages.remove(2));  // Go
        System.out.println(languages.remove(5));  // null

        System.out.println("Updated Languages: " + languages);

        System.out.println("---------------------remove(-,-)----------------------");

        HashMap<String, String> countries = new HashMap<>();

        // insert items to the HashMap
        countries.put("Washington", "America");
        countries.put("Ottawa", "Canada");
        countries.put("Kathmandu", "Nepal");
        System.out.println("Countries: " + countries);

        System.out.println(countries.remove("Ottawa", "Canada"));  // true
        System.out.println(countries.remove("Washington", "USA")); // false

        System.out.println("Countries after remove(): " + countries);
    }

    /*
     * compute() - update, using mappingFunction to compute newValue
     * computes a new value using mappingFunction and associates it with the specified key in the hashmap
     *
     * merge() is often simpler to use for such purposes
     *
     *        V oldValue = map.get(key);
     *        V newValue = remappingFunction.apply(key, oldValue);
     *        if (oldValue != null) {
     *            if (newValue != null)
     *              map.put(key, newValue);
     *            else
     *              map.remove(key);
     *        } else {
     *            if (newValue != null)
     *               map.put(key, newValue);
     *            else
     *              return null;
     *        }
     *
     *
     * Return - the new value associated with the specified key, or null if none
     * */
    private static void computeEx() {

        System.out.println("---------------------computeEx----------------------");
        HashMap<String, Integer> prices = new HashMap<>();

        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // recompute the value of Shoes with 10% discount
        int newPrice = prices.compute("Shoes", (key, value) -> value - value * 10 / 100);
        System.out.println("Discounted Price of Shoes: " + newPrice);

        System.out.println("Updated HashMap: " + prices);

        // System.out.println(prices.compute("Shirt", (key, value) -> value + 1)); // java.lang.NullPointerException
        System.out.println(prices.compute("Shirt", (key, value) -> null));
    }

    /*
     * computeIfAbsent() - if absent, compute newValue using mappingFunction, then update it
     * computeIfAbsent() method computes a new value and associates it with the specified key if key is absent
     *
     *        if (map.get(key) == null) {
     *            V newValue = mappingFunction.apply(key);
     *            if (newValue != null)
     *                map.put(key, newValue);
     *        }
     *
     *
     * Return - the current (existing or computed) value associated with the specified key, or null if no value associated with key
     * */

    private static void computeIfAbsentEx() {
        System.out.println("---------------------computeIfAbsentEx----------------------");

        HashMap<String, Integer> prices = new HashMap<>();

        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        int shirtPrice = prices.computeIfAbsent("Shirt", key -> 280);
        System.out.println("Price of Shirt: " + shirtPrice);

        // if key is present, then computeIfAbsent() method does not compute the new value for key, simply returning old mapped value
        System.out.println(prices.computeIfAbsent("Bag", key -> 500));

        System.out.println("Updated HashMap: " + prices);
    }

    /*
     * computeIfPresent() - if present , compute newValue using mappingFunction, then update it
     * computeIfPresent() method computes a new value and associates it with the specified key if the key is already present in the hashmap
     *
     *        if (map.get(key) != null) {
     *            V oldValue = map.get(key);
     *            V newValue = remappingFunction.apply(key, oldValue);
     *            if (newValue != null)
     *                map.put(key, newValue);
     *            else
     *                map.remove(key);
     *        }
     *
     *
     * Return - the new value associated with the specified key, or null if none
     * Note: We cannot use the computeIfPresent() method if the key is not present in the hashmap.
     * */
    private static void computeIfPresentEx() {
        System.out.println("---------------------computeIfPresentEx----------------------");
        HashMap<String, Integer> prices = new HashMap<>();

        // insert entries to the HashMap
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // recompute the value of Shoes with 10% VAT
        int shoesPrice = prices.computeIfPresent("Shoes", (key, value) -> value + value * 10 / 100);
        System.out.println("Price of Shoes after VAT: " + shoesPrice);

        System.out.println("Updated HashMap: " + prices);
        System.out.println(prices.computeIfPresent("foo", (key, value) -> value + 5)); //null
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
        hashMap.putIfAbsent("key3", 300);
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

    private static Integer get500(String strKey) {
        if (strKey.equals("key5")) {
            return 500;
        }
        return 0;
    }

    private static Integer get1000(String strKey) {
        if (strKey.equals("key10")) {
            return 1000;
        }
        return null;
    }

}

/*
 * O/P =>
 * ---------------------putIfAbsentVsComputeIfAbsent----------------------
 * 500
 * 1000
 * null
 * null
 * hashMap = {key1=100, key2=200, key5=500, key3=300, key4=null, key10=1000}
 * */