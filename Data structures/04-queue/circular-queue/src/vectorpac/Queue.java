package vectorpac;

public class Queue {
    int capacity;
    int front;
    int rear;
    int added_elements;
    int[] arr;


    Queue(int capacity) {

        this.capacity=capacity;
        front=rear=0;
        added_elements=0;
        arr=new int[capacity];
    }

    public int nextIndex(int index){
        if(index==capacity-1) return 0;
        return index+1;

    }
    public boolean isEmpty(){
      return added_elements==0;
    }
    public boolean isFull(){
        return added_elements==capacity;
    }

    void enqeue(int value){
        if(isFull()) throw new RuntimeException("queue is full cant add items");
        arr[rear]=value;
        rear=nextIndex(rear);
        added_elements++;

    }

    public int dequeue(){
     if(isEmpty()) throw new RuntimeException("stack is enpty cant remove items");
     int value =arr[front];
     front=nextIndex(front);
     added_elements--;
     return value;

    }
    void print(){
        for (int cur = front, step = 0; step < added_elements; ++step, cur = nextIndex(cur)) {
            System.out.printf(arr[cur]+" ");
        }

    }


}
