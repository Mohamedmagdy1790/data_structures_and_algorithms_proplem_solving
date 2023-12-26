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

	~Node() {
		//To easily test your nodes are destructed
		cout << "Destroy value: " << data << "\n";
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
	~LinkedList() {		// O(n) time - O(1) memory
		// idea: get next first, remove current head
		while(head){
			Node* current = head->next;
			delete head;
			head = current;
		}
	}
};


int main() {

	LinkedList list;
	list.insert_end(6);
	list.insert_end(10);
	list.insert_end(8);
	list.insert_end(15);

	return 0;
}

