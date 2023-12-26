#include <iostream>
#include <cassert>
using namespace std;

class Vector {
private:
	int *arr = nullptr;
	int size = 0;

public:
	Vector(int size) :
			size(size) {
		if (size < 0)
			size = 1;
		arr = new int[size] { };
	}

	~Vector() {
		delete[] arr;
		arr = nullptr;
	}

	int get_size() {
		return size;
	}

	int get(int idx) {
		assert(0 <= idx && idx < size);
		return arr[idx];
	}

	void set(int idx, int val) {
		assert(0 <= idx && idx < size);
		arr[idx] = val;
	}

	void print() {
		for (int i = 0; i < size; ++i)
			cout << arr[i] << " ";
		cout << "\n";
	}

	int find(int value) {
		for (int i = 0; i < size; ++i)
			if (arr[i] == value)
				return i;
		return -1;	// -1 for NOT found
	}

	int get_front() {
		return arr[0];
	}

	int get_back() {
		return arr[size-1];
	}

	void push_back(int value) {
		// Add element to the end of the vector
		// 1) create a new array of bigger size
		int *arr2 = new int[size + 1];		// size+1 steps
		// 2) copy old data
		for (int i = 0; i < size; ++i)		// 3size+1 steps
			arr2[i] = arr[i];
		// 3) add the new element and increase size
		arr2[size++] = value;				// 2 steps
		// 4) change the pointers
		swap(arr, arr2);					// 3 steps
		// 5) remove the useless data
		delete[] arr2;						// size steps

		// Total: 5size + 7 ==> approximately size steps
	}
};

int main() {

	int n = 4;
	Vector v(n);
	for (int i = 0; i < n; ++i)
		v.set(i, i);

	v.push_back(15);
	v.push_back(17);
	v.push_back(19);
	v.print();
	// 0 1 2 3 15 17 19

	for (int i = 0; i < 1000000; ++i) {
		v.push_back(i);
	} // takes tooooo much time! WHY

	return 0;
}
