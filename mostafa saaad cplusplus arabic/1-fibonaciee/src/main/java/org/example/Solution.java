package org.example;

public class Solution {


   public int[] fibonacci(int n){
       int first = 0;
       int second = 1;
       int sum = 0;
       int[] arr = new int[n+1];

       for(int i=1;i<n;i++){
           if(i==1) {
               arr[i-1]=first;
               arr[i]=second;
           }
         else {
           first = arr[i-1];
           second = arr[i];
         }
           sum = first+second;
           arr[i+1] = sum;

       }
    return arr;
   }

}
