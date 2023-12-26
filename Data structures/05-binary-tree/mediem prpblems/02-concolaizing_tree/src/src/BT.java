package src;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


public class BT<T extends  Comparable<T>> {

   public Node root ;

    BT(){
        root=null;
    }


    void  add(T v){

        if(root==null){
            root=new Node<T>(v);
        }
        else  {

            Node<T> temp =root;
            while (temp != null) {

                //check  if the value you want to add already exists
                if (temp.getValue() == v) {
                    throw new RuntimeException("value already exists");
                }
                //compare v with the currnt node if bigger go to the right node
                else if (temp.getValue().compareTo(v) < 0) {
                    if(temp.getRight() ==null){
                        Node newnode =new Node<>(v);
                        temp.setRight(newnode);
                        return;
                    }
                    temp= temp.getRight();

                }
                //compare v with the currnt node if smaller go to the left node
                else if (temp.getValue().compareTo(v) > 0) {
                    if(temp.getLeft() ==null){
                        Node newnode =new Node<>(v);
                        temp.setLeft(newnode);
                        return;
                    }
                    temp= temp.getLeft();

                }
            }


        }

    }

   private void _printInOrder(Node temp){
          if(temp == null) return;
           _printInOrder(temp.getRight());
           _printInOrder(temp.getLeft());
           System.out.println(temp.getValue());
    }
    void printInOrder(){
        _printInOrder(root);
    }


    String parenthsizing_tree(Node temp){

        if(temp==null) return "()";
        StringBuilder str =new StringBuilder();

       str.append("(").append(temp.value).toString();

       if(temp.getLeft()!=null) str.append(parenthsizing_tree(temp.left));
       else str.append("()");

        if(temp.getRight()!=null) str.append(parenthsizing_tree(temp.right));
        else str.append("()");

        str.append(")");

        return str.toString();


    }

    String concalizing_tree(Node temp){

        if(temp==null) return "()";
        StringBuilder str =new StringBuilder();

        Vector<String> vector = new Vector<>();

        str.append("(").append(temp.value).toString();

        if(temp.getLeft()!=null) vector.add(concalizing_tree(temp.left));
        else vector.add("()");

        if(temp.getRight()!=null) vector.add(concalizing_tree(temp.right));
        else vector.add("()");

        vector.stream().sorted();
        for (int i=0; i<vector.size(); i++) str.append(vector.get(i));

        str.append(")");

        return str.toString();


    }




    }



