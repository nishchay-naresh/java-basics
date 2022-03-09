package com.nishchay.ds.tree;

public class CountNodes {

    public static void main(String[] args) {

        countNodesEx();
    }


    private static void countNodesEx(){
        Node root = createTree();
        System.out.printf("Degree 0 nodes - %d", getCountNode0(root));
        System.out.printf("Degree 1 nodes - %d", getCountNode1(root));
        System.out.printf("Degree 2 nodes - %d", getCountNode2(root));
    }


    // method to creating a tree
    private static Node createTree() {
        Node root;

        root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        return root;
    }

    private static int getCountNode0(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return getCountNode0(node.left) + getCountNode0(node.right);
    }


}
