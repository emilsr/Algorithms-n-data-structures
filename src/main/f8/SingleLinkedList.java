package main.f8;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SingleLinkedList<E> implements Iterable<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
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
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
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

    private Node<E> getNode(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
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

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;
            private Node<E> beforCurrent = null;
            private Node<E> beforBeforCurrent = null;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
                beforBeforCurrent = beforCurrent;
                beforCurrent = current;
                E data = current.data;
                current = current.next;
                return data;
            }
            @Override
            public void remove(){       //ToDo this is broken
                if (beforCurrent == null || beforBeforCurrent == beforCurrent) {
                    throw new IllegalStateException("Can't call remove() before next()");
                }
                if (beforBeforCurrent != null){
                    beforBeforCurrent.next = current.next;
                } else {
                    head = current;
                }
                beforCurrent = beforBeforCurrent;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }

}
