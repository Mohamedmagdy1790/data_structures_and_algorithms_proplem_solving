// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        BST<Integer> b1 =new BST<>();


        System.out.println(".....................");
        Integer[] arr ={1,5,7,9,10,11,17};

        b1.root= b1.convertarrytobst(arr,0,(arr.length)-1);

        System.out.println(b1.exists(9));




    }
    }
