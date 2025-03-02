package main.tentaPrep.linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * ToDo fixa method getNode(index)
 * ToDo implementera en E Get(index)
 * Skriva metoden size till listan. Använd rekursion för att lösa uppgiften.
 *
 * Få en iterator att fungera korrekt för en enkellänkad lista.
 *
 * Lägga till en metod för att ange startindex för en iterator.
 */
public class MyLinkedList <E> implements Iterable {

    Node<E> head;
    int size;

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node <E> next){
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }

    }

    private class Itr implements Iterator<E>{
        Node<E> current;

        public Itr(Node<E> start){
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public E next() {
            if (current==null){
                throw new NoSuchElementException();
            }
            E t = current.data;
            current = current.next;
            return t;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

    public MyLinkedList (){
        head = null;
        size=0;
    }

    public boolean add(E data){
        return add(data, size);
    }

    // ToDo attLast och addAtIndex är samma method...
    public boolean add(E data, int index){
        if (0 > index || index > size) throw new IndexOutOfBoundsException();
        if (data == null) throw new IllegalArgumentException();
        if (index == 0){
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            addAtIndex(data,index);
        }
        return true;
    }

    public E remove(E data){
        Node<E> t = head;
        if (head.data == data){
            head = head.next;
            size--;
            return data;
        }
        while (t.next != null){
            if (t.next.data == data){
                t.next = t.next.next;
                size--;
                return data;
            }
            t = t.next;

        }
        return null;
    }

    public Iterator<E> iterator(){
        return new Itr(head);
    }

    public int size(){
        return size(head);
    }

    private int size(Node<E> node){
        if (node.next == null) return 1;
        return size(node.next)+1;
    }

    private void addFirst(E data){
        Node<E> newNode = new Node<>(data, head);
        head = newNode;
        size++;
    }

    private void addAtIndex(E data, int index){
        Node<E> t = head;
        for (int i = 0; i < index-1; i++){
            t = t.next;
        }
        t.next = new Node<>(data, t.next);
        size++;
    }

    private void addLast(E data){
        Node<E> t = head;
        while (t.next != null){
            t = t.next;
        }
        t.next = new Node<>(data, null);
        size++;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> t = head;
        sb.append("List = {").append(t.data);
        while (t.next != null){
            t = t.next;
            sb.append(", ").append(t.data);
        }
        sb.append("} size = ").append(size);
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<String> ll = new MyLinkedList();

        for (int i = 0; i<10; i++){
            ll.add("Sträng" + i);
        }
        Iterator iter = ll.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }


}
