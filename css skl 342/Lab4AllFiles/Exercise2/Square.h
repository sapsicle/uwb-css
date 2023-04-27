/*
 *  Square.h
 *  Class-example
 *
 */

#ifndef SQUARE_H
#define SQUARE_H

template <class T>
class Square {
	friend std::ostream& operator<<(std::ostream&, const Square&);
public:
	Square& operator=(const Square&);
	bool operator<(const Square&);
    bool operator>(const Square &other);
    void setSize(T newSize);
    int getSize(void) const;

private:
	T theSize;
};

#endif
