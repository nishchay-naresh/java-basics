package com.nishchay.core.collection;

import java.util.PriorityQueue;


/*
 *
 * PriorityQueue - only non-concurrent queue, can be used by a single thread to collect items and process them in a sorted order.
 * A unbounded data structures to have an ordered list(element must be homogeneous, comparable)
 *
 *	Method          | Throws Exception        | Returns Special Value
 *	--------------------------------------------------------------------
 *	Insert          | add(e)                  | offer(e)
 *	Remove          | remove()                | poll()
 *	Examine (peek)  | element()               | peek()
 *
 * */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        priorityQueueMethods();
        checkReturnSpecialValueMethods();
        checkThrowsExceptionMethods();
    }

    /*
    * ================================== ThrowsExceptionMethods ========================================
    * add() - true/false : true if the element was added to this queue, else false
    * remove() - e/NoSuchElementException : the head of this queue, or null if this queue is empty
    * element() - e/NoSuchElementException : the head of this queue, or null if this queue is empty
    *
    * */
    private static void checkThrowsExceptionMethods() {


        PriorityQueue<String> pq = new PriorityQueue<>();
//        System.out.println("pq.remove() = " + pq.remove());// java.util.NoSuchElementException
//        System.out.println("pq.element() = " + pq.element());// java.util.NoSuchElementException
        System.out.println("pq.add(e) = " + pq.add("test"));
        System.out.println("pq.element() = " + pq.element());
    }

    /*
     * ====================== ReturnSpecialValueMethods ===========================
     * offer() - true/false : true if the element was added to this queue, else false
     * poll() - e/null : the head of this queue, or null if this queue is empty
     * peek() - e/null : the head of this queue, or null if this queue is empty
     *
     * */
    private static void checkReturnSpecialValueMethods() {
        PriorityQueue<String> pq = new PriorityQueue<>();
        System.out.println("pq.poll() = " + pq.poll());
        System.out.println("pq.peek() = " + pq.peek());
        System.out.println("pq.offer(e) = " + pq.offer("test"));
        System.out.println("pq.peek() = " + pq.peek());
    }

    private static void priorityQueueMethods() {

        PriorityQueue<String> toDoItems = new PriorityQueue<>();

        toDoItems.add("dishes");
        toDoItems.add("laundry");
        toDoItems.add("bills");
        toDoItems.offer("bills");//offer() = add()
        // [bills, bills, dishes, laundry]

        System.out.println("toDoItems.size() = " + toDoItems.size());//4
        System.out.println("toDoItems.poll() = " + toDoItems.poll());//bills poll() = take()
        System.out.println("toDoItems.peek() = " + toDoItems.peek());//bills peek() - read only
        System.out.println("toDoItems.poll() = " + toDoItems.poll());//bills
        System.out.println("toDoItems.poll() = " + toDoItems.poll());//dishes
        System.out.println("toDoItems.poll() = " + toDoItems.poll());//laundry
    }

}
