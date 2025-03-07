package main.tentaPrep.ten.ten2_240313.uppgift5;

public class Main {

    public static void main(String[] args){

        BinarySearchTree<String> bst = new BinarySearchTree<>();
        buildTree(bst,new String[] {"H", "B", "N", "A", "E", "C", "F", "D", "P", "M"});
        //buildTree(bst,new String[] {"2", "1", "3", "4", "5", "6", "7", "8", "9", "10"});

        System.out.println(bst.height());
        System.out.println(bst.height("E"));
        //System.out.println(bst.siblings("A","E"));
    }

    private static void buildTree(BinarySearchTree<String> bst, String[] strings) {
        for(String data:strings) bst.add(data);
    }
}
