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
        if (index == 0){
            addFisrt(item);
        } else {
            Node<E> node = getNode(index-1);
            addAfter(node, item);
        }
    }

    private Node<E> getNode(int index){
        return null;
    }

    private void addFisrt(E data){

    }

    private void addAfter(Node<E> node, E item){

    }





}
