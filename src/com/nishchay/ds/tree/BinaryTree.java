package com.nishchay.ds.tree;

/*
 * Java class to solve various problems of tree data structure
 *
 * */
public class BinaryTree {

    public static void main(String[] args) {

        checkIsBSTEx();

    }

    private static void checkIsBSTEx(){
        Node root = createTree();
        System.out.printf("%s", checkIsBST(root) ? "Is BST" : "Not a BST");
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

    private static boolean checkIsBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* method to check if given Binary tree is a BST or not */
    private static boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;

        // false if this root violates the min/max constraints : min <= root.data <= max
        if (root.data < min && root.data > max)
            return false;

        // otherwise check the subtrees recursively tightening the min/max constraints
        return (isBST(root.left, min, root.data) && isBST(root.right, root.data, max));
    }




}