package uppgift3;

public class StringQueue {

    private Node front;
    private Node rear;
    
    private class Node {
        private String data;
        private Node next;

        Node (String str) {
            this.data = str;
            this.next = null;
        }

        Node () {
            this.data = null;
            this.next = null;
        }
    }

    StringQueue(){
        front = null;
        rear = null;
    }

    public boolean enqueue(String item){
        Node newRear = new Node(item);
        if (front == null) {
            front = newRear;
        }
        else if (rear == null){
            rear = newRear;
        }
        else {
            rear.next = newRear;
            rear = rear.next;
        }
        return true;
    }

    public String dequeue(){
        if (front == null) {
            return null;
        }
        String temp = front.data;
        if (front!=rear) {
            front = front.next;
        } else {
            front = null;
        }
        return temp;
    }

    public String peak(){
        if (front != null) {
            return front.data;
        }
        return null;
    }

    public boolean isEmpty(){
        return front != null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node t = new Node();
        while (t != null) {
            sb.append(t.data);
            sb.append(": ");
            t = t.next;
        }
        return sb.toString(); 

    }

    //ToDo
    // enqueue
    // dequeue
    // peak
    // isEmpty

}
