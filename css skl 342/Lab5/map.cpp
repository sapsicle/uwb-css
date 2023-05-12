#include <map>
#include <iostream>
#include <string>


using namespace std;


int main()
{
    map<string, int> pokemap;

    pokemap.insert(pair<string, int>("pikachu", 25));
    pokemap.insert(pair<string, int>("scizor", 212));
    pokemap.insert(pair<string, int>("gardevoir", 282));
    pokemap.insert(pair<string, int>("garchomp", 445));
    pokemap.insert(pair<string, int>("chandelure", 609));


    for (pair<string, int> var : pokemap) {
        cout << "name: " << var.first << ", number: " << var.second << endl;
    }


    std::pair<std::_Rb_tree_iterator<std::pair<const std::string, int>>, bool> tmp = pokemap.insert(pair<string, int>("pikachu", -25));

    cout << (tmp.first)->first << endl;
	cout << (tmp.first)->second << endl;
	cout << tmp.second << endl;



    std::pair<std::_Rb_tree_iterator<std::pair<const std::string, int>>, bool> tmp2;
    tmp2 = pokemap.insert(pair<string, int>("aegislash", 681));

    cout << (tmp2.first)->first << endl;
	cout << (tmp2.first)->second << endl;
	cout << tmp2.second << endl;



    pokemap["pikachu"] = 1;
    cout << "new pikachu number: " << pokemap["pikachu"] << endl;

    pokemap["decidueye"] = 724;
    cout << "decidueye number: " << pokemap["decidueye"] << endl;

    return 0;
}