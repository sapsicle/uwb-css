#include "LinkList.h"
#include "Node.h"
#include <iostream>

using namespace std;

void LinkList::display(const Node* head) {
    Node* current = head;
    while (current != nullptr) {
        cout << current->item << endl;
        current = current->next;
    }
}
