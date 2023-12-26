// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

     Queue q =new Queue();
        q.enqueue(20);
        q.enqueue(40);
        q.enqueue(70);
        q.print();

        q.dequeue();
        q.dequeue();


        q.print();
        System.out.println(q.isEmpty());





    }
}