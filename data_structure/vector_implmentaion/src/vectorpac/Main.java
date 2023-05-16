package vectorpac;


public class Main {
    public static void main(String[] args) {

      vector p1 =new vector(3);

      p1.pushback(10);
      p1.pushback(40);
      p1.pushback(30);
      p1.pushback(70);

      p1.print();

      System.out.println("................................");

      p1.Rotate_right();
      p1.print();

      System.out.println(".................................");

      p1.Rotate_left();
      p1.print();

      System.out.println("...............................");

      p1.Remove(2);
      p1.print();

      System.out.println("...............................");

      int x=p1.find_transposition(70);
      p1.print();
      System.out.println(x);

    }

}