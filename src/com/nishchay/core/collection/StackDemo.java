package com.nishchay.core.collection;

import java.util.Stack;


/*
 *	Stack follows LIFO (Last In First Out).
 *
 * Method          | Throws Exception                | Returns Special Value
 * ---------------------------------------------------------------------------
 * Push            | push(e)                         | — (no special-value version)
 * Pop             | pop()                           | — (no null/false version)
 * Peek            | peek()                          | — (no null version)
 * Empty Check     | —                               | empty() → returns boolean
 * Search          | —                               | search(e) → returns index or -1
 *
 * */
public class StackDemo {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        System.out.println("stack - " + stack + ", size - " + stack.size());
        // top is pointing to the last inserted element , so doing a peek() here will give the last element
        System.out.println("The top element is " + stack.peek());

        System.out.println("stack.pop() - " + stack.pop()); // removing the top element (`D`)
        System.out.println("stack.pop() - " + stack.pop()); // removing the next top (`C)

        System.out.println("stack - " + stack + ", size - " + stack.size());

        System.out.println("stack.empty() - " + stack.empty());
        while(! stack.empty()){
            System.out.println("stack.pop() - " + stack.pop());
        }
        System.out.println("stack.empty() - " + stack.empty());
    }
}
