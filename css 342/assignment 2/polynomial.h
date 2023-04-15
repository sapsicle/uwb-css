#ifndef POLYNOMIAL_H
#define POLYNOMIAL_H
// #pragma once

#include <vector>
#include <iostream>

class Polynomial {
friend std::ostream &operator<<(std::ostream &out, const Polynomial& other);

private:
    std::vector<double> coeffs;

public:
    // default constructor
    Polynomial(const std::vector<double>& c);

    // standard mathematic operators
    Polynomial operator+(const Polynomial& other) const;
    
    Polynomial operator-(const Polynomial& other) const;
    
    Polynomial operator*(const Polynomial& other) const;
    
    // equality comparison operators
    bool operator==(const Polynomial& other) const;

    bool operator!=(const Polynomial& other) const;

    // standard mathematic incrementation/decrementation operators
    Polynomial operator+=(const Polynomial& other);

    Polynomial operator-=(const Polynomial& other);

    Polynomial operator*=(const Polynomial& other);

    // inequality comparison operators
    bool operator>(const Polynomial& other) const;
    
    bool operator<(const Polynomial& other) const;

    bool operator>=(const Polynomial& other) const;

    bool operator<=(const Polynomial& other) const;
};

#endif