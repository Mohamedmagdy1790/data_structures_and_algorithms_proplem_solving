#include <iostream>
#include <cassert>
using namespace std;

struct Node {
	int data {};
	Node* next {};
	Node(int data) : data(data) {}
};

class LinkedList {
private:
	Node *head { };
	Node *tail { };
public:

	void print() {
		// DON'T change head itself.
		// 		You will lose it
		Node* temp_head = head;
		while(temp_head != nullptr) {
			cout<<temp_head->data<<" ";
			temp_head = temp_head->next;
		}
		cout<<"\n";
	}

	void insert_end(int value) {
		Node* item = new Node(value);

		if (!head)
			head = tail = item;
		else {
			tail->next = item;
			tail = item;
		}
	}

	// This code has memory leak, as we did not free memory
};

int main() {

	LinkedList list;

	list.insert_end(6);
	list.insert_end(10);
	list.insert_end(8);
	list.insert_end(15);
	list.print();


	return 0;
}


