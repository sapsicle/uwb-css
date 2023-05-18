#include "node.hpp"

Node* mergeTwoLists(Node* l1, Node* l2) {
    Node* next1 = l1->next;
    Node* next2 = l2->next;

    if (l1 == nullptr) return l2;
    if (l2 == nullptr) return l1;

    if (l1->data <= l2->data) {
        l1->next = mergeTwoLists(next1, l2);
        return l1;
    } else {
        l2->next = mergeTwoLists(l1, next2);
        return l2;
    }
}