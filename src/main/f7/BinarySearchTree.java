package main.f7;

public class BinarySearchTree <E extends Comparable<E>> {

    // create Node with data, and reference to right and left sub Node.
    private static class Node<E> {
        private E data;
        private Node<E> left, right;

        //Constructor for a Node, when we add new node it's a leaf, and we don't have any references to sub tress.
        private Node(E d){
            data = d;
            left = right = null;
        }

        // We only care about data in a given Node
        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    // add data at correct node in tree.
    public boolean add(E data) {
        if (root == null) {
            root = new Node<>(data);
            return true;
        }
        return add(data, root);

    }

    private boolean add(E data, Node<E> currentNode) {
        if (currentNode.data.compareTo(data) == 0) {
            return false;
        } else if (currentNode.data.compareTo(data) < 0) {
            if (currentNode.left == null) {
                currentNode.left = new Node<>(data);
            } else {
                add(data, currentNode.left);
            }
        } else if (currentNode.data.compareTo(data) > 0) {
            if (currentNode.right == null) {
                currentNode.right = new Node<>(data);
            } else {
                add(data, currentNode.right);
            }
        }
        return true;
    }

    public E find(E target) {
        return find(target, root);
    }

    // this is a bit different from the lecure, but I will think this should work the same way. it's a bit uglier.
    //ToDo test to make sure it works, and after remake it to be easier to read.
    private E find(E target, Node<E> currentNode) {
        if (currentNode.data.equals(target)) {
            return currentNode.data;
        } else if (currentNode.data.compareTo(target) < 0) {
            if (currentNode.left != null) {
                return find(target, currentNode.left);
            }
        } else if (currentNode.data.compareTo(target) > 0) {
            if (currentNode.right != null) {
                return find(target, currentNode.right);
            }
        }
        return null;
    }

    // Will revers through the BST "in order", meaning starting with left tree, current node and then right tree.
    public void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data + ", ");
            inOrder(node.right, sb);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }

        System.out.println(tree);
        System.out.println(tree.find(2));
        System.out.println(tree.find(70));
        System.out.println(tree.find(9));
        System.out.println(tree.find(0));
    }

}
