import java.util.Collections;

import static java.util.Collections.swap;
//dont forget that heap is an array not tree
//but i can convert this array to complete binary tree
//evey element i can get its parent and left and right
class MinHeap {

    private int[] array;
    int size;
    int capacity=100;

    public   MinHeap() {
        array = new int[capacity] ;
        size = 0;
    }

    int left(int node) {
        int p = 2 * node + 1;
        if (p >= size)
            return -1;
        return p;
    }
    int right(int node) {
        int p = 2 * node + 2;
        return p >= size ? -1 : p;
    }
    int parent(int node) {
        return node == 0 ? -1 : (node - 1) / 2;
    }

    //
    void heapify_up(int child_pos) {
       int parent_pos =  parent(child_pos);
       //child pos ==0 means we are at the root
       if(child_pos ==0 || array[parent_pos]<array[child_pos]) return;

        swap(array,parent_pos,child_pos);

        heapify_up(parent_pos);

    }

    void heapify_down(int parent_pos) {
        //i will assume that is left is smaller than right
        int child_pos =  left(parent_pos);
        int right_child= right(parent_pos);
        if (child_pos == -1) // no children
            return;
        //if right pos is smaller than change child_pod to right
        if(right_child != -1 && (array[child_pos] > array[right_child]) ) child_pos=right_child;

        if (array[parent_pos] > array[child_pos]) {
            swap(array,parent_pos,child_pos);
            heapify_down(child_pos);
        }

    }



    static void swap(int[] array, int a, int b){
        int x = array[a];
        array[a] = array[b];
        array[b] = x;

    }

    void push(int key) {
        if ((size + 1 > capacity)) throw new AssertionError();
        array[size++] = key;
        heapify_up(size - 1);
    }

    int top() {
        if ((isempty())) throw new AssertionError();
        return array[0];
    }

    void pop(){
      if ((isempty())) throw new AssertionError();
      array[0]=array[--size];
      heapify_down(0);
    }

    boolean isempty() {
        return size == 0;
    }
};

