// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        BT<Integer> b1 =new BT<>();

        b1.add(10);
        b1.add(5);
        b1.add(15);
        b1.add(2);
        b1.add(8) ;
        b1.add(12);
        b1.add(20);
        b1.add(1);
        b1.add(3);
        b1.add(7);
        b1.add(11);
        b1.add(13);
        b1.add(19);

        //System.out.println("doses thsi value exists : "+b1.exists(19));
        System.out.println(".....................");
        //System.out.println(b1.existsRecursion(19));

        //b1.printInOrder();
        System.out.println(b1.goodNodes(b1.root,-1));

        }
    }
