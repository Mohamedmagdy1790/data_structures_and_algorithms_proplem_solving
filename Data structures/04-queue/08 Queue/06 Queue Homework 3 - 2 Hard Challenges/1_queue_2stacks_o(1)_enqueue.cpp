#include <iostream>
#include <cassert>
using namespace std;

class Stack {
private:
	int size { };
	int top { };
	int* array { };
public:
	Stack(int size) :
			size(size), top(-1) {
		array = new int[size];
	}

	~Stack() {
		delete[] array;
	}

	void push(int x) {
		assert(!isFull());
		array[++top] = x;
	}

	int pop() {
		assert(!isEmpty());
		return array[top--];
	}

	int peek() {
		assert(!isEmpty());
		return array[top];
	}

	int isFull() {
		return top == size - 1;
	}

	int isEmpty() {
		return top == -1;
	}

	void display() {
		for (int i = top; i >= 0; i--)
			cout << array[i] << " ";
		cout << "\n";
	}
};

/*
 * For enqueue, just push to the stack1
 * 	Notice, data is reversed!
 *
 * For dequeue,
 * 	In the first time, we get all items from stack
 * 	now stack2 has its output as proper queue output (reverse of reverse)
 * 	all these elements must go in order
 *
 * 	at any time stack2 elements are done, we move again from stack1
 */
class Queue {
private:
	int size;
	int added_elements { };
	Stack s1;
	Stack s2;

	void move(Stack &from, Stack &to) {		// O(n)
		while(!from.isEmpty())
			to.push(from.pop());
	}

public:
	Queue(int size) :
			size(size), s1(size), s2(size) {
	}

	void enqueue(int value) {	// O(1)
		assert(!isFull());
		s1.push(value);
		added_elements++;
	}

	int dequeue() {				// O(n)
		assert(!isEmpty());

		if(s2.isEmpty())	// If s2 is done, move again from s1
			move(s1, s2);

		int value = s2.pop();
		--added_elements;
		return value;
	}

	int isEmpty() {
		return added_elements == 0;
	}

	bool isFull() {
		return added_elements == size;
	}
};

int main() {
	Queue qu(6);

	for (int i = 1; i <= 3; ++i)
		qu.enqueue(i);

	cout<<qu.dequeue()<<" ";

	for (int i = 4; i <= 5; ++i)
		qu.enqueue(i);

	while(!qu.isEmpty())
		cout<<qu.dequeue()<<" ";

	return 0;
}
