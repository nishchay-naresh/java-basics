package com.nishchay.ds.linklist;
// Java program for reversing the linked list

class SinglyLinkedList {


    public static void main(String[] args) {
        Node head = createList();

        System.out.println("Link List Content :");
        printList(head);

    }

    // creating a singly linked list (10-50)
    private static Node createList() {
        Node head =  new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        return head;
    }

    // prints content of a singly linked list
    private static void printList(Node head) {
        String delim = "head => ";
        for (Node p = head; p != null; p = p.next) {
            System.out.print(delim + p.data);
            delim = " -> ";
        }
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




}