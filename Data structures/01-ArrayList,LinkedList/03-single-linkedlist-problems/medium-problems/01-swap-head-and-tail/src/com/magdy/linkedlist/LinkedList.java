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




    void embed_after(Node node, int value) {
        // Add a node with value between node and its next
        Node item = new Node(value);
        ++length;
        item.next = node.next;
        node.next = item;
    }

    void swapHeadAndTail(){
        Node temp=head;

          // important note change your prev and curr they wont change automatically  as you change  tail and head
          for(Node prev=head,curr=head.next; curr!=null; prev=curr,curr=curr.next){

            if(prev==head){head=tail;   head.next=curr; }

            if(curr==tail){
                tail=temp;
                curr=tail;

                curr.next=null;
                tail.next=null;
                prev.next=tail;
            }



         }
    }


}
