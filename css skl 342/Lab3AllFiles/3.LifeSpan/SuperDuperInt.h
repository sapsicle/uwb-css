#include <iostream>
#include "SuperInt.h"
#include <string>

#pragma once


class SuperDuperInt : public SuperInt {

private:
    int myValue2;
    std::string myName2;

public:
    SuperDuperInt(int value, const char *name);
    int theValue();

};