

#include <iostream>
#include <fstream>
#include <stack>
// #include <random>

#include "creature.h"
#include "maze.h"

std::ostream &operator<<(std::ostream &Out, const Creature &Creature) {
    Out << "Creature location: [" << 
           Creature.currentLoc.first << 
           ", " << Creature.currentLoc.second << 
           "]" << endl;
    return Out;
}

/// @brief Constructor with initial coordinates in the maze
/// @param Row 
/// @param Col 
Creature::Creature(int Row, int Col) : 
                   startLoc(Row, Col), currentLoc(startLoc) {}
                   // sample code breaks 80 column limit

/// @brief Checks to see if creature is at the exit
/// @param Maze 
/// @return 
bool Creature::atExit(const Maze &Maze) const {
    // asinine column restrictions require this blasphemic code styling
    return (
        currentLoc == std::make_pair(
            Maze.getExitRow(), Maze.getExitColumn()
        )
    ) ? true : false;
}

/// @brief Solves the maze
/// @param Maze 
/// @return 
std::string Creature::solve(Maze &Maze) {
    string Path = "";

    Maze.markAsPath(currentLoc.first, currentLoc.second);

    // try movement in each direction from start
    // will come back and try a different direction if no exit

    if (Maze.isClear(currentLoc.first + (1), currentLoc.second)) {
        Path += goEast(Maze);
    }
    
    if (Maze.isClear(currentLoc.first, currentLoc.second + (1))) {
        Path += goSouth(Maze);
    }
    
    if (Maze.isClear(currentLoc.first + (-1), currentLoc.second)) {
        Path += goWest(Maze);
    }
    
    if (Maze.isClear(currentLoc.first, currentLoc.second + (-1))) {
        Path += goNorth(Maze);
    }

    if (Path == "") {
        // method assumes movement from starting location
        // if tried all 4 from start then unsolvable and exit
        std::cerr << "Out of paths to try, no solution found" << std::endl;
        exit(0);
    }

    return Path;
}

/// @brief Moves the creature North one tile
/// @param Maze 
std::string Creature::goNorth(Maze &Maze) {
    // update location as 1 tile north
    currentLoc.second += (-1);
    
    // mark tile as path
    Maze.markAsPath(currentLoc.first, currentLoc.second);

    // string path var
    std::string path = "N";

    // if current location is at the exit return an O to signal exit location
    // an empty string would work best here but that's the backtrack signal
    if (
        currentLoc == std::make_pair(Maze.getExitRow(), Maze.getExitColumn())
    ) {return path;}

    // check available directions
    
    int tmp = checkDirections(Maze);
    // if north empty, search
    if (tmp == (-1)) {path += goNorth(Maze);}

    // if north failed and returned empty, retry search
    if (path == "N") {tmp = checkDirections(Maze);}

    // if west is empty, search that
    if (tmp == (-1)) {path += goWest(Maze);}

    // if west failed, retry
    if (path == "N") {tmp = checkDirections(Maze);}

    // if east empty, search
    if (tmp == (1)) {path += goEast(Maze);}
    
    // won't be south since we came from there

    // path will only be N if all directions returned dead-end
    // so return blank for "dead ends from here"
    if (path == "N") {
        // unmark tile
        Maze.markAsVisited(currentLoc.first, currentLoc.second);
        // undo movement
        currentLoc.second -= (-1);
        // return out
        return "";
    } else return path; // return path if exit found from here
}

