package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println ("Hello world!");

        Solution solution = new Solution();
        int[] sol =  solution.fibonacci (6);
        Arrays.stream(sol).forEach (i -> System.out.printf ("%d , ",i));
    }


}