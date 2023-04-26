#include <iostream>
#include "Node.hpp"


#pragma once

template <class T>
class Stack {
private:
    Node<T>* head;
public:
    Stack(Node<T>& newNode);

    bool push(const T& newItem);
    bool pop();

};