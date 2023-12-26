package com.magdy.linkedlist;
import java.util.ArrayList;

public class LinkedList {
    public int length=0; //how many nodes we have
    Node head;
    Node tail;

    ArrayList <Node> debug_data =new ArrayList<>();    // add/remove nodes you use
    LinkedList(){
        head=tail=null;
    }

    public void add(int value){
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
        debug_verify_data_integrity();

    }

    public void addfront(int value) {
        Node n =new Node(value);
        if(head==null){
            head=tail=n;
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

    public void DeleteAll(){

        while(head != null){
            head.value=0;
           head=head.next;
        }
    }


    public void print_reversed(Node head){
        if(head==null){
            return;
        }
        print_reversed(head.next);//recursion takes memory for loop is better but in this case we cant o(n)memory also stack frame is small (stackoverflow)
        System.out.print(head.value+",");
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

    //return node based in a value
    public Node GetinthValue(int value){

        for(Node temp=head; temp!=null; temp=temp.next){
            Node.count++;
            if(temp.value==value){
                return temp;
            }
        }
        return null;
    }
    public Node Getinth_back(int index){
        int count=1;
        for(Node temp=head; temp!=null; temp=temp.next){
            if(!(index >0 && index <length)){
                System.out.println("\n wrong index ");
                return null;
            }

            else if(((length+1)-count)==index){
                return temp;
            }
            count++;
        }
        return null;
    }

    public int ImprovedSearch(int value){
        int count=1;
        for(Node curr=head, prev=null; curr!=null; prev =curr,curr=curr.next){
            if(curr.value==value){

                //swap prev node with tail node
                int temp =curr.value;
                curr.value=prev.value;
                prev.value=temp;
                count++;

                return count-1;
            }


        }
        return -1;
    }



    public void deleteFirst(){
        debug_remove_node(head);
        if(head==null) System.out.println("no element to delete");
        if(length==1) head=tail=null;
        else {head=head.next;}
        length--;
        debug_verify_data_integrity();

    }

    public void deleteNth(int n){
         if(n<1 || n>length){
             System.out.println("error no such nth node");
         }
         //if index is 1 then delete first node
        else if(n == 1){deleteFirst();}

        else{

            Node before_nth= Getinth(n-1);
            Node nth= before_nth.next;
            before_nth.next = nth.next;

             //tail assign
              if (before_nth.next==null) tail = before_nth;

            length--;
        }


    }

    //assuming i dont have tail node how to solve it
    void deleteNthWihHead(int index){

        //if there is no items to delete
        if(head==null) System.out.println("out of range no items");

        //if index is 1 then delete first node
        if(index==1){head=head.next; return;}

        //stop in the node before index
        Node beforeindex =head;
        int count=-1;
        while(count+1 <index ){
            count++;
            beforeindex=beforeindex.next;
        }
        //if the next of  node before index is null return
        if(beforeindex.next==null){
            return;
        }
        //link the node before index with the node after index
        beforeindex.next=beforeindex.next.next;

    }

    public void deleteWithKey(int value){
        Node temp=GetinthValue(value);
        deleteNth(temp.count);
    }


    boolean is_identical(LinkedList a){
        Node x =head, y=a.head;
        while(x !=null && y !=null){
            if(x.value !=y.value){
                return false;
            }
            x=x.next;
            y=y.next;
        }
        return (x==null) && (y==null);
    }

    boolean is_identical_withlengh(LinkedList a){

        if(length != a.length) return false;
        else{
            Node x =head, y=a.head;
            while(x !=null && y !=null){
                if(x.value !=y.value){
                    return false;
                }
                x=x.next;
                y=y.next;

        }
            return true;
        }

    }

    void swap(Node prev, Node current){
        Node temp =new Node(prev.value);

        prev.value=current.value;
        current.value=temp.value;

    }
    void swapPairs(){
        int count=1;
        for(Node curr=head, prev=null; curr!=null; prev =curr,curr=curr.next){
            //swap only ofter now steps that means in the even places
            if((count%2)==0){
                swap(prev,curr);
            }
            count++;
        }

    }




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void debug_print_address() {
        for (Node cur = head; cur!=null; cur = cur.next)
            System.out.println(cur + "," + cur.value + "\t");
        System.out.println();
    }

    public void debug_print_node(Node node ,boolean is_seperate ) {
        is_seperate=false;
        if (is_seperate)
            System.out.println("Sep: ");
        if (node == null) {
            System.out.println("nullptr \n");
            return;
        }
        System.out.println(node.value+ " ");

        if (node.next == null)
            System.out.println( "X ");
        else
            System.out.println(node.next.value+" ");

        if (node == head)
            System.out.println("head\n");
        else if (node == tail)
            System.out.println("tail\n");
        else
            System.out.println();
    }

    void debug_print_list(String msg ) {
        msg= "";
        if (msg != "")
            System.out.println(msg+ "\n");
        for (int i = 0; i < (int)debug_data.size(); ++i) {
            debug_print_node(debug_data.get(i),false);
        }
        System.out.println( "************\n" );
    }
    String debug_to_string() {
        if (length == 0)
            return "";
        StringBuilder oss=new StringBuilder();
        for (Node cur = head; cur!=null; cur = cur.next) {
            oss.append(cur.value);
            if (!(cur.next==null))
                oss.append(" ");
        }
        return oss.toString();
    }

    void debug_verify_data_integrity() {
        if (length == 0) {
            assert head == null;
            assert tail ==null;
        }
        else {
            assert head != null;
            assert tail !=null;
            if (length == 1)
                assert head == tail;
            else {
                assert head != tail;
                assert tail.next==null;
            }
        }
        int len = 0;
        for (Node cur = head; cur!=null; cur = cur.next, len++) {assert len < 10000;}    // Consider infinite cycle?

        assert length == len;
        if(len!=length){
            System.out.println("len != lengh");
        }
        assert length == (int)debug_data.size();
    }

    void debug_remove_node(Node node) {
        Node foundNode = debug_data.stream().filter(n -> n == node).findFirst().orElse(null);
        if(foundNode !=null){
            debug_data.remove(node);
        }
    }
    void debug_add_node(Node node){
        debug_data.add(node);
    }

}
