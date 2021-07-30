package com.nishchay.java8.lambda;
/*
* Main difference between lambda & anonymous inner class
* lambda - does not overrides the this reference value
*        - the value of 'this' reference will be the same as the value of this reference outside of lambda
* anonymous inner class - overrides the this reference value
*
* */
public class ThisRefDemo {


    public static void main(String[] args) {

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
//            System.out.println("this -" + this); // cannot be referenced from a static context
            System.out.println("a = " + a);
        });
        process.execute();

    }

}


