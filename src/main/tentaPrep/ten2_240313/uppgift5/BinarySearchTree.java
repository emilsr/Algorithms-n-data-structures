package main.tentaPrep.ten2_240313.uppgift5;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E>{
        private E data;
        private Node<E> left,right;
        private Node(E data){
            this.data=data;
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

    private void inOrder(Node<E> node, StringBuilder sb){
        if(node!=null){
            inOrder(node.left, sb);
            sb.append(": ").append(node);
            inOrder(node.right, sb);
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
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

    public int height(){
        if (root == null) return 0;
        return height(root);
    }

    private int height(Node<E> node){
        if (node == null) return 0;
        return Math.max((height(node.left)+1), (height(node.right)+1));
    }

    public int height(E data){
        Node<E> node = root;
        while (node != null && node.data.compareTo(data) != 0) {
            if (data.compareTo(node.data)<0){
                node = node.left;
            }else if (data.compareTo(node.data)>0){
                node = node.right;
            }
        }
        return height(node);
    }

    public boolean siblings(E data1, E data2){
        return false;
    }
}
