package com.nishchay.java8.basic.methodref;

public class InstanceMethodDemo {

    public void myMethod(){
        System.out.println("Instance Method");
    }

    public static void main(String[] args) {

        InstanceMethodDemo obj = new InstanceMethodDemo();
        // MyInterface1.display signature is () -> void, So MyInterface1 interface1 ~= () -> void
          MyInterface1 interface1 = () -> obj.myMethod();
        //  Calling the method of functional interface
        interface1.display();
    }
}




