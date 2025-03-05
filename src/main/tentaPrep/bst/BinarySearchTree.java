package main.tentaPrep.bst;

import java.util.LinkedList;
import java.util.Queue;

//Note: we must have "extends Comparable" since we only can putt in and take out thing we can compare, if not we
//don't know where to place the obj.
public class BinarySearchTree<E extends Comparable<E>>  {

    private Node<E> root;
    private E deletedData;

    private static class Node<E>{
        E data;
        Node<E>left;
        Node<E> right;

        public Node(E d) {
            this.data = d;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    public boolean add(E data){
        if (root == null) {
            root = new Node<>(data);
            return true;
        }
        return add(data, root);
    }

    private boolean add(E data, Node<E> node){
        if (data.compareTo(node.data)==0) return false;
        else if ((data.compareTo(node.data))<0){
            if (node.left==null){
                node.left = new Node<>(data);
                return true;
            }
            add(data, node.left);
        }
        else if ((data.compareTo(node.data))>0){
            if (node.right == null){
                node.right = new Node<>(data);
                return true;
            }
            return add(data, node.right);
        }
        return false;
    }

    public E find(E target){
        return find(target, root);
    }

    private E find(E target, Node<E> node){
        if (node==null) return null;
        if (target.compareTo(node.data)==0){
            return node.data;
        } else if (target.compareTo(node.data)<0){
            return find(target, node.left);
        } else if (target.compareTo(node.data)>0) {
            return find(target,node.right);
        }
        return null;
    }

    /*
    public Node<E> getNode(E data){
        return getNode(data, root);
    }

    private Node<E> getNode(E data, Node<E> node){
        if (node == null) return null;
        else if (data.compareTo(node.data) == 0) {
            return node;
        } else if (data.compareTo(node.data)<0) {
            return getNode(data, node.left);
        } else {
            return getNode(data, node.right);
        }
    }
    */

    public E remove(E target){
        root =  remove(target, root);
        return deletedData;
    }

    private Node<E> remove(E target, Node<E> node) {
        if (node == null) {
            deletedData = null;
            return null;
        }
        if (target.compareTo(node.data) < 0) {
            node.left = remove(target, node.left);
            return node;
        } else if (target.compareTo(node.data) > 0) {
            node.right = remove(target, node.right);
            return node;
        } else {
            deletedData = node.data;
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node<E> nodeToMove = node.right;
                Node<E> parentNodeToMove = node;
                if (nodeToMove.left == null){
                    nodeToMove.left = node.left;
                    return nodeToMove;
                }

                while (nodeToMove.left!=null){
                    parentNodeToMove = nodeToMove;
                    nodeToMove = nodeToMove.left;
                }
                parentNodeToMove.left = nodeToMove.right;
                node.data = nodeToMove.data;
                return node;
            }
        }
    }

    public String inOrder(Node<E> node, StringBuilder sb){
        if (node==null) return null;
        inOrder(node.left, sb);
        sb.append(" " + node);
        inOrder(node.right, sb);
        return sb.toString();
    }

    public String preOrder(Node<E> node, StringBuilder sb){
        if (node == null) return null;
        sb.append(" " +node);
        preOrder(node.left, sb);
        preOrder(node.right, sb);
        return sb.toString();
    }

    public String postOrder(Node<E> node, StringBuilder sb){
        if (node == null) return null;
        preOrder(node.left, sb);
        preOrder(node.right, sb);
        sb.append(" " +node);
        return sb.toString();
    }

    public String printTre(){
        StringBuilder sb = new StringBuilder();
        return printTre(root, sb);
    }

    private String printTre(Node<E> node, StringBuilder sb){
        Queue<String> queue = new LinkedList<>();
        if (node == null) return sb.toString();
        sb.append(" " + node);
        queue.offer(printTre(node.left, sb));
        queue.offer(printTre(node.right, sb));
        sb.append("\n");
        while (!queue.isEmpty()){
            sb.append(queue.poll());
        }
        return sb.toString();
    }


    public String toStringPre(){
        StringBuilder sb = new StringBuilder();
        return preOrder(root, sb);
    }

    public String toStringPost(){
        StringBuilder sb = new StringBuilder();
        return postOrder(root, sb);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        return inOrder(root, sb);
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> BST = new BinarySearchTree<>();
        System.out.println("add 2: " + BST.add(2));
        System.out.println(BST);
        System.out.println("add 3: " + BST.add(3));
        System.out.println(BST);
        System.out.println("add 1: " + BST.add(1));
        System.out.println(BST);
        System.out.println("find 3: " + BST.find(3));
        System.out.println("find 4: " + BST.find(4));
        //System.out.println("getNode(3).data: " + BST.getNode(3));
        //System.out.println("getNode(4).data: " + BST.getNode(4));
        //System.out.println("remove(2): " + BST.remove(2));
        System.out.println(BST);
        //System.out.println("remove(1): " + BST.remove(1));
        System.out.println(BST);
        System.out.println(BST.toStringPre());
        System.out.println("Print tree");
        System.out.println(BST.printTre());
    }
}
