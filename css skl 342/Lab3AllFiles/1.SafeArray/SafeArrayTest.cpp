#include <iostream>
#include "SafeArray.h"

using namespace std;

int main() {
    int size = 10;
    SafeArray myA = SafeArray(size);
    cout << "myA after initializing : "  << myA << endl;

    /*  Uncomment and expand when your setter & getter work
    
    for (int i = 0; i < size; i++){
        myA.setValue(i, i*2);
    }
    cout << "myA after setting: "  << myA << endl;

    try {
        myA.setValue(-100, 5);
    }
    catch (const std::exception &e) {
        cout << "Caught exception: " << e.what() << "! Continuing..." << endl;
    }
    */
};