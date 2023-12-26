#include <iostream>
using namespace std;
#include "stack.h"


void main()
{
	Stack <int> stack;
	for (int i = 0; i < 10; i++)
	{
		stack.Push(i);
	}

	while (!stack.IsEmpty())
	{
		cout << stack.Pop() << " ";
	}
	cout << endl;
}