import java.util.ArrayList;

public class Linkedlist {

    public int length; //how many nodes we have
    Node head;
    Node tail;

    Linkedlist(){
        head=tail=null;
        length=0;
    }

    public void Link(Node first, Node second){

        if(first !=null) first.next=second;
        if(second !=null) second.prev=first;
    }
    public void InsertEnd(int value){
        Node n =new Node(value);
        length++;
        if(head==null){
            head=tail=n;
        }
        else{
            Link(tail,n);
            tail=n;
        }


    }

    public void InsertFront(int value) {
        Node n =new Node(value);
        length++;

        if(head==null){
            head=tail=n;
        }
        Link(n,head);
        head=n;


    }


    //insert in any place you want
    public void InsertInPlace(int index,int value){
        if(index==1){InsertFront(value); return;}
        Node current=Getinth(index);
        if(current == tail) InsertEnd(index);
        else{
            Node newNode =new Node(value);
             newNode.next=current.next;
             (current.next).prev=newNode;

             current.next=newNode;
             newNode.prev=current;
            length++;
         }
    }


    public void embedafter(Node prev, int value){
        Node middle =new Node(value);
        length++;
        Node curr=prev.next;
        Link(prev,middle);
        Link(middle,curr);

    }

    public void InsertSorted(int value){

        if(head==null || value<=head.value){
           InsertFront(value);
        }
        else if(value>=tail.value){
            InsertEnd(value);
        }
        else{

            for(Node temp=head; temp!=null; temp=temp.next ){
                if(value<=temp.value){
                    embedafter(temp.prev,value);
                    break;
                }
            }
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

    public void DeleteAll(){

        while(head != null){
            head.value=0;
            head=head.next;
        }
    }


    public void print_reversed(){
        if(head==null){
            return;
        }
        for(Node temp=tail; temp!=null; temp=temp.prev ){
            System.out.println(temp.value);
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
    public Node Getinth_back(int index){
        int count=1;
        for(Node temp=head; temp!=null; temp=temp.next){
            if(!(index >0 && index <length)){
                System.out.println("\n sorry we begin from index 1");
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



    public void DeleteFirst(){

        if(head==null) System.out.println("no element to delete");
        if(length==1) head=tail=null;
        else {head=head.next;}
        length--;


    }

      public void deleteNth(int n){

        if (n == 1){DeleteFirst();}
        if(n<1 || n>length){
            System.out.println("out of index");
        }
        else{
            //current is the node we want to delete
            Node current= Getinth(n);
            // if the node we want to delete is the tail
            if(current==tail) {
                //current.prev is the node before the tail
                tail=(current.prev);
                tail.next=null;
            }
            else {
                 // linking the next of the node before the current with the node before the current
                (current.prev).next = current.next;
                // linking the previous of the node after the current with the node after the current
                (current.next).prev=current.prev;

            }
            length--;
        }


    }

    public void DeleteFront(){
        if(head==null) return;
        if(length==1){
            head=tail=null;

        }
        else{
            head=head.next;
            head.prev=null;
        }
        length--;
    }

    void DeleteAllNodesWithKey(int value){
         if(head==null)return;

         //if value is in the first node
         if(head.value==value) DeleteFront();
         //if the value is the middle
         else if(value>= head.value && value<= tail.value){
             for(Node curr=head; curr!=null; curr=curr.next){
                 if(curr.value==value){
                     Link(curr.prev,curr.next);

                 }
             }
         }
         //if the value is in the tail
         else {
             tail=tail.prev;
             tail.next=null;
         }

    }
    void DeleteEvenPositions(){
        int count=1;
        for(Node curr=head; curr!=null; curr=curr.next){
            if((((count++)%2)==0)){
                Link(curr.prev,curr.next);

            }
        }

    }
    void DeleteOddPositions(){
        int count=1;

        for(Node curr=head; curr!=null; curr=curr.next){
            if((((count++)%2)!=0)){
                Link(curr.prev,curr.next);

            }
        }
        DeleteFront();
    }

    boolean IsPalindrome(){
        if(length<=1) return true;
        int count=length/2;

        //iterate only the half length at the same time compare the two values
        for(Node temp1=head,temp2=tail; count>=1; temp1=temp1.next,temp2=temp2.prev,count--){
            if(temp1.value==temp2.value){
                continue;
            }
            else return false;
        }
        return true;
    }

}
