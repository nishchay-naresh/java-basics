package com.nishchay.java8.lambda;

/*
* Also referred as closure in lambda
* Effective Final -  concept introduced in java8. in earlier version you need to make y as final to achieve this
* java compiler keeping a watch on y, if user changes it , compiler will flag compiler time error
* Have same behaviour for both lambda & anonymous inner class
* */

public class EffectiveFinalDemo {

    public static void main(String[] args) {

        int x = 100;
        int y = 20;

        System.out.println("----------anonymous inner class-------------");
        doProcess(x, new ProcessI() {
            @Override
            public void process(int a) {
//                y = 50; // Variable 'y' is accessed from within inner class, needs to be final or effectively final
                System.out.println(a + y);
            }
        });

        System.out.println("----------Using lambda-------------");
        doProcess(x, a -> {
//            y = 50; // Variable used in lambda expression should be final or effectively final
            System.out.println(a + y);
        });

    }

    public static void doProcess(int a, ProcessI p) {
        p.process(a);
    }

}


