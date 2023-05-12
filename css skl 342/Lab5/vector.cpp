#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>

#include "vector.hpp"


using namespace std;


template<class T>
void printVector(vector<T> vector)
{
    for (typename vector<T>::iterator i = vector.begin(); i < vector.end(); i++) {
        cout << *i << " ";
    }
    cout << endl;
}


Person::Person(string name, int age) : name(name), age(age) {}


ostream& operator <<(ostream& out, const Person& person)
{
    out << "name: " << person.name << ", age: " << person.age << endl;
    return out;
}


int main()
{
    vector<int> vector(6);

    for (int i = 0; i < vector.size(); i++){
        vector[i] = (rand() % 100) * 2;
    }

    printVector(vector);


    for (int i = 0; i < 5; i++) {
        vector.push_back(ceil((rand() % 100) / 2));
    }

    printVector(vector);


    sort(vector.begin(), vector.end(), greater<int>());


    // refuses to accept without std:: namespace despite declaring namespace above
    std::vector<Person> pvec = {{"max", 25}, {"alex", 30}};

    printVector(pvec);

    return 0;
}