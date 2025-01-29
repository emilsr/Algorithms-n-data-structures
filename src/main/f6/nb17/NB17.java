package main.f6.nb17;

/**
 * Skriv om getNode till vår länkade lista så att den blir rekursiv. Du behöver inte hantera felaktiga
 * index. Skriv också en rekursiv size som inte använder en medlemsvariabel utan beräknar size vid
 * varje anrop. Tänk på att size ska fungera på en tom lista.
 */
public class NB17 {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        for (int i = 1; i <= 10; i++) {
            System.out.println("Add " + i + " to list: " + list.add(i));
        }
        System.out.println(list);
        System.out.println("Get node index 1, expect 0:....." + list.getNode(0));
        System.out.println("Get node index 5, expect 6:....." + list.getNode(5));

    }
}
