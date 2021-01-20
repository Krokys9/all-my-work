#include <iostream>
#include "list.h"
#include "list.cpp"
using namespace std;

int main()
{
    Konteineris <int> a;
    a.AddLast(1);
    a.AddLast(2);
    a.AddLast(3);
    a.PrintList();
     cout << endl;
    a.add(0,-9);
    a.PrintList();
    cout << endl;
    a.del_pos(1);
     cout << endl;
    a.PrintList();
    return 0;
}
