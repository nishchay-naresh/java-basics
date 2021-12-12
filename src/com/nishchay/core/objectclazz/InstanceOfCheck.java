package com.nishchay.core.objectclazz;


public class InstanceOfCheck {

    public static void main(String args[]) {
        Parent p = new Parent();
        Child c = new Child();
        System.out.println("child instanceof Parent " + (c instanceof Parent)); // true
        System.out.println("parent instanceof Child " + (p instanceof Child)); // false
    }
}

class Parent {
}

class Child extends Parent {
}
/*
O/P =>
    child instanceof Parent true
    parent instanceof Child false
* */