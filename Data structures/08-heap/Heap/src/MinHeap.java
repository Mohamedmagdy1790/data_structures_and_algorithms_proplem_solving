import static java.util.Collections.swap;

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

       swap(array[parent_pos],array[child_pos]);
       heapify_up(parent_pos);

    }




    public static <T> void swap(T a, T b) {
        T temp = a;
        a = b;
        b = temp;
    }

    void push(int key) {
        assert(size + 1 <= capacity);
        array[size++] = key;
        heapify_up(size - 1);
    }

    int top() {
        assert(!isempty());
        return array[0];
    }

    boolean isempty() {
        return size == 0;
    }
};

