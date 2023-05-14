package vectorpac;

// vector is creating a dynamic array with some operations

public class vector {
    int size=0;
    int currnt_pos;
    int[] arr=null;

    vector(int s){
        size =s;
        currnt_pos=0;
        arr = new int[size];
    }

    void set(int index,int value){
        arr[index]=value;
    }
    void get(int index){

    }

    void pushback(int value){
        if(currnt_pos==size){

            expand();
        }
        arr[currnt_pos++]=value;    //arr[currnt_pos]=value; current_pos++;
    }

    void expand(){
        size =size*3;
        int arr2[] =new int[size];
        for(int i=0; i<currnt_pos; i++){
            arr2[i]=arr[i];
        }
       arr=arr2;
    }

    void print(){
        for(int i=0; i<currnt_pos; i++){
            System.out.println(arr[i]);
        }
    }

    

    void insert(int value, int index){

        if(currnt_pos==size){

            expand();
        }

        for(int i=currnt_pos; i>index; i--){
            arr[i]=arr[i-1];
        }
        arr[index]=value;
        currnt_pos++;



    }

    void Rotate_right(){

        int temp;


         temp=arr[currnt_pos-1];
        for(int i=currnt_pos-1; i>=1; i--){

            arr[i]=arr[i-1];
        }
        arr[0]=temp;

    }

    void Rotate_left(){
        int temp=arr[0];
        for(int i=1; i<currnt_pos; i++){

            arr[i-1] =arr[i];
        }
        arr[currnt_pos-1]=temp;

    }

    void Remove(int index){
        for(int i=index; i<currnt_pos; i++){

            arr[i]=arr[i+1];
        }
        currnt_pos--;
    }


}


// when i study generics make it genric
