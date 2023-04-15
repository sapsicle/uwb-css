#include <iostream>
#include <cassert>
#include "polynomial.h"

using namespace std;

int main() {
    cout << endl << "+==+ Running Tests +==+" << endl;

    Polynomial p1({1, 2, 3});   // x^2 + 2x + 3
    Polynomial p2({4, 5, 6});   // 4x^2 + 5x + 6

    Polynomial p3 = p1 + p2;

    Polynomial p4 = p1 * p2;    // (x^2 + 2x + 3) * (4x^2 + 5x + 6)
    cout << p3 << endl;         // output: 4x^4 + 13x^3 + 28x^2 + 27x + 18

    cout << (p1 + p2) << endl;
    cout << (p1 - p2) << endl;
    cout << (p1 * p2) << endl;
    cout << (p1 += p2) << endl;
    cout << (p1 -= p2) << endl;
    cout << (p1 *= p2) << endl;
    cout << (p1 == p2) << endl;
    cout << (p1 != p2) << endl;
    cout << (p1 > p2) << endl;
    cout << (p1 < p2) << endl;
    cout << (p1 >= p2) << endl;
    cout << (p1 <= p2) << endl;

    cout << "+==+ End Tests +==+" << endl;

    return 0;
}