package com.nishchay.java8.lambda;


/*
 *
 *	Instance of a functional interface
 *		1. Instance of a class implementing a functional interface - legacy way
 *      2. Implementation under an anonymous inner class
 *		3. Lambda expression (-> operator)
 *		4. Method reference expression (:: separator)
 *	 Each of the above is declarative - the function formed by the expression is not executed until called
 *
 *
 * */
public class LambdaDemo {
    public static void main(String[] args) {

        instantiatingFIEx();

    }

    private static void instantiatingFIEx() {

        /*
         * 1. Providing the implementation under an implementation class
         * Two class will be generated -  HelloGreeting.class, LambdaDemo.class
         * */
        Greeting instance =  new HelloGreeting();
        instance.perform();

        /*
         * 2. Providing the implementation under an anonymous inner class
         * Two class will be generated -  LambdaDemo.class, LambdaDemo$1.class(main running class)
         * */
        instance = new Greeting() {
            @Override
            public void perform() {
                System.out.println("anonymous inner class - greeting");
            }
        };
        instance.perform();

        /*
         * 3. Providing the implementation by a lambda expression
         * Only one class will be generated -  Greeting.class
         * */
        instance = () -> System.out.println("lambda expression - greeting");
        instance.perform();

        /*
         * 4. Providing the implementation by a method, calling it using method reference
         * Only one class will be generated -  Greeting.class
         * */
        // instance = () -> LambdaDemo.implMethod();
        instance = LambdaDemo::implMethod;
        instance.perform();
    }

    private static void implMethod() {
        System.out.println("method reference - greeting");
    }

    // Implementation to abstract method in form of implementation class
    static class HelloGreeting implements Greeting {
        @Override
        public void perform() {
            System.out.println("implementation class - greeting");
        }
    }
}

/*
 * O/P =>
 *	implementation class - greeting
 *	anonymous inner class - greeting
 *	lambda expression - greeting
 *	method reference - greeting
 *
 * */

