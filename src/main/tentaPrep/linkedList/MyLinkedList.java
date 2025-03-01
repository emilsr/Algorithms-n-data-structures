package main.tentaPrep.linkedList;

/**
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
        MyLinkedList ll = new MyLinkedList();
        System.out.println("add node: " + ll.add("1", 0));
        System.out.println(ll);
        System.out.println("add node: " + ll.add("2", 0));
        System.out.println(ll);
        System.out.println("add node: " + ll.add("3", 0));
        System.out.println(ll);
        System.out.println("add node: " + ll.add("4", 1));
        System.out.println(ll);
        System.out.println("add node: " + ll.add("5", 1));
        System.out.println(ll);
        System.out.println("add node: " + ll.add("6", 5));
        System.out.println(ll);
        System.out.println(ll.remove("4"));
        System.out.println(ll);
        System.out.println(ll.remove("6"));
        System.out.println(ll);
        System.out.println(ll.remove("3"));
        System.out.println(ll);
        System.out.println(ll.size());




    }


}
