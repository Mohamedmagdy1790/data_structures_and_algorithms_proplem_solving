#include <iostream>
using namespace std;

class abstract_pizza {

    virtual void MakePizza()=0;

};

class pizza: abstract_pizza {
public:


void MakePizza(string x){
    cout<<"i made a gread pizza to"<<x;
}

};

int main(){

    pizza* ahmed;
    pizza* mohamed;

    ahmed->MakePizza("ahmed");
    cout<<endl;
    mohamed->MakePizza("mohamed");

    return 0;
}