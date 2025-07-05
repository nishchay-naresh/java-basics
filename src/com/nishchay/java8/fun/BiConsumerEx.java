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

        // basicEx();

        mdcEx();
    }

    private static void basicEx() {
        
        BiConsumer<String, Integer> printConsumer = (s, i) -> System.out.println(s + ": " + i);
        printConsumer.accept("Age", 30);
        
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "Perl");
        map.put(4, "Spring");
        map.put(5, "Go");

        map.forEach((k, v) -> System.out.println(k + ":" + v));

    }


    private static void mdcEx() {
        BiConsumerEx ref = new BiConsumerEx();
        ref.logWithMDC("message", (s, e) -> {
            System.out.println(s + ": " + e);
            System.out.println("exceuting lambda");
        }
        );

        ref.logWithMDC(new IllegalArgumentException("Exception"), (s, e) -> {
            System.out.println(s + ": " + e);
            System.out.println("exceuting lambda");
        }
        );
    }

    String name;
    Map<String, String> MDC = new LinkedHashMap<>();

    private void logWithMDC(Object message, Throwable throwable, BiConsumer<Object, Throwable> biConsumer) {

    try {
      MDC.put("SECURITY_LOGGER_NAME", name);
      String msg = (message instanceof Throwable) ? "Exception thrown" : message.toString();
      biConsumer.accept(msg, throwable);
    } finally {
      MDC.remove("SECURITY_LOGGER_NAME");
    }

  }

  private void logWithMDC(Object message, BiConsumer<Object, Throwable> biConsumer) {
    logWithMDC(message, null, (msg, t) -> biConsumer.accept(msg, null));
  }


}
