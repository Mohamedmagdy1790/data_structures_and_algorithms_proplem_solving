package vectorpac;


public class Main {
    public static void main(String[] args) {
   Stack s = new Stack(20);

   s.Push(1,20);
   s.Push(1,70);
   s.print(1);

   s.Push(2,90);
   s.pop(2);
   s.Push(2,100);
   s.Push(2,120);
   s.print(2);


       System.out.println(s.peek(1));
       System.out.println(s.peek(2));



    }

}