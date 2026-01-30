package com.nishchay.core.collection;


import java.util.LinkedList;
import java.util.Queue;

/*
 *	Queue follows FIFO (First In First Out).
 *	Common implementations:
 *		LinkedList
 *		ArrayDeque (recommended — faster, no capacity restriction)
 *		PriorityQueue (orders by priority, not FIFO)
 *
 *
 *	Method          | Throws Exception        | Returns Special Value
 *	--------------------------------------------------------------------
 *	Insert          | add(e)                  | offer(e)
 *	Remove          | remove()                | poll()
 *	Examine (peek)  | element()               | peek()
 *
 *
 * */
public class QueueDemo {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Queue: " + queue);

        // Peek (head element)
        System.out.println("Peek: " + queue.peek());  // 10

        // Remove elements (FIFO)
        System.out.println("Removed: " + queue.poll());  // 10
        System.out.println("Removed: " + queue.poll());  // 20

        System.out.println("Queue after removals: " + queue);
    }
}
