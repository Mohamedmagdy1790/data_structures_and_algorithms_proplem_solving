package org.example;

import java.util.Scanner;

public class Solution {


    Boolean isArrayIncreasing(){

        Scanner sc = new Scanner(System.in);

         Integer counter = sc.nextInt ();
         Integer[] arr = new Integer[counter];

        for (int i = 0; i < counter; i++) {
            arr[i]  =sc.nextInt ();
            if(i==0) continue;

            else if(arr[i]<arr[i-1] ){
                return false;
            }



        }
       return true;

    }
    }


