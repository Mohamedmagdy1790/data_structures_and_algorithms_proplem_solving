#include <iostream>
using namespace std;

int main()
{
  
 
 
 int arr[5]={1,7,4,7,7};
 int max=-1,maxcount=-1;

 for(int i=0; i<5; i++){

    int temp= 0;

    for(int j=1; j<5; j++){

     if(arr[i]==arr[j]) temp++;
      
        
    }

    if (temp > maxcount) {
        max=i;
        maxcount=temp;
        }


 }
 cout<<arr[max]<<"   "<<"n of occurnce: "<<maxcount;

}

 
