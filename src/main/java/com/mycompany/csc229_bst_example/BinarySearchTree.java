package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {// ToDo 1: complete InOrder Traversal
        if (root!=null) {
            doInOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            doInOrder(root.getRight());
        }


    }
    private void doPreOrder(BstNode root) {// ToDo 2: complete the pre-order travesal .
        if (root!=null) {
            System.out.print(root.getData()+" ");
            doPreOrder(root.getLeft());
            doPreOrder(root.getRight());
        }
    }
        public void preOrderTraversal() {
        doPreOrder(this.root);

    }

    public Integer findHeight(BstNode node) {// ToDo 3: Find the height of a tree
        BstNode left = node.getLeft();
        BstNode right = node.getRight();
        if (node == null) {
            return -1;
        }
        else {
            return 1 + Math.max(findHeight(left), findHeight(right));
        }

    }

    

    public int getDepth(BstNode node, BstNode root, int depth) {//ToDo 4: complete getDepth of a node
        if (root == null) {
            return -1;
        }
        if (root.getData().equals(node.getData())) {
            return depth;
        }
        int leftDepth = getDepth(root.getLeft(), node, depth + 1);
        if (leftDepth != -1) {
            return leftDepth;
        }
        depth++;
        return getDepth(node, root.getRight(), depth);
    }
    
   public void print() {
       System.out.println("\n==== BST Print =====");
       print(root, "", true);
       System.out.println();
   }
    private void print(BstNode root, String str, boolean bool) {
        if (root!=null){
            if(bool){
                print(root.getRight(), str + "│   " , false);
            }
            else{
                print(root.getRight(), str + "    ", false);
            }
            System.out.println(str + "--" + root.getData());
            if(bool){
                print(root.getLeft(), str + "    ", true);
            }
            else{
                print(root.getLeft(), str + "│   ", true);
            }
        }

    }

}
