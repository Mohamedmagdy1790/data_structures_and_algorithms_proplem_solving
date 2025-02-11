package org.example;

public class Solution {

    int factorial(int n) {
        System.out.println (n);
        // base case
        if(n<=1)return 1;

        int subproblem = factorial(n-1);
        int problem =subproblem*n;

        return problem;

    }

    void printTriangle(int levels) {
        if(levels==0) return;
        for(int i=1;i<=levels;i++) {
            System.out.printf("*");
        }
        System.out.println();
        printTriangle (levels-1);
    }


    void printTriangleInverse(int levels) {
        if(levels==0) return;
        printTriangleInverse(levels-1);

        for(int i=0;i<levels;i++) {
            System.out.printf("*");
        }
        System.out.println();

    }

    void threeNPlusOneSequence(int n) {
        System.out.printf ("%d  ",n);
        if(n==1) {System.out.printf ("%d",1);return;}
        if(n%2==0) threeNPlusOneSequence(n/2);
        else threeNPlusOneSequence(3*n+1);

    }

}
