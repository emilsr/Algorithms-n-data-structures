package main.F2;

public class IntListTest {
    public static void main(String[] args) {
        IntList testList = new IntList(20);

        for (int i = 0; i < 20; i++) {
            System.out.println(testList.add(i));
        }

        System.out.println(testList);

        testList.add(2, 2);

        System.out.println(testList);
    }
}
