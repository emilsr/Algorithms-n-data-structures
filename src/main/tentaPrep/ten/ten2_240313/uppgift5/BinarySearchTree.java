package main.tentaPrep.ten.ten2_240313.uppgift5;

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
        return heightRec(root);
    }

    private int heightRec(Node<E> node){
        if (node == null) return 0;
        int height = Math.max(heightRec(node.left), heightRec(node.right));
        return height +1;
    }

    public int height(E data){
        Node<E> node = getNode(data, root);
        return heightRec(node);
    }

    private Node<E> getNode(E data , Node<E> node){
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) == 0) {
            return node;
        } else if (data.compareTo(node.data) < 0) {
            return getNode(data, node.left);
        }
        return getNode(data, node.right);
    }

    public boolean siblings(E data1, E data2){
        return false;
    }
}
