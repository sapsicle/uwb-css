#include <iostream>
#include <stdexcept>
#include "SafeArray.h"

SafeArray::SafeArray(int size) : mySize(size) {
    myArray = new int[mySize];
    for (int i{0}; i < size; i++) myArray[i] = i;
}

SafeArray::~SafeArray() {
    delete myArray;
    myArray = nullptr;
}

void SafeArray::setValue(int index, int value) {
    // if out of bounds (beyond last index (index of size or greater) or less than 0)
    if (index >= SafeArray::getSize() || index < 0) throw std::invalid_argument("Bad Index: setValue()");

    // valid index if not thrown
    myArray[index] = value;
}

int SafeArray::getValue(int index) {
    // throw if out of bounds
    if (index >= SafeArray::getSize() || index < 0) throw std::invalid_argument("Bad Index: getValue()");

    // valid index if not thrown
    return myArray[index];
}

int SafeArray::getSize() {
    return mySize;
}
