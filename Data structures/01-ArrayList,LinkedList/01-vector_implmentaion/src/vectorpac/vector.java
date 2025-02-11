package vectorpac;

// vector is creating a dynamic array with some operations

public class vector {
    int capacity =0;
    // size here means until which index we are really used and we pushed into them values
    int size;
    int[] arr=null;

    vector(int capacity){
        this.capacity =capacity;
        size =0;
        // we want to avoid passing -ve number as the size of array max will return the greater value betwwen 0 or this.capacity
        arr = new int[Math.max (this.capacity, 0)];
    }

    void set(int index,int value){
        arr[index]=value;
    }
    int get(int index){
        if(index<0 || index>= size) return 0;
        return arr[index];
    }

    void pushback(int value){
        if(size == capacity){

            expand();
        }
        arr[size++]=value;    //arr[currnt_pos]=value; current_pos++;
    }

    void expand(){
        capacity = capacity *3;
        int arr2[] =new int[capacity];
        for(int i = 0; i< size; i++){
            arr2[i]=arr[i];
        }
       arr=arr2;
    }

    void print(){
        for(int i = 0; i< size; i++){
            System.out.println(arr[i]);
        }
    }

    

    void insert(int value, int index) throws Exception {
        //0 indexed array
        if(index<0 || index>= size) throw new Exception("out of range");

        if(size == capacity){expand();}

        for(int i = size; i>index; i--){
            arr[i]=arr[i-1];
        }
        arr[index]=value;
        size++;



    }

    void Rotate_right(){

        int temp;


         temp=arr[size -1];
        for(int i = size -1; i>=1; i--){

            arr[i]=arr[i-1];
        }
        arr[0]=temp;

    }

    void Rotate_left(){
        int temp=arr[0];
        for(int i = 1; i< size; i++){

            arr[i-1] =arr[i];
        }
        arr[size -1]=temp;

    }

    void Remove(int index){
        for(int i = index; i< size; i++){
            arr[i]=arr[i+1];
        }
        size--;
    }

    int find_transposition(int value){

        for(int i = 1; i< size; i++){
            if (arr[i]==value){
                int temp=arr[i];
                arr[i]=arr[i-1];
                arr[i-1]=temp;
              return i-1;
            }
        }
        return 0;
    }


}


// when i study generics make it genric
