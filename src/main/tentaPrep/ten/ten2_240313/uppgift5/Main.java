package main.tentaPrep.ten.ten2_240313.uppgift5;

public class Main {

    public static void main(String[] args){

        BinarySearchTree<String> bst = new BinarySearchTree<>();
        //buildTree(bst,new String[] {"H", "B", "N", "A", "E", "C", "F", "D", "P", "M"});
        //buildTree(bst,new String[] {"B", "A", "C", "D", "E"});
        buildTree(bst,new String[] {"B", "A", "C"});


        System.out.println(bst.height());
        System.out.println(bst.height("E"));
        System.out.println(bst.siblings("A","B"));
    }

    private static void buildTree(BinarySearchTree<String> bst, String[] strings) {
        for(String data:strings) bst.add(data);
    }
}
