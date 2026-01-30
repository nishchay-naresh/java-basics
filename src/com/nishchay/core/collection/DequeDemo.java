package com.nishchay.core.collection;


import java.util.ArrayDeque;
import java.util.Deque;

/*
 *	What Is Deque (noun)?
 *  Deque (Double Ended Queue) is a linear data structure that allows both insertion and deletion at both of its end
 *  Allow operations:
 *      -   Insert/Remove at front (head)
 *      -   Insert/Remove at rear (tail)
 *
 * Can be used as:
 *  -   Queue (FIFO)
 *  -   Stack (LIFO)
 *
 *	Common implementations:
 *		ArrayDeque, Backed by resizable array
 *		LinkedList, Backed by doubly linked list
 *
 *
 *		Methods that throw exception on failure
 *		Operation        | Front             | Rear
 *		-----------------------------------------------
 *		Insert           | addFirst(e)       | addLast(e)
 *		Remove           | removeFirst()     | removeLast()
 *		Get              | getFirst()        | getLast()
 *
 *		Methods that return special value (null or false)
 *		Operation        | Front             | Rear
 *		-----------------------------------------------
 *		Insert           | offerFirst(e)     | offerLast(e)
 *		Remove           | pollFirst()       | pollLast()
 *		Get              | peekFirst()       | peekLast()
 *
 *		Stack-like Methods (LIFO)
 *		Action           | Method            | Same As
 *		-----------------------------------------------
 *		Push onto top    | push(e)           | addFirst(e)
 *		Pop from top     | pop()             | removeFirst()
 *		Peek top         | peek()            | peekFirst()
 *
 * */
public class DequeDemo {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        // Queue operations (FIFO)
        deque.offerLast(10);
        deque.offerLast(20);
        deque.offerLast(30);
        System.out.println("Queue Mode: " + deque);

        System.out.println("Removed from front: " + deque.pollFirst()); // 10

        // Stack operations (LIFO)
        deque.push(99);  // same as addFirst(99)
        deque.push(88);

        System.out.println("After Stack pushes: " + deque);

        System.out.println("Popped: " + deque.pop()); // 88

        System.out.println("Front element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());

        System.out.println("Final Deque: " + deque);
    }
}
