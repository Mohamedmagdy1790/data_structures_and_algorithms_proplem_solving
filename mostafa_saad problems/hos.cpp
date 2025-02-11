#include <iostream>
using namespace std;
// name of each patient and speciaization
string names[20][5] ;

 int i,j=0,status=0;



 


void Read_patients(){

 cout<<"please enter specialzation :";

 cin>>i;
 cout<<endl;
 cout<<"please enter  a name : ";
 string name =" ";
 cin>>name;

 if(names[i][j] != "0"){
    cout<<" sorry we dont have seats";
    
 }

 else {
    
    cout<<" status";
    cin>>status;
    
    if(status == 1 || j >0){

        for(int k=j; k>=0; k--){

            names[i][k]=names[i][k-1];

        }

        names[i][0]=name;

    

    }

    else{

    names[i][j]= name;

    }

    j++;
   

 }
}







int main(){

for(int i=0; i<20; i++){
    
for(int j=0; j<5; j++){

    names[i][j]="0";
}

}

int choice;

cout<<endl;

while(choice != -1){

cout<< "please enter one of the follwing choices : \n 1 read a new patient : ";
cin>>choice;

switch(choice){
case 1:

    Read_patients();
    cout<<" nice one patient is added" <<endl;;
    break;

}

}
    return 0;
}

  





 




