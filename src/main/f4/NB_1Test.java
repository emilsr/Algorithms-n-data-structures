package main.f4;

public class NB_1Test {
    public static void main(String[] args) {
        NB8_1 test = new NB8_1<>(5);
        System.out.println("Filling Q");
        System.out.println("Adding " + 0 + "to Q..............." + test.offer(0));
        System.out.println("Get maxSize, expect 5........." + test.getMaxSize());
        System.out.println(test);
        for (int i = 1; i < 6; i++) {
            System.out.println("Adding " + i + "to Q..............." + test.offer(i));
        }
        System.out.println("Get maxSize, expect 10....." + test.getMaxSize());
        System.out.println("Get Size, expect 6....." + test.getSize());
        System.out.println(test);

        for (int i = 1; i < 6; i++) {
            System.out.println("Removing item from Q......"+ test.poll());
        }

        System.out.println("Peek, expect 5............." + test.peek());

        System.out.println(test);
        System.out.println("Get Size, expect 1........" + test.getSize());

        System.out.println("Removing item from Q......"+ test.poll());
        System.out.println("Get Size, expect 0........" + test.getSize());
        //System.out.println("Removing item from Q, expect exception ");
        //test.poll();
        System.out.println("Peek, expect exception ");
        test.poll();
    }
}
