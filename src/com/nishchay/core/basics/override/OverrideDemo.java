package com.nishchay.core.basics.override;

public class OverrideDemo {

    public static void main(String[] args) {

        Parent p1 = new Parent();
        Parent p2 = new Child();
        Child c = new Child();

//        p1.print();
//        p2.print();
//        c.print();

        doPrint(p1);
        doPrint(p2);
        doPrint(c);
    }

    public static void doPrint(Parent p){
        p.print();
    }
}



