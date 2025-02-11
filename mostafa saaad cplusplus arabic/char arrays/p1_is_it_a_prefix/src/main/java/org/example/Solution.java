package org.example;

import java.util.Scanner;

public class Solution {



    Boolean isItPerfix(){
        Scanner sc = new Scanner(System.in);

        // the  bigger string
        String s1 = sc.nextLine();
        // prefix string
        String s2 = sc.nextLine();


      if(s2.length () > s1.length()){
          return false;
      }

      for(int i = 0; i < s2.length(); i++){
          if(s1.charAt(i) != s2.charAt(i)){
              return false;
          }

      }
        return true;
    }
}
