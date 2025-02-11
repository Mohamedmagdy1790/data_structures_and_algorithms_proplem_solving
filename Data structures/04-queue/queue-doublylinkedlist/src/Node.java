public class Node {
    int value;
    Node next;
    Node prev;
    Node(int value){
        this.value=value;
        next=prev=null;

    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}