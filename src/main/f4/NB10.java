package main.f4;

public class NB10<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E data, Node<E> next, Node<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public NB10(){
        head = null;
        tail = null;
        size = 0;
    }

    public boolean enqueue(E e){
        Node<E> newNode = new Node<E>(e, null, tail);
        if(tail == null){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
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
        } else {
            head.prev = null;
        }
        size--;
        return data;
    }

    public int size(){
        return size;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> node = head;
        while (node != null) {
            sb.append(node.data);
            if (node.next != null) {
                sb.append(" <-> ");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }


}
