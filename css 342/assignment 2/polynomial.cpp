#include "polynomial.h"
#include <iostream>
#include <vector>


/// @brief Constructor for Polynomial Class, that takes and stores coefficients of a polynomial in a vector in reverse order, 
/// such that the index represents the degree of the corresponding X. 
/// e.g. the Polynomial x^3 + 5x^2 + 4 would be stored in a vector as [4, 0, 5, 1] where 4x^0 is stored in coeffs[0], 0x^1 in coeffs[1], etc.
/// This assumes that the polynomial is sorted in power order, where you do not have c + bx + ax^2, but rather ax^2 + bx + c. 
/// @param c Vector of coefficients to copy into this Polynomial object, expected to be stored in reverse order where ax^0 is stored in c[0] up through nx^m
/// where n is stored in c[m]
Polynomial::Polynomial(const std::vector<double> &c) {
    coeffs.resize(c.size());
    // copy coefficients into class level vector
    for (double var : c) {
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
    for (int i = other.coeffs.size() - 1; i >= 0; i--) {
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

/// @brief Adds two Polynomials together
/// @param other Polynomial to sum with calling Polynomial
/// @return New Polynomial sum
Polynomial Polynomial::operator+(const Polynomial &other) const {
    std::vector<double> outVec;
    outVec.resize((this->coeffs.size() > other.coeffs.size()) ? this->coeffs.size() : other.coeffs.size());
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

    // clear any headroom from vector like in constructor
    outVec.shrink_to_fit();
    // create object with this vector
    Polynomial outPoly(outVec);
    // return it
    return outPoly;
}

/// @brief Subtracts two Polynomials
/// @param other Polynomial to subtract from calling Polynomial
/// @return New Polynomial difference
Polynomial Polynomial::operator-(const Polynomial &other) const {
    std::vector<double> outVec;
    outVec.resize((this->coeffs.size() > other.coeffs.size()) ? this->coeffs.size() : other.coeffs.size());
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

    // clearing any headroom
    outVec.shrink_to_fit();
    // new object with vector
    Polynomial outPoly(outVec);
    // return it
    return outPoly;
}

/// @brief Multiplies two Polynomials together
/// @param other Polynomial to multiply with calling Polynomial
/// @return New Polynomial product
Polynomial Polynomial::operator*(const Polynomial &other) const {
    std::vector<double> outVec((this->coeffs.size() + other.coeffs.size()) - 2, 0);
    // failsafe condition in case new power sum exceeds length
    // if ((this->coeffs.size() + other.coeffs.size()) > outVec.size()) outVec.resize((this->coeffs.size() + other.coeffs.size()), 0);
    for (int i{0}; i < this->coeffs.size(); i++) {
        for (int j{0}; j < other.coeffs.size(); j++) {
            // multiply each term together, adding the powers together
            // each new term produced has a coefficient of the products with a power of sums
            // store new coeffs in the new power index, adding them in as there will be multiple like-terms to combine
            outVec[i + j] += this->coeffs[i] * other.coeffs[j];
        }
    }

    // clear headroom
    outVec.shrink_to_fit();
    // new polynomial from vector
    Polynomial outPoly(outVec);
    // return it
    return outPoly;
}

/// @brief Checks for equality between two Polynomials
/// @param other Polynomial to compare against
/// @return Boolean for equality
bool Polynomial::operator==(const Polynomial &other) const {
    // not equal if not same length
    if (this->coeffs.size() != other.coeffs.size()) return false;

    for (int i{0}; i < this->coeffs.size(); i++) {
        // return false if mismatch found
        if (this->coeffs[i] != other.coeffs[i]) return false;
    }

    // if all coefficients were equal at corresponding powers
    return true;
}

/// @brief Checks for inequality between two Polynomials
/// @param other Polynomial to compare against
/// @return Boolean for equality
bool Polynomial::operator!=(const Polynomial &other) const {
    return !(*this == other);
}

/// @brief Adds a Polynomial into calling Polynomial
/// @param other Polynomial to add in
/// @return Incremented Polynomial
Polynomial Polynomial::operator+=(const Polynomial &other) {
    if (other.coeffs.size() > this->coeffs.size()) this->coeffs.resize(other.coeffs.size(), 0);
    *this = *this + other;
    this->coeffs.shrink_to_fit();
    return *this;
}

/// @brief Subtracts a Polynomial from calling Polynomial
/// @param other Polynomial to subtract out
/// @return Decremented Polynomial
Polynomial Polynomial::operator-=(const Polynomial &other) {
    if (other.coeffs.size() > this->coeffs.size()) this->coeffs.resize(other.coeffs.size(), 0);
    *this = *this - other;
    this->coeffs.shrink_to_fit();
    return *this;
}

/// @brief Multiplies a Polynomial into calling Polynomial
/// @param other Polynomial to multiply in
/// @return Product Polynomial in calling Polynomial
Polynomial Polynomial::operator*=(const Polynomial &other) {
    if (other.coeffs.size() > this->coeffs.size()) this->coeffs.resize(other.coeffs.size(), 0);
    *this = *this * other;
    this->coeffs.shrink_to_fit();
    return *this;
}

/// @brief Greater than operator for Polynomial
/// @param other Polynomial to compare against
/// @return Boolean value, true if calling Polynomial greater than Other, false if lesser
bool Polynomial::operator>(const Polynomial &other) const {
    for (int i = std::max(this->coeffs.size() - 1, other.coeffs.size() - 1); i >= 0; i--) {
        // if within scope for either poly, use coefficient as normal
        // if out of scope, default the coefficient to 0
        double this_coef = (i < this->coeffs.size() ? this->coeffs[i] : 0);
        double other_coef = (i < other.coeffs.size() ? other.coeffs[i] : 0);

        // if at any point a coefficient is greater at a given power, one is greater than the other and thus we return accordingly
        if (this_coef > other_coef) {
            return true;
        } else if (this_coef < other_coef) {
            return false;
        }
        // if coefficients are equal, do nothing and check the next term
    }

    // if all coefficients are equal, the polynomials are equal and thus one is not greater than the other
    return false;
}

/// @brief Lesser than operator for Polynomial
/// @param other Polynomial to compare against
/// @return Boolean value, true if calling Polynomial lesser than Other, false if greater
bool Polynomial::operator<(const Polynomial &other) const {
    for (int i = std::max(this->coeffs.size() - 1, other.coeffs.size() - 1); i >= 0; i--) {
        // if within scope for either poly, use coefficient as normal
        // if out of scope, default the coefficient to 0
        double this_coef = (i < this->coeffs.size() ? this->coeffs[i] : 0);
        double other_coef = (i < other.coeffs.size() ? other.coeffs[i] : 0);

        // if at any point a coefficient is greater at a given power, one is greater than the other and thus we return accordingly
        if (this_coef < other_coef) {
            return true;
        } else if (this_coef > other_coef) {
            return false;
        }
        // if coefficients are equal, do nothing and check the next term
    }

    // if all coefficients are equal, the polynomials are equal and thus one is not greater than the other
    return false;
}

/// @brief Greater than or equals operator for Polynomial
/// @param other Polynomial to compare against
/// @return Boolean value, true if calling Polynomial greater than or equal to Other, false if lesser than
bool Polynomial::operator>=(const Polynomial &other) const {
    return (*this > other || *this == other);
}

/// @brief Lesser than or equals operator for Polynomial
/// @param other Polynomial to compare against
/// @return Boolean value, true if calling Polynomial lesser than or equal to Other, false if greater than
bool Polynomial::operator<=(const Polynomial &other) const {
    return (*this < other || *this == other);
}