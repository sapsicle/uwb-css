#include <vector>


using namespace std;

void dutchFlagPartition(int pivotIndex, vector<int> &v) {
int pivot = v[pivotIndex];
int smaller = 0;
int equal = 0;
int larger = v.size();

while (equal < larger) {
    if (v[equal] < pivot) {
        swap(v[smaller++], v[equal++]);
    } else if (v[equal] == pivot) {
        ++equal;
    } else {
        swap(v[equal], v[--larger]);
    }
    }
}

void swap(int a, int b)
{

}