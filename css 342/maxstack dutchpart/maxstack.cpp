#include <stack>


using namespace std;

class MaxStack {
public:
    stack<pair<int, int>> s;

    MaxStack() {}

    void push(int x)
    {
        int mx;
        if (s.empty() || x >= max()) {
            mx = x;
        } else {
            mx = max();
        }
        s.push(make_pair(x, mx));
    }

    int pop()
    {
        int e = s.top().first;
        s.pop();
        return e;
    }

    int max() { return s.top().second; }
};

