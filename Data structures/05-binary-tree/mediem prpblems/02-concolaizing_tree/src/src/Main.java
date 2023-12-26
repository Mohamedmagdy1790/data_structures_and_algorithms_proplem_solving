package src;

import java.util.Vector;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        BT<Integer> b1 =new BT<>();
        b1.add(1);
        b1.add(3);
        b1.add(1);
        b1.add(3);

        String result =b1.parenthsizing_tree(b1.root);

        String res =b1.concalizing_tree(b1.root);


        System.out.println(result);
        System.out.println(res);

        Vector<String> vector =new Vector<>();

        vector.add("()");
        vector.add("()");

        vector.stream().sorted();
        for(int i=0; i<vector.size(); i++){
            System.out.println(vector.get(i));
        }
        }
    }
