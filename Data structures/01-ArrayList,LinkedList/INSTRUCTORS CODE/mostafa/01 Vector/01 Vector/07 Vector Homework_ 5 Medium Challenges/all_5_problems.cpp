#include <iostream>
#include <cassert>
using namespace std;

class Vector {
private:
	int *arr { nullptr };
	int size { 0 };			// user size
	int capacity { };		// actual size

	void expand_capacity() {
		// Double the actual array size
		capacity *= 2;
		cout << "Expand capacity to " << capacity << "\n";
		int *arr2 = new int[capacity] { };
		for (int i = 0; i < size; ++i)
			arr2[i] = arr[i];	// copy data

		swap(arr, arr2);
		delete[] arr2;
	}

public:

	Vector(int size) :
			size(size) {
		if (size < 0)
			size = 1;
		capacity = size;
		// The actual size array will
		// be bigger than needed
		arr = new int[capacity] { };
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
		return arr[size - 1];
	}

	void push_back(int value) {
		// we can't add any more
		if (size == capacity)
			expand_capacity();
		arr[size++] = value;
	}

	void insert(int idx, int value) {
		assert(0 <= idx && idx < size);

		// we can't add any more
		if (size == capacity)
			expand_capacity();

		// Shift all the data to right first
		for (int p = size - 1; p >= idx; --p)
			arr[p + 1] = arr[p];

		arr[idx] = value;
		++size;
	}

	void right_rotate() {
		if (size <= 1)
			return;
			
		// Make sure your code doesn't expand capacity or goes beyond limit
		int last_element = arr[size - 1];
		// right shift first size-1 elements
		for (int p = size - 2; p >= 0; --p)
			arr[p + 1] = arr[p];
		arr[0] = last_element;
	}

	void left_rotate() {
		// Make sure your code doesn't expand capacity or goes beyond limit
		int first_element = arr[0];
		// right shift first size-1 elements
		for (int p = 1; p < size; ++p)
			arr[p - 1] = arr[p];
		arr[size - 1] = first_element;
	}

	void right_rotate(int times) {
		// Every 'size' rotations, just return the array to its original position
		// First, get rid of all of these multiple of size rotations
		times %= size;

		while (times--)
			right_rotate();
	}

	int pop(int idx) {
		assert(0 <= idx && idx < size);
		int val = arr[idx];

		// Shift all the data to left
		for (int p = idx + 1; p < size; ++p)
			arr[p - 1] = arr[p];

		--size;
		return val;
	}

	int find_transposition(int value) {
		for (int i = 0; i < size; ++i)
			if (arr[i] == value) {
				if (i == 0)	// special case
					return 0;

				// one shift left
				swap(arr[i], arr[i - 1]);
				return i - 1;	// NOT i
			}
		return -1;	// -1 for NOT found
	}
};

int main() {

	int n = 5;
	Vector v(n);
	for (int i = 0; i < n; ++i)
		v.set(i, i);

	v.print();			// 0 1 2 3 4
	v.right_rotate(5 * 1000);
	v.print();			// 0 1 2 3 4
	v.right_rotate(2);
	v.print();			// 3 4 0 1 2
	v.left_rotate();
	v.print();			// 4 0 1 2 3

	int val = v.pop(2);
	cout << val << "\n";	// 1
	v.print();			// 4 0 2 3

	cout<<v.find_transposition(3)<<"\n";	// 2
	v.print();			// 4 0 3 2

	return 0;
}
