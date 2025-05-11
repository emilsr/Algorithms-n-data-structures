package uppgift5;

public class Main {


	public static void main(String[] args) {

		BinarySearchTree<Integer> bst= new BinarySearchTree<>();
		bst.add(10);
		System.out.println(bst.full());//true
		bst.add(15);
		System.out.println(bst.full());
		bst.add(5);
		System.out.println(bst.full());//true
		bst.add(7);
		System.out.println(bst.full());
		bst.add(3);
		System.out.println(bst.full());
		bst.add(12);
		System.out.println(bst.full());
		bst.add(18);
		System.out.println(bst.full());//true
		bst.add(4);
		System.out.println(bst.full());
		bst.add(24);
		System.out.println(bst.full());
		bst.add(16);
		System.out.println(bst.full());
		bst.add(13);
		System.out.println(bst.full());
		bst.add(6);
		System.out.println(bst.full());
		bst.add(1);
		System.out.println(bst.full());
		bst.add(11);
		System.out.println(bst.full());
		bst.add(8);
		System.out.println(bst.full());//true
		bst.add(30);
		System.out.println(bst.full());


		System.out.println(bst);
	}

}
