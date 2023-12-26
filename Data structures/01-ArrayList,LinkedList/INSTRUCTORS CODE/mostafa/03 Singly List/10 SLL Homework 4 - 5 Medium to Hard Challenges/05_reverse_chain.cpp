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
		cout << "************\n"<<flush;
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
		assert(length == (int)debug_data.size());
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

	void insert_front(int value) {
		Node* item = new Node(value);
		++length;
		debug_add_node(item);

		item->next = head;
		head = item;

		if(length == 1)
			tail = head;

		debug_verify_data_integrity();
	}

	void insert_after(Node* node, int value) {
		Node* item = new Node(value);
		++length;
		debug_add_node(item);

		item->next = node->next;
		node->next = item;
	}

	pair<Node*, pair<Node*, Node*>> reverse_subchain(Node* cur_head, int k) {	// O(n) time - O(1) memory
		// Given a node: reverse only a chain of k nodes
		// return: current chain head, current chain tail, next head
		// Logic same as normal reverse function

		Node* cur_tail = cur_head;	// the head is tail once reversed
		Node* prv = cur_head;
		cur_head = cur_head->next;	// Start from next

		for (int s = 0; s < k-1 && cur_head; ++s) {	//k-1 links reversed
			// store & reverse link
			Node* next = cur_head->next;
			cur_head->next = prv;

			// move step
			prv = cur_head;
			cur_head = next;
		}
		return make_pair(prv, make_pair(cur_tail, cur_head));	// C++17 can use tie/tuple
	}

	void reverse_chains(int k) {
		// Reverse each K consecutive nodes
		if (length <= 1 || k == 1)
			return;

		Node* last_tail = nullptr;
		Node* next_chain_head = head;
		head = nullptr;

		while(next_chain_head) {
			// Keep reversing a chain of K nodes, and link with prv chain
			pair<Node*, pair<Node*, Node*>> p = reverse_subchain(next_chain_head, k);
			Node* chain_head = p.first;
			Node* chain_tail = p.second.first;
			next_chain_head = p.second.second;
			tail = chain_tail;

			if(!head)	// first chain
				head = chain_head;
			else	// connect last chain tail with next chain head
				last_tail->next = chain_head;
			last_tail = chain_tail;
		}
		tail->next = nullptr;
		debug_verify_data_integrity();
	}
};

void test1() {
	cout << "\n\ntest1\n";
	LinkedList list;

	list.insert_end(1);
	list.insert_end(2);
	list.insert_end(3);
	list.insert_end(4);
	list.insert_end(5);
	list.insert_end(6);
	list.reverse_chains(6);
	// some actions
	list.print();

	string expected = "6 5 4 3 2 1";
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
	list.insert_end(2);
	list.insert_end(3);
	list.insert_end(4);
	list.insert_end(5);
	list.insert_end(6);
	list.reverse_chains(3);
	// some actions
	list.print();

	string expected = "3 2 1 6 5 4";
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
	list.insert_end(2);
	list.insert_end(3);
	list.insert_end(4);
	list.insert_end(5);
	list.insert_end(6);
	list.insert_end(7);
	list.reverse_chains(2);
	// some actions
	list.print();

	string expected = "2 1 4 3 6 5 7";
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

	cout << "\n\nNO RTE\n";		// must see it, otherwise RTE
	return 0;
}

