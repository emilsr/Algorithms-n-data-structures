package main.tentaPrep.ten.ten1_240604.losningar.uppgift6;

public class Main {

    public static void main(String[] args){

        BinarySearchTree<String> bst = new BinarySearchTree<>();
        System.out.println(bst.complete());//T
        bst.add("H");
        System.out.println(bst.complete());//T
        bst.add("B");
        System.out.println(bst.complete());//T
        bst = new BinarySearchTree<>();
        bst.add("H");
        bst.add("P");
        System.out.println(bst.complete());//F
        bst.add("D");
        System.out.println(bst.complete());//T
        bst.add("B");
        System.out.println(bst.complete());//T
        bst.add("F");
        System.out.println(bst.complete());//T
        bst.add("K");
        System.out.println(bst.complete());//T
        bst.add("R");
        System.out.println(bst.complete());//T
        buildTree(bst,new String[] {"A", "C", "G"});
        System.out.println(bst.complete());//F
        bst = new BinarySearchTree<>();
        buildTree(bst,new String[] {"H","D","P","B","F","K","R","A","C","E","G","J"});
        System.out.println(bst.complete());//T
        bst = new BinarySearchTree<>();
        buildTree(bst,new String[] {"H","D","P","B","F","K","R","A","C","E","G","L"});
        System.out.println(bst.complete());//F
        bst = new BinarySearchTree<>();
        buildTree(bst,new String[] {"H","D","P","B","F","K","A","C","E","G","J"});
        System.out.println(bst.complete());//F
    }

    private static void buildTree(BinarySearchTree<String> bst, String[] strings) {
        for(String data:strings) bst.add(data);
    }
}
