package main.tentaPrep.ten.ten2_240313.Losningar.uppgift3;

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack();
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        for(int i=0;i<5;i++)
            myStack.push("data: "+i);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.push("data 5"));
        while(!myStack.isEmpty())
            System.out.print(myStack.pop()+" ");
    }
}
