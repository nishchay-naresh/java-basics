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

        System.out.println("Invoked method: " + method.getName());
        method.invoke(obj, args);
        System.out.println("intercepting method execution - after");

        return null;
    }
}