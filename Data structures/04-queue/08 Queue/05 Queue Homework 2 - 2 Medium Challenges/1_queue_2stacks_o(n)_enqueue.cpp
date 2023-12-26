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
 * We simply keep enqueuing in the bottom of the stack
 * This makes stack pop is exactly like a queue
 * Dequeue then is O(1)
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
	// assume we enqueue: [1, 2, 3, 4]
	// assume we built stack to be s1 = [4, 3, 2, 1 (top)] 
		// That is: it matches queue output
	// let's enqueue 5
	// move s1 to s2: s2 = [1, 2, 3, 4]
	// push 5 to s1: s1 = [5]
	// move s2 to s1: [5, 4, 3, 2 ,1]
	// 2 moves: reverse and cancel it

	void enqueue(int value) {	// O(n)
		assert(!isFull());
		move(s1, s2);
		s1.push(value);
		move(s2, s1);
		added_elements++;
	}

	int dequeue() {				// O(1)
		assert(!isEmpty());
		int value = s1.pop();
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
