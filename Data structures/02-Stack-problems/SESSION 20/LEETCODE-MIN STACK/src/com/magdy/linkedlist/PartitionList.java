package com.magdy.linkedlist;
public class PartitionList {
    public Node partition(Node head, int x) {
       Node dummy_upper =new Node(0);
       Node dummy_lower=new Node(0);
       Node before=dummy_lower; Node after=dummy_upper;

       for(Node temp=head; temp!=null; temp=temp.next){
           if(temp.value <x) {
               before.next = temp;
               before=temp;
           } else if (temp.value>=x) {
               after.next=temp;
               after=temp;

           }
       }

        before.next=dummy_upper.next;
        after.next=null;
        head=dummy_lower.next;
      return head;
    }
}
