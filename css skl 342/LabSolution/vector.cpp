#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

// Exercise 2.7
class Person {
    string name;
    int age;

    public:
    Person(string name, int age) : name(name), age(age){} 

    // Exercise 2.8
    friend ostream& operator <<(ostream& out, const Person& p)
    {   
        out << "Name: " <<  p.name << " Age: " << p.age;
        return out;
    }
};

// Exercise 2.4
template<typename T>
void printVector(vector<T> v){
    for (typename vector<T>::iterator i = v.begin(); i != v.end(); i++){
        cout << *i << " ";
    }
    typename vector<T>::iterator i = v.begin();
}

int main(){

    // Set a random seed using the current time to get non-reproducable random numbers
    srand (time(NULL));


    // Exercise 2.2
    vector<int> v(6);
    // Exercise 2.3
    for (int i = 0; i < v.size(); i++){
        v[i] = (rand() % 100) * 2;
    }
    printVector(v);

    // Exercise 2.5
    for (int i = 0; i < 5; i++){
        v.push_back(i*2+1);
    }
    printVector(v);

    // Exercise 2.6
    sort(v.begin(), v.end(), greater<int>());
    printVector(v);


    // Exercise 2.9
    vector<Person> p {{"Katie", 33}};
    p.push_back({"Liang", 37});
    printVector(p);
    cout << endl;

}