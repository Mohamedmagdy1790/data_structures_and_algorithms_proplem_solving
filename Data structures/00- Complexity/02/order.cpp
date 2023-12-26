#include <iostream>
#include <cassert>
using namespace std;

void ConstantOrder1() {
	// O(1)
	int start = 6;
	int end = 100;

	int mid = (end - start) / 2;

	if (mid % 2 == 0)
		--mid;
}

void ConstantOrder2() {
	int start = 7;
	int end = 0;

	for (int i = 0; i < 1000; ++i)
		end += end * 2 + start;
}

void linear1(int n) {	// O(n)
	int sum = 0;
	for (int i = 0; i < n; i++) {
		// All below are O(1)
		int x = 2 + 3 * 4;
		sum += i;
		sum += 2;
		sum += x;
	}
}

void linear2(int n) { // O(n)
	for (int i = 0; i < 10 * n; i++)
		ConstantOrder1();

	for (int i = 0; i < 5 * n; i++)
		ConstantOrder1();

}

void quadratic1(int n) { // O(n^2)
	int cnt = 0;
	for (int i = 0; i < 5 * n; ++i) {
		for (int j = 0; j < 3 * n; ++j) {
			cnt++;
			ConstantOrder1();
		}
	}
}

void quadratic2(int n) { // O(n^2)
	int cnt = 0;
	for (int i = 0; i < 5 * n; ++i) {
		for (int j = 0; j < 3 * n; ++j) {
			cnt++;
			ConstantOrder1();
		}
	}
	for (int i = 0; i < 10 * n; i++)
		ConstantOrder1();
}

void quadratic3(int n) { // O(n^2)
	int cnt = 0;
	for (int i = 0; i < 5 * n; ++i) {
		for (int j = 0; j < 3 * n; ++j) {
			for (int k = 0; k < 1000; ++k) {
				cnt++;
				ConstantOrder1();
			}
		}
	}
	for (int i = 0; i < 10 * n; i++)
		ConstantOrder1();
}

void quadratic4(int n) { // O(n^2)
	for (int i = 0; i < 10 * n; i++)
		ConstantOrder1();

	for (int i = 0; i < 3 * n * n; i++)
		ConstantOrder1();
}

void cubic1(int n) { // O(n^3)
	int cnt = 0;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			for (int k = 0; k < n; ++k) {
				cnt++;
			}
		}
	}
}

void cubic2(int n) { // O(n^3)
	int cnt = 0;
	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j)
			for (int k = 0; k < n; ++k)
				cnt++;

	for (int i = 0; i < 1000 * n; ++i)
		for (int j = 0; j < 1000 * n; ++j)
			cnt++;
}

void f(int n) { // O(n^6)
	int cnt = 0;
	for (int i = 0; i < n * n; ++i)
		for (int j = 0; j < n; ++j)
			for (int k = 0; k < n * n * n; ++k)
				cnt++;

}

void f1(int n) { // O(n^3)
	int cnt = 0;
	for (int i = 0; i < n * n; ++i)
		for (int j = 0; j < n; ++j)
			cnt++;
}

void f2(int n) { // O(n^4)
	for (int i = 0; i < n; ++i)
		f1(i);	// n^3
}

void f3(int n, int m) {		// O(nm)
	int cnt = 0;
	for (int i = 0; i < 2 * n; ++i)
		for (int j = 0; j < 3 * m; ++j)
			cnt++;
}

void f4(int n, int m) {		// O(nm + n^3)
	int cnt = 0;
	for (int i = 0; i < 2 * n; ++i)
		for (int j = 0; j < 3 * m; ++j)
			cnt++;

	for (int i = 0; i < n * n * n; ++i)
		cnt++;
}

int main() {

	return 0;
}
