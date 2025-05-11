
package uppgift3;

public class AnsStringQueue {

    private static class Node {

        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node front, rear;
    private int size;
    
    public StringQueue(){
        front=rear=null;
        size=0;
    }
    
    public void enqueue(String data){
        if(isEmpty())
            front=rear=new Node(data,null);
        else{
            rear.next=new Node(data,null);
            rear=rear.next;
        }
        size++;
    }
    
    public String dequeue(){
        if(isEmpty()) return null;
        String returnData = front.data;
        front=front.next;
        size--;
        if(size==0) rear=null;
        return returnData;
    }

    public String peak(){
        if(isEmpty()) return null;
        return front.data;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
}
