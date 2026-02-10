package com.nishchay.java8.lambda;

/*
 * The main difference between lambda & anonymous inner class
 * lambda - does not override the 'this' reference value
 *        - the value of 'this' reference will be the same as the value of this reference outside of lambda
 *
 * anonymous inner class - overrides the 'this' reference value to new anonymous inner class (which will sth like MainClass$1)
 *
 * */
public class ThisRefDemo {

    public static void main(String[] args) {
        staticMethodEx();
        instanceMethodEx();
    }

    private static void staticMethodEx() {
        Process process = new Process();
        int x = 100;

        System.out.println("----------anonymous inner class-------------");
        process.doProcess(x, new ProcessI() {
            @Override
            public void process(int a) {
                System.out.println("this -" + this); // ThisRefDemo$1
                System.out.println("a = " + a);
            }
        });

        System.out.println("----------Using lambda-------------");
        process.doProcess(x, a -> {
            // System.out.println("this -" + this); // cannot be referenced from a static context
            System.out.println("a = " + a);
        });
        process.execute();

    }

    private static void instanceMethodEx() {
        ThisRefDemo refDemo = new ThisRefDemo();
        refDemo.implUsingInner();
        refDemo.implUsingLambda();
    }

    public void implUsingInner(){
        Greeting ref = new Greeting() {
            @Override
            public void perform() {
                System.out.println("this -" + this); // ThisRefDemo$2
                System.out.println("implementation using inner clazz");
            }
        };

        ref.perform();
    }
    public void implUsingLambda(){
        Greeting ref = () -> {
            System.out.println("this -" + this); // ThisRefDemo
            System.out.println("implementation using lambda");
        };

        ref.perform();
    }
}
