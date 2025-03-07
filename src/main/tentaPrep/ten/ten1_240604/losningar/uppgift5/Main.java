package main.tentaPrep.ten.ten1_240604.losningar.uppgift5;

public class Main {

    public static void main(String[] args) {
        Heap h = new Heap();
        h.offer(82);
        h.offer(41);
        h.offer(30);
        h.offer(24);
        h.offer(4);
        h.offer(12);
        h.offer(91);
        h.offer(19);
        System.out.println(h);
        int i;
        while((i=h.poll())!=Integer.MAX_VALUE)
            System.out.println(i);
    }

}
