package main.tentaPrep.ten.ten5_220610.losningar.uppgift3;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E>{
        private E data;
        private Node<E> left,right;
        private Node(E d){
            data=d;
            left=right=null;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }

    private Node<E> root;

    public BinarySearchTree(){
        root=null;
    }

    private String toString(Node<E> node){
        if(node!=null){
            return toString(node.left) + node + " " + toString(node.right);
        }
        return "";
    }

    @Override
    public String toString(){
        return toString(root);
    }

    private boolean add(E data,Node<E> node){
        if(data.compareTo(node.data)==0) return false;
        if(data.compareTo(node.data)<0) {
            if (node.left == null) {
                node.left = new Node<>(data);
                return true;
            } else
                return add(data, node.left);
        }
        if(node.right==null){
            node.right = new Node<>(data);
            return true;
        }else
            return add(data,node.right);
    }
    public boolean add(E data){
        if(root==null){
            root = new Node<>(data);
            return true;
        }
        return add(data,root);
    }

    public int size(){
        return size(root);
    }

    private int size(Node<E> node) {
        if(node == null) return 0;
        return 1+size(node.left)+size(node.right);
    }

}

