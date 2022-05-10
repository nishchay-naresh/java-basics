package com.nishchay.core.reflect;

class MyInterfaceImpl implements MyInterface {
    @Override
    public void greet(String name) {
        System.out.println("Hi " + name);
    }
}