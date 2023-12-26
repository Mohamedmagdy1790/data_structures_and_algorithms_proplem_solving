#include <iostream>
#include <cassert>
using namespace std;

class Queue {
	int size { };
	int front { 0 };
	int rear { 0 };
	int added_elements { };
	int *array { };

public:
	Queue(int size) :
			size(size) {
		array = new int[size];
	}

	~Queue() {
		delete[] array;
	}

	int next(int pos) {
		++pos;
		if (pos == size)
			pos = 0;
		return pos;
		//return (pos + 1) % size;	//  Or shorter way
	}

	void enqueue(int value) {
		assert(!isFull());
		array[rear] = value;
		rear = next(rear);
		added_elements++;
	}

	int dequeue() {
		assert(!isEmpty());
		int value = array[front];
		front = next(front);
		--added_elements;
		return value;
	}

	void display() {
		for (int cur = front, step = 0; step < added_elements; ++step, cur = next(cur))
			cout << array[cur] << " ";
		cout << "\n";
	}

	int isEmpty() {
		return added_elements == 0;
	}

	bool isFull() {
		return added_elements == size;
	}
};

class PriorityQueue {
private:
	int size { };
	int added_elements { };
	Queue q1, q2, q3;

public:
	PriorityQueue(int size) :
			size(size), q1(size), q2(size), q3(size) {
	}

	void enqueue(int value, int priority) {
		assert(!isFull());

		if (priority == 3)
			q3.enqueue(value);
		else if (priority == 2)
			q2.enqueue(value);
		else if (priority == 1)
			q1.enqueue(value);
		else
			assert(false);	// priority > 3
		++added_elements;
	}

	int dequeue() {
		assert(!isEmpty());
		--added_elements;

		if (!q3.isEmpty())
			return q3.dequeue();
		else if (!q2.isEmpty())
			return q2.dequeue();
		else
			return q1.dequeue();
	}

	void display() {
		if (!q3.isEmpty()) {
			cout << "Priority #3 tasks: ";
			q3.display();
		}
		if (!q2.isEmpty()) {
			cout << "Priority #2 tasks: ";
			q2.display();
		}
		if (!q1.isEmpty()) {
			cout << "Priority #1 tasks: ";
			q1.display();
		}
		cout<<"******************\n";
	}

	int isEmpty() {
		return added_elements == 0;
	}

	bool isFull() {
		return added_elements == size;
	}
};

int main() {


	PriorityQueue tasks(8);

	tasks.enqueue(1131, 1);
	tasks.enqueue(3111, 3);
	tasks.enqueue(2211, 2);
	tasks.enqueue(3161, 3);

	tasks.display();
	//Priority #3 tasks: 3111 3161
	//Priority #2 tasks: 2211
	//Priority #1 tasks: 1131

	cout << tasks.dequeue() << "\n";	// 3111
	cout << tasks.dequeue() << "\n";	// 3161

	tasks.enqueue(1535, 1);
	tasks.enqueue(2815, 2);
	tasks.enqueue(3845, 3);
	tasks.enqueue(3145, 3);

	tasks.display();
	//Priority #3 tasks: 3845 3145
	//Priority #2 tasks: 2211 2815
	//Priority #1 tasks: 1131 1535

	while (!tasks.isEmpty())
		cout << tasks.dequeue() << " ";
	// 3845 3145 2211 2815 1131 1535

	return 0;
}

/*
Priority #3 tasks: 3111 3161
Priority #2 tasks: 2211
Priority #1 tasks: 1131
******************
3111
3161
Priority #3 tasks: 3845 3145
Priority #2 tasks: 2211 2815
Priority #1 tasks: 1131 1535
******************
3845 3145 2211 2815 1131 1535
 */
