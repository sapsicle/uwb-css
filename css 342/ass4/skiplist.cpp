/*
skiplist.cpp
This code file is implementing a data structure known as a "skip list". A skip list 
is a probabilistic data structure that allows for efficient search, insertion, and 
removal operations. It is an alternative to balanced trees and binary search trees 
which can be complex to implement.

The basic idea of a skip list is to create a linked list that has multiple levels, 
where each level is a subset of the level below it.

The implementation provided here contains two classes: SNode and SkipList.

@author Neha Nehru & Andrew Coop
@version 15th May 2023

*/
#include "skiplist.h"
#include "random.h"
#include <cassert>
#include <climits>
#include <cstdlib>
#include <iostream>
#include <unordered_map>

using namespace std;

/*
This is the constructor for the SNode class. It is used to create a new node in a 
Skip List. 

The constructor takes an integer value val as input. This value will be stored in 
the node. The val(val) part of the constructor initialization list assigns the input 
val to the val member variable of the SNode class.

The next and prev member variables, which are a vector of pointers to SNode objects,
are initialized to contain a single element, a nullptr.

*/
SNode::SNode(int val) : val(val) {
    // Initialize next and prev as empty vectors
    next = vector<SNode*>(1, nullptr);
    prev = vector<SNode*>(1, nullptr);
}

/*
This is the copy constructor for the SNode class. It is used to create a new SNode 
object as a copy of an existing SNode object.

The constructor takes a constant reference to an SNode object other as input. 
The val(other.val) part of the constructor initialization list assigns the value 
(val) of the other node to the val member variable of the new SNode object.

The next and prev member variables of the new SNode object are set to the next member
variable of the other node. 

*/
SNode::SNode(const SNode &other) : val(other.val) {
    // Copy next and prev from the other node
    next = other.next;
    prev = other.prev;
}

/*
This function is a part of the SkipList class. It is used to determine whether a 
new node should be inserted at a higher level in the skip list structure.

It multiplies the probability member of the SkipList class by 100. This probability 
is a value between 0 and 1 that determines the chance a node will be inserted at a 
higher level.
It then generates a random number between 0 and 99 using the Random::random() % 100
function call.
Finally, it checks if the result of the multiplication is greater than or equal to 
the generated random number. If it is, the function returns true, indicating that a 
new node should be inserted at a higher level. If it's not, it returns false, 
indicating that the new node should be inserted at the current level.

*/
bool SkipList::shouldInsertAtHigherLevel() const {
    return probability * 100 >= Random::random() % 100;
}

/*
This is the overloaded << operator function for the SkipList class. 

The function signature takes a reference to an ostream object (out) and a constant 
reference to a SkipList object (skip).
*/
ostream &operator<<(ostream &out, const SkipList &skip)
{
    if (skip.isEmpty()) {
        out << "List is empty" << endl;
        return out;
    }

    //If the skip list is not empty, it iterates through each level of the skip list, 
    //from highest to lowest
    for (int i = skip.levels - 1; i >= 0; i--) {
        SNode* tmp = skip.head->next[i];
        out << "[level: " << i + 1 << "] ";

        //For each level, it outputs the level number and then iterates through each 
        //node at that level, outputting each node's value.
        while (tmp != nullptr) {
            out << tmp->val << "-->";
            tmp = tmp->next[i];
        }

        out << "nullptr\n";
    }

    return out;
}

/*
This function, is a member of the SkipList class. It returns a vector of pointers to 
SNode objects that come before a certain value (val) at each level of the skip list.

It initializes a vector beforeNodes. It then iterates through each level of the skip 
list. At each level, it traverses through the nodes while the next node exists and 
its value is less than val. The current node is then stored in beforeNodes.

It returns beforeNodes.

*/
vector<SNode*> SkipList::getBeforeNodes(int val) const {
    cout << "getNodes 0" << endl;
    vector<SNode*> beforeNodes(levels, nullptr);
    cout << "getNodes 1" << endl;
    SNode* curr = head;

    for (int i = levels - 1; i >= 0; i--) {
        cout << "getNodes 2" << endl;
         vector<SNode *> nextLevel = curr->next;
        if( nextLevel[i] == nullptr){
            cout << "empyty" << endl;
        }
        else{
            cout << "not empty" <<endl;
        }
        //get current vector 
       

        while (curr->next[i]!= nullptr && curr->next[i]->val < val) {
            cout << "getNodes 33" << endl;
            curr = curr->next[i];
            cout << "getNodes 3" << endl;
        }
        beforeNodes[i] = curr;
        cout << "getNodes 4" << endl;
    }

    
    return beforeNodes;
}

/*
This function, is a member function of the SkipList class. Its purpose is to check 
whether the skip list is empty.

It checks if the head of the skip list is nullptr.

If the head is not nullptr, so it returns false.
*/
bool SkipList::isEmpty() const
{
    return (head->next[0] == nullptr);
}



/*
This function, is the constructor of the SkipList class. It is used to initialize a 
new instance of a skip list with a given number of levels and a given probability.

This constructor allows the creation of a new, empty skip list with a specified number
 of levels and a specific probability for the level selection when inserting new nodes.
*/
SkipList::SkipList(int levels, int probability) : levels(levels), probability(probability) {
    head = new SNode(INT_MIN);  // initialize head node with minimum integer value
    head->next = vector<SNode*>(levels, nullptr);  // initialize next vector with 'levels' number of nullptr
    head->prev = vector<SNode*>(levels, nullptr);  // initialize prev vector with 'levels' number of nullptr
}

