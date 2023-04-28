#include <iostream>
#include <map>
#include <string>

using namespace std;

int main() {

	// Exercise 4.2
	map<string, int> statesM;

	// Exercise 4.3
	statesM.insert(pair<string, int>("Washington", 1889));
	statesM.insert(pair<string, int>("Colorado", 1876));
	statesM.insert(pair<string, int>("Oregon", 1859));
	statesM.insert(pair<string, int>("California", 1850));
	statesM.insert(pair<string, int>("Hawaii", 1959));
	
	// Exercise 4.4
	for (map<string, int>::iterator it = statesM.begin(); it != statesM.end(); it++){
		cout << "Key: " << it->first << " / Value: " << it->second << endl;
	}

	// Exercise 4.5
	pair<map<string, int>::iterator,bool>  retVal1;
	retVal1 = statesM.insert(pair<string, int>("Washington", -1)); 
	// Return value gives you a pair of an iterator and a bool
	// The iterator is pointing to either the element you just inserted, or the element that already has
	// the key you were trying to insert.
	// The bool indicates whether the element was inserted (1), 
	// or skipped because the key already existed (0).
	cout << "The iterator is pointing to: " << endl;
	cout << "   first: " << (retVal1.first)->first << endl;
	cout << "   second: " << (retVal1.first)->second << endl;
	// The bool is false because you did not successfully insert the element.
	cout << "Did I insert something new: " << retVal1.second << endl;

	// Seemingly, nothing happens.  But you can tell that the insert failed if you check the
	// second value returned from insert.

	// Exercise 4.6
	pair<map<string, int>::iterator,bool>  retVal2;
	retVal2 = statesM.insert(pair<string, int>("Alaska", 1959)); 
	// The iterator is pointing to your newly inserted element.
	cout << "The iterator is pointing to: " << endl;
	cout << "   first: " << (retVal2.first)->first << endl;
	cout << "   second: " << (retVal2.first)->second << endl;
	// Now the bool is true.
	cout << "Did I insert something new: " << retVal2.second << endl;

	// Exercise 4.7
	statesM["Washington"] = 2022;
	cout << "Washington's value has been updated to: " << statesM["Washington"] << endl;

	statesM["Utah"] = 1896;
	cout << "Utah's value has been added: " << statesM["Utah"] << endl;
	// Takeaway: using operator[] will add or update the value for the key
	// But since the behavior is the same, you will not know which (add OR update) happened
	// Insert can be safer, if you need to be precise about the behavior

	return 0;
}
