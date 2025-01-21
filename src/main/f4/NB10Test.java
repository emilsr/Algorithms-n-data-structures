package main.f4;

public class NB10Test {
    public static void main(String[] args) {
        NB10 queue = new NB10();
        for (int i = 0; i < 10; i++) {
            System.out.println("Add " + i + " to queue....."+ queue.offerFirst(i));
        }
        System.out.println(queue);

        for (int i = queue.size(); i != 0; i--) {
            System.out.println("Removing item from queue....."+ queue.offerLast(i));
        }

        System.out.println(queue);

        for (int i = 0; i < 10; i++) {
            System.out.println("pollFirst........"+ queue.pollFirst());
        }

        for (int i = queue.size(); i != 0; i--) {
            System.out.println("pollLast....."+ queue.offerLast(i));
        }

        System.out.println(queue);

        System.out.println("Size: " + queue.size());
        System.out.println("pollLast, should return NUll ");
        queue.pollLast();
        System.out.println("pollFirst, should return NUll ");
        queue.pollFirst();
    }
}
