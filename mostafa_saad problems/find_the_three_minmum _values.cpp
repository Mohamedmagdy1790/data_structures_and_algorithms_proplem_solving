#include<iostream>
using namespace std;

int main(){

int arr[]={4,10,3,1,8};
int min1,min2,min3;
min1=min2=min3=1000;

for(int i=1; i<5; i++){

if(arr[i]<= min1){
min3=min2;
min2=min1;
min1=arr[i];

}
else if ((arr[i] <= min2) ){

    min3=min2;
    min2=arr[i];

}
else if((arr[i]<= min3) && (min3 != min1) &&(min3 != min2) ){
    min3=arr[i];
}


cout<<min1<<" "<<min2<<" "<<min3;

    return 0;
}
}