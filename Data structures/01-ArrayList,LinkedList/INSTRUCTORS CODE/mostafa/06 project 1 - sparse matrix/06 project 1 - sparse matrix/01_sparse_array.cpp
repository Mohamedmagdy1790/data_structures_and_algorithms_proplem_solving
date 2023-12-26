#include <iostream>
#include <cassert>
using namespace std;

struct ArrayNode {
	int data { };
	int index { };		// element index in the array (non-zero)
	ArrayNode* next { };
	ArrayNode* prev { };

	ArrayNode(int data, int index) :
			data(data), index(index) {
	}
};

class ArrayLinkedList {
private:
	ArrayNode *head { };
	ArrayNode *tail { };
	int length = 0;			// total number of nodes
	int array_length { };	// Total number of array elements

	void link(ArrayNode* first, ArrayNode*second) {
		if (first)
			first->next = second;
		if (second)
			second->prev = first;
	}

	ArrayNode* embed_after(ArrayNode* node_before, int data, int index) {
		ArrayNode* middle = new ArrayNode(data, index);
		++length;

		ArrayNode* node_after = node_before->next;
		link(node_before, middle);

		if (!node_after)
			tail = middle;
		else
			link(middle, node_after);

		return middle;
	}

	// Return the node of this index
	ArrayNode* get_index(int index, bool is_create_if_missing) {
		ArrayNode* prev_index = head;
		// Find the node with index-1
		while (prev_index->next && prev_index->next->index < index)
			prev_index = prev_index->next;

		bool found = prev_index->next && prev_index->next->index == index;

		if (found)
			return prev_index->next;

		if (!is_create_if_missing)
			return nullptr;

		return embed_after(prev_index, 0, index);
	}
public:
	ArrayLinkedList(int array_length) :
			array_length(array_length) {
		// Dummy node of index = -1, to make coding shorter and more robust!
		// Reading: https://en.wikipedia.org/wiki/Sentinel_node
		tail = head = new ArrayNode(0, -1);
		++length;
	}

	void print_array() {
		ArrayNode* cur = head->next;

		for (int c = 0; c < array_length; ++c) {
			if (cur && cur->index == c) {
				cout << cur->data << " ";
				cur = cur->next;
			} else
				cout << "0 ";
		}
		cout << "\n";
	}

	void print_array_nonzero() {
		for (ArrayNode* cur = head->next; cur; cur = cur->next)
			cout << cur->data << " ";
		cout << "\n";
	}
	void set_value(int data, int index) {
		get_index(index, true)->data = data;
	}

	int get_value(int index) {
		ArrayNode* node = get_index(index, false);
		if (!node)
			return 0;
		return node->data;
	}
	void add(ArrayLinkedList &other) {
		assert(array_length == other.array_length);

		// Iterate on the other first, and add it to the current one
		for (ArrayNode* other_cur = other.head->next; other_cur; other_cur = other_cur->next) {
			ArrayNode* this_index = get_index(other_cur->index, true);  // **
			this_index->data += other_cur->data;
		}
		// ** We can make this function more efficient, but let's keep simple
	}
};

void test_index() {
	ArrayLinkedList array(10);	// length 10
	array.set_value(50, 5);
	array.set_value(20, 2);
	array.set_value(70, 7);
	array.set_value(40, 4);
	array.print_array();
	// 0 0 20 0 40 50 0 70 0 0
	array.print_array_nonzero();
	// 20 40 50 70
	cout << array.get_value(7) << "\n";	// 70

	ArrayLinkedList array2(10);
	array2.set_value(1, 4);
	array2.set_value(3, 7);
	array2.set_value(4, 6);

	array.add(array2);
	array.print_array();
	// 0 0 20 0 41 50 4 73 0 0
}

int main() {
	test_index();
	//test_sparse();

	cout << "\n\n\nNO RTE\n";

	return 0;
}

