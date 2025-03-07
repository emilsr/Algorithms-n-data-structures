package main.tentaPrep.ten2_240313.uppgift3;

public class MyStack {

    MyLinkedList<String> stack;

    public MyStack(){
        this.stack = new MyLinkedList<String>();
    }

    public boolean push(String str){
        return stack.add(str);
    }

    public String peek(){
        return stack.peek();
    }

    public String pop(){
        return stack.remove();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
