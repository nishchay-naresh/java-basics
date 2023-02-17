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
public class ThreadUsingLambda {

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
         * assignment less programming
         *
         * Here we have converted the code to lambda expression rather than anonymous method or anonymous class
         * Here Thread constructor is a higher order function -  which says your don’t have to pass object of runnable to me.
         *  It's okay you can pass a function to me which have no name.
         * This is actually is treating a Function as first class citizen.
         * And that function is of course is lambda expression
         *
         * */
        Thread t2 = new Thread(() -> System.out.println("Creating a thread using lambda expression"));
        t2.start();


        Runnable task = () -> System.out.println("Explicit assignment of lambda");
        Thread t3 = new Thread(task);
        t3.start();

    }

}
