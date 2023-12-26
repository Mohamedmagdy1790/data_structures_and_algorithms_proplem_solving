#include <iostream>
#include <cassert>
using namespace std;


struct Node {
	int data {};
	Node* next {};
	// Pointer to SAME type
	Node(int data) : data(data) {}
};

int main() {

	// Create 4 objects and set data
	Node* node1 = new Node(6);
	Node* node2 = new Node(10);
	Node* node3 = new Node(8);
	Node* node4 = new Node(15);

	// Set 4 links

	node1->next = node2;	//1-2 link
	node2->next = node3;	//2-3 link
	node3->next = node4;	//3-4 link
	node4->next = nullptr;	//4-E link

	// Output is 15 for all of them
	cout<<node1->next->next->next->data<<"\n";	// 15
	cout<<node2->next->next->data<<"\n";		// 15
	cout<<node3->next->data<<"\n";				// 15
	cout<<node4->data<<"\n";					// 15

	cout<<node1<<" "<<&node1<<" "<<node1->next<<" "<<&node1->next<<"\n";
	cout<<node2<<" "<<&node2<<" "<<node2->next<<" "<<&node2->next<<"\n";
	cout<<node3<<" "<<&node3<<" "<<node3->next<<" "<<&node3->next<<"\n";
	cout<<node4<<" "<<&node4<<" "<<node4->next<<"\n";

	/*
	 	0x23f9c20 0x7ffdea6fa4e8 0x23f9c40 0x23f9c28
		0x23f9c40 0x7ffdea6fa4f0 0x23f9c60 0x23f9c48
		0x23f9c60 0x7ffdea6fa4f8 0x23f9c80 0x23f9c68
		0x23f9c80 0x7ffdea6fa500 0
	 */

	/*
	int *val1 = new int(6);
	int *val2 = new int(10);
	int *val3 = new int(8);
	int *val4 = new int(15);
	*/




	return 0;
}
