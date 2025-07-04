package com.nishchay.java8.fun;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/*
 *	java.util.function.BiConsumer<T>	:    <T, U> -> void  :	void accept(T t, U u);
 *	T, U – Type of input argument
 *  As similar to Consumer, the Consumer accepts a generic argument and returns nothing
 *  BiConsumer represents an operation that accepts two input arguments and returns nothing.
 *
 *	@FunctionalInterface
 *	public interface BiConsumer<T, U> {
 *	  void accept(T t, U u);
 *	}
 *
 *  primitive BiConsumer : There is no primitive BiConsumer 
 *  
 *  Why there is no primitive BiConsumer in java 8?
 *
 * */

public class BiConsumerEx {

    public static void main(String[] args) {

        basicEx();
    }

    private static void basicEx() {
        
        BiConsumer<String, Integer> printConsumer = (s, i) -> System.out.println(s + ": " + i);
        printConsumer.accept("Age", 30);
        
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "Rust");
        map.put(4, "JavaScript");
        map.put(5, "Go");

        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

}
