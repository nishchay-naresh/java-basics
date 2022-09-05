package com.nishchay.core.proxy;

public class MyObject implements IObject {

    public String getData () {
        return "expensiveData-" + System.nanoTime();
    }
}