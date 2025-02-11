package org.example;

import java.util.Scanner;

public class Solution {



    Boolean isItSuffix(){
        Scanner sc = new Scanner(System.in);

        // the  bigger string
        String s1 = sc.nextLine();
        // sufix string
        String s2 = sc.nextLine();


        if(s2.length () > s1.length()){
            return false;
        }

        int j = s1.length()-1;
        for(int i = s2.length()-1; i>=0;  i--){
            if(s1.charAt(j) != s2.charAt(i)){
                return false;
            }
            j--;
        }
        return true;
    }
}
