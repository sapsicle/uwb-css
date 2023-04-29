//
//

#ifndef ASS3_CREATURE_H
#define ASS3_CREATURE_H

#include "maze.h"
// #include "offset.hpp"
#include <ostream>
#include <fstream>
#include <stack>

class Creature {
public:
    friend ostream &operator<<(ostream &Out, const Creature &Creature);

private:
    // keep track of directions in a stack, makes easy backtracking
    // std::stack<char> runningPath;
    
    // keep track of starting location
    std::pair<int, int> startLoc;
    
    // current location
    std::pair<int, int> currentLoc;

public:
    Creature(int Row, int Col);
    string solve(Maze &Maze);
    bool atExit(const Maze &Maze) const;
    std::string goNorth(Maze &Maze);
    std::string goSouth(Maze &Maze);
    int checkDirections(Maze &Maze);
    std::string goEast(Maze &Maze);
    std::string goWest(Maze &Maze);
};

#endif //ASS3_CREATURE_H