package com.nishchay.core.spi;

/*
 *
 * https://dzone.com/articles/play-with-java-serviceloader-forget-about-dependen
 * */
public class Launcher {
    public static void main(String... args) {
        GreetingsService service = GreetingsProvider.getInstance().serviceImpl();
        service.sayHello("James");
    }
}