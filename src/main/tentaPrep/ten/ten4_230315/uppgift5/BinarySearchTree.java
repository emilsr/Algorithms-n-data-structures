
package main.tentaPrep.ten.ten4_230315.uppgift5;

import java.util.LinkedList;
import java.util.Queue;

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
	
	public E find(E target){
		if (root == null) return null;
		return find(target, root);
	}

	private E find(E target, Node<E> node){
		if (node == null) return null;
		if (target.compareTo(node.data) == 0) return node.data;
		else if (target.compareTo(node.data)<0) {
			return find(target, node.left);
		} else {
			return find(target, node.right);
		}
	}
	
	public int nrOneGrandChild() {
		if (root == null) return -1;
		int count = 0;
		Node<E> node = root;
		Queue<Node<E>> q = new LinkedList<>();
		q.offer(node);

		while (!q.isEmpty()){
			node= q.poll();

			if (node.left!=null){
				if (node.right == null || ( node.right.right == null && node.right.left == null)){
					if ((node.left.left != null && node.left.right == null) ||
							(node.left.left == null && node.left.right != null)){
						count++;
					}
				}
				q.offer(node.left);
			}
			if (node.right!=null){
				if (node.left == null || (node.left.left==null && node.left.right == null)){
					if ((node.right.left != null && node.right.right == null) ||
							(node.right.left == null && node.right.right != null)){
						count++;
					}
				}
				q.offer(node.right);
			}
		}
		return count;
	}


	public E secondSmallest() {
		Node<E> node = root;
		while (node.left != null && node.left.left != null){
			node= node.left;
		}
		if (node.left != null && node.left.right != null){
			return node.left.right.data;
		}
		return node.data;
	}
}