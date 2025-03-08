package main.tentaPrep.ten.ten3_230607.losningar.uppgift3;

import java.util.ArrayDeque;
import java.util.Queue;

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
        if(data.compareTo(node.data)==0)
            return false;
        else if(data.compareTo(node.data)<0)
            if(node.left==null){
                node.left = new Node<>(data);
                return true;
            }else
                return add(data,node.left);
        else
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
        }else{
            return add(data,root);
        }
    }

    public String widthFirstString(){
        Queue<Node<E>> queue = new ArrayDeque<>();
        if(root!=null) queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            Node<E> current = queue.poll();
            sb.append(current.data + ", ");
            if(current.left!=null) queue.offer(current.left);
            if(current.right!=null) queue.offer(current.right);
        }
        return sb.toString();
    }

}
