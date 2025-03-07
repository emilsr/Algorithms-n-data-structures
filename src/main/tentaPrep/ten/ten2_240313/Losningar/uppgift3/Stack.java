package main.tentaPrep.ten.ten2_240313.Losningar.uppgift3;

public class Stack {
    private static class Node{
        private String data;
        private Node next;
        private Node(String d, Node n){
            data=d;
            next=n;
        }
    }

    private Node top;

    public Stack(){
        top=null;
    }

    public String push(String data){
        top = new Node(data,top);
        return data;
    }

    public String pop(){
        if(top==null) return null;
        String result = top.data;
        top=top.next;
        return result;
    }

    public String peek(){
        if(top==null) return null;
        return top.data;
    }

    public boolean isEmpty(){
        return top==null;
    }
}
