// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        BST<Integer> b1 =new BST<>();
         b1.add(9);
         b1.add(5);
         b1.add(11);
         b1.add(1);
         b1.add(7);
         b1.add(17);
         b1.add(10);

        System.out.println(".....................");
       Node sol=b1.getlca(b1.root,b1.root.getLeft().getLeft() ,b1.root.getLeft().getRight());
        System.out.println(sol.getValue());






                                                                                                                //9
                                                                                                        //5           //11
                                                                                                  //1         7     10       17




    }
    }
