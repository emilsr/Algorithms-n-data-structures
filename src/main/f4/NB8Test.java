package main.f4;

public class NB8Test {
    public static void main(String[] args) {
        // Create a circular buffer with an initial maximum size of 5
        NB8<Integer> queue = new NB8<>(2);
        System.out.println("Added 1.........................." + queue.offer(1));
        System.out.println("Added 2.........................." + queue.offer(2));
        System.out.println("peek (expected 1)................" + queue.peek());
        System.out.println("poll (expected 1)................" + queue.poll());
        System.out.println("peek (expected 2)................" + queue.peek());
        System.out.println("current max size (expected 2)...." + queue.getMaxSize());
        System.out.println("Added 3.........................." + queue.offer(3));
        System.out.println("peek (expected 2)................" + queue.peek());
        System.out.println("Added 4.........................." + queue.offer(4));
        System.out.println("peek (expected 2)................" + queue.peek());
        System.out.println("current max size (expected 4)...." + queue.getMaxSize());
        System.out.println("poll (expected 2)................" + queue.poll());
        System.out.println("poll (expected 3)................" + queue.poll());
        System.out.println("current max size................." + queue.getMaxSize());
        System.out.println("peek (expected 4)................" + queue.peek());
    }
}