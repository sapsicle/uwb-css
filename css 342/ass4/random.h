/*
/*
random.h
Assignment 4
Neha Nehru and Andrew Coop
15th May 2023

*/
#ifndef RANDOM_H
#define RANDOM_H

#include <vector>

using namespace std;

class Random {
private:
  // internal counter
  static int counter;

  // list of random numbers
  static const vector<int> NUMS;

public:
  // return a pseudorandom number
  static int random();
};

#endif