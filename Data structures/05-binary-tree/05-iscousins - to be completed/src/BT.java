

import java.awt.event.ItemEvent;

import static java.lang.Integer.max;

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

    Node findParentNode(Node temp, int value){
        if(temp ==null) return null;

        if(
                (temp.getRight() !=null && (int)temp.getRight().getValue() == value)
                        ||
                 temp.getLeft() != null && ((int)temp.getLeft().getValue()) == value
        )
             return temp;

        Node l=findParentNode(temp.getLeft(),value);
        Node r=findParentNode(temp.getRight(),value);
        if(l !=null) return l;
        else return r;
    }
    int _findNodeDepth(Node root, int value, int curDepth) {
        if (root == null) return 0;
        if ((int) root.value == value) return curDepth;
        // node might be in thr left or right , the other one will return 0 so wont affect the return
        return _findNodeDepth(root.left, value, curDepth + 1) + _findNodeDepth(root.right, value, curDepth + 1);
    }

    public int findNodeDepth(int value) {
        return _findNodeDepth(root, value, 0); // call the overloaded version with default value
    }


//    boolean isCousin(Node temp, int x, int y ){
//        if(temp ==null) return false;
//
//        if(maxDepth(x) == maxDepth(y) && ( parentof(x) != parentof(y) )) return true;
//        else return false;
//
//    }


    int count(Node temp) {
        if (temp == null) return 0;

        return count(temp.left) + count(temp.right) + 1;

    }


    private boolean isleaf(Node temp) {
        if (temp.getLeft() == null && temp.getRight() == null) return true;
        return false;
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

    boolean exists(T v) {
        Node temp = root;
        int count = 0;
        while (temp != null) {
            if (temp.getValue() == v) {
                System.out.println("counter equal : " + count);
                return true;
            } else if (temp.getValue().compareTo(v) < 0) {

                temp = temp.getRight();
            } else if (temp.getValue().compareTo(v) > 0) {

                temp = temp.getLeft();
            }
            count++;
        }
        return false;
    }


}



