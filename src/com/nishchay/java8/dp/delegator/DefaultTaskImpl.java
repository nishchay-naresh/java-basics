package com.nishchay.java8.dp.delegator;

public class DefaultTaskImpl implements Task{
    @Override
    public void doTask1() {
        System.out.println("DefaultTaskImpl#task1");
    }

    @Override
    public void doTask2() {
        System.out.println("DefaultTaskImpl#task2");
    }
}
