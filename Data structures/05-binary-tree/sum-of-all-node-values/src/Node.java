public class Node<T extends Comparable<T>> {
    Node left;
    Node right;

    T value ;


    Node(T v){
        value=v;
        left=right=null;
    }

    //setters and getters
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
