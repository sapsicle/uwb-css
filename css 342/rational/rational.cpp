#include "rational.h"


Rational &Rational::operator+=(const Rational &other) const {

}

void Rational::reduce() {
    int gcd = euclidian(numerator, denominator);
}

int Rational::euclidian(int a, int b) {
    int r{0}, gcd{1};

    if (a < b) {
        int temp = a;
        a = b;
        b = temp;
    }

    do {
        r = a % b;
        a = b;
        b = r;
    } while (r != 0);

    gcd = a;
    return gcd;
}
