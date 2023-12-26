import java.util.Scanner;

public class Main {


    public static void  main(String[] args) {
        KthNumberProcessor processor=new KthNumberProcessor(4);

        int num;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
             num = scanner.nextInt();
            System.out.println(processor.next(num));
        }




    }
}