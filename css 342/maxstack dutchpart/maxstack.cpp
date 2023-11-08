<<<<<<< HEAD
#include <stack>


using namespace std;

class MaxStack {
public:
    stack<pair<int, int>> s;

    MaxStack() {}

    void push(int x)
    {
        int mx;
        if (s.empty() || x >= max()) {
            mx = x;
        } else {
            mx = max();
        }
        s.push(make_pair(x, mx));
    }

    int pop()
    {
        int e = s.top().first;
        s.pop();
        return e;
    }

    int max() { return s.top().second; }
};

=======
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
>>>>>>> 80ff3ad04ec6cd5438723ce6d3d74ab3fc9e9846
