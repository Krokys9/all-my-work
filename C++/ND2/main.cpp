#include <iostream>
#include <vector>
#include "list.h"
using namespace std;

int main()
{
    Konteineris Hello;
    Hello.AddLast(1);
    Hello.AddLast(2);
    Hello.AddLast(3);
    Hello.AddLast(4);
    Hello.AddLast(5);
    Hello.PrintList();
    Hello.DelNumber(5);
    int  x = Hello.getFirst();
    cout << x << endl;
    return 0;
}
