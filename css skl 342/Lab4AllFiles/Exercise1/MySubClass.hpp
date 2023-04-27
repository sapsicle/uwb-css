#include <iostream>
#include "MyClass.h"


#pragma once


class MySubClass : public MyClass {

private:
    int subClassData;

public:
    // no arg constructor
    MySubClass();

    // copy constructor
    MySubClass(const MySubClass& orig);

    // no arg destructor
    ~MySubClass();
};