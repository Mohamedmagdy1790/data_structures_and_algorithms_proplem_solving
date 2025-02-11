public class Queue extends Linkedlist {


    void enqueue(int value){
        this.InsertEnd(value);
    }

    void dequeue(){
        this.DeleteFirst();
    }
    boolean isEmpty(){
        return head==null;
    }


}
