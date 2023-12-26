package vectorpac;


public class Main {
    public static void main(String[] args) {

        Problem P= new Problem();
         int[] arr=new int[5];
         arr[0]=10;
         arr[1]=5;
         arr[2]=7;
         arr[3]=15;
         arr[4]=11;



         Stack<Integer> result = P.nextGreaterNumber(arr);

         result.display();

         P.next_greater_num(arr,arr.length);



            }



        }






