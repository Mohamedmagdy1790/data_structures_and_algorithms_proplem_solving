#include <iostream>
#include <cassert>
using namespace std;


struct Node {
	int data {};
	Node* next {};
	// Pointer to SAME type
	Node(int data) : data(data) {}
};

void print1(Node* head) {
	while(head != nullptr) {
		cout<<head->data<<" ";
		head = head->next;
	}
	cout<<"\n";
}

void print2(Node* head) {		// print forward recursively
	if (head == nullptr) {
		cout<<"\n";
		return;
	}
	cout<<head->data<<" ";
	print2(head->next);
}

void print3_reversed(Node* head) {		// print backward recursively
	if (head == nullptr) {
		return;
	}
	print3_reversed(head->next);
	cout<<head->data<<" ";
}

int main() {

	Node* node1 = new Node(6);
	Node* node2 = new Node(10);
	Node* node3 = new Node(8);
	Node* node4 = new Node(15);

	node1->next = node2;
	node2->next = node3;
	node3->next = node4;
	node4->next = nullptr;

	print1(node1);


	print2(node1);
	print3_reversed(node1);

	return 0;
}



