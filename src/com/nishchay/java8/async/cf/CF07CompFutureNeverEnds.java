package com.nishchay.java8.async.cf;

import static com.nishchay.util.Utils.create;
import static com.nishchay.util.Utils.printIt;

public class CF07CompFutureNeverEnds {

    public static void main(String[] args) {

        thenRunEx();

    }

    // we can keep adding the runnable task to a cf using thenRun() , its keep executing them
    private static void thenRunEx() {

        create(2)
                .thenAccept(e -> printIt(e))
                .thenRun(() -> System.out.println("all done"))
                .thenRun(() -> System.out.println("not really"))
                .thenRun(() -> System.out.println("keeps on going"))
                .thenRun(() -> System.out.println("cf never ends"));
    }

}