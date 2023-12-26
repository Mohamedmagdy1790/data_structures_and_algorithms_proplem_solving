#include <iostream>
#include <cassert>
using namespace std;


// the vector interface (corresponds to ADT)
class Vector {
private:
	int *arr { nullptr };
	int size { 0 };
	int capacity { };
	void expand_capacity();

public:
	Vector(int size);
	~Vector();

	int get_size();
	int get_front();
	int get_back();
	int get(int idx);
	void set(int idx, int val);

	void print();
	int find(int value);
	void push_back(int value);
};

// The following is ONE implementation
// we can actually move it to a header file!
void Vector::expand_capacity() {
	// Double the actual array size
	capacity *= 2;
	cout << "Expand capacity to " << capacity << "\n";
	int *arr2 = new int[capacity] { };
	for (int i = 0; i < size; ++i)
		arr2[i] = arr[i];	// copy data

	swap(arr, arr2);
	delete[] arr2;
}

Vector::Vector(int size) :
		size(size) {
	if (size < 0)
		size = 1;
	capacity = size + 10;
	// The actual size array will
	// be bigger than needed
	arr = new int[capacity] { };
}

Vector::~Vector() {
	delete[] arr;
	arr = nullptr;
}

int Vector::get_size() {
	return size;
}

int Vector::get(int idx) {
	assert(0 <= idx && idx < size);
	return arr[idx];
}

void Vector::set(int idx, int val) {
	assert(0 <= idx && idx < size);
	arr[idx] = val;
}

void Vector::print() {
	for (int i = 0; i < size; ++i)
		cout << arr[i] << " ";
	cout << "\n";
}

int Vector::find(int value) {
	for (int i = 0; i < size; ++i)
		if (arr[i] == value)
			return i;
	return -1;	// -1 for NOT found
}

int Vector::get_front() {
	return arr[0];
}

int Vector::get_back() {
	return arr[size - 1];
}

void Vector::push_back(int value) {
	// we can't add any more
	if (size == capacity)
		expand_capacity();
	arr[size++] = value;
}

int main() {

	int n = 2;
	Vector v(n);
	for (int i = 0; i < n; ++i)
		v.set(i, i);

	for (int i = 0; i < 15; ++i)
		v.push_back(i + 10);

	v.print();

	return 0;
}
