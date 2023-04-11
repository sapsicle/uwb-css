#include <string>

#ifndef _NODE
#define _NODE

using namespace std;

// template<class ItemType>
class Node {
    friend LinkList;
private:
    
    string item;
    Node* next;
public:

};

#endif