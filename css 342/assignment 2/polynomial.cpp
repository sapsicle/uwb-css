#include "polynomial.h"
#include <iostream>
#include <vector>


/// @brief Constructor for Polynomial Class, that takes and stores coefficients of a polynomial in a vector in reverse order, 
/// such that the index represents the degree of the corresponding X. 
/// e.g. the Polynomial x^3 + 5x^2 + 4 would be stored in a vector as [4, 0, 5, 1] where 4x^0 is stored in coeffs[0], 0x^1 in coeffs[1], etc.
/// @param c Vector of coefficients to copy into this Polynomial object, expected to be stored in reverse order where ax^0 is stored in c[0] up through nx^m
/// where n is stored in c[m]
Polynomial::Polynomial(const std::vector<double> &c) {
    // copy coefficients into class level vector
    for (auto var : c) {
        coeffs.push_back(var);
    }

    // eliminate headroom so capacity() == size(), no more coefficients will be added to this polynomial
    // comparisons could still be made with size() being a length checker, but this saves memory so boosts efficiency
    coeffs.shrink_to_fit();
}

// no args constructor
// Polynomial::Polynomial() {}

/// @brief Output stream for Polynomial object, produces a proper Polynomial expression from the vector of coefficients
/// @param out Output stream to pass back through
/// @param other Polynomial object to be sent to the output stream
/// @return 
std::ostream &operator<<(std::ostream &out, const Polynomial &other) {
    // looping backwards from last index as coefficient index determines x degree

    for (double i{other.coeffs.size() - 1}; i >= 0; i--) {
        if (other.coeffs[i] != 0) {
            if (i == 0) {
                out << other.coeffs[i];
            } else if (i == 1) {
                out << other.coeffs[i] << "x + ";
            } else {
                out << other.coeffs[i] << "x^" << i << " + ";
            }
        }
    }

    return out;
}

Polynomial Polynomial::operator+(const Polynomial &other) const {
    std::vector<double> outVec;
    for (int i{0}; i < ((this->coeffs.size() > other.coeffs.size()) ? this->coeffs.size() : other.coeffs.size()); i++) {
        // looping through longer of the 2 vectors as to not miss any indices
        if (i > this->coeffs.size()) {
            // if beyond scope of this, we know that this's var is effectively 0 therefore the sum is simply other's var
            outVec[i] = other.coeffs[i]; // technically other.coeffs[i] + 0
        } else if (i > other.coeffs.size()) {
            // same condition but reversed, beyond scope of one (other) means the sum is in effect the other one (this) + 0
            outVec[i] = this->coeffs[i]; // technically this->coeffs[i] + 0
        } else {
            // if within scope for both, the new var at i is simply the sum
            outVec[i] = this->coeffs[i] + other.coeffs[i];
        }
    }

    // clear headroom from vector like in constructor
    outVec.shrink_to_fit();
    // create object with this vector
    Polynomial outPoly(outVec);
    // return it
    return outPoly;
}

Polynomial Polynomial::operator-(const Polynomial &other) const {
    std::vector<double> outVec;
    for (int i{0}; i < ((this->coeffs.size() > other.coeffs.size()) ? this->coeffs.size() : other.coeffs.size()); i++) {
        // looping through longer of the 2 vectors as to not miss any indices
        if (i > this->coeffs.size()) {
            // if out of scope on this, var at index is effectively 0 and we subtract other from it
            outVec[i] = 0 - other.coeffs[i];
        } else if (i > other.coeffs.size()) {
            // if out of scope on other, difference is effectively this
            outVec[i] = this->coeffs[i]; // technically this->coeffs[i] - 0
        } else {
            // if within scope for both, find difference
            outVec[i] = this->coeffs[i] - other.coeffs[i];
        }
    }

    // clearing headroom
    outVec.shrink_to_fit();
    // new object with vector
    Polynomial outPoly(outVec);
    // return it
    return outPoly;
}

Polynomial Polynomial::operator*(const Polynomial &other) const {
    std::vector<double> outVec;
    for (int i{0}; i < this->coeffs.size(); i++) {
        for (int j{0}; j < other.coeffs.size(); j++) {
            
        }
    }
}

bool Polynomial::operator==(const Polynomial &other) const {
    return false;
}

bool Polynomial::operator!=(const Polynomial &other) const {
    return false;
}