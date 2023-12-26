package vectorpac;


public class Main {
    public static void main(String[] args) {

     Stack s =new Stack(20);

      System.out.println(s.currnt_pos);
      s.Push(20);
      s.Push(40);
      s.Push(60);
      s.Push(70);
      System.out.println(s.currnt_pos);
      s.printstack();



    }

}