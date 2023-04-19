#include <iostream>
#include "SafeArray.h"

SafeArray::SafeArray(int size) {
    mySize = size;
    myArray = new int[mySize];
}

SafeArray::~SafeArray() {
    delete myArray;
    myArray = nullptr;
}

void SafeArray::setValue(int index, int value) {
    // if out of bounds (beyond last index (index of size or greater) or less than 0)
    if (index >= sizeof(*myArray) || index < 0) throw std::invalid_argument("Bad Index");

    // valid index if not thrown
    myArray[index] = value;
}

int SafeArray::getValue(int index) {
    // throw if out of bounds
    if (index >= sizeof(*myArray) || index < 0) throw std::invalid_argument("Bad Index");

    // valid index if not thrown
    return myArray[index];
}

int SafeArray::getSize() {
    return sizeof(*myArray);
}
