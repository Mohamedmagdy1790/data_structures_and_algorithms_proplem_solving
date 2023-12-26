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
	Node* prev { };	 // Previous node!

	Node(int data) :
			data(data) {
	}

	void set(Node* next, Node* prev) {
		this->next = next;
		this->prev = prev;
	}

	~Node() {
		cout << "Destroy value: " << data << " at address " << this << "\n";
	}
};

class LinkedList {
private:
	Node *head { };
	Node *tail { };
	int length = 0;

	// let's maintain how many nodes

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

		if (node->prev == nullptr)
			cout << "X\t";
		else
			cout << node->prev->data << "\t";

		cout << " <= [" << node->data << "]\t => \t";

		if (node->next == nullptr)
			cout << "X\t";
		else
			cout << node->next->data << "\t";

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
			assert(!head->prev);
			assert(!tail->next);
		}
		int len = 0;
		for (Node* cur = head; cur; cur = cur->next, len++) {
			if (len == length - 1)	// make sure we end at tail
				assert(cur == tail);
		}

		assert(length == len);
		assert(length == (int )debug_data.size());

		len = 0;
		for (Node* cur = tail; cur; cur = cur->prev, len++) {
			if (len == length - 1)	// make sure we end at head
				assert(cur == head);
		}
		cout << "\n";
	}

	~LinkedList() {
		while (length)
			delete_front();
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
		else {
			link(tail, item);
			tail = item;
		}
		debug_verify_data_integrity();
	}

	void insert_front(int value) {
		Node* item = new Node(value);
		add_node(item);

		if (!head)
			head = tail = item;
		else {
			link(item, head);
			head = item;
		}
		debug_verify_data_integrity();
	}

	void print_reversed() {
		for (Node* cur = tail; cur; cur = cur->prev)
			cout << cur->data << " ";
		cout << "\n";
	}

	void delete_front() {
		if (!head)
			return;
		Node* cur = head->next;
		delete_node(head);
		head = cur;

		// Integrity change
		if (head)
			head->prev = nullptr;
		else if (!length)
			tail = nullptr;

		debug_verify_data_integrity();
	}

	void delete_end() {
		if (!head)
			return;
		Node* cur = tail->prev;
		delete_node(tail);
		tail = cur;

		// Integrity change
		if (tail)
			tail->next = nullptr;
		else if (!length)
			head = nullptr;

		debug_verify_data_integrity();
	}

	void link(Node* first, Node*second) {
		if (first)
			first->next = second;
		if (second)
			second->prev = first;
	}

	void delete_and_link(Node* cur) {
		// remove this node, but connect its neighbors
		link(cur->prev, cur->next);
		delete_node(cur);
	}

	/////////////////////////////////////////

	void merge_2sorted_lists(LinkedList &other) {	// O(n+m)
		if (!other.head)
			return;

		if (head) {
			Node* cur1 = head;
			Node* cur2 = other.head;
			Node* last { };
			head = nullptr;

			while (cur1 && cur2) {
				Node* next { };
				// pick the smallest among the 2 lists and then link it
				if (cur1->data <= cur2->data) {
					next = cur1;
					cur1 = cur1->next;
				} else {
					next = cur2;
					cur2 = cur2->next;
				}
				link(last, next);
				last = next;
				if (!head)	// first step is the head
					head = last;
			}
			if (cur2) {	// our tail is from 2nd
				tail = other.tail;
				link(last, cur2);
			} else if (cur1) {
				link(last, cur1);
			}
		} else {	// use its data
			head = other.head;
			tail = other.tail;
		}

		length += other.length;
		debug_data.insert(debug_data.end(), other.debug_data.begin(), other.debug_data.end());	// add other nodes
		other.head = other.tail = nullptr;
		other.length = 0;
		other.debug_data.clear();

		debug_verify_data_integrity();
	}
};

void test1() {
	cout << "\n\ntest1\n";
	LinkedList list1;
	list1.insert_end(10);
	list1.insert_end(20);
	list1.insert_end(30);
	list1.insert_end(40);
	list1.insert_end(50);

	LinkedList list2;
	list2.insert_end(15);
	list2.insert_end(17);
	list2.insert_end(22);
	list2.insert_end(24);
	list2.insert_end(35);

	list1.merge_2sorted_lists(list2);
	list1.print();

	string expected = "10 15 17 20 22 24 30 35 40 50";
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
	list1.insert_end(10);
	list1.insert_end(20);
	list1.insert_end(30);
	list1.insert_end(40);
	list1.insert_end(50);

	LinkedList list2;
	list2.insert_end(5);
	list2.insert_end(17);
	list2.insert_end(22);
	list2.insert_end(24);
	list2.insert_end(60);

	list1.merge_2sorted_lists(list2);
	list1.print();

	string expected = "5 10 17 20 22 24 30 40 50 60";
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
	list1.insert_end(10);
	list1.insert_end(20);
	list1.insert_end(30);
	list1.insert_end(40);
	list1.insert_end(50);

	LinkedList list2;
	list2.insert_end(60);

	list1.merge_2sorted_lists(list2);
	list1.print();

	string expected = "10 20 30 40 50 60";
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
	list1.insert_end(60);

	LinkedList list2;
	list2.insert_end(10);
	list2.insert_end(20);
	list2.insert_end(30);
	list2.insert_end(40);
	list2.insert_end(50);

	list1.merge_2sorted_lists(list2);
	list1.print();

	string expected = "10 20 30 40 50 60";
	string result = list1.debug_to_string();
	if (expected != result) {
		cout << "no match:\nExpected: " << expected << "\nResult  : " << result << "\n";
		assert(false);
	}
	list1.debug_print_list("********");
}

void test5() {
	cout << "\n\ntest4\n";
	LinkedList list1;

	LinkedList list2;
	list2.insert_end(10);
	list2.insert_end(20);
	list2.insert_end(30);
	list2.insert_end(40);
	list2.insert_end(50);

	list1.merge_2sorted_lists(list2);
	list1.print();

	string expected = "10 20 30 40 50";
	string result = list1.debug_to_string();
	if (expected != result) {
		cout << "no match:\nExpected: " << expected << "\nResult  : " << result << "\n";
		assert(false);
	}
	list1.debug_print_list("********");
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

