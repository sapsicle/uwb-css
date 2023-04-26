#include <iostream>
#include "Node.hpp"


template <class T>
Node<T>::Node(const T& newData) {
    this->data = newData;
}