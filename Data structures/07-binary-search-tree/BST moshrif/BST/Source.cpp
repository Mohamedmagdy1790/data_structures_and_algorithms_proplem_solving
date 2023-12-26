#include <iostream>
using namespace std;
#include "BST.h"


void main()
{
	BST<int> bst;

	bst.Add(10);
	bst.Add(5);
	bst.Add(15);
	bst.Add(2);
	bst.Add(8);
	bst.Add(12);
	bst.Add(20);
	bst.Add(1);
	bst.Add(3);
	bst.Add(7);
	bst.Add(11);
	bst.Add(13);
	bst.Add(19);

	cout << "Does 19 exists? " << bst.ExistsR(89) << endl;
}