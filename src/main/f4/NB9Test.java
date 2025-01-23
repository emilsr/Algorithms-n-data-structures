package main.f4;

public class NB9Test {
    public static void main(String[] args) {
        NB9<Integer> queue = new NB9<>();
        for (int i = 0; i < 10; i++) {
            System.out.println("Add " + i + " to queue....."+ queue.enqueue(i));
        }
        System.out.println(queue);

        for (int i = queue.size(); i != 0; i--) {
            System.out.println("Removing item from queue....."+ queue.dequeue());
        }

        System.out.println(queue);

        System.out.println("Size: " + queue.size());
        System.out.println("Remove item from empty queue, should throw");
        queue.dequeue();
    }
}
