package vectorpac;

import java.util.Scanner;

public class reverseNumber {
    Scanner input=new Scanner(System.in);
    Stack<Integer> s =new Stack<>(20);

    void ReverseNumbers(int size){

        for(int i=1; i<size; i++){
            s.push(input.nextInt());
        }
        s.display();


    }
}
