#include <iostream>
#include <cassert>
#include <climits>
using namespace std;

struct Node {
	int data { };
	Node* next { };
	Node(int data) :
			data(data) {
	}
};

class LinkedList {
private:
	Node *head { };
	Node *tail { };
	int length = 0;	// let's maintain how many nodes

public:

	void print() {
		// DON'T change head itself
		for (Node* cur = head; cur; cur = cur->next)
			cout << cur->data << " ";
		cout << "\n";
	}

	void insert_end(int value) {
		Node* item = new Node(value);
		if (!head)
			head = tail = item;
		else
			tail->next = item, tail = item;
		++length;
	}
	//////////////////////////////New Functions/////////////////////////////////

	int max(Node* head = nullptr, bool is_first_call = true) {		// O(n) time - O(n) memory
		// It is tricky to have function name same as standard
		// use std for standard and this-> for the class for clarity
		if (is_first_call)
			return this->max(this->head, false);

		if (head == nullptr)
			return INT_MIN;		// initial min value
		return std::max(head->data, this->max(head->next, false));
	}
};

int main() {

	LinkedList list;

	cout<<list.max()<<"\n";		// -2147483648
	list.insert_end(6);
	list.insert_end(10);
	list.insert_end(8);
	cout<<list.max()<<"\n";		// 10
	list.insert_end(15);
	cout<<list.max()<<"\n";		// 15


	return 0;
}

