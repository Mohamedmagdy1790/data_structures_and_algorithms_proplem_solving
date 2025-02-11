#include <iostream>
using namespace std;
 // every time i hear in aproplem pair >>>> there is a nested loop
int main() {

int arr[]={20,1,9,4};
int min=1000,tmp;
for(int i=0; i<4; i++){
for(int j=i+1; j<4; j++){
 if(j>i && i!=j){
  tmp =arr[i]+arr[j]+j-i;
 }
 if(min>tmp){
    min=tmp;
 }


}



}
cout<<min;
return 0;
}


