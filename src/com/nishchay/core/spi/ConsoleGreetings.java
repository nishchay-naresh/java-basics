package com.nishchay.core.spi;

public class ConsoleGreetings implements GreetingsService {
    @Override
    public void sayHello(String name) {
        System.out.println( "Hello to " + name);
    }
}