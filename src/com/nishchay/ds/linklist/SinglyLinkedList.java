package com.nishchay.ds.linklist;

import static com.nishchay.ds.linklist.Utils.createList;
import static com.nishchay.ds.linklist.Utils.printList;

/*
 * Java class to solve various small problems on a singly linked list
 *
 * */
class SinglyLinkedList {

    public static void main(String[] args) {

        createPrintListEx();
        insertEx();
        deleteEx();
        printMiddleElementEx();
        printFromBackEx();
        printFrontAndBackEx();
        isPalindromeEx();
        searchNodeEx();
        nthNodeEx();
        nthFromLastNodeEx();
        reverseListEx();
        isLoopExistsEx();
    }


    private static void createPrintListEx() {
        Node head = createList();
        printList(head);
    }

    // insert in - beginning(before the head), end(after the tail) and middle (random locating, after some node base don value)
    private static void insertEx() {

        Node head = createList();

        printList(head);

        System.out.println("--------------insert in beginning----------------------");
        Node newNode = new Node(99);
        newNode.next = head;
        head = newNode;
        printList(head);

        System.out.println("--------------insert at end ----------------------");
        head = createList();

        if (head == null) { // If the list is empty
            head = newNode;
            return;
        }

        // position p to the last node
        Node p = head;
        while (p.next != null)
            p = p.next;

        newNode.next = p.next;
        p.next = newNode;
        printList(head);

        System.out.println("--------------insert in middle : after 40 ----------------------");
        head = createList();
        if (head == null) {  // List is empty, can't insert after a key
            return;
        }
        int key = 40;

        // position p to node having value 40
        Node q = head;
        while (q.data != key && q.next != null) {
            q = q.next;
        }

        if (q == null) { // Key not found
            System.out.println(key + " doesn't exist");
            return;
        }
        newNode.next = q.next;
        q.next = newNode;
        printList(head);
    }

    private static void deleteEx() {
        Node head = createList();
        printList(head);
        System.out.println("-------------- deleting last node ----------------------");
        head = removeLastNode(head);
        printList(head);
    }

    private static Node removeLastNode(Node head) {

        // Handle Edge Cases: Empty list, Single node list
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }

