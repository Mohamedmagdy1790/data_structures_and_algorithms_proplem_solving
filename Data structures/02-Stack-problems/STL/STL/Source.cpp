#include <iostream>
#include <vector>
#include <list>
#include <queue>
#include <stack>
using namespace std;


void main()
{
	vector<int> v;
	list<int> l;
	stack<int> s;
	queue <int> q;
	for (int i = 0; i < 10; i++)
	{
		v.push_back(i);
		l.push_back(i);
		q.push(i);
		s.push(i);
	}

	cout << "Printing vector (Arraylist): " << endl;
	for (int i = 0; i < v.size(); i++)
	{
		cout << v[i] << " ";
	}
	cout << endl << endl;

	cout << "Printing list (LinkedList): " << endl;
	for (list<int>::iterator it = l.begin(); it != l.end(); it++)
	{
		cout << (*it) << " ";
	}
	cout << endl << endl;

	cout << "Printing queue: " << endl;
	while (!q.empty())
	{
		cout << q.front() << " ";
		q.pop();
	}

	cout << endl << endl;

	cout << "Printing stack: " << endl;
	while (!s.empty())
	{
		cout << s.top() << " ";
		s.pop();
	}

	cout << endl << endl;
}