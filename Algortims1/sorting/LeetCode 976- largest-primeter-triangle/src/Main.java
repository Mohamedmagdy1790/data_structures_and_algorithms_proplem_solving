import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] arr={16,4,2,6,8,0,7,1};

        int sol =s.largestPrimterTriangle(arr);
        System.out.println(sol);

    }
}

class Solution {

    int largestPrimterTriangle(int[] arr){
        //sort array
        Arrays.sort(arr);

      

        //check first three items makes a valid triangle or no
        for (int i=arr.length-1; i>=2; i--){
            if(arr[i-1]+arr[i-2]> arr[i]){return arr[i]+arr[i-1]+arr[i-2];}
        }

       return 0;
    }


}