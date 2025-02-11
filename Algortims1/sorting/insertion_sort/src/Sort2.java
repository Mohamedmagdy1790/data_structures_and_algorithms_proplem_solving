import java.util.ArrayList;

public class Sort2 {

    // descnding order  mostafa ssad sol
    void insertionSort2(ArrayList<Integer> arr){
        for (int i=1; i<arr.size(); i++){
            int key = arr.get(i);
            int j=i;
            j = getJ(arr, j, key);
            arr.set(j, key);
        }
    }

    private static int getJ(ArrayList<Integer> arr, int j, int key) {
        for(; j >0 && key > arr.get(j - 1); j--){
            arr.set(j, arr.get(j - 1));
        }
        return j;
    }
}
