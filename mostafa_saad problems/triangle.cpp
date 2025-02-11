#include <iostream>
using namespace std;


int main()
{
	int h;
	cout << "Please enter height: ";
	cin >> h;
	
	int height = h;
	int spaces = 0;
	int stars = h-1;

	for (int i = 0; i <= (height/2)-1; i++)
	{
		//Draw spaces;
		for (int j = 0; j < spaces; j++)
		{
			cout << " ";
		}

		//Draw stars and spaces between
		for (int j = 0; j < stars; j++)
		{
            if(j==0 || j==stars-1 || i == (height/2)-1)
			cout << "*";
            else cout<<" ";
		}

		//Finish the line
		cout << endl;

		if(i==((height/2)-1)){
           continue;
		}
		else {
             stars=stars-2;
		   //Decrease spaces by 1
		    spaces=spaces+1;
		} 
       
	}

     

    for (int i = 1; i <= (height/2)-1; i++)
	{
		//Draw spaces;
		for (int j = 0; j < spaces; j++)
		{
			cout << " ";
		}

		//Draw stars and spaces between
		for (int j = 0; j < stars; j++)
		{
            if(j==0 || j==stars-1 ) cout << "*";
            else cout<<" ";
		}

		//Finish the line
		cout << endl;

		
         stars=stars+2;
		//Decrease spaces by 1
		spaces=spaces-1;
	}

    return 0;
}