#include "maxstack.hpp"

Node::Node(int newData)
{
    data = newData;
    next = nullptr;
}

Node::Node(int newData, Node *newNext)
{
    data = newData;
    next = newNext;
}

void MaxStack::push(int newData)
{
    Node* tmp = new Node(newData, top);
    top = tmp;
}

int MaxStack::pop()
{
    Node* tmp = top;
    top = top->next;
    int val = tmp->data;
    
    delete tmp;
    tmp = nullptr;

    return val;
}

int MaxStack::max()
{
    MaxStack tmp;


}

MaxStack::MaxStack(int data)
{
    top = new Node(data);
}
