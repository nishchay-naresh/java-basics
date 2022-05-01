package com.nishchay.java8.lambda;

/*
 * Main difference between lambda & anonymous inner class
 * lambda - does not override the 'this' reference value
 *        - the value of 'this' reference will be the same as the value of this reference outside of lambda
 * anonymous inner class - overrides the 'this' reference value to new anonymous inner class (which will sth like MainClass$1)
 *
 * https://stackoverflow.com/questions/24202236/
 * */
public class ThisRefDemo1 {

    public static void main(String[] args) {
        ThisRefDemo1 refDemo = new ThisRefDemo1();
        refDemo.implUsingInner();
        refDemo.implUsingLambda();
    }
    public void implUsingInner(){
        Greeting ref = new Greeting() {
            @Override
            public void perform() {
                System.out.println("this -" + this); // Demo$1
                System.out.println("implementation using inner clazz");
            }
        };

        ref.perform();
    }
    public void implUsingLambda(){
        Greeting ref = () -> {
            System.out.println("this -" + this); // Demo
            System.out.println("implementation using lambda");
        };

        ref.perform();
    }
}
