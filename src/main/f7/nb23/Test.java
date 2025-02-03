package main.f7.nb23;

public class Test {

    public static void main(String[] args) {
        BinarySearchTreeNb23 tree1 = new BinarySearchTreeNb23();
        BinarySearchTreeNb23 tree2 = new BinarySearchTreeNb23();

        for (int i = 0; i < 5; i++) {
            tree1.add(i);
        }
        System.out.println(tree1.numberOfNodes());
        System.out.println(tree1.numberOfLeaves());
        System.out.println(tree1.height());


        tree2.add(3);
        tree2.add(1);
        tree2.add(2);
        tree2.add(4);
        tree2.add(5);
        System.out.println(tree2.numberOfNodes());
        System.out.println(tree2.numberOfLeaves());
        System.out.println(tree2.height());
    }

}
