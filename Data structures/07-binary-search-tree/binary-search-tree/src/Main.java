// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static int rexusionTest(int x){
        x--;
        if(x==0) return 1;
        return  rexusionTest (x)+10;
    }

    public static int factorial(int x){
        int temp = x--;
        if(x==0) return 1;
        return  factorial (x)*temp;
    }

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

        System.out.println("doses thsi value exists : "+b1.exists(19));
        System.out.println(".....................");
        System.out.println(b1.existsRecursion(19));

        b1.insert(b1.root,21);
        b1.insert(b1.root,22);
        System.out.println(b1.exists(22));
        System.out.println (rexusionTest(10));
        System.out.println (factorial(4));

    }
    }
