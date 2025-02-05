package main.f6.nb17;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SingleLinkedList<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private class Itr implements Iterator<E> {
        Node<E> current;

        public Itr(Node<E> start) {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null){
                throw new NoSuchElementException();
            }
            if (!hasNext())
                return null;
            current = current.next;
            return (E) current;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Iterator.super.forEachRemaining(action);
        }
    }

    private Node<E> head;
    private int size = 0;

    public SingleLinkedList(){
        head = null;
        size = 0;
    }

    public void add(int index, E item){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            addFirst(item);
        } else {
            Node<E> node = getNode(index-1);
            addAfter(node, item);
        }
    }

    public boolean add(E item){
        add(size, item);
        return true;
    }

    private void addFirst(E item){
        head = new Node<E>(item, head);
        size++;
    }

    private void addAfter(Node<E> node, E item){
        node.next = new Node<E>(item, node.next);
        size++;
    }

    public Node<E> getNode(int index){
        return getNodeRecursive(head, index);
    }

    private Node<E> getNodeRecursive(Node<E> node, int index){
        if (index == 0){
            return node;
        } return getNodeRecursive(node.next, index-1);
    }

    private E get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public String toStringT() {
        return "MySingleLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node<E> node = head;
        if (head != null){
            while (node.next != null) {
                sb.append(node.data.toString());
                sb.append(" -> ");
                node = node.next;
            }
            sb.append(node.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }
}
