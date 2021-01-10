package com.nishchay.core.basics.block;

public class BlockExecutionOrder {


    {
        System.out.println("2 instance block");
    }

    static	{
        System.out.println("1 static block");
        BlockExecutionOrder ref = new BlockExecutionOrder();
    }

    public static void main(String[] args) {
        System.out.println("3 main method");
        System.gc();
    }

    protected void finalize(){
        System.out.println("4 finalize method");
    }
}
