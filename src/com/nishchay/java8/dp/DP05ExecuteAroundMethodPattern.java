package com.nishchay.java8.dp;

import java.util.function.Consumer;


/*
 * ================ Higher Order Functions ============
 *
 *	Higher Order Functions - A function that either
 *	•	takes one or more functions as parameter
 *	•	 returns a function as result
 *
 *	================ Execute around method pattern / loan pattern ============
 *   ExecuteAroundMethodPattern - EAM
 *	per-op
 *		some operations
 *	post-op
 *
 *	Use case  - certain logic using repeatedly in the project
 *	but, have some boilerplate code - take these boilerplate code and role this under this function
 *  anything that I want to do specific, will keep in between pass it as Supplier
 *
 *
 * https://medium.com/@sandeep12.rao/execute-around-design-pattern-cf1f2e38f626
 * https://stackoverflow.com/questions/341971/what-is-the-execute-around-idiom
 * https://java-design-patterns.com/patterns/execute-around/#explanation
 *
 * */
public class DP05ExecuteAroundMethodPattern {
    public static void main(String[] args) {

        problem();
        System.out.println("---------------------- problem_fix1 ------------------");
        problem_fix1_callingClose();
        System.out.println("---------------------- problem_fix2 ------------------");
        problem_fix2_callingCloseInFinally();
        System.out.println("---------------------- problem_fix3 ------------------");
        problem_fix3_ARM();
        System.out.println("---------------------- problem_fix4 ------------------");
        problem_fix4_lambda();

    }


    /*
     * Some heavy resource is being created and not been cleaned up
     * resources are not getting clean up - replying on GC to clean it
     * */
    private static void problem() {
        Resource1 resource = new Resource1();
        resource.opl();
        resource.op2();
    }

    /*
     * Now cleaning the resources by self immediately after the use is over
     *
     * Now still this code have some problems :
     *   1. easy to forget close()
     *   2. poor exception handling – close() will never get called if exception happen during ops()
     *
     * */
    private static void problem_fix1_callingClose() {
        Resource1 resource = new Resource1();
        resource.opl();
        resource.op2();
        resource.close();
    }


    /*
     * Now cleaning the resources by self in finally block
     *
     * Now still this code have some problems :
     *   1. easy to forget close() ++
     *   2. verbose
     *
     * */
    private static void problem_fix2_callingCloseInFinally() {

        Resource1 resource = new Resource1();
        try {
            resource.opl();
            resource.op2();
        } finally {
            resource.close();
        }
    }


    /*
     * Now using Java 7: ARM - Automatic Resource Management for resource cleaning
     *
     * easy to forget ++
     * not so verbose
     *
     * */
    private static void problem_fix3_ARM() {

        try (Resource1 resource = new Resource1()) {
            resource.opl();
            resource.op2();
        }
    }


    /*
     * Making both construction & destruction method as private
     * Making changes to op() methods - as a builder/pipeline method
     *
     * having a static use() method, which will the construction & description
     * this use() method take operation as argument in the form of Consumer and perform it
     *
     * */
    private static void problem_fix4_lambda() {
        Resource2.use(
                resource -> resource.opl().op2()
        );
    }

}

class Resource1 implements AutoCloseable {
    public Resource1() {
        System.out.println("created...");
    }

    public void opl() {
        System.out.println("opl");
    }

    public void op2() {
        System.out.println("op2");
    }

    public void finalize() {
        System.out.println("cleanup...");
    }

    public void close() {
        System.out.println("close called automatically");
        System.out.println("cleanup...");
    }
}

class Resource2 {
    private Resource2() {
        System.out.println("created...");
    }

    // Using higher order functions
    public static void use(Consumer<Resource2> block) {
        Resource2 resource = new Resource2();
        try {
            block.accept(resource);
        } finally {
            resource.close();
        }
    }

    public Resource2 opl() {
        System.out.println("opl");
        return this;
    }

    public Resource2 op2() {
        System.out.println("op2");
        return this;
    }

    private void close() {
        System.out.println("cleanup...");
    }

}


