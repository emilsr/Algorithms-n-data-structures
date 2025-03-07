package main.tentaPrep.ten.ten2_240313.Losningar.uppgift5;

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
    private E deletedData;

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
        return height(root);
    }

    private int height(Node<E> node) {
        if(node==null) return 0;
        return 1 + Math.max(height(node.left),height(node.right));
    }

    public int height(E data){
        return height(findNode(data, root));
    }
    private Node<E> findNode(E target, Node<E> node){
        if( node==null)
            return null;
        if(target.compareTo(node.data)==0)
            return node;
        if(target.compareTo(node.data)<0)
            return findNode(target,node.left);
        return findNode(target,node.right);
    }
    public boolean siblings(E data1, E data2){
        if(data1.compareTo(data2)==0) return false;
        if(data1.compareTo(data2)<0) return siblings(data1, data2, root);
        return siblings(data2,data1,root);
    }

    private boolean siblings(E data1, E data2, Node<E> node) {//förutsätter data1<data2
        if(node==null) return false;
        if(data2.compareTo(node.data)<0) return siblings(data1,data2,node.left);
        if(data1.compareTo(node.data)>0) return siblings(data1,data2,node.right);
        if(node.left==null||node.right==null) return false;
        if(data1.compareTo(node.left.data)==0&&data2.compareTo(node.right.data)==0) return true;
        return false;
    }
}
