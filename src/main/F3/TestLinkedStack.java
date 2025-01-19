package main.F3;

public class TestLinkedStack {

    public static void main(String[] args){
        LinkedStack_NB7<Integer> test = new LinkedStack_NB7<>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(1);
        test.push(5);
        System.out.println("Should print 5: " + test.peek());
        System.out.println("Should print 4: " + test.peek(2));
        System.out.println("Should print 6: " + test.size());
        System.out.println("Should print 5: " + test.pop());
        System.out.println("Should print 5: " + test.size());
        System.out.println("Should print 1: " + test.flush());
        System.out.println("stack is empty exception should be thrown" + test.size());
    }
}