package com.nishchay.core.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


class MyInvocationHandler implements InvocationHandler {
    private Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Impl class " + method.getName() + " - before execution");
        method.invoke(obj, args);
        System.out.println("Impl class " + method.getName() + " - after execution");

        return null;
    }
}