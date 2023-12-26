#include <iostream>
using namespace std;
#include "Queue.h"


void main()
{
	Queue <int> queue;
	for (int i = 0; i < 10; i++)
	{
		queue.Enqueue(i);
	}

	while (!queue.IsEmpty())
	{
		cout << queue.Dequeue() << " ";
	}
	cout << endl;
}