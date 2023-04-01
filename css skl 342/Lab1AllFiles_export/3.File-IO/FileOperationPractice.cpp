#include <iostream>
#include <fstream>
using namespace std;

int main() {
    ifstream inFile;
    inFile.open("textfile3.txt");

    int foo;
    for (int i{0}; i < 100; i++) {
        if (inFile.peek() != EOF) {
            inFile >> foo;
            cout << foo << endl;
        } else {
            break;
        }
    }

    inFile.close();

    return 0;
}