#include <iostream>


#pragma once

template <class T>
struct Node {
    friend class Stack;
private:
    T data;
    Node<T>* next;
    // Node<T>* previous;
public:
    Node(const T& newData);
};