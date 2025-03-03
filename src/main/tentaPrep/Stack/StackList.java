package main.tentaPrep.Stack;

import java.util.NoSuchElementException;

public class StackList<E> {

    private Node<E> head;

    private static class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next){
            this.data=data;
            this.next=next;
        }
    }

    public StackList(){
        head = new Node<>(null, null);
    }

    public boolean add(E data){
        if (data==null) throw new NoSuchElementException();
        head = new Node<>(data, head);
        return true;
    }

    public E remove(){
        if (head == null) return null;
        E t = head.data;
        head = head.next;
        return t;
    }

    public E peek(){
        if (head == null) return null;
        return head.data;
    }

}
