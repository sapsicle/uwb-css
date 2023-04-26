#include <iostream>
#include "Stack.hpp"


template <class T>
Stack<T>::Stack(Node<T>& newNode)
{
    this->head = newNode;
}

template <class T>
bool Stack<T>::push(const T& newItem)
{
    Node<T> newNode = new Node(newItem);
    newNode.next = this->head;
    this->head = newNode;
    return true;
}

template <class T>
bool Stack<T>::pop()
{
    Node<T>* tmp = this->head;
    this->head = tmp->next;
    delete tmp;
    tmp = nullptr;
    return true;
}