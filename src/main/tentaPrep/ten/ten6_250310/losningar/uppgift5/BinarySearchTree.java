package uppgift5;

public class BinarySearchTree<E extends Comparable<E>> {
	
	private static class Node<E>{
		private E data;
		private Node<E> left,right;
		private Node(E d){
			data=d;
			left=right=null;
		}
		@Override
		public String toString(){
			return data.toString();
		}
	}
	
	private Node<E> root;
	
	public BinarySearchTree(){
		root=null;
	}
	
	private void inOrder(Node<E> node, StringBuilder sb){
		if(node!=null){
			inOrder(node.left, sb);
			sb.append(": ").append(node);
			inOrder(node.right, sb);
		}
	}
        
        @Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		inOrder(root,sb);
		return sb.toString();
	}

	private boolean add(E data,Node<E> node){
		if(data.compareTo(node.data)==0)
			return false;
		else if(data.compareTo(node.data)<0)
			if(node.left==null){
				node.left = new Node<>(data);
				return true;
			}else
				return add(data,node.left);
		else
			if(node.right==null){
				node.right = new Node<>(data);
				return true;
			}else
				return add(data,node.right);
	}
	public boolean add(E data){
		if(root==null){
			root = new Node<>(data);
			return true;
		}else{
			return add(data,root);	
		}
	}

	public boolean full(){
		return check(root)!=-1;
	}

	private int check(Node<E> node) {//returns -1 if not full otherwise height
		if(node==null) return 0;
		int left = check(node.left);
		int right = check(node.right);
		if(left!=-1 && left == right) return 1+left;
		return -1;
	}
}