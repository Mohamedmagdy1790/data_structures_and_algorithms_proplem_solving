// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

     Linkedlist ll =new Linkedlist();
        ll.InsertEnd(10);
        ll.InsertEnd(140);
        ll.InsertEnd(20);
        ll.InsertEnd(90);

       //ll.deleteNth(3);
        ll.InsertInPlace(1,1000);
        ll.print();



        System.out.println(ll.IsPalindrome());


    }
}