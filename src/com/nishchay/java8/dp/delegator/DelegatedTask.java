package com.nishchay.java8.dp.delegator;

public class DelegatedTask implements Task{

    private Task task;

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
