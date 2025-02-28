package main.tentaPrep.linkedList;

/**
 *
 * Implementera metoder som add(index, item) och get(index) i en länkad lista.
 *
 * Skriva metoden remove till en lista.
 *
 * Skriva metoden size till listan. Använd rekursion för att lösa uppgiften.
 *
 * Få en iterator att fungera korrekt för en enkellänkad lista.
 *
 * Lägga till en metod för att ange startindex för en iterator.
 */
public class MyLinkedList <E> {

    private Node<E> head;
    private int size;

    private static class Node <E> {
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

    public MyLinkedList (){
        head = null;
        size=0;
    }

    public boolean add(E data, int index){
        if (index == 0){
            addFirst(data);
            return true;
        } else if (index == size) {
            addLast(data);
            return true;
        } else {
            addAtIndex(data,index);
        }
        return false;
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
            System.out.println(t);
        }
        t.next = new Node<>(data, t.next.next);
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
        Node t = head;
        sb.append("List = {").append(head.data);
        for (int i = 0; i < size-1; i++){
            sb.append(", ").append(t.next.data);
            t = t.next;
        }
        sb.append("} size = ").append(size);
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.add("1", 0);
        ll.add("2", 0);
        ll.add("3", 2);
        ll.add("4", 1);

        System.out.println(ll);


    }


}
