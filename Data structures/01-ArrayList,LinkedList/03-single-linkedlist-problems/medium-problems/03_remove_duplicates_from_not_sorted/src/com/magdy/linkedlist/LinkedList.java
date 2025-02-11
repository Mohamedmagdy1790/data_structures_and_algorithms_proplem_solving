package com.magdy.linkedlist;

public class LinkedList {
    public int length=0; //how many nodes we have
    Node head;
    Node tail;

    LinkedList(){

        head=tail=null;

    }

    public void addEnd(int value){
        Node n =new Node(value);
        if(length==0){
            head=tail=n;
        }
        else{
        //n.next=null; we implmented that in Node deafult constructor
            tail.next=n;
            tail=n;
        }
        length++;
    }

    public void addfront(int value) {
        Node n =new Node(value);
        if(head==null){
            head=tail=n;
            return;
        }

        n.next=head;
        head=n;
        length++;

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

    public void deleteFirst(){

        if(head==null) System.out.println("no element to delete");
        if(length==1) head=tail=null;
        else {head=head.next;}
        length--;

    }
    public void deleteNth(int n) {
        if (n < 1 || n > length) {
            System.out.println("error no such nth node");
        }
        //if index is 1 then delete first node
        else if (n == 1) {
            deleteFirst();
        } else {

            Node before_nth = Getinth(n - 1);
            Node nth = before_nth.next;
            before_nth.next = nth.next;

            //tail assign
            if (before_nth.next == null) tail = before_nth;

            length--;
        }
    }


    public void print(){
        Node temp=head;
        while(temp != null){
            System.out.print(temp.value+" ,");

            temp=temp.next;

        }
        System.out.println();
    }

    public void removeDuplicates(){
      // create new array to put how many times value is in every space
        int[] newarr = new int[200];
        Node temp =head;
        int count=0;

        while (temp != null){
            count++;
            newarr[temp.value] += 1;
        if(newarr[temp.value] >1){
            deleteNth(count);
            count--;
        }
        temp=temp.next;

        }


    }




    }


















