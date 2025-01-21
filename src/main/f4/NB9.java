package main.f4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Implementera en kö med en enkellänkad lista med en pekare till varje ända av listan så att alla
 * operationer blir O(1). Det räcker om du implementerar enqueue (offer), dequeue (poll) och size.
 * Använd bara bokens exempel om du kör fast.
 */

public class NB9<E> {

    private static class Node<E> {
        private E data;
        private NB9.Node<E> next;

        public Node(E data, NB9.Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private class Itr implements Iterator<E> {
        NB9.Node<E> current;

        public Itr(NB9.Node<E> start) {
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


    private NB9.Node<E> head;
    private int size = 0;

    public NB9(){
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
            NB9.Node<E> node = getNode(index-1);
            addAfter(node, item);
        }
    }

    public boolean add(E item){
        add(size, item);
        return true;
    }

    private void addFirst(E item){
        head = new NB9.Node<E>(item, head);
        size++;
    }

    private void addAfter(NB9.Node<E> node, E item){
        node.next = new NB9.Node<E>(item, node.next);
        size++;
    }

    private NB9.Node<E> getNode(int index){
        NB9.Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    private E get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        NB9.Node<E> node = getNode(index);
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
        NB9.Node<E> node = head;
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
