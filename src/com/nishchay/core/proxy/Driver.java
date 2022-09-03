package com.nishchay.core.proxy;

public class Driver {

    public static void main(String[] args) {
        m1();
//        m2();
    }

    private static void m1() {
        MyObject object = new MyObject();
        System.out.println(object.getData());

        IObject decorator = new NormalCacheDecorator(object);
        System.out.println(decorator.getData());
    }

    private static void m2() {

        MyObject object = new MyObject();
        IObject iObject = GenericCacheDecorator.decorate(object, IObject.class);
        System.out.println(iObject.getData());
        System.out.println(iObject.getData());

    }

}
