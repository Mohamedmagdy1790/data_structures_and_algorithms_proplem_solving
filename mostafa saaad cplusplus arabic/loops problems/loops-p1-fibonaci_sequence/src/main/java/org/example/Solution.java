package org.example;

public class Solution {
    public int[] printFibSequence(){
        int[] fib = new int[10];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < 10; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib;
    }



    public void printFibSequenceMostafaSaad(){
        int a= 0;
        int b = 1;
        System.out.print (a+" "+b);
        for (int i = 2; i < 10; i++){
           int c = a + b;
           a = b;
           b = c;
           System.out.print (" "+b);
        }
    }
}
