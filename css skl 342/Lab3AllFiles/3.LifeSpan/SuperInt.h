/*
 * SuperInt.h
 *
 * This is a class that acts like an int, but outputs various useful
 * stuff. You can add to this to experiment!
 *
 * Created by Michael Stiber
 * Modified by Yang Peng on 01/12/18
 */
#include <string>
#pragma once

class SuperInt {
    // had to overload as print statements in ScopeEtc were erroring with the changes to theValue()
    friend std::ostream &operator<<(std::ostream& out, SuperInt& superint);
 public:
    // Name helps us see which variable
    SuperInt(int init, const char *name);

    ~SuperInt();

    // For demonstrating lvalues
    // int& theValue(void);
    SuperInt& theValue(void);

    // had to write a new getter to access myValue in SuperInt as the updated theValue() cuts off access to SuperInt::myValue from SuperDuperInt
    int getValue(void);

 private:
    int myValue;
    std::string myName;

    // Neat trick: making this private prevents creating unitialized
    // objects
    SuperInt();

};



