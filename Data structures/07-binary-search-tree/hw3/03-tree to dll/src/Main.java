// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
         BST<Integer> b1 =new BST<>();

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        Pair<Node, Node> ddl = b1.TreeToDDL(root);

        // Print the doubly linked list
        Node currentNode = ddl.getFirst();
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.right;
        }

    }
    }
