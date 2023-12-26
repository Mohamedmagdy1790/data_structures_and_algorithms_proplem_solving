import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        BST<Integer> b1 =new BST<>();

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

        Pair<Boolean,Integer> ans =b1.successor(5);

        Pair<Boolean,Integer> ans2 =b1.successor_2(5);

        System.out.println(ans.getFirst()+ "  "+ans.getSecond());
        System.out.println(ans2.getFirst()+ "  "+ans2.getSecond());





    }
    }
