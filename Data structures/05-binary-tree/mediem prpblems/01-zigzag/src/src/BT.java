package src;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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

    boolean exists(T v){
          Node temp =root;
          int count =0;
        while (temp != null) {
            if (temp.getValue() == v) {
                System.out.println("counter equal : "+ count);
                return true;
            }
            else if (temp.getValue().compareTo(v) < 0) {

                temp = temp.getRight();
            }

            else if (temp.getValue().compareTo(v) > 0) {

                temp = temp.getLeft();
            }
            count++;
        }
        return false;
    }

    void zigzag(){
        Deque<Node> queue = new LinkedList<>();
        queue.offerLast(root);

        boolean fromLeftOrRight=true;

        Node temp =root;
        while (!queue.isEmpty()){
            int size =queue.size();

            while (size !=0){
                if(fromLeftOrRight){
                    temp = queue.pollFirst();
                    if(temp.getLeft() != null ) queue.offerLast(temp.getLeft());
                    if(temp.getRight() != null ) queue.offerLast(temp.getRight());


                }
                else{
                    temp =queue.pollLast();
                    if(temp.getRight() != null ) queue.offerFirst(temp.getRight());
                    if(temp.getLeft() != null ) queue.offerFirst(temp.getLeft());


                }
                System.out.println(temp.value);
                size--;

            }

            fromLeftOrRight=!fromLeftOrRight;
        }

    }

    Boolean existsInternalRecursion(T value, Node temp){

        if(temp == null) return false;
        else if (temp.getValue() == value) return true;
            //compare value with the currnt node if bigger go to the right node
        else if (temp.getValue().compareTo(value) <0) return existsInternalRecursion(value,temp.getRight());

        else if (temp.getValue().compareTo(value) >0) return existsInternalRecursion(value,temp.getLeft());
        return false;
        }

        boolean existsRecursion(T value){
         return existsInternalRecursion(value,root);
        }

    }



