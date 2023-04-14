#ifndef POLYNOMIAL_H
#define POLYNOMIAL_H

#include <vector>
#include <iostream>

class Polynomial {

friend std::ostream &operator<<(std::ostream &out, const Polynomial& other);
private:
    std::vector<double> coeffs;  // coefficients of the polynomial
    
public:
    // constructor that takes a vector of coefficients
    Polynomial(const std::vector<double>& c);

    // no-args constructor 
    // Polynomial();

    // addition operator
    Polynomial operator+(const Polynomial& other) const;
    
    // subtraction operator
    Polynomial operator-(const Polynomial& other) const;
    
    // multiplication operator
    Polynomial operator*(const Polynomial& other) const;
    
  // check equality
  bool operator==(const Polynomial& other) const;

  // check if not equal
  bool operator!=(const Polynomial& other) const;
    // print function
   
};

#endif