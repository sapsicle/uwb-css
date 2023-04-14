/*
 * SafeArray.h
 *
 * Simple "safe" wrapper around C++ arrays
 * Code to show constructor/destructor and get/set values.
 *
 * Created by Katie Ewing
 */

#pragma once

#include <iostream>

class SafeArray {
public:
  // Constructor that takes the size of the desired array
  SafeArray(int size);

  // Destructor
  ~SafeArray();

  // Overload of the operator<< to print our array.  You do not need to
  // understand how this works.
  friend std::ostream &operator<<(std::ostream &out, const SafeArray &sa) {
    out << "[";

    for (int i = 0; i < sa.mySize; i++) {
      out << sa.myArray[i] << ", ";
    }
    out << "]";
    return out;
  }

  // Set the value in the array at index given.
  // Check if the index is valid. If it is, set the value.  If not, throw an
  // exception.
  void setValue(int index, int value);

  // Get the value in the array at index given.  Check if the index is valid, if
  // not, throw an exception.
  int getValue(int index);

  // Returns the size of the array
  int getSize();

private:
  int mySize;
  int *myArray;
};