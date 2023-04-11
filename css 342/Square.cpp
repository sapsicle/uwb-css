#include <iostream>
#include <cassert>

using namespace std;

class Square {
    friend ostream &operator<<(ostream &out, const Square &sq);
public:
    explicit Square(int length) {
        this->length = length;
    }
    
    int getLength() const {
        return this->length;
    }

    Square operator+(const Square &other) const {
        return Square(this->length + other.length);
    }

    Square &operator+=(const Square &other) {
        this->length += other.length;
        return *this;
    }
private:
    int length;
};

int main() {
    Square S2(2);
    cout << "S2: " << S2 << endl;
    assert(S2.getLength() == 2);
    
    return 0;
}