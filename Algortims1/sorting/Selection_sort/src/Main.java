
public class Main {


    public void selectionsort(int[] arr , int l0, int h0){
          //h0-1 because we dont need to change last item
        for(int h=l0; h<h0-1; h++){
            int s = getSmallest(arr, h, h0);
            swap(arr,h,s);
        }

    }

    public static int getSmallest(int[] arr, int h, int h0) {
        int smallest=h;
        for(int i=h+1; i<h0; i++){
            if(arr[i]<arr[smallest]) smallest=i;
        }
        return smallest;
    }

    public static void swap(int[] arr, int i, int j) {
     //swap elements list[i] and list[j]
        int hold = arr[i];
        arr[i] = arr[j];
        arr[j] = hold;
    }


    public static void main(String[] args) {

        int[] arr ={1,8,3,14,2,16};
        Main m =new Main();
        m.selectionsort(arr, 0,arr.length-1);

        for( int i=0; i<arr.length; i++ ){
            System.out.println(arr[i]);



        }


    }
}