package com.nishchay.ds.tree;

public class Tree {

    /*
     * TODO
     * Code to perform BST search
     *            2
     *        1       3
     * */

    /*       Node searchBST(Node root, int key){

            if(root == null){
                return;
            }else if(root.data == key){
                return root;
            }
            if(root.left == null && root.left == null){
                return;
            }
            if(root.left != null || root.right != null){
                searchBST(root.left, key);
                searchBST(root.right, key);
            }

        }
*/

    // A utility function to search a given key in BST
    public Node search(Node root, int key)    {
        if (root==null || root.data==key)
            return root;

        if (root.data < key)
            return search(root.right, key);

        return search(root.left, key);
    }

}
