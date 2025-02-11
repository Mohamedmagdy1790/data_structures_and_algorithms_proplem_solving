public class Solution {

    int binarySerach(int[] arr, int start, int end, int target){


        while (start<end){
            int mid= start+ ((end-start)/2);
            if(target > arr[mid])  start= mid+1;
            else if (target < arr[mid])  end=mid-1;
            else  return mid;


        }
        return -1;
    }


}
