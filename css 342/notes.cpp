#include <iostream>
#include <string>
// using namespace std;

int main() {
    // TestArray();

    return 0;
}

void TestArray() {
    int nums[10];
    nums[0] = 23;
    for (int i{0}; i < 10; ++i) {
        std::cout << nums[i];
    }
}

struct Rectangle {
    int length;
    int width;
};

int area(Rectangle &rect) {
    int temp;
    temp = rect.length;
    rect.length = 35;
    return temp * rect.width;
}

void TestRectangle() {
    int result;
    Rectangle r = {3, 3};
    result = area(r);
    std::cout << "length = " << r.length << std::endl;
    std::cout << "width = " << r.width << std::endl;
    std::cout << "area = " << result << std::endl;
}

void swapStrings(std::string &str1, std::string &str2) {
    std::string temp = str1;
    str1 = str2;
    str2 = temp;
}

