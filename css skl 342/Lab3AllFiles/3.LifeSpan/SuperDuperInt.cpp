#include "SuperDuperInt.h"
#include "SuperInt.h"

SuperDuperInt::SuperDuperInt(int value, const char *name) : SuperInt(value, name), myValue2(value), myName2(name) {

}

int SuperDuperInt::theValue() {
    // had to write a new getter to access myValue in SuperInt as the updated theValue() cuts off access to SuperInt::myValue from SuperDuperInt
    return SuperInt::getValue();
}