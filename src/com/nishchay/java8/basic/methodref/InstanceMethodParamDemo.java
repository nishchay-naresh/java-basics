package com.nishchay.java8.basic.methodref;

public class InstanceMethodParamDemo {

    public void myMethod(int x){
        System.out.println("Instance Method - " + x);
    }

    public static void main(String[] args) {
        InstanceMethodParamDemo obj = new InstanceMethodParamDemo();
        // MyInterface1 ref ~= (int ) -> void
        MyInterface2 myInterface2 = (x) -> obj.myMethod(x);
        myInterface2.display(10);
    }
}

