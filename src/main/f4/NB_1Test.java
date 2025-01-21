package main.f4;

public class NB_1Test {
    public static void main(String[] args) {
        NB8_1 test = new NB8_1<>(5);
        System.out.println("Filling Q");
        System.out.println("Adding " + 0 + "to Q..............." + test.offer(0));
        System.out.println("Get size, expect 5........." + test.getMaxSize());
        for (int i = 1; i < 6; i++) {
            System.out.println("Adding " + i + "to Q..............." + test.offer(i));
        }
        System.out.println("Get size, expect 6........." + test.getMaxSize());

        System.out.println(test);
    }



}
