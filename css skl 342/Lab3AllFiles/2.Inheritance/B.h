/*
 *  B.h
 *  Inheritance Example
 *
 *  Created by Prof. Michael Stiber
 *  Modified by Yang Peng on 01/12/2018
 *
 */

#pragma once
#include "A.h"

class B : public A
{
public:
    B();
    B(string name);
    B(string name, int data1, int data2, int data3);
    ~B();

private:
    int testDataB;

};
