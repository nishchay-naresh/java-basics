package com.nishchay.test.paypal;


import java.util.ArrayList;
import java.util.List;

/*
 *
 *	Flat a muti-level singly linked list, level wise
 *	input : 1 -->2 --> 3-->4 -> NULL
 *				|         |
 *				5-->6     9-> 10
 *				|
 *				11
 *
 *    output : 1-->2-->3-->4-->5-->6-->9-->10-->11
 *
* */
public class FlatSLL {

    public static void main(String[] args) {

        System.out.println("main");

        Node head = createList();

        flatList(head);

    }

    private static Node createList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);


        return head;
    }

    private static void flatList(Node head) {

        List<Node> queue = new ArrayList<>();

        Node p = head;
        for( ; p.next != null; p=p.next){
            if(p.down!=null){
                queue.add(p.down);
            }
        }
        for (Node currNode:queue) {
            p.next = currNode;
            p=p.next;
            if(currNode.down!=null){
                queue.add(currNode.down);
            }
            while(currNode.next!=null){
                p.next = currNode.next;
                p=p.next;
            }
        }
    }
/*
   1 -->2 --> 3-->4 -> NULL
        |         |
        5-->6     9-> 10
        |
        11
        1-->2-->3 4 5 6  9 10 11
* */

}

class Node{
    int data;
    Node next, down;

    public Node() {
        data =0;
        next= down = null;

    }

    public Node(int data) {
        data =data;
        next= down = null;

    }
}
