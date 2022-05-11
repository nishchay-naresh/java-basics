package com.nishchay.core.reflect;
import java.lang.reflect.Proxy;

public class Driver {

    public static void main(String[] argv) {

        MyInterface ref = new MyInterfaceImpl();
        ref.greet("Iron Man");

        System.out.println("-----------intercepting method call using InvocationHandler----------");
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(),
                new Class[] { MyInterface.class }, new MyInvocationHandler(ref));
        proxy.greet("Wonder Women");

    }

    public static MyInterface m1() {
        final MyInterface ref = new MyInterfaceImpl();
/*        return Proxy.newProxyInstance(MyInterface.class.getClassLoader(),
                new Class[] { MyInterface.class }, (proxy, method, args) -> {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    for (int i =0; i < parameterTypes.length; i++) {
                        if (String.class.equals(parameterTypes[i])) {
                            args[i] = proxy + " :: " + args[i].toString();
                        }
                    }
                    return method.invoke(this, args);
                });*/
        return ref;
    }


}