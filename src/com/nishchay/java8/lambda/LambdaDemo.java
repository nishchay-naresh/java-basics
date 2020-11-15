package com.nishchay.java8.lambda;

public class LambdaDemo {

    public static void main(String[] args) {

        /*
        * 1. Providing the implementation under an implementation class
        * Two class will be generated -  HelloGreeting.class, LambdaDemo.class
        *
        * */

        Greeting helloGreeting =  new HelloGreeting();
        helloGreeting.perform();

        /*
        * 2. Providing the implementation under an anonymous inner class
        * Two class will be generated -  LambdaDemo.class, LambdaDemo$1.class(main running class)
        *
        * */


        Greeting innerClassGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("anonymous inner class - greeting");
            }
        };
        innerClassGreeting.perform();

        /*
        * 2. Providing the implementation by a lambda expression
        * Only one class will be generated -  Greeting.class
        *
        * */

        Greeting lambdaGreeting = () -> System.out.println("lambda expression - greeting");
        lambdaGreeting.perform();

    }
}



