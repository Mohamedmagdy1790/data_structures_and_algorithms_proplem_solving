#include<iostream>
using namespace std;

int main(){

int n;
cin>>n;

int*  arr =new int[n];

for(int i=0; i<n; i++){

    cin>>arr[i];
}

bool x = true;

for(int i=0; i<n; i++)

if ( arr[i]!=arr[n-1-i]){
    x =false;
}
cout<<x;
}

