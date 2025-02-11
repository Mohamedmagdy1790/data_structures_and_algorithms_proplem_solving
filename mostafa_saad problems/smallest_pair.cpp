#include <iostream>
using namespace std;
 
int main() {


int arr[]={20,1,9,4};
int eq=1000,min1val=arr[0],min2val=arr[0],min1=0,min2=0;

for(int i=1; i<6; i++){

if(arr[i]<=min2val) {

min1=min2;
min2=i;
min1val=arr[min1];
min2val= arr[i];
}

else if (min1val > arr[i] ){
    min1=i;
    min1val=arr[i];
}

if(eq >= (min1val+min2val+min2-min1) && (min2 >= min1)){
   eq= (min1val+min2val+min2-min1);
}


}

cout<<eq;
    return 0;
}


