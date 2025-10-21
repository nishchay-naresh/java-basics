package com.nishchay.ds.linklist;

public class Utils {


    // creating a singly linked list (10-50)
    static Node createList() {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        head.next.next.next.next.next = null;
        return head;
    }

    // create a singly linked list from an array int[]
    public static Node createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node current = head;

        // Iterate through the rest of the array to create subsequent nodes
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper function to print a given linked list
    static void printList(Node head) {
        System.out.println("Link List Content :");
        String delim = "head => ";
        for (Node p = head; p != null; p = p.next) {
            System.out.print(delim + p.data);
            delim = " -> ";
        }
        System.out.println(" -> null");
    }

}
