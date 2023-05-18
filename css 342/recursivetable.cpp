#include <iostream>
#include <string>

// using namespace std;

void truthTable(int num, const std::string& sofar = "")
{
    if (num == 1) {
        std::cout << sofar << "T" << std::endl;
        std::cout << sofar << "F" << std::endl;
    } else {
        truthTable(num - 1, sofar + "T");
        truthTable(num - 1, sofar + "F");
    }
}

int main(int argc, char const *argv[])
{
    truthTable(3);

    return 0;
}