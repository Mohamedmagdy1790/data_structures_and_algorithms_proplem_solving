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


    public void print(){
        Node temp=head;
        while(temp != null){
            System.out.print(temp.value+" ,");

            temp=temp.next;

        }
        System.out.println();
    }

    void left_rotate(int k){
        if(length <= 1 || k % length == 0)
            return;
        //remove useles cylces
        k=k%length;
        while (k!=0){

            int temp= head.value;
           //rotate left
           for (Node curr=head; curr.next!=null; curr=curr.next){
               curr.value=curr.next.value;
           }
           tail.value=temp;
          k--;

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

    void lef_rotate_drmostafa(int k){
        if(length <= 1 || k % length == 0)
            return;
        //remove useles cylces
        k %= length;

        //get kth elemt
        Node kth = Getinth(k);
        tail.next=head;

        tail=kth;
        head=kth.next;
        tail.next=null;

    }









}



