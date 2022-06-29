package com.nishchay.core.basics.exc;

public class MyAutoClosable implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("MyAutoClosable closed!");
    }
}