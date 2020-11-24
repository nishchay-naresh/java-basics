package com.nishchay.ds.lru;

public class TestLRUCache {

    public static void main(String[] args) {

    	cacheDemo();
    	cacheDemo1();

    }

	private static void cacheDemo() {

		//		using a cache of - <Integer, Integer>
		LRUCache<Integer,Integer> lruCache = new LRUCache<>(3);

		lruCache.put(1, 100);
		lruCache.put(10, 99);
		lruCache.put(15, 98);
		System.out.println("lruCache = " + lruCache);
		lruCache.put(10, 97);
		System.out.println("lruCache = " + lruCache);
		lruCache.put(12, 96);
		System.out.println("lruCache = " + lruCache);
		lruCache.put(18, 95); // remove - Node{key=1, value=100} & add - Node{key=18, value=95}
		System.out.println("lruCache = " + lruCache);
		lruCache.get(15);
		lruCache.put(1, 94);// remove - Node{key=10, value=97} & add - Node{key=1, value=94}
		System.out.println("lruCache = " + lruCache);

		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(10));
		System.out.println(lruCache.get(15));
	}


	private static void cacheDemo1() {

		//		using a cache of - <Integer, String>
		LRUCache<Integer,String> lruCache = new LRUCache<>(3);

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

/*
 *	O/P =>
 *
 * lruCache = LRUCache{map={1=1->100, 10=10->99, 15=15->98}}
 * lruCache = LRUCache{map={1=1->100, 10=10->97, 15=15->98}}
 * lruCache = LRUCache{map={12=12->96, 10=10->97, 15=15->98}}
 * lruCache = LRUCache{map={12=12->96, 10=10->97, 18=18->95}}
 * lruCache = LRUCache{map={12=12->96, 1=1->94, 18=18->95}}
 * 94
 * null
 * null
 * lruCache = LRUCache{map={1=1->Object1, 2=2->Object2, 3=3->Object3}}
 * lruCache = LRUCache{map={1=1->Object1, 2=2->Object2, 3=3->Object3}}
 * lruCache = LRUCache{map={4=4->Object4, 1=1->Object1, 3=3->Object3}}
 * lruCache = LRUCache{map={4=4->Object4, 1=1->Object1, 5=5->Object5}}
 * lruCache = LRUCache{map={4=4->Object4, 5=5->Object5, 6=6->Object6}}
 * lruCache = LRUCache{map={4=4->Object4, 1=1->Object10, 7=7->Object7}}
* */