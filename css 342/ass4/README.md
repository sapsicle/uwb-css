# assignment4: Skiplist

Goals: Working with dynamic arrays, pointers, doubly linked lists

## Assignment description

Download the starter code from here:

For this assignment, you will write a Skip List data structure to store integers. Skip List allows search, insert and add operations to be completed in O(log n) time. Wikipedia has a good introductory article on Skip List data structure.

A SkipList can have multiple levels. SkipList of level 1 is similar to a linked list. All elements are inserted into a sorted linked list.

The advantage of Skip List comes when it has multiple levels. For a multi-level Skip List, elements are always inserted at level-1. They are also inserted at level-2 with a given probability, at level-3, and so on.

#### 5: ----------------->9
#### 4: ----------------->9
#### 3:--------->5------->9
#### 2:----->3-->5-->7--->9
#### 1:->1-->3-->5-->7--->9

The above picture shows a SkipList with a depth of 5, Level-1 to Level-5

The levels of a SkipList are defined when it is first constructed and cannot be changed
The nodes in SkipList are called SNode. Each SNode contains a value and a vector of SNode* nexts. nexts[0] would hold the pointer to the next SNode* at level-1, nexts[1] would hold the pointer for the next SNode* at level-2 and so on.
A naive implementation of Skip List would result in O(n) times and would wast extra space, so we need a few clever tricks.

When adding a new item, we start the search from the highest level (level-5 in our example) and find the node that would come before the item we are inserting. Once an SNode* is found, we move to one level lower and repeat the process until there are no more levels left. The SNode pointers that are collected during this search are  stored in a vector (the getBeforeNodes function in my implementation). For example, if inserting the value 6 to the above SkipList, the before SNodes would be [headnode, headnode, 5, 5, 5]. 
We can then insert the new item at level-0. We know exactly which node comes before it.
We can then call our random function to decide if it should get inserted at a higher level (using function shouldInsertAtHigherLevel). If we need to insert it at level-1, we can use the SNodes* we have already collected to insert it.
Inserting the new item at multiple levels does not require us to create a new SNode. We just need to extend its nexts vector to correctly point at the next item at each level.
The process stops either when shouldInsertAtHigherLevel returns false or when we have inserted the item at the highest level possible and there are no more levels left.
For the above example, we'd insert 6 at level-1 to follow the SNode 5. Next, assuming shouldInsertAtHigherLevel returns true, we'd increase SNode 6's forward and backward pointers and connect it at level-2 after SNode 5 and before SNode 7. If shouldInsertAtHigherLevel returns true again, we'd once again increase SNode 6's forward and backward pointers and connect it at level-3 after SNode 5 and before SNode 9.
Finding an item works in a similar way.

If we searched at level-1, it would be O(n) time, so to speed up search, we start at the highest level.
If we are searching for 6, we'd move forward looking for the SNode that would be before 6 at level-5.  In this case, that would be the head node.
We'd then move one level down, to level-4, and continue the search from the node we have already found. At level-4, the node that would come before 6 is still the head node.
Moving to level-3, we'd continue searching forward and find SNode 5 as the node that must be before 6
If we find a node with value 6 at any of the level, we can return true. Otherwise, we need to keep going down all the levels until level-0 to check if the item is in the SkipList.
You must implement the public SkipList functions add, remove, contains, constructor, destructor and the operator<< function. You can delete any private functions you are not using and add any other private functions as needed.
