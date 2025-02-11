package org.example;

public class Solution {

    int[] leftMax(int[] arr,int length){

        for(int i=0;i<length;i++){
            for(int j=0;j<=i;j++){
                if(arr[i]<=arr[j]){
                    arr[i]=arr[j];
                }
            }
        }
        return arr;
    }

    public int[] leftMaxRecursive(int[] arr){

        for(int i=0;i<arr.length;i++){
           // getMaxOfCurrentElement (arr,i);
            leftMax(arr,i);
        }

     return arr;
    }

    public int[] getMaxOfCurrentElement( int[] arr,int length){
        if(length==0)  return arr;
        if(arr[length-1]>=arr[length]){
         arr[length]=arr[length-1];
        }
        return getMaxOfCurrentElement(arr,length-1);
    }
  // leftmax0f 5 is left max of 4 then max between 4 and 5
   public void leftMaxRecursiveMostafaSaadSol(int[] arr , int length){
        if(length==0)  return ;

        leftMaxRecursiveMostafaSaadSol (arr,length-1);
        arr[length]= Math.max(arr[length-1],arr[length]);  ;
   }



}
