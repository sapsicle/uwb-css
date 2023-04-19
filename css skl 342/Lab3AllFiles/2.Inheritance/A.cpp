/*
 *  A.cpp
 *  Inheritance Example
 *
 *  Created by Prof. Michael Stiber
 *  Modified by Yang Peng on 01/12/2018
 *
 */

#include "A.h"
#include <iostream>

using namespace std;

A::A()
{
    testDataA2 = 5;
    n = "unnamed A";
    cout << "Inside A::A() for object " << n << endl;
    cout << "testDataA2: " << testDataA2 << endl;
}

A::A(string name) : n(name), testDataA1(6)
{
    cout << "Inside A::A(string) for object " << n << endl;
    cout << "testDataA1: " << testDataA1 << endl;
}

A::A(string name, int data1, int data2) : n(name), testDataA1(data1), testDataA2(data2) {
    cout << "inside A(name and 2 datas)" << endl;
}

A::~A()
{
    cout << "Inside A::~A() for object " << n << endl;
}


void A::setN(const char* s)
{
  n = s;
}

string A::getN(void) const
{
  return n;
}


