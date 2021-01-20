#include <iostream>
#include "vector.h"
#include "vector.cpp"
using namespace std;

int main()
{
    MyVector <int> a;
    a.push_back(4);
    a.push_back(8);
    a.push_back(2);
    a.print();
    a.sortas();
    cout << endl;
    a.print();
    cout << "Hello world!" << endl;
    return 0;
}
