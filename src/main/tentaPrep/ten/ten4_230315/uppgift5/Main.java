
package main.tentaPrep.ten.ten4_230315.uppgift5;

public class Main {

	public static void buildTree(BinarySearchTree<String> b){


		b.add("4");
		b.add("2");
		b.add("3");
		//b.add("4");
		b.add("5");
		b.add("7");
		//b.add("6");
		b.add("8");
		b.add("1");
		b.add("0");



		/*
		b.add("P");
		b.add("E");
		b.add("U");
		b.add("C");
		b.add("H");
		b.add("R");
		b.add("X");
		b.add("A");
		b.add("D");
		b.add("K");
		b.add("S");
		b.add("V");
		b.add("B");
		b.add("J");
		b.add("L");
		b.add("W");

		 */



	}
	public static void main(String[] args) {

		BinarySearchTree<String> bst= new BinarySearchTree<>();
		buildTree(bst);
		System.out.println(bst);
		//System.out.println(bst.find("L"));
		System.out.println(bst.nrOneGrandChild());
		System.out.println(bst.secondSmallest());
	}

}
