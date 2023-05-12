#include <list>
#include <iostream>


using namespace std;


bool isOdd(const int& num)
{
    return num % 2 == 1;
}


int main()
{
    list<int> list;

    list.push_back(11);
    list.push_back(13);
    list.push_back(15);
    list.push_back(17);
    list.push_back(19);

    list.push_front(12);
    list.push_front(14);
    list.push_front(16);
    list.push_front(18);
    list.push_front(20);


    cout << list.front() << endl;
    cout << list.back() << endl;


    list.remove(13);


    list.sort();


    for (int var : list) {
        cout << var << " ";
    }
    cout << endl;


    list.remove_if(isOdd);


    for (int var : list) {
        cout << var << " ";
    }
    cout << endl;

    return 0;
}