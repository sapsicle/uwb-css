/*
 * ScopeEtc.cpp
 *
 * Code to show some things about scope, variable lifespan, and lvalues.
 *
 * Created by Michael Stiber
 * Modified by Yang Peng on 01/12/18
 */

#include <iostream>
#include "SuperInt.h"
#include "SuperDuperInt.h"

using namespace std;

// var is static and outside of any method so it will only be deleted manually
static SuperInt var(0, "global");

int main()
{
    cout << "At start of main()" << endl;

    cout << "var's value is " << var.theValue() << endl << endl;

    // var2 will be deleted at the end of this method, main()
    SuperInt var2(1, "Main");
    cout << "var2's value is " << var2.theValue() << endl << endl;


    cout << "Entering top block" << endl;
    {
        // this var2 is inside a block so will be deleted once the block encs
        SuperInt var2(2, "block");
        cout << "var2's value is " << var2.theValue() << endl << endl;
    }
    cout << "Exiting top block" << endl << endl;;


    cout << "Entering bottom block" << endl;
    {
        // though inside a block, this var2 is static so will only be deleted manually later
        static SuperInt var2(2, "static");
        cout << "var2's value is " << var2.theValue() << endl << endl;
    }
    cout << "Exiting bottom block" << endl << endl;

    // int i = var2.theValue();

    // pvar is a pointer created with new to put it on the heap so it will only be deleted manually
    SuperInt* pvar = new SuperInt(3, "dynamic");

    cout << "At end of main()" << endl;

    SuperDuperInt svar(21, "super");
    cout << svar.theValue() << endl;

    // err: expression must be a modifiable lvalue
    // svar.theValue() = 4;
}

// anticipated 3 mem leaks from undeleted objects