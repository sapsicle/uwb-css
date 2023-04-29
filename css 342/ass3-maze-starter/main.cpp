#include <iostream>

#include "creature.h"
#include "maze.h"

/// @brief Runs program tests
void test() {
    Maze M("maze.txt");
    // cout << m << endl;
    Creature C(4, 4);
    std::cout << "Path: " << C.solve(M) << endl;
    std::cout << M << endl;
}

/// @brief Main method
/// @return 
int main() {
    test();
    std::cout << "Done!" << std::endl;
    return 0;
}