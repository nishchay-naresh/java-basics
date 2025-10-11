package com.nishchay.core.basics.exc;

public class CustomAutoClosableImpl {

    public static void main(String[] args) throws Exception {
        myAutoClosable();
    }

    private static void myAutoClosable() throws Exception {
        try (MyAutoClosable resource1 = new MyAutoClosable();
             AutoCloseable resource2 = () -> System.out.println("AutoCloseable#close() using lambda");
        ) {
           // use resource
        } // close() get triggered immediate once we reach the end of try block (no catch is required for this try)
          // it's same like closing the open resource in finally block
    }
}
/*
* o/p =>
* AutoCloseable#close() using lambda
* MyAutoClosable closed!
*
* */