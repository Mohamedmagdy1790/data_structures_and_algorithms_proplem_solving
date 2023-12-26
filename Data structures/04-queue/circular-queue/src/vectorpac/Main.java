package vectorpac;


public class Main {
    public static void main(String[] args) throws Exception {

        Queue p1 = new Queue(3);

        p1.enqeue(10);
        p1.enqeue(40);
        p1.enqeue(40);
        p1.print();


        p1.dequeue();
        p1.enqeue(80);
        p1.print();


    }

}