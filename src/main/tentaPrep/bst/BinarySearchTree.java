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

    public int nrOfNodes(){
        if (root == null) return 0;
        int counter=1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        Node<E> node;

        while (!queue.isEmpty()){
            node = queue.poll();
            if (node.left != null){
                queue.offer(node.left);
                counter++;
            }
            if (node.right!= null){
                queue.offer(node.right);
                counter++;
            }
        }
        return counter;
    }

    public int nrOfLeafs(){
        if (root == null) return 0;
        int counter=0;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        Node<E> node;

        while (!queue.isEmpty()){
            node = queue.poll();
            if (node.left == null && node.right == null){
                counter++;
            }
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right!= null){
                queue.offer(node.right);
            }
        }
        return counter;
    }

    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(Node<E> node){
        if (node == null) return 0;
        return Math.max(getHeight(node.left)+1, getHeight(node.right)+1);
    }

    public E maxRec(){
        return maxRec(root);
    }

    private E maxRec(Node<E> node){
        if (node == null) return null;
        if (node.right != null) return maxRec(node.right);
        return node.data;
    }

    public E maxIt(){
        Node<E> node = root;
        while (node.right != null){
            node = node.right;
        }
        return node.data;
    }

    public E findIt(E target){
        Node<E> node = root;
        while (target.compareTo(node.data) != 0){
            if (target.compareTo(node.data)>0 && node.right != null){
                node = node.right;
            } else if (target.compareTo(node.data)<0 && node.left != null) {
                node = node.left;
            } else {
                return null;
            }
        }
        return node.data;
    }

    public String printTre(){
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int wight = queue.size();
            StringBuilder levelSb = new StringBuilder();

            for (int i = 0; i<wight; i++){
                Node<E> node = queue.poll();
                if (node != null){
                    levelSb.append(node.data).append(" ");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else {
                    levelSb.append("null ");
                }
                if ((i+1)%2==0){
                    levelSb.append(": ");
                }
            }
            sb.append(levelSb.toString()).append("\n");
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
        System.out.println("add 7: " + BST.add(7));
        System.out.println(BST);
        System.out.println("add 12: " + BST.add(12));
        System.out.println(BST);
        System.out.println("add 3: " + BST.add(3));
        System.out.println(BST);
        System.out.println("add 2: " + BST.add(2));
        System.out.println("add 1: " + BST.add(1));
        System.out.println("add 3: " + BST.add(5));
        System.out.println("add 3: " + BST.add(4));

        System.out.println("Print tree");
        System.out.println(BST.printTre());
        System.out.println("Nr of nodes:" + BST.nrOfNodes());
        System.out.println("Nr of leafs: " + BST.nrOfLeafs());
        System.out.println("getHeight: " + BST.getHeight());
        for (int i = 13; i<19; i++){
            System.out.println("add " + i +": " + BST.add(i));
        }
        System.out.println("Print tree");
        System.out.println(BST.printTre());

        System.out.println("getHeight: " + BST.getHeight());
        System.out.println("maxRec: " + BST.maxRec());
        System.out.println("maxIt: " + BST.maxIt());
        System.out.println("findIt: " + BST.findIt(100));

    }
}
