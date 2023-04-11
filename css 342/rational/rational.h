#include <iostream>

using namespace std;

#ifndef RAT_H
#define RAT_H

class Rational {
public:
    Rational &operator+=(const Rational &other) const;
    void reduce();

private:
    static int numerator;
    static int denominator;
    int euclidian(int a, int b);

};


#endif