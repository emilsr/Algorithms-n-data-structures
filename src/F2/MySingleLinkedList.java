package F2;

/**
 * Needed component
 * -- Node
 * ---- Next, "points" to next node in list
 * ---- Data, payload of the node
 * -- size
 * Needed methods
 * -- add
 * -- remove
 * -- get
 * -- insert
 */

public class MySingleLinkedList<E> {

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

    public MySingleLinkedList(){
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

    private Node<E> getNode(int index){
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
        StringBuilder sb = new StringBuilder();
        Node<E> node = head;
        while (node != null) {
            sb.append(node.data.toString());
        }
    }
}
