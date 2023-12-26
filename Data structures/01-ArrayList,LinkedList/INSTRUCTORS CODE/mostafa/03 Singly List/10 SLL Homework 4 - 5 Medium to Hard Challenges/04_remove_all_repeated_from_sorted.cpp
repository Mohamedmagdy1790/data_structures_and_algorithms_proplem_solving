#include <iostream>
#include <cassert>
#include <climits>

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
		cout << "Destroy value: " << data << " at address " << this << "\n";
	}
};

class LinkedList {
private:
	Node *head { };
	Node *tail { };
	int length = 0;	// let's maintain how many nodes

	vector<Node*> debug_data;	// add/remove nodes you use

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
		assert(length == (int )debug_data.size());
	}

	////////////////////////////////////////////////////////////

	void print() {
		for (Node* cur = head; cur; cur = cur->next)
			cout << cur->data << " ";
		cout << "\n";
	}

	// These 2 simple functions just to not forget changing the vector and length
	void delete_node(Node* node) {
		debug_remove_node(node);
		--length;
		delete node;
	}

	void add_node(Node* node) {
		debug_add_node(node);
		++length;
	}

	void insert_end(int value) {
		Node* item = new Node(value);
		add_node(item);

		if (!head)
			head = tail = item;
		else
			tail->next = item, tail = item;
	}

	void insert_front(int value) {
		Node* item = new Node(value);
		add_node(item);

		item->next = head;
		head = item;

		if (length == 1)
			tail = head;
	}
	void delete_front() {
		assert(length);
		Node* cur = head->next;
		delete_node(head);
		head = cur;
	}
	////////////////////////////////////////////////////////////

	Node* move_and_delete(Node* node) {
		Node* temp = node->next;
		delete_node(node);
		return temp;
	}

	void remove_all_repeated_from_sorted() {	// O(n) time - O(1) memory
		if (length <= 1)
			return;

		// Add dummy head for easier prv linking
		insert_front(-1234);

		tail = head;
		Node *previous = head;
		Node *cur = head->next;	// Our actual head

		while (cur) {
			// 2 cases: Either blocks of repeated so remove it. Or single node, keep it

			// keep removing blocks of SAME value
			bool any_removed = false;
			while (cur && cur->next && cur->data == cur->next->data) {
				int block_value = cur->data;
				any_removed = true;
				while (cur && cur->data == block_value)
					cur = move_and_delete(cur);
			}
			if (any_removed) {
				if (!cur)
					tail = previous;
				previous->next = cur;	// link after the removed nodes
				previous = cur;
			} else {
				// No duplicates. Connect and use as tail for now
				tail = cur;
				previous = cur;
				cur = cur->next;
			}
		}
		previous = head->next;	// actual head
		delete_front();		// remove dummy head
		head = previous;
		if (!head)
			tail = head;
		debug_verify_data_integrity();
	}
};

void test1() {
	cout << "\n\ntest1\n";
	LinkedList list;

	list.insert_end(0);
	list.insert_end(1);

	list.remove_all_repeated_from_sorted();
	list.print();

	string expected = "0 1";
	string result = list.debug_to_string();
	if (expected != result) {
		cout << "no match:\nExpected: " << expected << "\nResult  : " << result << "\n";
		assert(false);
	}
	list.debug_print_list("********");
}

void test2() {
	cout << "\n\ntest2\n";
	LinkedList list;

	list.insert_end(1);
	list.insert_end(1);

	list.remove_all_repeated_from_sorted();
	list.print();

	string expected = "";
	string result = list.debug_to_string();
	if (expected != result) {
		cout << "no match:\nExpected: " << expected << "\nResult  : " << result << "\n";
		assert(false);
	}
	list.debug_print_list("********");
}

void test3() {
	cout << "\n\ntest3\n";
	LinkedList list;

	list.insert_end(1);
	list.insert_end(1);
	list.insert_end(2);
	list.insert_end(2);

	list.remove_all_repeated_from_sorted();
	list.print();

	string expected = "";
	string result = list.debug_to_string();
	if (expected != result) {
		cout << "no match:\nExpected: " << expected << "\nResult  : " << result << "\n";
		assert(false);
	}
	list.debug_print_list("********");
}

void test4() {
	cout << "\n\ntest4\n";
	LinkedList list;

	list.insert_end(1);
	list.insert_end(1);
	list.insert_end(2);
	list.insert_end(3);
	list.insert_end(3);
	list.insert_end(4);
	list.insert_end(4);
	list.insert_end(5);
	list.insert_end(6);

	list.remove_all_repeated_from_sorted();
	list.print();

	string expected = "2 5 6";
	string result = list.debug_to_string();
	if (expected != result) {
		cout << "no match:\nExpected: " << expected << "\nResult  : " << result << "\n";
		assert(false);
	}
	list.debug_print_list("********");
}

void test5() {
	cout << "\n\ntest5\n";
	LinkedList list;

	list.insert_end(1);
	list.insert_end(1);
	list.insert_end(2);
	list.insert_end(3);
	list.insert_end(3);
	list.insert_end(4);
	list.insert_end(4);
	list.insert_end(5);
	list.insert_end(6);
	list.insert_end(7);
	list.insert_end(7);

	list.remove_all_repeated_from_sorted();
	list.print();

	string expected = "2 5 6";
	string result = list.debug_to_string();
	if (expected != result) {
		cout << "no match:\nExpected: " << expected << "\nResult  : " << result << "\n";
		assert(false);
	}
	list.debug_print_list("********");
}


int main() {

	test1();
	test2();
	test3();
	test4();
	test5();

	// must see it, otherwise RTE
	cout << "\n\nNO RTE\n";

	return 0;
}

