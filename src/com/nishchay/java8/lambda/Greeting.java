package com.nishchay.java8.lambda;

@FunctionalInterface
public interface Greeting {
    void perform();


//    void anotherMethod();
/*
if we are adding any further abstract method to a Functional Interface, errro will come at all the implementation class & lambda code
but if we are pitting annotation - @FunctionalInterface, then it will flash the error here only
error - Multiple non-overriding abstract methods found in interface
*/

}


