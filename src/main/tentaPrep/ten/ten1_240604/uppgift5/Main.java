package main.tentaPrep.ten.ten1_240604.uppgift5;

public class Main {

    //Inser att jag har gjort en max heap och inte en min heap, fattar dock inte hur jag ska holla poll() o(1)
    //med en min heap... skulle kunna göra en cirkulär heap men det känns overkill...

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
        System.out.println(h); //valfritt men praktiskt att implementera
        int i;

        while((i=h.poll())!=Integer.MAX_VALUE)
            System.out.println(i);


    }

}
