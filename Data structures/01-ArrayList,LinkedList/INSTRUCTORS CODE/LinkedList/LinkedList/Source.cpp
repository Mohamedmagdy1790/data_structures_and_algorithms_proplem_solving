#include <iostream>
using namespace std;

#include "LinkedList.h"

void main()
{
	LinkedList<int> list;
	cout << "Please enter how many items you want to input: ";
	int count;
	cin >> count;

	for (int i = 0; i < count; i++)
	{
		list.Add(i);
	}

	list.PrintAll();
}