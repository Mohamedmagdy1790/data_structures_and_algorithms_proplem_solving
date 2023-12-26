#include <iostream>
#include <cassert>
#include <climits>
#include <vector>
using namespace std;

int* f1(int n) { // Total O(n) memory, O(n^2) time

	// This line: O(n) time and O(n) memory
	int *p = new int[n] {};

	for (int i = 0; i < n; ++i)	// O(n) time
		p[i] = i;

	int sum = 0;	// O(n^2) time
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			sum += p[i];
		}
	}
	return p;
}

int* f2() { // Total O(1) memory, O(1) time
	int n = 10000;
	int *p = new int[n] {};

	for (int i = 0; i < n; ++i)
		p[i] = i;

	int sum = 0;
	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j)
			sum += p[i];
	return p;
}

int* f3B(int n) {	// O(n) time/memory
	return new int[n] {};
}

void f3A(int n) {
	// O(n^2) time but still O(n) memory
	for (int i = 1; i < n; ++i) {
		int *p = f3B(n);
		delete [] p;
	}
}

int* f4B(int n) {	// O(n) time/memory
	return new int[n] {};
}

void f4A(int n) {
	// O(n^2) time & memory
	for (int i = 1; i < n; ++i) {
		int *p = f3B(n);
		// we accumulate memory!
	}
}

void f5(int n) {	// O(n) time/memory
	int p1 = new int[10 * n] {};
	int p2 = new int[20 * n] {};
}


void f6(int n, int m) {	// O(n+m) time/memory
	int p1 = new int[10 * n] {};
	int p2 = new int[20 * m] {};
}

int f7B(int *arr, int n) {
	// O(1) excluding parameters with reference
	int sum = 0;
	for (int i = 0; i < n; ++i)
		sum += arr[i];
	return sum;
}

void f7A(int n) {
	int *x = new int[n];	// O(n) memory
	f7B(x, n);	// O(1) memory
}


int f8B(vector<int> & v, int f) {
	// O(n) time and O(1) memory
	int sum = 0;
	for (int i = 0; i < v.size(); ++i)
		sum += v[i] * f;
	return sum;
}

void f8A(int n) {
	//vector of n numbers: On) memory
	vector<int> v(n, 1);

	// O(n^2) time and O(1) memory
	for (int i = 0; i < n; ++i)
		f8B(v, i);
}


int f9B(vector<int> v, int f) {
	// O(n) time and O(n) memory
	// The vector n items will copied each time!
	int sum = 0;
	for (int i = 0; i < v.size(); ++i)
		sum += v[i] * f;
	return sum;
}

void f9A(int n) {
	//vector of n numbers: On) memory
	vector<int> v(n, 1);

	// O(n^2) time and O(n) memory
	for (int i = 0; i < n; ++i)
		f9B(v, i);
}

int factorial1(int n) {
	// O(n) time and O(1) memory
	int res = 1;
	for (int i = 1; i <= n; ++i)
		res *= i;
	return res;
}

int factorial2(int n) {
	// O(n) time and O(n) memory
	if(n <= 1)
		return 1;

	int subres = factorial2(n-1);
	return n * subres;
}

void f10(int n) {	// O(n^2) memory
	if(n <= 0)
		return;
	int *p = new int[n];	// O(n) memory
	f10(n-1);
	delete[] p;
}

void f11(int n) {	// O(n) memory
	if(n <= 0)
		return;
	int *p = new int[n];	// O(n) memory
	delete[] p;
	f10(n-1);

}






int main() {

	return 0;
}
