public class Solution {

    int BSfindFirst(int[] arr, int target){

        int start=0;
        int end=arr.length;

        while (start<end){
            int mid= start+ ((end-start)/2);

             if (target < arr[mid])  end=mid-1;
             else if(target > arr[mid])  start= mid+1;
            else {
               end=mid;
            }



        }
        //just testing boundries
        if(start < 0 || start >= (int)arr.length)
            return -1;

        return arr[start]==target? start:-1;

    }

    int BSfindLast(int[] arr, int target){
        int start=0;
        int end=arr.length;

        while (start<end){
                                                         // s  e
            // added in the equation to handle the case if [5,5]
            int mid= start+ ((end-start+1)/2);
            if(target > arr[mid])  start= mid+1;
            else if (target < arr[mid])  end=mid-1;
            else {
                start=mid;
            }



        }
        //just testing boundries
        if(start < 0 || start >= (int)arr.length)
            return -1;

        return arr[start]==target? start:-1;

    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{BSfindFirst(nums, target), BSfindLast(nums, target)};
    }

}
