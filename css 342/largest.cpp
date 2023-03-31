#include <iostream>
using namespace std;

int main() {
    int num, largest = 0;

    cout << "Enter a number to start: " << endl;
    cin >> largest;
    for (int i = 0; i < 5; i++) {
        cout << "Enter another number: " << endl;
        cin >> num;
        
        if (num > largest) {
            largest = num;
            cout << num << endl;
        } else {
            cout << largest << endl;
        }
    }

    return 0;
}