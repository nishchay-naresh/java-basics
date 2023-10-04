package com.nishchay.java8.dp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.nishchay.java8.dp.Locker2.runLocked;

public class DP05EAPManagingLock {
    public static void main(String[] args) {

        usingLocks_oldWay();
        usingLocks_fix();

    }

    private static void usingLocks_oldWay() {

        Lock lock = new ReentrantLock();
        Locker1 locker = new Locker1();
        locker.setLock(lock);
        locker.doOp1();
    }

    private static void usingLocks_fix() {
        final Lock lock = new ReentrantLock();
        Locker2 locker = new Locker2();

        locker.doOp1(lock, () -> {
            System.out.println("Locker2 class");
            System.out.println("executing critical section code");
        });

        runLocked(lock, () -> System.out.println("executing code within lock"));
    }
}


/*
 *  Problems :
 *       verbose
 *       error-prone
 *       hard to maintain
 *
 * */
class Locker1 {
    Lock lock;

    protected void setLock(final Lock lock) {
        this.lock = lock;
    }

    public void doOp1() {
        lock.lock();
        try {
            //...critical code...
            System.out.println("executing critical section code");
        } finally {
            lock.unlock();
        }
    }
}

class Locker2 {

    public static void runLocked(Lock lock, Runnable block) {
        lock.lock();
        try {
            block.run();
        } finally {
            lock.unlock();
        }
    }

    public void doOp1(Lock lock, Runnable block) {
        runLocked(lock, block);
    }

}