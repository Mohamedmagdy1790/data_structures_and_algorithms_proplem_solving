package com.magdy.linkedlist;
import java.util.ArrayList;

public class LinkedList<T> {
    public int length=0; //how many nodes we have
    Node head;
    Node tail;

    ArrayList <Node> debug_data =new ArrayList<>();    // add/remove nodes you use
    LinkedList(){
        head=tail=null;
    }


    int getLength(){
        return length;
    }

    public void add(T value){
        length++;
        Node n =new Node(value);
        if(length==1){
            head=tail=n;
        }
        else{
        //n.next=null; we implmented that in Node deafult constructor
            tail.next=n;
            tail=n;
        }

    }

    public void addfront(T value) {
        Node n =new Node(value);
        if(head==null){
            head=tail=n;
            return;
        }
        n.next=head; head=n;
        length++;
    }

    public void print(){
        Node temp=head;
        while(temp != null){
            System.out.print(temp.value+" ,");

            temp=temp.next;

        }
        System.out.println();
    }

    public void DeleteAll(){

        while(head != null){
            head.value=0;
           head=head.next;
        }
    }

    public Node Getinth(int index){
        int count=1;
        for(Node temp=head; temp!=null; temp=temp.next){
            if(!(index >=0 || index <length)){
                System.out.println("\n sorry we begin from index 1");
                return null;
            }

            else if(count==index){
                return temp;
            }
            count++;
        }
         return null;
    }

    public Node GetinthValue(T value){

        for(Node temp=head; temp!=null; temp=temp.next){
            Node.count++;
            if(temp.value==value){
                return temp;
            }
        }
        return null;
    }

    public void deleteFirst(){
        if(head==null) {System.out.println("no element to delete"); return;}

        // avoid lengh
        if(length==0) {head=tail=null; return;}

        head=head.next;
        length--;


    }

    public void deleteNth(int n){

        if (n == 1){
           // DeleteFirst();
            System.out.println("pleaser call fundction Deletefirst to delete first node");
        }
        else if(n>1){

            Node prev= Getinth(n-1);
            Node curr= prev.next;
            if(n==length)
            { tail=prev;
              tail.next=null;
            }

           else if(n<length) {
               prev.next = curr.next;

           }
            length--; //or prev.next=prev.next.next;
        }

         if(length==0){head=tail=null;; }
    }



 }


