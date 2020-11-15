package com.nishchay.java8.lambda;

// One class should always be there for the interface - Greeting.class, not counting that here
public class HelloGreeting implements Greeting {

    @Override
    public void perform() {
        System.out.println("implementation class - greeting");
    }

}
