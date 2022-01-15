package com.nishchay.ds.linklist;

/*
 * Java class to solve various small problems of singly linked list
 *
 * */
class SinglyLinkedList {

    public static void main(String[] args) {

//        createPrintListEx();
//        printMiddleElementEx();
//        printFromBackEx();
//        printFrontAndBack();
//        searchNodeEx();
        nthFromLastNodeEx();
//        reverseListEx();
//        isLoopExistsEx();

    }


    private static void createPrintListEx() {
        Node head = createList();
        System.out.println("Link List Content :");
        printList(head);
    }


    private static void printMiddleElementEx() {
        Node head = createList();
        System.out.println("Link List Content :");
        printList(head);

        printMiddleElement(head);
    }

    private static void printFromBackEx() {
        Node head = createList();
        System.out.println("Original list :");
        printList(head);

        System.out.println("List printing from back :");
        printFromBack(head);
    }


    private static void printFrontAndBack() {
        Node head = createList();
        System.out.println("Original list :");
        printList(head);

        System.out.println("Front & Back traversal :");
        printFrontAndBack(head);

        System.out.println("\n-----------------------------------");

        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        System.out.println("Original list :");
        printList(head);

        System.out.println("Front & Back traversal :");
        printFrontAndBack(head);
    }

    private static void searchNodeEx() {
        Node head = createList();
        System.out.println("Original list :");
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


    private static void nthFromLastNodeEx() {
        Node head = createList();
        System.out.println("Original list :");
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

    private static void reverseListEx() {
        Node head = createList();
        System.out.println("Original list :");
        printList(head);

        head = reverse(head);
        System.out.println("Reversed list :");
        printList(head);
    }

    private static void isLoopExistsEx() {
        Node head = createList();
        System.out.println("Original list :");
        printList(head);
        System.out.printf("%s%n", isLoopExists(head) ? "Loop found" : "Loop not found");

        System.out.println("-----------------------------------");

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

    // creating a singly linked list (10-50)
    private static Node createList() {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        head.next.next.next.next.next = null; // optional
        return head;
    }

    // prints content of a singly linked list
    private static void printList(Node head) {
        String delim = "head => ";
        for (Node p = head; p != null; p = p.next) {
            System.out.print(delim + p.data);
            delim = " -> ";
        }
        System.out.println(" -> null");
    }


    /* Function to print middle of linked list */
    private static void printMiddleElement(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        System.out.println("The middle element is = " + slowPointer.data);
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

    // method to get nth node from the last
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

    /* Function to reverse the linked list */
    public static Node reverse(Node head) {
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

    /*
     *  Floyd’s Tortoise and Hare Algorithm (Cycle Detection Algorithm).
     *  slowPtr &  fastPtr concept
     *
     * Time complexity: O(n).
     * Auxiliary Space:O(1).
     * */
    private static boolean isLoopExists(Node head) {
        Node slowPtr = head, fastPtr = head;
        int flag = 0;
        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }


}