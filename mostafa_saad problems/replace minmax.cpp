#include <iostream>
using namespace std;
 
int main() {

int max=0,min=0;
int arr[]={0,1,3,6,8,9};
int n=6;
for(int i=0; i<n; i++){

if (arr[i]>=max){
    max=i;
}
else if (arr[i]<= min){
    min=i;
}

}

cout<<max<<" "<<min<<endl<<endl;

int maxvalue=arr[max],minvalue=arr[min];
for(int i=0; i<n; i++){
if(arr[i]==arr[max]){
    arr[i]=minvalue;
}
else if(arr[i]==arr[min]) {
arr[i]=maxvalue;
}

}


for(int i=0; i<n; i++){
    cout<<arr[i];
}







}