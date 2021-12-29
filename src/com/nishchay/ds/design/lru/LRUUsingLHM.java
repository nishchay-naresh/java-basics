package com.nishchay.ds.design.lru;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUUsingLHM {


	public static void main(String[] args) {

		cacheDemo();
		genericCacheDemo();

	}

	private static void cacheDemo() {

//		using a cache of - <String, String>
		final int SIZE = 3;

		LinkedHashMap<String, String> fruitCache = new LinkedHashMap<String, String>(SIZE, .75F, true) {
			@Override
			protected boolean removeEldestEntry(Entry<String, String> eldest) {
				return size() > SIZE;
			}
		};

		fruitCache.put("o", "orange");
		fruitCache.put("a", "apple");
		fruitCache.put("m", "mango");
		System.out.println("fruitCache = " + fruitCache);
		fruitCache.get("o");
		System.out.println("fruitCache = " + fruitCache);
		fruitCache.put("p", "plum");
		System.out.println("fruitCache = " + fruitCache);
		fruitCache.put("m", "mango1");
		System.out.println("fruitCache = " + fruitCache);
		fruitCache.put("c", "carrot");
		System.out.println("fruitCache = " + fruitCache);
		fruitCache.put("b", "banana");
		System.out.println("fruitCache = " + fruitCache);

	}


	private static void genericCacheDemo() {

		//		using a cache of - <Integer, String>
		LRUCacheImpl<Integer, String> lruCache = new LRUCacheImpl<>(3, 0.75f);

		lruCache.put(1, "Object1");
		lruCache.put(2, "Object2");
		lruCache.put(3, "Object3");
		System.out.println("lruCache = " + lruCache);
		lruCache.get(1);
		System.out.println("lruCache = " + lruCache);
		lruCache.put(4, "Object4");
		System.out.println("lruCache = " + lruCache);
		lruCache.put(5, "Object5");
		System.out.println("lruCache = " + lruCache);
		lruCache.get(3);
		lruCache.put(6, "Object6");
		System.out.println("lruCache = " + lruCache);
		lruCache.get(4);
		lruCache.put(7, "Object7");
		lruCache.put(1, "Object10");
		System.out.println("lruCache = " + lruCache);

	}
}


class LRUCacheImpl<K,V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = 1L;
	private int capacity;

	public LRUCacheImpl(int capacity, float loadFactor){
		super(capacity, loadFactor, true);
		this.capacity = capacity;
	}

	/**
	 * removeEldestEntry() should be overridden by the user,
	 * to implement the eviction policy which LRU here
	 */
	@Override
	protected boolean removeEldestEntry(Entry<K, V> eldest){
		return size() > this.capacity;
	}
}

/*
 *	O/P =>
 *		fruitCache = {o=orange, a=apple, m=mango}
 *		fruitCache = {a=apple, m=mango, o=orange}
 *		fruitCache = {m=mango, o=orange, p=plum}
 *		fruitCache = {o=orange, p=plum, m=mango1}
 *		fruitCache = {p=plum, m=mango1, c=carrot}
 *		fruitCache = {m=mango1, c=carrot, b=banana}
 *
 * ----------------
 *
 *	lruCache = {1=Object1, 2=Object2, 3=Object3}
 *	lruCache = {2=Object2, 3=Object3, 1=Object1}
 *	lruCache = {3=Object3, 1=Object1, 4=Object4}
 *	lruCache = {1=Object1, 4=Object4, 5=Object5}
 *	lruCache = {4=Object4, 5=Object5, 6=Object6}
 *	lruCache = {4=Object4, 7=Object7, 1=Object10}
 *
* */

