package main.tentaPrep.ten.ten1_240604.uppgift6;


import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * Du gjorde detta mycker svårare än vad det behöver vara...
     * använd en flaga för att kolla om du hittat null, om du hittar en ny nod efter det så ör det rip...
     * du behöver inte en wrapper... vet inte änns varför du tämnkte det.
     * gör om denna efter du har ättit...
     * @return
     */
    public boolean complete(){
        if (root == null) return false;
        return complete(root);
    }

    private boolean complete(Node<E> node){
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        int w = 1;

        while (!queue.isEmpty()){
            System.out.println("wQ.size: " + queue.size());
            System.out.println("W " + w);
            boolean flag = queue.size() == w;
            for (int i = w; i>0; i--){
                node = queue.poll();
                if (!leafCheck(node)){
                    flag = false;
                }

            }
            if (flag) return true;
            if (node.left != null && node.right != null){
                queue.offer(node.left);
                queue.offer(node.right);
            }
            w = w*2;
            System.out.println("outer Q size: " + queue.size());

        }
        return false;
    }


    private boolean leafCheck(Node<E> node){
        return node.left == null && node.right == null;
    }


}
