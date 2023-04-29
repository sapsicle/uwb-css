//
//

#include <fstream>
#include <iostream>
#include "maze.h"
#include <string>

using namespace std;

ostream &operator<<(ostream &Out, const Maze &Maze) {
    for (int Row = 0; Row < Maze.Height; ++Row) {
        for (int Col = 0; Col < Maze.Width; ++Col) {
        Out << Maze.Field[Row][Col];
        }
        Out << endl;
    }
    Out << endl;
    return Out;
}

// For Clion, need the following line in CMakeLists.txt so maze.txt is found
// at the same location as the cpp files
// # need to load data files from current directory as cpp files
// set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

/// @brief Pulls the maze into the program in a 2D array
/// @param FileName 
Maze::Maze(const string &FileName) {
    ifstream InFile;
    InFile.open(FileName);
    if (!InFile) {
        cout << "Unable to open file";
        exit(1); // terminate with error
    }
    InFile >> Width >> Height;
    InFile >> ExitRow >> ExitColumn;
    string Str;
    getline(InFile, Str);
    for (int Row = 0; Row < Height; Row++) {
        for (int Col = 0; Col < Width; Col++) {
        InFile.get(Field[Row][Col]);
        // std::cout << Row << ", " << Col << ": " << Field[Row][Col] << endl;
        }
        getline(InFile, Str);
    }

    std::cout << *this << endl;
}

/// @brief Returns the row coordinate of the exit
/// @return 
int Maze::getExitRow() const {
    return ExitRow;
}

/// @brief Returns the column coordinate of the exit
/// @return 
int Maze::getExitColumn() const {
    return ExitColumn;
}

/// @brief Returns the width of the maze
/// @return 
int Maze::getWidth() const
{
    return Width;
}

/// @brief Returns the height of the maze
/// @return 
int Maze::getHeight() const
{
    return Height;
}

/// @brief Checks if the tile at the given coords is clear
/// @param Row 
/// @param Col 
/// @return 
bool Maze::isClear(int Row, int Col) const {
    return Field[Row][Col] == ' ';
}

/// @brief Sets the tile at the given coord as current path
/// @param Row 
/// @param Col 
void Maze::markAsPath(int Row, int Col) {
    Field[Row][Col] = '*';
}

/// @brief Sets the tile at coords as visited non-path
/// @param Row 
/// @param Col 
void Maze::markAsVisited(int Row, int Col) {
    Field[Row][Col] = '+';
}


// additional methods for ease

/// @brief Checks if the tile at the given coords is a wall
/// @param Row 
/// @param Col 
/// @return 
bool Maze::isWall(int Row, int Col) {
    return Field[Row][Col] == 'x';
}

/// @brief Checks if tile at given coords is part of the path
/// @param Row 
/// @param Col 
/// @return 
bool Maze::isPath(int Row, int Col) {
    return Field[Row][Col] == '*';
}

/// @brief Checks if tile at given coords is visited non-path
/// @param Row 
/// @param Col 
/// @return 
bool Maze::isVisited(int Row, int Col)
{
    return Field[Row][Col] == '+';
}
