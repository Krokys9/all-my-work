#include <iostream>
#include "list.h"
#include "list.cpp"
using namespace std;

int main()
{
    Konteineris < int >  a;
    a.AddLast(1);
    a.AddLast(2);
    a.AddLast(3);
    a.AddLast(4);
        a.DelNumber(1);
    a.PrintList();
a.DelNumber(3);
    a.getFirst();
    a.AddLast(8);
    a.PrintList();
}
