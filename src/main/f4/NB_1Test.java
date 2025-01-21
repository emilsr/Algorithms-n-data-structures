package main.f4;

public class NB_1Test {
    public static void main(String[] args) {
        System.out.println("Filling Q");
        NB8_1 test = new NB8_1<>(5);
        for (int i = 0; i < 5; i++) {
            System.out.println("Adding " + i + "to Q..............." + test.offer(i));
        }
        System.out.println("Get size, expect 5........." + test.getSize());

        System.out.println(test);
    }



}
