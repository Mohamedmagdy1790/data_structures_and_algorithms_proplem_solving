import java.util.ArrayList;
import java.util.List;

class Sort {
   // asc order from smaller to larger
    void insertionSort(ArrayList<Integer> a){
        for(int i=1; i<a.size(); i++){
            int prevElementIndex=i-1;
            Integer key =a.get(i);
            compareKeyWithAllPreviousElementsAndPutKeyAtTheEndInTheRightPlace(a, key, prevElementIndex);
        }
    }
    private static void compareKeyWithAllPreviousElementsAndPutKeyAtTheEndInTheRightPlace(ArrayList<Integer> array, Integer key, int prevElementIndex) {
        while(true){
            if( prevElementIndex >=0 && key <= array.get(prevElementIndex) ){
                array.set(prevElementIndex +1, array.get(prevElementIndex));
                prevElementIndex--;
            }
            else {
            array.set(prevElementIndex+1,key);
            break;
            }
        }
    }


}





public class ]]Main {
    public static void main(String[] args) {
        Sort2 s=new Sort2();
        Sort s1= new Sort();
        ArrayList<Integer> a = new ArrayList<>(List.of(10,30,1,7,8,5));

        // s.insertionSort2(a);

        s1.insertionSort(a);

        a.forEach(element-> {
            System.out.print(element+ " ");
        });
    }
}