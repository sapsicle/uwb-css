/*
 *  C.cpp
 *  Inheritance Example
 *
 *  Created by Prof. Michael Stiber
 *  Modified by Yang Peng on 01/12/2018
 *
 */

#include "C.h"
#include <iostream>

using namespace std;

C::C() : B()
{
    testDataC = 2;
    setN("unnamed C");
    cout << "Inside C::C() for object " << getN() << endl;
}

C::C(string name) : B(name), testDataC(1)
{
    cout << "Inside C::C(string) for object " << getN() << endl;
}

C::C(string name, int data1, int data2, int data3, int data4) : B(name, data1, data2, data3), testDataC(data4) {
    cout << "inside C(data)" << endl;
}

C::~C()
    {
    cout << "Inside C::~C() for object " << getN() << endl;
}


