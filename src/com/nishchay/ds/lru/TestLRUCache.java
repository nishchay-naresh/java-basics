package com.nishchay.ds.lru;

public class TestLRUCache {

    public static void main(String[] args) {

		LRUCache lrucache = new LRUCache(4);
		lrucache.set(1, 100);
		lrucache.set(10, 99);
		lrucache.set(15, 98);
		lrucache.printCacheHM();
		lrucache.set(10, 97);
		lrucache.printCacheHM();
		lrucache.set(12, 96);
		lrucache.printCacheHM();
		lrucache.set(18, 95); // remove - Node{key=1, value=100} & add - Node{key=18, value=95}
		lrucache.printCacheHM();
		lrucache.get(15);
		lrucache.set(1, 94);// remove - Node{key=10, value=97} & add - Node{key=1, value=94}
		lrucache.printCacheHM();

		System.out.println(lrucache.get(1));
		System.out.println(lrucache.get(10));
		System.out.println(lrucache.get(15));
    }
}