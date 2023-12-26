#include <iostream>
#include <cassert>
using namespace std;

// We can't depend on front/rear to know empty/full
// But what if we prevented the full case to have front == rear?
// The trick: for an array of length n, ONLY n-1 elements will be used
// This way front == rear will always be for empty
// We can derive isFull and display based on this decision as below

// Minor issuer: user creates queue of N items, but only N-1 is available!
// Simple workaround, create a queue of size+1, this way the usage matches user expectations!

class Queue {
	int front { 0 };	// index of our first element
	int rear { 0 };		// an empty position waiting for a new element to be added in it
	int size { };
	int *array { };

public:
	Queue(int size) :
			size(size+1) {
		// Observe: we used size+1 NOT size to match user expectations!
		array = new int[this->size];
	}

	~Queue() {
		delete[] array;
	}

	int next(int pos) {
		//return (pos + 1) % size;	//  Or shorter way
		++pos;
		if (pos == size)
			pos = 0;
		return pos;
	}

	void enqueue(int value) {
		assert(!isFull());
		array[rear] = value;	// rear is empty. add and move
		rear = next(rear);
	}

	int dequeue() {
		assert(!isEmpty());
		int value = array[front];
		front = next(front);
		return value;
	}

	void display() {
		cout << "Front " << front << " - rear " << rear << "\t";
		if (isFull())
			cout << "full";
		else if (isEmpty()) {
			cout << "empty";
		}
		cout << "\nContent: ";
		// cur != rear   : rear doesn't have element
		for (int cur = front; cur != rear; cur = next(cur))
			cout << array[cur] << " ";
		cout << "\n\n";
	}

	int isEmpty() {
		return front == rear;
	}

	// 0 1 2 3 x 5 6       x = rear. 5 front
	bool isFull() {
		return next(rear) == front;
	}
};


int main() {
	Queue qu(6);
	assert(qu.isEmpty());
	qu.display();

	for (int i = 1; i <= 6; ++i) {
		assert(!qu.isFull());
		qu.enqueue(i);
		qu.display();
	}
	assert(qu.isFull());

	for (int i = 1; i <= 6; ++i) {
		assert(!qu.isEmpty());
		qu.dequeue();
		//qu.display();
	}

	for (int i = 1; i <= 6; ++i) {
		assert(!qu.isFull());
		qu.enqueue(i);
		qu.display();
	}

	qu.dequeue();
	assert(!qu.isFull());
	qu.enqueue(7);
	assert(qu.isFull());
	qu.display();

	qu.dequeue();
	qu.dequeue();
	assert(!qu.isFull());
	qu.enqueue(8);
	assert(!qu.isFull());
	qu.display();
	qu.enqueue(9);
	assert(qu.isFull());
	qu.display();

	for (int i = 1; i <= 6; ++i) {
		assert(!qu.isEmpty());
		qu.dequeue();
		qu.display();
	}

	return 0;
}

/*
Front 0 - rear 0	empty
Content:

Front 0 - rear 1
Content: 1

Front 0 - rear 2
Content: 1 2

Front 0 - rear 3
Content: 1 2 3

Front 0 - rear 4
Content: 1 2 3 4

Front 0 - rear 5	full
Content: 1 2 3 4 5

Front 5 - rear 0
Content: 1

Front 5 - rear 1
Content: 1 2

Front 5 - rear 2
Content: 1 2 3

Front 5 - rear 3
Content: 1 2 3 4

Front 5 - rear 4	full
Content: 1 2 3 4 5

Front 0 - rear 5	full
Content: 2 3 4 5 6

Front 2 - rear 0
Content: 4 5 6 7

Front 2 - rear 1	full
Content: 4 5 6 7 8

Front 3 - rear 1
Content: 5 6 7 8

Front 4 - rear 1
Content: 6 7 8

Front 5 - rear 1
Content: 7 8

Front 0 - rear 1
Content: 8

Front 1 - rear 1	empty
Content:


Observe for empty case: we always have rear = front
Observe for full case: always next(rear) = front
as we left one empty element between them

With current design choices, we can detect isEmpty and isFull
*/
