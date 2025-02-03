package main.f7.nb22_1;

public class test {
    public static void main(String[] args) {
        BinarySearchTreeNb22_1 tree = new BinarySearchTreeNb22_1();
        tree.add("H");
        tree.add("B");
        tree.add("N");
        tree.add("A");
        tree.add("E");
        tree.add("C");
        tree.add("F");
        tree.add("D");
        System.out.println(tree.printAsTree());
        System.out.println(tree);
    }
}
