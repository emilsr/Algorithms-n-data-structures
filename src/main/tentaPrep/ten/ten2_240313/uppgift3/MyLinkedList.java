package main.tentaPrep.ten.ten2_240313.uppgift3;

public class MyLinkedList<E> {

    Node<E> head;

    private class Node<E> {
        E data;
        Node<E> next;

        private Node(E data){
            this.data = data;
            next = null;
        }

        private Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    public MyLinkedList(){
        head = null;
    }

    public boolean add(E data){
        if (data == null) return false;
        if (head == null) head = new Node<>(data);
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

    public boolean isEmpty(){
        return head == null;
    }
}
