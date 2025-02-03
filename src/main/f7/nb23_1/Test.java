package main.f7.nb23_1;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(4);
        tree.add(7);
        tree.add(4);
        tree.add(3);
        tree.add(40);
        tree.add(100);
        tree.add(30);
        tree.add(70);
        tree.add(75);

        System.out.println(tree.printAsTree());
        System.out.println(tree.maxit());
        System.out.println(tree.maxRec());

        System.out.println(tree.findRec(999));

    }
}
