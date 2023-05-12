#include <iostream>
#include <limits>


using namespace std;

int main()
{
    cout << numeric_limits<int>::max() << endl;
    cout << numeric_limits<int>::min() << endl;

    cout << numeric_limits<unsigned int>::max() << endl;
    cout << numeric_limits<unsigned int>::min() << endl;

    cout << numeric_limits<double>::max() << endl;
    cout << numeric_limits<double>::min() << endl;
    
    cout << numeric_limits<float>::max() << endl;
    cout << numeric_limits<float>::min() << endl;



    // cout << numeric_limits<int>::max() + 1 << endl;
    // cout << numeric_limits<int>::min() - 1 << endl;



    cout << numeric_limits<float>::digits10 << endl;
    cout << numeric_limits<double>::digits10 << endl;

    return 0;
}