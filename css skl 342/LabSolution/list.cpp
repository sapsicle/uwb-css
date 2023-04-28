#include <iostream>
#include <list>
#include <string>

using namespace std;

bool is_odd(const int& value) {return (value % 2) == 1; }

int main() {

	// Exercise 3.2
    list<int> a;         						// empty int list

	// Exercise 3.3
	a.push_back(11);
	a.push_back(13);
	a.push_back(15);
	a.push_back(17);
	a.push_back(19);

	// Exercise 3.4
	a.push_front(12);
	a.push_front(14);
	a.push_front(16);
	a.push_front(18);
	a.push_front(20);

	// Exercise 3.5
	cout << "first: " << a.front() << endl;
	cout << "last: " << a.back() << endl;

	// Exercise 3.6
	a.remove(13);

	// Exercise 3.7
	a.sort();

	// Exercise 3.8
	cout << "sorted list: " << endl;
	for (list<int>::iterator it = a.begin(); it != a.end(); ++it) {
		cout << *it << " ";
	}
	cout << endl;

	// Exercise 3.9
	a.remove_if(is_odd);

	cout << "after removing odd values: " << endl;
	for (list<int>::iterator it = a.begin(); it != a.end(); ++it) {
		cout << *it << " ";
	}
	cout << endl;

	return 0;
}