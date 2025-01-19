package main.F3;

public class TestArrayListStack  {
    public static void main(String[] args) {
        ArrayListStack_NB5<Integer> stack = new ArrayListStack_NB5<>();

        System.out.println("Is stack empty?     " + stack.empty());
        System.out.println("push 1, 2, 3 ");

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Is stack empty?     " + stack.empty());
        System.out.println("Top element:        " + stack.peek());

        System.out.println("Popping and peeking elements:");
        while (!stack.empty()) {
            System.out.println("Top element:        " + stack.peek());
            System.out.println("Popped element:     " +stack.pop());
        }

        System.out.println("Is stack empty?         " + stack.empty());
    }
}
