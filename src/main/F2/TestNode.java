package main.F2;

public class TestNode {
    public static void main(String[] args) {
        Node[] linkedNodes = new Node[4];
        linkedNodes[3] = new Node("stäppen", null);
        linkedNodes[2] = new Node("på", linkedNodes[3]);
        linkedNodes[1] = new Node("löper", linkedNodes[2]);
        linkedNodes[0] = new Node("Gilgamesh", linkedNodes[1]);
        
        Node nextNode = linkedNodes[0];
        while (nextNode != null) {
            System.out.print(nextNode.data + " ");
            nextNode = nextNode.next;
        }
        System.out.println("\nLink node[1] to node[3]");
        nextNode = linkedNodes[0];
        linkedNodes[1].next = linkedNodes[3];
        while (nextNode != null) {
            System.out.print(nextNode.data + " ");
            nextNode = nextNode.next;
        }
    }
}
