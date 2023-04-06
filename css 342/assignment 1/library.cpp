//
// Created by XXXX on MM/DD/YYYY.
//
// Library class demonstrating partially filled arrays
// Can add/remove books from library
// findbooks in library


#include "library.h"
#include <iostream>

// constructor with default name
Library::Library(const string &Name) {
    // static string library[MAX];
    this->numBooks = 0;
}

// destructor
// nothing on heap
Library::~Library() {
    // destructor
}

// true if book found in library
bool Library::isInLibrary(const string &BookName) const {
    if (this->numBooks == 0) return false;
    for (int i{0}; i < this->numBooks; i++) {return (BookName == this->library[i]) ? true : false;}
    // dummy return, compiler unhappy
    return false;
}

// add a new book
// return true if successful, false if
// book already in library
bool Library::addBook(const string &BookName) {
    // if book already exists, return early with false
    if (isInLibrary(BookName)) return false;

    // set book to numBooks index
    // numBooks == 0 will place it in library[0] which is the first index
    // numBooks == 5 will place it in library[5] which is the 6th index
    library[this->numBooks] = BookName;
    // then increment to account for new book
    this->numBooks++;

    // if successful return true (got here without error)
    return true;
}

// remove a book
// return true if successfully removed
// false if book not in library
bool Library::removeBook(const string &BookName) {
    // if target book not in library, return early with false
    if (!isInLibrary(BookName)) {return false;}

    // loop through library array up to number of books (filled size)
    for (int i{0}; i < this->numBooks; i++) {
        // check for match with each book
        if (this->library[i] == BookName) {
            // if matched, move last position book to fill index of book to remove
            this->library[i] = this->library[this->numBooks - 1];
            // decrement to account for lost book
            this->numBooks--;
        }
    }

    // if no errors return true
    return true;
}

// list all books
void Library::listAllBooks() const {
    // loop through filled portion of library and output all books on individual lines
    for (int i{0}; i < this->numBooks; i++) {cout << this->library[i] << endl;}
}

ostream &operator<<(ostream &Out, const Library &Lib) {
    return Out;
}