package com.nishchay.core.basics.exc;

public class CustomAutoClosableImpl {

    public static void main(String[] args) throws Exception {
        myAutoClosable();
    }

    private static void myAutoClosable() throws Exception {
        try(MyAutoClosable resource1 = new MyAutoClosable();
            MyAutoClosable resource2 = new MyAutoClosable();
        ){
           // use resource
        } // close() get triggered immediate once we reach the end of try block
    }
}
/*
* o/p =>
* MyAutoClosable closed!
* MyAutoClosable closed!
*
* */