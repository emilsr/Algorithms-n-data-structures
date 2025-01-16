package main.F2;

public class IntListTest {
    public static void main(String[] args) {
        IntList testList = new IntList(20);

        for (int i = 0; i < 20; i++) {
            System.out.println(testList.add(i));
        }
        System.out.println(testList);
        System.out.println(testList.add(9, 2));
        System.out.println(testList);
        System.out.println(testList.get(2));
        System.out.println(testList);
        System.out.println(testList.indexOf(9));
        System.out.println(testList);
        testList.set(0, 100);
        System.out.println(testList);
        testList.remove(0);
        System.out.println(testList);
    }
}