/// @brief Moves the creature West one tile
/// @param Maze 
std::string Creature::goWest(Maze &Maze) {
    // update location as 1 tile west
    currentLoc.first += (-1);

    // mark tile as path
    Maze.markAsPath(currentLoc.first, currentLoc.second);

    // string path var
    std::string path = "W";

    // if current location is at the exit return an O to signal exit location
    // an empty string would work best here but that's the backtrack signal
    if (
        currentLoc == std::make_pair(Maze.getExitRow(), Maze.getExitColumn())
    ) {return path;}

    // check available directions

    int tmp = checkDirections(Maze);
    // if south empty, search
    if (tmp == (1)) {path += goSouth(Maze);}

    // if south failed and returned empty, retry search
    if (path == "W") {tmp = checkDirections(Maze);}

    // if west is empty, search that
    if (tmp == (-1)) {path += goWest(Maze);}

    // if west failed, retry
    if (path == "W") {tmp = checkDirections(Maze);}

    // if west empty, search
    if (tmp == (-1)) {path += goNorth(Maze);}
    
    // won't be east since we came from there

    // path will only be W if all directions returned dead-end
    // so return blank for "dead ends from here"
    if (path == "W") {
        // unmark tile
        Maze.markAsVisited(currentLoc.first, currentLoc.second);
        // undo movement
        currentLoc.first -= (-1);
        // return out
        return "";
    } else return path; // return path if exit found from here
}

/// @brief Moves the creature East one tile
/// @param Maze 
std::string Creature::goEast(Maze &Maze) {
    // update location as 1 tile west
    currentLoc.first += (1);

    // mark tile as path
    Maze.markAsPath(currentLoc.first, currentLoc.second);

    // string path var
    std::string path = "E";

    // if current location is at the exit return an O to signal exit location
    // an empty string would work best here but that's the backtrack signal
    if (
        currentLoc == std::make_pair(Maze.getExitRow(), Maze.getExitColumn())
    ) {return path;}

    // check available directions

    int tmp = checkDirections(Maze);
    // if south empty, search
    if (tmp == (1)) {path += goSouth(Maze);}

    // if south failed and returned empty, retry search
    if (path == "E") {tmp = checkDirections(Maze);}

    // if north is empty, search that
    if (tmp == (-1)) {path += goNorth(Maze);}

    // if north failed, retry
    if (path == "E") {tmp = checkDirections(Maze);}

    // if east empty, search
    if (tmp == (1)) {path += goEast(Maze);}
    
    // won't be west since we came from there

    // path will only be E if all directions returned dead-end
    // so return blank for "dead ends from here"
    if (path == "E") {
        // unmark tile
        Maze.markAsVisited(currentLoc.first, currentLoc.second);
        // undo movement
        currentLoc.first -= (1);
        // return out
        return "";
    } else return path; // return path if exit found from here
}

/// @brief Moves the creature South one tile
/// @param Maze 
std::string Creature::goSouth(Maze &Maze) {
    // update location as 1 tile north
    currentLoc.second += (1);
    
    // mark tile as path
    Maze.markAsPath(currentLoc.first, currentLoc.second);
    
    // string path var
    std::string path = "S";

    // if current location is at the exit return an O to signal exit location
    // an empty string would work best here but that's the backtrack signal
    if (
        currentLoc == std::make_pair(Maze.getExitRow(), Maze.getExitColumn())
    ) {return path;}

    // check available directions

    int tmp = checkDirections(Maze);
    // if south empty, search
    if (tmp == (1)) {path += goSouth(Maze);}

    // if south failed and returned empty, retry search
    if (path == "S") {tmp = checkDirections(Maze);}

    // if west is empty, search that
    if (tmp == (-1)) {path += goWest(Maze);}

    // if west failed, retry
    if (path == "S") {tmp = checkDirections(Maze);}

    // if east empty, search
    if (tmp == (1)) {path += goEast(Maze);}
    
    // won't be north since we came from there

    // path will only be S if all directions returned dead-end
    // so return blank for "dead ends from here"
    if (path == "S") {
        // unmark tile
        Maze.markAsVisited(currentLoc.first, currentLoc.second);
        // undo movement
        currentLoc.second -= (1);
        // return out
        return "";
    } else return path; // return path if exit found from here
}


int Creature::checkDirections(Maze& Maze) {
    if (Maze.isClear(currentLoc.first, currentLoc.second + (-1))) {
        return (-1);
    }

    if (Maze.isClear(currentLoc.first, currentLoc.second + (1))) {
        return (1);
    }

    if (Maze.isClear(currentLoc.first + (-1), currentLoc.second)) {
        return (-1);
    }

    if (Maze.isClear(currentLoc.first + (1), currentLoc.second)) {
        return (1);
    }

    // dummy return
    return 0;
}