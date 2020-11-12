package com.nishchay.core.collection;

import java.util.PriorityQueue;


/*
 *
 * PriorityQueue - only non-concurrent queue, can be used by a single thread to collect items and process them in a sorted order.
 * A unbounded data structures to have an ordered list(element must be homogeneous, comparable)
 *
 * */
public class PriorityQueueDemo {

    public static void main(String[] args) {
//        priorityQueueMethods();

//        checkReturnSpecialValueMethods();

        checkThrowsExceptionMethods();
    }


    private static void checkThrowsExceptionMethods() {
//        add() - true/false : true if the element was added to this queue, else false
//        remove() - e/NoSuchElementException : the head of this queue, or null if this queue is empty
//        element() - e/NoSuchElementException : the head of this queue, or null if this queue is empty

        PriorityQueue<String> pq = new PriorityQueue<>();
//        System.out.println("toDo.remove() = " + pq.remove());// java.util.NoSuchElementException
//        System.out.println("toDo.element() = " + pq.element());// java.util.NoSuchElementException
        System.out.println("toDo.add(e) = " + pq.add("test"));
        System.out.println("toDo.element() = " + pq.element());
    }


    private static void checkReturnSpecialValueMethods() {
//        offer() - true/false : true if the element was added to this queue, else false
//        poll() - e/null : the head of this queue, or null if this queue is empty
//        peek() - e/null : the head of this queue, or null if this queue is empty

        PriorityQueue<String> pq = new PriorityQueue<>();
        System.out.println("toDo.poll() = " + pq.poll());
        System.out.println("toDo.peek() = " + pq.peek());
        System.out.println("toDo.offer(e) = " + pq.offer("test"));
        System.out.println("toDo.peek() = " + pq.peek());

    }


    private static void priorityQueueMethods() {

        PriorityQueue<String> toDo = new PriorityQueue<>();

        toDo.add("dishes");
        toDo.add("laundry");
        toDo.add("bills");
        toDo.offer("bills");//offer() = add()
        // [bills, bills, dishes, laundry]

        System.out.println("toDo.size() = " + toDo.size());//4
        System.out.println("toDo.poll() = " + toDo.poll());//bills poll() = take()
        System.out.println("toDo.peek() = " + toDo.peek());//bills peek() - read only
        System.out.println("toDo.poll() = " + toDo.poll());//bills
        System.out.println("toDo.poll() = " + toDo.poll());//dishes
        System.out.println("toDo.poll() = " + toDo.poll());//laundry

    }
}
