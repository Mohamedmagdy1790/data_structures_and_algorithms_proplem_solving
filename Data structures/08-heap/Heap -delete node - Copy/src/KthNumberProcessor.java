public class KthNumberProcessor {
    int k;
    MaxHeap q;


    public KthNumberProcessor(int k){
        this.k=k;
        q=new MaxHeap();
    }

    int next(int new_num) {


         if (q.size<k) {
            q.push(new_num);
        }
       else if(q.top()> new_num){
            q.pop();
            q.push(new_num);
        }
        return q.top();
    }
}