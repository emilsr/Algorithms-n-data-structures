package main.f7.nb21;

import main.f7.BinarySearchTree;

import java.util.Scanner;

/**
 * Skriv en main som läser in sju ord från användaren och placerar dessa i ett BST. Kör programmet och
 * skriv in 7 ord så att trädet får minsta möjliga höjd. Kör programmet och skriv in 7 ord så att trädet får
 * maximal höjd.
 */

public class NB21 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree<>();
        Scanner scanIn = new Scanner(System.in);;

        for (int i = 0; i < 7; i++) {
            System.out.println("Add word to tree: " );
            String word = scanIn.nextLine();
            tree.add(word);

        }
        System.out.println(tree.printAsTree());

        // min height, aiming for a balanced tree
        BinarySearchTree treeMin = new BinarySearchTree<>();
        treeMin.add("4");
        treeMin.add("2");
        treeMin.add("6");
        treeMin.add("1");
        treeMin.add("3");
        treeMin.add("5");
        System.out.println(treeMin.printAsTree());

        // Max height,
        BinarySearchTree treeMax = new BinarySearchTree<>();
        for (int i = 1; i <= 7; i++){
            treeMax.add(i);
        }
        System.out.println(treeMax.printAsTree());

    }
}
