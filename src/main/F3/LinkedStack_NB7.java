package main.F3;

import java.util.EmptyStackException;

public class LinkedStack_NB7<E> implements StackInt<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }
    private Node<E> top;

    public LinkedStack_NB7() {
        top = null;
    }

    @Override
    public E push(E obj) {
        top = new Node<E>(obj, top);
        return obj;
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            E result = top.data;
            top = top.next;
            return result;
        }
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            return top.data;
        }
    }

    public E peek(int index){
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = top;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        if (empty()) {
            throw new EmptyStackException();
        }
        int size = 0;
        Node<E> nextElement = top;
        while (nextElement != null){
            nextElement = nextElement.next;
            size++;
        }
        return size;
    }

    public E flush() {
        if (empty()) {
            throw new EmptyStackException();
        }
        E lastElement = top.data;
        while (top != null) {
            lastElement = top.data;
            Node<E> temp = top.next;
            top.next = null;
            top = temp;
        }
        return lastElement;
    }
}
