package com.nishchay.java8.dp.delegator;

/*
 * when you want to perform some additional actions before/after you delegate
 * (that's the Decorator pattern, but it's based on delegation).
 *  For example, Collections.synchronizedList(..)
 *
 * */
public class DelegatedTask implements Task{

    private final Task task;

    public DelegatedTask(Task task) {
        this.task = task;
    }

    @Override
    public void doTask1() {
        task.doTask1();
        System.out.println("Extra things from Delegator#task1");
    }

    @Override
    public void doTask2() {
            task.doTask2();
            System.out.println("Extra things from Delegator#task2");
    }
}
