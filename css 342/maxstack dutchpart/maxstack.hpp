



#pragma once


class Node {
    friend class MaxStack;

private:
    int data;
    Node* next;

public:
    Node(int newData);
    Node(int newData, Node* newNext);
    Node(const Node& other);

};



class MaxStack {

private:
    Node* top;

public:
    void push(int newData);
    int pop();
    int max();
    MaxStack(int data);

};