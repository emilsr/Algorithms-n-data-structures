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

    private E peek(int idex) {
        Node<E> result = top;
        for (int i = 0; i < idex; i++) {
            result = result.next;
        }
        return result.data;
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

    //ToDo size(), peek(n), och flush()

    public static void main(String[] args) {
        LinkedStack_NB7 stack = new LinkedStack_NB7();
        System.out.println(stack.empty());

        System.out.println(stack.push(1));
        System.out.println(stack.push(2));
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        for (int i = 0; i<10; i++) {
            stack.push(i);
        }
        System.out.println(stack.peek(0));


    }


}
