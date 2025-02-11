#include<iostream>

using namespace std;

int main(){

int n;

cin>>n;
int* arr=new int[n];


//adding elments to array
for(int i=0; i<n; i++){
cin>> arr[i];
}



for(int i=1; i<n; i++){
if(i==n-1 && arr[n-1]> arr[n-2]){
    cout<< "arry is increasing";
}

if(arr[i]>=arr[i-1]) continue;
else{ cout<<"the array is not increasing";

break;
}


}
return 0;
}