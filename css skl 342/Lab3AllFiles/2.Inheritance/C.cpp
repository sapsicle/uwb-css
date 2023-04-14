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

C::C()
{
  setN("unnamed C");
  cout << "Inside C::C() for object " << getN() << endl;
}

C::C(string name) : B(name)
{
  cout << "Inside C::C(string) for object " << getN() << endl;
}


C::~C()
{
  cout << "Inside C::~C() for object " << getN() << endl;
}


