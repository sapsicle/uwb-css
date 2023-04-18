#include <iostream>
#include <cmath>

using namespace std;

unsigned long int catalan(unsigned long int n) {
    if (n <= 1) return 1;

    unsigned long int res = 0;
    for (int i{0}; i < n; i++) {
        res += catalan(i) * catalan(n - i - 1);
    }
    return res;
}

int main() {
    for (int i = 1; i <= 20; i++) cout << catalan(i) << " ";
    cout << endl;
    return 0;
}