/*
This function, is the copy constructor of the SkipList class. It is used to initialize
a new instance of a skip list as a copy of an existing instance.

This copy constructor ensures a deep copy of the other skip list.

*/
SkipList::SkipList(const SkipList &other) : levels(other.levels), probability(other.probability) {
    head = new SNode(*other.head);
    unordered_map<const SNode*, SNode*> nodeMap;

    // Create a mapping between the original nodes and new nodes
    SNode* curr = head;
    const SNode* otherCurr = other.head;
    nodeMap[otherCurr] = curr;

    while (otherCurr->next[0] != nullptr) {
        curr->next[0] = new SNode(*otherCurr->next[0]);
        curr = curr->next[0];
        otherCurr = otherCurr->next[0];
        nodeMap[otherCurr] = curr;
    }

    // Update the next and prev pointers using the mapping
    curr = head;
    otherCurr = other.head;
    while (otherCurr->next[0] != nullptr) {
        for (int i = 0; i <= levels; i++) {
            if (otherCurr->next[i] != nullptr) {
                curr->next[i] = nodeMap[otherCurr->next[i]];
                curr->prev[i] = (otherCurr->prev[i] != nullptr) ? nodeMap[otherCurr->prev[i]] : nullptr;
            }
        }
        curr = curr->next[0];
        otherCurr = otherCurr->next[0];
    }
}

/*
This function, is the destructor of the SkipList class. It's called when an object of 
the SkipList class goes out of scope or is explicitly deleted.

By iterating over each node in the skip list and deleting it, this destructor ensures
that all memory allocated for the skip list is properly released when the skip list 
is no longer needed.

*/
SkipList::~SkipList() {
    SNode* curr = head;
    while (curr != nullptr) {
        SNode* nextNode = curr->next[0];
        delete curr;
        curr = nextNode;
    }
}

/*
This function, is used to add a new node with a given value into the skip list. 

*/
void SkipList::add(int val) {
    // This line calls the `getBeforeNodes(val)` function, which returns a vector 
    //of pointers to nodes that should be updated to insert the new node.
    vector<SNode*> prevNodes = getBeforeNodes(val);

    //The following `if` statement checks if the next node is either nonexistent or 
    //its value is not equal to the new node's value.
    if (prevNodes[0]->next[0] == nullptr || prevNodes[0]->next[0]->val != val) {
        //This line creates a new node with the given value.
        SNode* newNode = new SNode(val);
        int newNodeLevels = 1;

        //The following `while` loop determines the number of levels this new node
        // will have in the skip list. 
        while (shouldInsertAtHigherLevel() && newNodeLevels < levels) {
            newNodeLevels++;
        }
        //Resize the `next` and `prev` vectors of the new node to the decided level.
        newNode->next.resize(newNodeLevels, nullptr);
        newNode->prev.resize(newNodeLevels, nullptr);

        //The next `for` loop is used to insert the new node at the appropriate places
        //in the skip list.
        for (int i = 0; i < newNodeLevels; i++) {
            if (i >= prevNodes.size()) {
                head->next.push_back(newNode);
                newNode->prev[i] = head;
                prevNodes.push_back(head);
            } else {
                newNode->next[i] = prevNodes[i]->next[i];
                if (prevNodes[i]->next[i] != nullptr) {
                    prevNodes[i]->next[i]->prev[i] = newNode;
                }
                prevNodes[i]->next[i] = newNode;
                newNode->prev[i] = prevNodes[i];
            }
        }
    }
}



/*
This function, is an overload of the `add(int val)` function that allows multiple 
values to be added to the skip list at once.

It accepts a vector of integers as an argument and adds each value in the vector to 
the skip list.

*/
void SkipList::add(const vector<int>& values) {
    for (int val : values) {
        add(val);
    }
}

/*

This function, is used to remove a value from the skip list.

*/
bool SkipList::remove(int val) {
    vector<SNode*> prevNodes = getBeforeNodes(val);
    if (prevNodes[0]->next[0] == nullptr || prevNodes[0]->next[0]->val != val) {
        // Value not found in the list
        return false;
    } else {
        SNode* nodeToRemove = prevNodes[0]->next[0];
        int nodeLevels = nodeToRemove->next.size();

        // Update the next and prev pointers to bypass the node to be removed
        for (int i = 0; i < nodeLevels; i++) {
            if (nodeToRemove->next[i] != nullptr) {
                nodeToRemove->next[i]->prev[i] = prevNodes[i];
            }
            prevNodes[i]->next[i] = nodeToRemove->next[i];
        }

        // Delete the node
        delete nodeToRemove;

        // Check if the levels need to be adjusted
        if (levels > 1) {
            // Check if the highest level is empty
            if (head->next[levels - 1] == nullptr) {
                // Decrease the levels if the highest level is empty
                while (levels > 1 && head->next[levels - 1] == nullptr) {
                    levels--;
                }
            }
        }

        return true;
    }
}

/*

This function,is used to check if a given value is present in the skip list.

*/
bool SkipList::contains(int val) const {
    SNode* curr = head;

    // Traverse the list horizontally on the bottom level
    while (curr->next[0] != nullptr && curr->next[0]->val < val) {
        curr = curr->next[0];
    }

    // Check if the value is found
    if (curr->next[0] != nullptr && curr->next[0]->val == val) {
        return true;
    } else {
        return false;
    }
}