        // Find the second last node
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }

        // Delete the last node by making
        // secondLast point to null
        secondLast.next = null;

        return head;
    }

    private static void printMiddleElementEx() {
        // odd list
        Node head = createList();
        printList(head);
        printMiddleElement(head);

        // even list
        head = createList(new int[]{10, 20, 30, 40});
        printList(head);
        printMiddleElement(head);
    }

    // Function to print middle of a linked list
    private static void printMiddleElement(Node head) {
        Node slowPointer, fastPointer;

        slowPointer = fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        System.out.println("The middle element is = " + slowPointer.data);
    }

    private static void printFromBackEx() {
        Node head = createList();
        printList(head);

        System.out.println("List printing from back :");
        printFromBack(head);
    }


    private static void printFrontAndBackEx() {
        // odd list
        Node head = createList();
        printList(head);
        System.out.println("Front & Back traversal :");
        printFrontAndBack(head);

        System.out.println("\n----------------------------------------");

        // even list
        head = createList(new int[]{10, 20, 30, 40, 50, 60});
        printList(head);
        System.out.println("Front & Back traversal :");
        printFrontAndBack(head);
    }


    private static void isPalindromeEx() {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(20);
        head.next.next.next.next.next = new Node(10);
        // head -> 10->20->30->30->20->10 , even length
        printList(head);
        System.out.println("Current list is palindrome - " + isPalindrome(head));

        System.out.println("--------------------------------------");

        head = createList(new int[]{10, 20, 50, 20, 10});
        // head -> 10->20->50->20->10 , odd length
        printList(head);
        System.out.println("Current list is palindrome - " + isPalindrome(head));
    }

    private static void searchNodeEx() {
        Node head = createList();
        printList(head);

        int key = 8;
        System.out.printf("Search key = %d, Found at = %d%n", key, searchNode(head, key));

        key = 50;
        System.out.printf("Search key = %d, Found at = %d%n", key, searchNode(head, key));

        key = 30;
        System.out.printf("Search key = %d, Found at = %d%n", key, searchNode(head, key));

        key = 10;
        System.out.printf("Search key = %d, Found at = %d%n", key, searchNode(head, key));
    }

    // search a key in a singly linked list, return node position else -1
    private static int searchNode(Node head, int key) {
        if (key == head.data)
            return 1;
        Node p = head;
        int cnt = 0;

        while (p != null && p.data != key) {
            p = p.next;
            cnt++;
        }
        if (p != null)
            return cnt + 1; // found

        return -1; // not found
    }

    /*
     *
     * Function to get Nth node in a linked list - from front
     *
     *
     * Input:  1->10->30->14,  index = 2
     * Output: 10
     * Explanation: The node value at index 2 is 10
     *
     * Input:  1->32->12->10->30->14->100,  index = 6
     * Output: 14
     * Explanation: The node value at index 6 is 14
     *
     * Input:  1->32->12->10->30->14->100,  index = 8
     * Output: -1
     * Explanation: No such node exists at index = 8.
     *
     *
     * */
    private static void nthNodeEx() {
        Node head = createList(new int[]{1, 10, 30, 14});
        // head -> 1->10->30->14
        printList(head);
        int index = 2;
        System.out.println(index + "th node in list - " + nthNode(head, index));

        System.out.println("-------------------------------------------------------------");
        head = createList(new int[]{1, 32, 12, 10, 30, 14, 100});
        // head -> 1->32->12->10->30->14->100
        printList(head);

        index = 6;
        System.out.println(index + "th node in list - " + nthNode(head, index));

        index = 8;
        System.out.println(index + "th node in list - " + nthNode(head, index));
    }

    private static int nthNode(Node head, int index) {
        if (head == null || index < 1)
            return -1;

        // if index equal to 1 return node.data
        if (index == 1)
            return head.data;

        Node curr = head;
        while (index > 1 && curr != null) {
            curr = curr.next;
            index--;
        }
        if (curr != null)
            return curr.data;

        return -1;
    }

    private static void nthFromLastNodeEx() {
        Node head = createList();
        printList(head);

        int n = 2;
        System.out.printf("%d th node from last = %s%n", n, nthFromLastNode(head, n));
        n = 4;
        System.out.printf("%d th node from last = %s%n", n, nthFromLastNode(head, n));

        // edge cases
        n = 1;
        System.out.printf("%d th node from last = %s%n", n, nthFromLastNode(head, n));
        n = 5;
        System.out.printf("%d th node from last = %s%n", n, nthFromLastNode(head, n));

        // failure cases
        n = 0;
        System.out.printf("%d th node from last = %s%n", n, nthFromLastNode(head, n));
        n = 8;
        System.out.printf("%d th node from last = %s%n", n, nthFromLastNode(head, n));
    }

    // method to get nth node from the last, return node else null
    private static Node nthFromLastNode(Node head, int n) {
        if (null == head || n < 1)
            return null;

        Node firstPtr = head;
        Node secondPtr = head;

        // skip n node from start
        for (int i = 1; i <= n; i++) {
            if (firstPtr == null)
                return null;
            firstPtr = firstPtr.next;
        }

        while (firstPtr != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        return secondPtr;
    }

    private static void reverseListEx() {
        Node head = createList();
        printList(head);
        System.out.println("--------- Reversed list -----------");
        head = reverse(head);
        printList(head);
    }

    // Function to reverse the linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }


    private static void isLoopExistsEx() {
        Node head = createList();
        printList(head);
        System.out.printf("%s%n", isLoopExists(head) ? "Loop found" : "Loop not found");

        System.out.println("-----------------------------------");

        // created a link list with loop
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        // loop
        head.next.next.next.next.next = head.next;
        /*
         *  head => 10 -> 20 -> 30 -> 40 -> 50
         *                 |----------------|
         * */
        System.out.printf("%s%n", isLoopExists(head) ? "Loop found" : "Loop not found");
    }

    // prints content of a singly linked list from end
    private static void printFromBack(Node head) {
        Node p, end;
        // get end node
        for (p = head; p.next != null; p = p.next) ;
        end = p;

        String delim = "head => ";
        while (head != end) {
            System.out.print(delim + end.data);
            delim = " -> ";

            for (p = head; p.next != end; p = p.next) ;
            end = p;
        }
        System.out.print(delim + end.data);
        System.out.println(" -> null");
    }

    // prints content of a singly linked list from start & end respectively
    private static void printFrontAndBack(Node head) {
        Node start, p, end;
        start = head;

        // get end node
        for (p = head; p.next != null; p = p.next) ;
        end = p;

        String delim = "head => ";
        while (start != end && start.next != end) {
            System.out.print(delim + start.data + " -> " + end.data);
            delim = " -> ";

            // move start forward
            start = start.next;

            // move end backward
            for (p = head; p.next != end; p = p.next) ;
            end = p;
        }
        if (start == end) {
            System.out.print(delim + start.data + " -> null");
        } else if (start.next == end) {
            System.out.print(delim + start.data + delim + end.data + " -> null");
        }

    }

    // Function to check if a linked list is palindrome
    private static boolean isPalindrome(Node head) {

        if (head == null) {
            return false;
        }
        Node start, p, end;
        start = head;

        // get end node
        for (p = head; p.next != null; p = p.next) ;
        end = p;

        while (start != end && start.next != end) {

            if (start.data != end.data) {
                return false;
            }
            // move start forward
            start = start.next;

            // move end backward
            for (p = head; p.next != end; p = p.next) ;
            end = p;
        }
        return true;
    }


    /*
     *  Floyd’s Tortoise and Hare Algorithm (Cycle Detection Algorithm).
     *
     *  slow & fast pointer approach:
     *	    slow and fast met before reaching null, this means that the list contains a cycle
     *
     *
     *     +--------+-----------+----------+
     *     | Hare   | Tortoise  | Distance |
     *     +--------+-----------+----------+
     *     |   2    |     1     |    9     |
     *     |   4    |     2     |    8     |
     *     |   6    |     3     |    7     |
     *     |   8    |     4     |    6     |
     *     |  10    |     5     |    5     |
     *     |   2    |     6     |    4     |
     *     |   4    |     7     |    3     |
     *     |   6    |     8     |    2     |
     *     |   8    |     9     |    1     |
     *     |  10    |    10     |    0     |
     *     +--------+-----------+----------+
     *
     * Time complexity: O(n).
     * Auxiliary Space: O(1).
     *
     * https://www.codingninjas.com/blog/2021/09/24/detect-a-loop-in-a-linked-list/?amp=1
     *
     * */
    private static boolean isLoopExists(Node head) {

        if (head == null || head.next == null) {
            return false;
        }

        Node slowPtr, fastPtr;
        slowPtr = fastPtr = head;
        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;         // moves one step
            fastPtr = fastPtr.next.next;    // moves two steps

            if (slowPtr == fastPtr) {
                return true;                // cycle detected
            }
        }
        return false;                       // no detected
    }

}