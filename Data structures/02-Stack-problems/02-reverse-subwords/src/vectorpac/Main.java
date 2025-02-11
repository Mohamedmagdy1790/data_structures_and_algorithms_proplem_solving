package vectorpac;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter a s string you want sub word in it to be reversed make space btween ecah subword");
        Scanner input=new Scanner(System.in);

        char[] arr = input.nextLine().toCharArray();
        Stack<Character> s =new Stack<>(20);

        StringBuilder sb = new StringBuilder();


        //
       for(int i=0; i<arr.length; i++){

            if(arr[i] ==' '){
              while (!(s.IsEmptystack())) {sb.append(s.pop());}
               sb.append(' ');
            }
            else s.push(arr[i]);
        }

        System.out.println(sb.toString());



    }








}
