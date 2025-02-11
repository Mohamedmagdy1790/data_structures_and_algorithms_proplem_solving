#include <iostream>
using namespace std;
 
int main() {

int arr[]={4,4,6,6,6,7,7,7,2,2,2,9,9,9,9,9};


for(int i=1; i<16; i++){
if(arr[i] == arr[i-1]) continue;
else cout<<arr[i-1];

}
cout<<arr[15];

    return 0;
}