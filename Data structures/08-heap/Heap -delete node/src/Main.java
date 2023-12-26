import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MinHeap heap =new MinHeap();

        // iput List.of() inside arraylist to be able to insert new elements to that array
      int[] v={2, 17, 22, 10, 8, 37,
              14, 19, 7, 6, 5, 12, 25, 30};

        for (int i = 0; i < v.length; ++i)
            heap.push(v[i]);

        while (!heap.isempty()) {
            System.out.printf(heap.top()+" ") ;
            heap.pop();

        }


    }
}