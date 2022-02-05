package com.nishchay.ds.stack;

import java.util.*;

/*
 *	=========== Design a stack that supports getMin() in O(1) time and O(1) extra space ===========
 *
 *	Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull()
 *  and an additional operation getMin() which should return minimum element from the SpecialStack.
 *  All these operations of SpecialStack must be O(1) time and O(1) extra space.
 *
 * https://www.youtube.com/watch?v=QMlDCR9xyd8
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 *
 * */
public class StackWithGetMin {

    public static void main(String[] args) {

        MyStack s = new MyStack();
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.peek();

    }

    /*
     *   Why the formula - (2 * min - curr)
     *
     * while pushing it easy to get the newMin, its complex to get newMin while poping
     * new min = 2 * curr min - diff(which is been stored)
     *
     * caveat - not storing original value in stack, storing  = 2 * x - minEle
     * */
    static class MyStack {
        private Stack<Integer> s;
        private Integer minEle;

        MyStack() {
            s = new Stack<>();
        }

        void getMin() {
            if (s.isEmpty())
                System.out.println("Stack is empty");
            else
                System.out.println("Minimum Element in the stack is: " + minEle);
        }

        void peek() {
            if (s.isEmpty()) {
                System.out.println("Stack is empty ");
                return;
            }

            Integer t = s.peek(); // Top element.
            System.out.print("Top Most Element is: ");

            if (t < minEle)
                System.out.println(minEle);
            else
                System.out.println(t);
        }

        // Removes the top element from MyStack
        void pop() {
            if (s.isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }

            System.out.print("Top Most Element Removed: ");
            Integer curr = s.pop();

            if (curr < minEle) {
                System.out.println(minEle);
                minEle = 2 * minEle - curr;
            } else
                System.out.println(curr);
        }

        // Insert new number into MyStack
        void push(Integer x) {
            if (s.isEmpty()) {
                minEle = x;
                s.push(x);
                System.out.println("Number Inserted: " + x);
                return;
            }

            // If new number is less than original minEle
            if (x < minEle) {
                s.push(2 * x - minEle);
                minEle = x;
            } else
                s.push(x);

            System.out.println("Number Inserted: " + x);
        }
    }
}
/*
 * O/P =>
 * Number Inserted: 3
 * Number Inserted: 5
 * Minimum Element in the stack is: 3
 * Number Inserted: 2
 * Number Inserted: 1
 * Minimum Element in the stack is: 1
 * Top Most Element Removed: 1
 * Minimum Element in the stack is: 2
 * Top Most Element Removed: 2
 * Top Most Element is: 5
 * */