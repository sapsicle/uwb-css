#include <iostream>
#include <cmath>
using namespace std;

int myRoundingFunction(double input) {
    int noDec = (int)input;                                         // cast double to int to remove decimal
    double decimal = input - noDec;                                 // subtract from intial input to isolate decimal value
    if (decimal >= 0) {                                             // if positive value (sign stays from input)
        if (decimal >= 0.5) {
            return noDec + 1;                                       // if .5 or higher, round up to next integer
        } else {
            return noDec;                                           // else round down, input without the decimals
        }
    } else {
        if (decimal <= -0.5) {
            return noDec - 1;                                       // if 0.5 or "above", return "next" int which since negative is int - 1
        } else {
            return noDec;                                           // else round "down", which is up one towards 0, exists as noDec
        }
    }

}

int main() {
    double arr[] = {0.4, 0.6, -0.4, -1.6};                          // add more numbers into array to test, will automatically be tested in loop

    for (double var : arr) {
        cout << "Rounding " << var << " with cmath round: " << round(var) << endl;
        cout << "Rounding " << var << " with myRoundingFunction: " << myRoundingFunction(var) << endl;
        cout << endl;
    }
    
    return 0;
}