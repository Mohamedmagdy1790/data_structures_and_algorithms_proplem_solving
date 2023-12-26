#include <iostream>
using namespace std;
#include "ArrayList.h"


void main()
{
	ArrayList<int> list;

	cout << "Please enter how many items you want to input: ";
	int size;
	cin >> size;

	for (int i = 0; i < size; i++)
	{
		list.Add(i);
	}

	for (int i = 0; i < list.GetCount(); i++)
	{
		cout << list[i] << " ";
	}

	cout << endl;

	list.Remove(2);
	

	for (int i = 0; i < list.GetCount(); i++)
	{
		cout << list[i] << " ";
	}

	cout << endl;
}