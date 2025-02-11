package vectorpac;

public class Queue extends vector {
    Queue(int capacity) {
        super(capacity);
    }

    void enqeue(int value){
        this.pushback(value);
    }

    void dequeue(){

        this.Remove(this.currnt_pos);
    }

    boolean isEmpty(){
        return currnt_pos==0;
    }
}
