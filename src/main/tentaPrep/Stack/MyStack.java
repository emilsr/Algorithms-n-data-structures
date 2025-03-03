package main.tentaPrep.Stack;

/**
 * Stackar:

 *
 * pop()
 * push()
 *
 * create()
 * empty()
 * peak()
 */

public class MyStack<E> {

    private StackList<E> stack;
    private int size;

    public MyStack(){
        stack = new StackList<>();
        size = 0;
    }

    public void create(){
        new MyStack();
    }

    public boolean push(E element){
        stack.add(element);
        size++;
        return true;
    }

    public E pop(){
        if (size == 0) return null;
        size--;
        return stack.remove();
    }

    public boolean empty(){
        return size==0;
    }

    public E peak(){
        return stack.peek();
    }


    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 0; i<10; i++){
            System.out.println("add " + i+ " to stack: " + stack.push(i));
        }
        System.out.println("peek: " + stack.peak());
        System.out.println("Empty: " + stack.empty());
        for (int i = 0; i<10; i++){
            System.out.println("pop from stack: " + stack.pop());
        }
        System.out.println("pop from empty stack, should return null: " + stack.pop());
        System.out.println("Empty: " + stack.empty());
    }



}
