public class BT<T extends  Comparable<T>> {

    public Node root;

    BT() {
        root = null;
    }


    void add(T v) {

        if (root == null) {
            root = new Node<T>(v);
        } else {

            Node<T> temp = root;
            while (temp != null) {

                //check  if the value you want to add already exists
                if (temp.getValue() == v) {
                    throw new RuntimeException("value already exists");
                }
                //compare v with the currnt node if bigger go to the right node
                else if (temp.getValue().compareTo(v) < 0) {
                    if (temp.getRight() == null) {
                        Node newnode = new Node<>(v);
                        temp.setRight(newnode);
                        return;
                    }
                    temp = temp.getRight();

                }
                //compare v with the currnt node if smaller go to the left node
                else if (temp.getValue().compareTo(v) > 0) {
                    if (temp.getLeft() == null) {
                        Node newnode = new Node<>(v);
                        temp.setLeft(newnode);
                        return;
                    }
                    temp = temp.getLeft();

                }
            }


        }

    }


    boolean isLeaf(Node temp) {
        if (temp.right == null && temp.left == null) return true;
        return false;
    }

    public boolean pathSum2(Node temp, int targetsum, int sum) {
        if (temp == null) return false;
        if (isLeaf(temp) && sum == targetsum) return true;

        // checks if temp.left is equal to null in this case nothing to add
        return pathSum2(temp.left, targetsum, (sum + (((temp.left) == null) ? 0 : (int) temp.left.value))) || pathSum2(temp.right, targetsum, (sum + (((temp.right) == null) ? 0 : (int) temp.right.value)));

    }

    public boolean pathSum(Node temp, int targetsum) {
        if (temp == null) return false;
        if (isLeaf(temp) && (int) temp.value == targetsum) return true;

        return pathSum(temp.left, (targetsum - (int) temp.value)) || pathSum(temp.right, (targetsum - (int) temp.value));

    }


    private void _printInOrder(Node temp) {
        if (temp == null) return;
        _printInOrder(temp.getRight());
        _printInOrder(temp.getLeft());
        System.out.println(temp.getValue());
    }

    void printInOrder() {
        _printInOrder(root);
    }

}



