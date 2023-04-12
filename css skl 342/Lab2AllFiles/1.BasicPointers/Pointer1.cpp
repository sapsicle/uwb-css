/*
 *  Pointer1.cpp
 *
 *  Created by Rob Nash
 *
 *  Modified by Yang Peng on 01/09/18
 */


#include <iostream>
using namespace std;


void display1(int l, int m, int n, int o, int* p) {
  cout << "\ndisplay1():" << endl;
  cout << "var1 is " << l << endl;
  cout << "var2 is " << m << endl;
  cout << "var3 is " << n << endl;
  cout << "var4 is " << o << endl;
  cout << "address of \"l\" (var1) is " << &l << endl;
}

void display2(int l, int m, int n, int o, int& p) {
  cout << "\ndisplay2():" << endl;
  cout << "var1 is " << l << endl;
  cout << "var2 is " << m << endl;
  cout << "var3 is " << n << endl;
  cout << "var4 is " << o << endl;
  cout << "address of \"l\" (var1) is " << &l << endl;
}

int main()
{
  int a = 3;
  int b, c, d;
  int* aPtr, bPtr;  //Pitfall: note that bPtr is an int, not an int *
  b = 3;
  c = 5;
  d = a + b + c;
    
  aPtr = &a;
    
  display1(a, b, c, d, aPtr);
  display2(a, b, c, d, aPtr);
    
  cout << endl;
  cout << "\"aPtr\" is a pointer, whose value is " << aPtr << endl;
  cout << "This is the same as \"&a\", or " << &a << endl;
    
  cout << endl;
  cout << "\"aPtr\" points to the following value:  " << *aPtr << endl;
  cout << "This is the same as \"a\", or " << a <<endl;
  
  // Your additional code here.
}
