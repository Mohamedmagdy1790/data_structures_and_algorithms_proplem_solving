package binarytree;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        Scanner in = new Scanner(new FileReader("btree.in"));
        BinaryTree bt = new BinaryTree(in);

        bt.preOrder();

        Solution s1=new Solution();



        System.out.println(s1.isSymmetric(bt.root));





    }
    }
