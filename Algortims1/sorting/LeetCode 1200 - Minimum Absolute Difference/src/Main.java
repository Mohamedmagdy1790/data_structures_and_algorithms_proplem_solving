import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Solution s=new Solution();
        Integer[] arr={10,4,2,6,8,0,7,1};

        List<List<Integer>> sol =s.minimumAbsDiff(arr);
        // Print the list of lists using nested loops
        for (List<Integer> innerList :sol ) {
            for (Integer element : innerList) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

class Solution {

   List<List<Integer>> minimumAbsDiff(Integer[] list){

       //use any sort builtin
       Arrays.sort(list);


       //get min o(n)
       int min=10000000;
       for (int i=1; i<list.length; i++)
       min= Math.min(min,list[1]-list[0]);


      List<List<Integer>> pairs=new ArrayList<>();
      //get all pairs
      for(int i=1 ; i< list.length; i++){
         if(list[i]-list[i-1]==min){
             pairs.add(List.of(i, i-1));
         }

      }
    return pairs;
   }


}