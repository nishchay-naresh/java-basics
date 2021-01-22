package com.nishchay.core.basics.block;


/*
* Static Block - A static block is called once, when the class is loaded and initialized by the JVM.
* Instance Block - An instance initializer is executed when an instance of the class is constructed, just like a constructor.
*
* */
public class BlockExecutionOrder {

    public BlockExecutionOrder() {
        System.out.println("3 Constructor execution");
    }

    {
        System.out.println("2 instance block execution");
    }

    static	{
        System.out.println("1 static block execution");
        BlockExecutionOrder ref1 =  new BlockExecutionOrder();
    }

    public static void main(String[] args) {
        BlockExecutionOrder ref1 =  new BlockExecutionOrder();
        System.gc();
    }

    protected void finalize(){
        System.out.println("4 finalize method"); // no guarantee of its execution
    }

}
/*
 * o/p =>
 *	1 static block execution
 *	2 instance block execution
 *	3 Constructor execution
 *  2 instance block execution
 * 3 Constructor execution
 * 4 finalize method
 *
 * */