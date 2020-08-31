

public class BinaryTree {
    Node root = null;

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(7);
        bt.add(5);
        bt.add(9);
        bt.add(1);
        bt.add(4);
        bt.add(15);
        boolean result = bt.containsNode(9);
        System.out.println("Done: " + result);
        System.out.println("Print tree");
        bt.printTree();
    }


    private Node addNode(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addNode(current.left, value);
        } else if (value > current.value) {
            current.right = addNode(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    private void add(int value) {
        root = addNode(root, value);
    }

    public boolean containsNode(int value) {
        return findValue(root, value);
    }

    private boolean findValue(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value < current.value) {
            return findValue(current.left, value);
        } else if (value > current.value) {
            return findValue(current.right, value);
        } else {
            return true;
        }
    }

    private void printTree() {
        printNodes(root);
    }

    private void printNodes(Node current) {
        if (current == null) {
            return;
        }
        printNodes(current.left);
        System.out.println("value: " + current.value);
        printNodes(current.right);
    }
}

class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
