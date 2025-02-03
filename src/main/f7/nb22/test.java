package main.f7.nb22;

import main.f7.BinarySearchTree;

public class test {
    public static void main(String[] args) {
        BinarySearchTreeNb22 bst = new BinarySearchTreeNb22();
        bst.add(4);
        bst.add(2);
        bst.add(6);
        bst.add(1);
        bst.add(3);
        bst.add(5);
        bst.add(7);
        System.out.println("PreOrder: " +bst.toString("preOrder"));
        System.out.println("InOrder: " +bst.toString());
        System.out.println("PostOrder: " +  bst.toString("postOrder"));
    }
}
