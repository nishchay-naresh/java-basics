package com.nishchay.ds.tree;

public class CountNodes {

    public static void main(String[] args) {


    }


    private static void countNodesEx(){
        Node root = createTree();
        System.out.printf("Degree 0 nodes - %d", getCountNode0(root));
        System.out.printf("Degree 1 nodes - %d", getCountNode1(root));
        System.out.printf("Degree 2 nodes - %d", getCountNode2(root));
    }

}
