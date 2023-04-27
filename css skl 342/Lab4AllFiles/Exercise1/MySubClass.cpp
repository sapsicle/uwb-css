#include <iostream>

#include "MySubClass.hpp"


MySubClass::MySubClass() : subClassData(0), MyClass()
{
    // use parent constructor to initialize other values
}

MySubClass::MySubClass(const MySubClass& orig) : subClassData(orig.subClassData), MyClass(orig)
{
    // use parent constructor to initialize other values
}

MySubClass::~MySubClass()
{

}