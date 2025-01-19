package main.F3;

import java.util.EmptyStackException;

public class LinkedStack<E> implements StackInt<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }
    private Node<E> top;

    public LinkedStack() {
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


    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        System.out.println(stack.empty());

        System.out.println(stack.push(1));
        System.out.println(stack.push(2));
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.empty());


    }


}
