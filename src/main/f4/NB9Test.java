package main.f4;

public class NB9Test {
    public static void main(String[] args) {
        NB9<Integer> queue = new NB9<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue); // [1 -> 2 -> 3]

        System.out.println("Dequeued: " + queue.dequeue()); // Dequeued: 1
        System.out.println(queue); // [2 -> 3]

        queue.enqueue(4);
        System.out.println(queue); // [2 -> 3 -> 4]

        System.out.println("Size: " + queue.size()); // Size: 3
    }
}
