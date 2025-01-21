package main.f4;

/**
 * Implementera en kö med en enkellänkad lista med en pekare till varje ända av listan så att alla
 * operationer blir O(1). Det räcker om du implementerar enqueue (offer), dequeue (poll) och size.
 * Använd bara bokens exempel om du kör fast.
 */

public class NB9<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public NB9(){
        head = null;
        tail = null;
        size = 0;
    }

    public boolean enqueue(E e){
        Node<E> newNode = new Node<E>(e, null);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public E dequeue(){
        if(head == null){
            throw new IllegalStateException("Queue is empty");
        }
        E data = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return data;
    }

    public int size(){
        return size;
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
