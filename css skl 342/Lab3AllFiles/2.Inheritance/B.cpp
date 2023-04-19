/*
 *  B.cpp
 *  Inheritance Example
 *
 *  Created by Prof. Michael Stiber
 *  Modified by Yang Peng on 01/12/2018
 *
 */

#include "B.h"
#include <iostream>

using namespace std;

B::B() : A()
{
    testDataB = 3;
    setN("unnamed B");
    cout << "Inside B::B() for object " << getN() << endl;
}

B::B(string name) : A(name), testDataB(4)
{
    cout << "Inside B::B(string) for object " << getN() << endl;
}

B::B(string name, int data1, int data2, int data3) : A(name, data1, data2), testDataB(data3) {
    cout << "in B(name and 3 datas)" << endl;
}

B::~B()
{
    cout << "Inside B::~B() for object " << getN() << endl;
}

