package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println ("Hello world!");

        Solution solution = new Solution();
        int[] arr ={1,2,4,3,1};
        int[] sole =solution.leftMax(arr,5);
        int[] solr =solution.leftMaxRecursive (arr);



        Arrays.stream(sole).forEach(System.out::print);
        System.out.println ("----------------------------");
        Arrays.stream(solr).forEach(System.out::print);
    }
}