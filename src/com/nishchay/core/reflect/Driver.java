package com.nishchay.core.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * Dynamic Proxy using Proxy and Invocation Handler
 *
 * Proxy - creating a proxy object using reflexion and exposing a hook of Invocation handler
 * Invocation handler - intercepting all the method invocation, can add the extra things at run-time
 * Wherever we have the Delegator use case we can use this.
 *
 * Its is very helpfully, when we have so many methods calls to delegate, without writing an implementation class for method call delegations only
 *
 * */
public class Driver {

    public static void main(String[] argv) {

        MyInterface impl = new MyInterfaceImpl();
        impl.greet("Iron Man");

        // intercepting method call using InvocationHandler
        System.out.println("-----------InvocationHandler - Impl class ----------");
        MyInterface dynamicProxy = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class}, new MyInvocationHandler(impl));
        dynamicProxy.greet("Wonder Women");

        System.out.println("-----------InvocationHandler - Inner class ----------");
        dynamicProxy = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Proxy using Inner class " + method.getName() + " - before execution");
                        method.invoke(impl, args);
                        System.out.println("Proxy using Inner class " + method.getName() + " - after execution");
                        return null;
                    }
                });
        dynamicProxy.greet("Bat Man");

        System.out.println("-----------InvocationHandler - Lambda ----------");
        dynamicProxy = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class}, (proxy, method, args) -> {
                    System.out.println("Proxy using lambda " + method.getName() + " - before execution");
                    method.invoke(impl, args);
                    System.out.println("Proxy using lambda " + method.getName() + " - after execution");
                    return null;
                });
        dynamicProxy.greet("Captain America");

    }


}