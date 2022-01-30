package com.nishchay.ds.tree;

// Class containing left and right child reference of current node and data
class Node {

    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }

}