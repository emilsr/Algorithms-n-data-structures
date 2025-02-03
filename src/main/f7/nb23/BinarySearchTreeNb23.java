package main.f7.nb23;

public class BinarySearchTreeNb23<E extends Comparable<E>> {

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
    private E deletedData = null;

    public BinarySearchTreeNb23() {
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

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) == 0) {
            return false;
        } else if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
            } else {
                add(data, node.left);
            }
        } else if (data.compareTo(node.data) > 0) {
            if (node.right == null) {
                node.right = new Node<>(data);
            } else {
                add(data, node.right);
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

    public E delete(E target) {
        root = delete(target, root);
        return deletedData;
    }

    private Node<E> delete(E target, Node<E> node) {
        if (node == null) {
            deletedData = null;
            return null;
        } else {
            if (target.compareTo(node.data) < 0) {
                node.left = delete(target, node.left);
                return node;
            } else if (target.compareTo(node.data) > 0) {
                node.right = delete(target, node.right);
                return node;
            } else {
                deletedData = node.data;
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    Node<E> nodeToMove = node.right;
                    Node<E> parentNodeToMove = node;
                    if (nodeToMove.left == null) {

                        nodeToMove.left = node.left;
                        return nodeToMove;
                    }
                    while (nodeToMove.left != null) {
                        parentNodeToMove = nodeToMove;
                        nodeToMove = nodeToMove.left;
                    }
                    parentNodeToMove.left = nodeToMove.right;
                    node.data= nodeToMove.data;
                    return node;
                }
            }
        }

    }

    // Will revers through the BST "in order", meaning starting with left tree, current node and then right tree.
    public void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(": " + node.toString());
            inOrder(node.right, sb);
        }
    }

    /** ToDo
     * Skriv funktionerna numberOfLeaves, numberOfNodes och height till vår implementation från
     * föreläsningen. Obs de ska bestämma antalet utifrån trädet och inte använda privata
     * medlemsvariabler
     */
    public int numberOfNodes() {
        return numberOfNodes(root);
    }

    public int numberOfNodes(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
    }

    public int numberOfLeaves(){
        return numberOfLeaves(root);
    }

    public int numberOfLeaves(Node<E> node) {
        if (node.left == null && node.right == null) {
            return 1;
        }
        int count = 0;
        if (node.left != null) {
            count += numberOfLeaves(node.left);
        }
        if (node.right != null) {
            count += numberOfLeaves(node.right);
        }
        return count;
    }

    public int height(){
        return height(root);
    }
    private int height(Node<E> node) {
        if (node != null) {
            return 1 + Math.max(height(node.left), height(node.right));
        }
        return 0;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    public String printAsTree() {
        StringBuilder sb = new StringBuilder();
        printAsTree(root, sb, "", true);
        return sb.toString();
    }

    private void printAsTree(Node<E> node, StringBuilder sb, String prefix, boolean isTail) {
        if (node != null) {
            sb.append(prefix).append(isTail ? "└── " : "├── ").append(node.data).append("\n");
            String newPrefix = prefix + (isTail ? "    " : "│   ");
            if (node.right != null || node.left != null) {
                if (node.right != null) {
                    printAsTree(node.right, sb, newPrefix, node.left == null);
                }
                if (node.left != null) {
                    printAsTree(node.left, sb, newPrefix, true);
                }
            }
        }
    }

}
