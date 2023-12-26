#include <iostream>
#include <cassert>
#include <climits>
#include <tuple>

#include <vector>		// for debug
#include <algorithm>
#include <sstream>
using namespace std;

struct Node {
	int data { };
	Node* next { };
	Node(int data) :
			data(data) {
	}

	~Node() {
		cout << "Destroy value: " << data << "\n";
	}
};

class LinkedList {
private:
	Node *head { };
	Node *tail { };
	int length = 0;	// let's maintain how many nodes

	vector<Node*> debug_data;	// add/remove nodes you use

public:

	// Below 2 deletes prevent copy and assign to avoid this mistake
	LinkedList() {
	}
	LinkedList(const LinkedList&) = delete;
	LinkedList &operator=(const LinkedList &another) = delete;

	void debug_print_address() {
		for (Node* cur = head; cur; cur = cur->next)
			cout << cur << "," << cur->data << "\t";
		cout << "\n";
	}

	void debug_print_node(Node* node, bool is_seperate = false) {
		if (is_seperate)
			cout << "Sep: ";
		if (node == nullptr) {
			cout << "nullptr\n";
			return;
		}
		cout << node->data << " ";
		if (node->next == nullptr)
			cout << "X ";
		else
			cout << node->next->data << " ";

		if (node == head)
			cout << "head\n";
		else if (node == tail)
			cout << "tail\n";
		else
			cout << "\n";
	}
	void debug_print_list(string msg = "") {
		if (msg != "")
			cout << msg << "\n";
		for (int i = 0; i < (int) debug_data.size(); ++i)
			debug_print_node(debug_data[i]);
		cout << "************\n" << flush;
	}

	void debug_add_node(Node* node) {
		debug_data.push_back(node);
	}
	void debug_remove_node(Node* node) {
		auto it = std::find(debug_data.begin(), debug_data.end(), node);
		if (it == debug_data.end())
			cout << "Node does not exist\n";
		else
			debug_data.erase(it);
	}

	string debug_to_string() {
		if (length == 0)
			return "";
		ostringstream oss;
		for (Node* cur = head; cur; cur = cur->next) {
			oss << cur->data;
			if (cur->next)
				oss << " ";
		}
		return oss.str();
	}

	void debug_verify_data_integrity() {
		if (length == 0) {
			assert(head == nullptr);
			assert(tail == nullptr);
		} else {
			assert(head != nullptr);
			assert(tail != nullptr);

			if (length == 1)
				assert(head == tail);
			else
				assert(head != tail);
			assert(!tail->next);
		}

		int len = 0;
		for (Node* cur = head; cur; cur = cur->next, len++)
			assert(len < 10000);	// Consider infinite cycle?

		assert(length == len);
		//assert(length == (int )debug_data.size());
	}
	////////////////////////////////////////////////////////////

	void print() {
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

		debug_add_node(item);
	}

	void delete_node(Node* node) {
		debug_remove_node(node);
		--length;
		delete node;
	}

	void insert_after(Node *src, Node* target) {
		// Given node src, link target after it with my list before/after
		assert(src && target);
		target->next = src->next;
		src->next = target;
		debug_add_node(target);
		++length;
	}

	Node* move_to_end(Node* cur, Node* prv) {
		if (cur == tail)	// Fix
			return cur;	// already at the end

		Node* next = cur->next;
		tail->next = cur;

		if (prv)
			prv->next = next;
		else
			head = next;	// cur was head

		tail = cur;
		tail->next = nullptr;
		return next;
	}

	void move_key_occurance_to_end(int key) {		// O(n) time - O(1) memory
		if (length <= 1)
			return;

		// Simple idea with tail: for each matching key, remove it and add to the end!

		int len = length;	// iterate length steps, don't go infinte with added ones
		for (Node* cur = head, *prv = nullptr; len--;) {
			if (cur->data == key)	// no change for prv
				cur = move_to_end(cur, prv);
			else
				prv = cur, cur = cur->next;	// normal step
		}
		debug_verify_data_integrity();
	}
};

void test1() {
	cout << "\n\ntest1\n";
	LinkedList list1;

	list1.insert_end(1);
	list1.insert_end(2);
	list1.insert_end(3);
	list1.insert_end(2);
	list1.insert_end(4);
	list1.insert_end(1);
	list1.move_key_occurance_to_end(1);


	string expected = "2 3 2 4 1 1";
	string result = list1.debug_to_string();
	if (expected != result) {
		cout << "no match:\nExpected: " << expected << "\nResult  : " << result << "\n";
		assert(false);
	}
	list1.debug_print_list("********");
}


void test2() {
	cout << "\n\ntest2\n";
	LinkedList list1;

	list1.insert_end(5);
	list1.insert_end(2);
	list1.insert_end(3);
	list1.insert_end(2);
	list1.insert_end(1);
	list1.insert_end(1);
	list1.move_key_occurance_to_end(1);


	string expected = "5 2 3 2 1 1";
	string result = list1.debug_to_string();
	if (expected != result) {
		cout << "no match:\nExpected: " << expected << "\nResult  : " << result << "\n";
		assert(false);
	}
	list1.debug_print_list("********");
}

void test3() {
	cout << "\n\ntest3\n";
	LinkedList list1;

	list1.insert_end(1);
	list1.insert_end(1);
	list1.insert_end(1);
	list1.insert_end(1);
	list1.insert_end(1);
	list1.insert_end(1);
	list1.move_key_occurance_to_end(1);


	string expected = "1 1 1 1 1 1";
	string result = list1.debug_to_string();
	if (expected != result) {
		cout << "no match:\nExpected: " << expected << "\nResult  : " << result << "\n";
		assert(false);
	}
	list1.debug_print_list("********");
}

void test4() {
	cout << "\n\ntest4\n";
	LinkedList list1;

	list1.insert_end(1);
	list1.insert_end(2);
	list1.insert_end(3);
	list1.insert_end(1);
	list1.insert_end(2);
	list1.insert_end(4);
	list1.insert_end(1);
	list1.insert_end(7);
	list1.insert_end(1);
	list1.insert_end(8);
	list1.insert_end(1);
	list1.insert_end(1);
	list1.move_key_occurance_to_end(1);


	string expected = "2 3 2 4 7 8 1 1 1 1 1 1";
	string result = list1.debug_to_string();
	if (expected != result) {
		cout << "no match:\nExpected: " << expected << "\nResult  : " << result << "\n";
		assert(false);
	}
	list1.debug_print_list("********");
}


void test5() {
	cout << "\n\ntest5\n";
	LinkedList list1;

	list1.insert_end(1);
	list1.insert_end(2);
	list1.insert_end(3);
	list1.insert_end(4);

	list1.move_key_occurance_to_end(4);


	string expected = "1 2 3 4";
	string result = list1.debug_to_string();
	if (expected != result) {
		cout << "no match:\nExpected: " << expected << "\nResult  : " << result << "\n";
		assert(false);
	}
	list1.debug_print_list("********");
}


int main() {
	test5();

	test1();
	test2();
	test3();
	test4();

	cout << "\n\nNO RTE\n";		// must see it, otherwise RTE
	return 0;
}


