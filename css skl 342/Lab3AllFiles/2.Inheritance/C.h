/*
 *  C.h
 *  Inheritance Example
 *
 *  Created by Prof. Michael Stiber
 *  Modified by Yang Peng on 01/12/2018
 *
 */

#ifndef C_H
#define C_H
#include "B.h"

class C : public B
{
public:
    C();
    C(string name);
    C(string name, int data1, int data2, int data3, int data4);
    ~C();

private:
    float testDataC;

};

#endif
