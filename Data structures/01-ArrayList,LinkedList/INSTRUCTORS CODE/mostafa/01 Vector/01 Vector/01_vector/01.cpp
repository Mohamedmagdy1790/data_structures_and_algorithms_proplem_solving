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
};

int main() {


	Vector v(10);
	for (int i = 0; i < 10; ++i)
		v.set(i, i);

	v.print();
	cout<<v.find(5)<<" "<<v.find(55);	// 5 -1

	return 0;
}
