package com.nishchay.java8.lambda;

/*
*
* Basic difference in both the approach
* In java method is the 2nd class citizen, A method can't exist as independent, it must be wrapped around an Object
*
* 1. anonymous inner class - We are passing the behaviour, by wrapping it under a class
* 2. lambda expression - passing the behaviour as en independent entity, which has been pointed by lambda
*
* */
public class RunnableUsingLambda {

    public static void main(String[] args) {

        /*
         * 1. Providing Runnable interface implementation using anonymous inner class
         * Two class will be generated -  RunnableUsingLambda.class, RunnableUsingLambda$1.class(main running class)
         * */
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Creating a thread using anonymous inner class");
            }
        });
        t1.start();

        /*
         * 2. Providing Runnable interface implementation using lambda expression
         * Only one class will be generated -  RunnableUsingLambda.class(main running class)
         * */
        Thread t2 = new Thread(() -> System.out.println("Creating a thread using lambda expression"));
        t2.start();

    }

}
