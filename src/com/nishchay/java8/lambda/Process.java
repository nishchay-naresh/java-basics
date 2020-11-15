package com.nishchay.java8.lambda;

public class Process {

    public void doProcess(int a, ProcessI p) {
        p.process(a);
    }

    public void execute() {
        System.out.println("----------Using lambda-------------");
        doProcess(100, a -> {
            System.out.println("this -" + this); // calling object of Process class
            System.out.println("a = " + a);
        });
    }
}