

#include<iostream>
#include<vector>
#include<stack>
#include<queue>
using namespace std;

void play(vector<int> &v) {
}

void test_vector() {
	vector<int> v1;

	v1.push_back(30);
	v1.push_back(10);
	v1.push_back(20);
	// Now we have 3 elements only

	for (int i = 0; i < (int) v1.size(); ++i) {
		cout << v1[i] << " ";	// 30 10 20
	}
	cout << "\n";

	// vector of 3 strings
	vector<string> str_vec { "mostafa", "ali", "me" };
	// We can make nested vectors similar to 2D/3D arrays
}

void test_stack() {
	stack<string> s;
	s.push("ibrahim");
	s.push("saad");
	s.push("mostafa");

	while (!s.empty()) {
		cout << s.top() << " ";
		s.pop();
	}
	cout << "\n";
	// mostafa saad ibrahim
}

void test_queue() {
	queue<int> q;
	q.push(10);
	q.push(20);
	q.push(30);

	cout << "Last element in Queue: " << q.back() << "\n";

	cout << "Queue elements: ";
	while (!q.empty()) {
		cout << q.front() << " ";
		q.pop();
	}
	cout << "\n";

	queue<string> q_names;
	q_names.push("mostafa");
	string name = q_names.front();
}

void test_pairs() {
	pair<int, string> p1 = make_pair(10, "ali");

	cout << p1.first << " " << p1.second << "\n";	// 10 ali
	p1.first += 3;

	pair<float, pair<int, string>> p2 = make_pair(20.5, p1);
	cout << p2.second.first << "\n";	// 13
	p1 = p2.second;

	vector<pair<int, string>> v1;
	v1.push_back(p1);
}

int main() {
	test_pairs();
	return 0;
}

