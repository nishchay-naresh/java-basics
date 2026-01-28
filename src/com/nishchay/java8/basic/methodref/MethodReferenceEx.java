package com.nishchay.java8.basic.methodref;

import com.nishchay.java8.basic.methodref.pojo.FI1;
import com.nishchay.java8.basic.methodref.pojo.FI2;
import com.nishchay.java8.basic.methodref.pojo.FI3;
import com.nishchay.java8.basic.methodref.pojo.Person;

/*
 * There are 3 Functional Interface that have below abstract method
 *
 *   FI1    {   void display();              }
 *   FI2    {   void display(int a);         }
 *   FI3    {   Person display(String msg);  }
 *
 *   Runnable { void run(); }
 *
 * */
public class MethodReferenceEx {

    public static void main(String[] args) {
        instanceMethod_noArg();
        instanceMethod_1Arg();
        constructor_1Arg();
        staticMethod_noArg();
    }

    private static void instanceMethod_noArg(){
        MethodReferenceEx ref = new MethodReferenceEx();
        //  FI1 fi1 = () -> void
        //  FI1 fi1 = () -> ref.m1();
        FI1 fi1 = ref::m1;
        fi1.display();
    }
    private void m1(){
        System.out.println("FI1.display() impl using instance method");
    }

    private static void instanceMethod_1Arg(){
        MethodReferenceEx ref = new MethodReferenceEx();
        // FI2 fi1 ~= (int) -> void
        // FI2 FI2 = (x) -> ref.m2(x);
        FI2 FI2 = ref::m2;
        FI2.display(10);
    }

    public void m2(int x){
        System.out.println("FI2.display() impl using instance method, x - " + x);
    }

    private static void constructor_1Arg(){

        // FI3 fi3 = (String ) -> Person
        // FI3 FI3 = (s) ->  new Person(s); //  Method reference to a constructor
        FI3 FI3 = Person::new;
        FI3.display("java8");

    }

    private static void myTask() {
        System.out.println(Thread.currentThread().getName() + " - static method");
    }

    private static void staticMethod_noArg(){
        // Runnable task = () -> void
        Thread t1 = new Thread(MethodReferenceEx::myTask);
        t1.start();
    }
}

