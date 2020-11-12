package com.nishchay.core.basics.interfaceobj;


class Driver {

    public static void main(String[] args) {

        Check infObj1 = new Check() {
            @Override
            public void message() {
                System.out.println("Interface implementation using anonymous inner class ");
            }
        };
        System.out.println("infObj1 = " + infObj1.getClass());
        infObj1.message();

        Check infObj2 = new InterfaceObj$1();
        System.out.println("infObj2 = " + infObj2.getClass());
        infObj2.message();

    }

}
