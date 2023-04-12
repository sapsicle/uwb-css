/*
 * ArrayDemo
 *
 * Created by Rob Nash
 *
 * Modified by Yang Peng on 01/09/18
 * Modified by Katie Ewing 2022-2023
 */

#include <iostream>
using namespace std;

// Forward declarations.
void display(int data[], int size);
void bubbleSort(int data[], int size);
void swapByValue(int data[], int idx1, int idx2);

int main(int argc, const char * argv[])
{
  const int SIZE = 7;
  // These are auto variables.
  int set[] = {1,4,3,2,5,9,8}; // Size implicit
  int set2[SIZE] = {30, 23, 25, 19, 100, 13, 7};
  // What does it look like in JAVA?
  // int[] myArray = new int[3];
  // int[] myArray = {1, 2, 3};
  // int[] myArray = new int[] {1, 2, 3};
    
  // You have to pass the size in; a C++ array is just a dumb block of
  // storage; no size information is carried with it and no bounds
  // checking is done.
  display(set, SIZE);
  bubbleSort(set, SIZE);
  display(set, SIZE);
    
  return 0;
}

void display(int data[], int size) {
  for(int i = 0; i < size; i++) {
    cout << data[i] << ",";
  }
  cout << std::endl;
}

void bubbleSort(int data[], int size) {
  for(int i = 0; i < size; i++) {
    for(int k = 0; k < size - 1 - i; k++) {
      if(data[k] < data[k+1]) {
		    swapByValue(data, k, k+1);
      }
    }
  }
}

void swapByValue(int data[], int idx1, int idx2) {
  int temp = data[idx1];
  data[idx1] = data[idx2];
  data[idx2] = temp;
}
 
