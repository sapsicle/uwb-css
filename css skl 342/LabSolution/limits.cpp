#include <iostream>
#include <limits> 
#include <iomanip>

using namespace std;

int main() {

	// Exercise 1.1
	cout << "max of int is " << numeric_limits<int>::max() << endl;
	cout << "min of int is " << numeric_limits<int>::min() << endl;

	cout << "max of unsigned int is " << numeric_limits<unsigned int>::max() << endl;
	cout << "min of unsigned int is " << numeric_limits<unsigned int>::min() << endl;

	cout << "max of long is " << numeric_limits<long>::max() << endl;
	cout << "min of long is " << numeric_limits<long>::min() << endl;

	cout << "max of double is " << numeric_limits<double>::max() << endl;
	cout << "min of double is " << numeric_limits<double>::min() << endl;

	cout << "max of float is " << numeric_limits<float>::max() << endl;
	cout << "min of float is " << numeric_limits<float>::min() << endl;

	// Exercise 1.2
	cout << "Max int + 1 is " << numeric_limits<int>::max() + 1 << endl;
	// Note we get a compiler warning like:
	// warning: integer overflow in expression of type ‘int’ results in ‘-2147483648’
	// You can still run the program to see what the result is even with the warning.
	// Although we see a warning here, there is no guarantee that you will get a warning about 
	// overflows.  You should always check integer boundaries if you are using large numbers or
	// the integer could be anything (for example, a user input).
	cout << "Max unsigned + 1 is " << numeric_limits<unsigned int>::max() + 1 << endl;

	// Exercise 1.3
	cout << "digits past the decimal point that a float can accurately represent: " 
		 << numeric_limits<float>::digits10 << endl;
	cout << "digits past the decimal point that a int can accurately represent: " 
		 << numeric_limits<int>::digits10 << endl;
	cout << "digits past the decimal point that a double can accurately represent: " 
		 << numeric_limits<double>::digits10 << endl;

	// Experiment to demonstrate precision
	float a = 9999979000;
	cout << "We set a originally as 9999979000 " << endl;
	// cout will only use 7 digits of precision by default, so that the number you see will be correct (although less precise)
	cout << "Print a with standard precision: " << a << endl;
	// We can change the amount of precision cout will use.  17 is enough to get the full float representation.
	cout << setprecision(17) << "Print a with full precision: " << a << endl;
	// Notice how the number is not what it started as?
	return 0;
}