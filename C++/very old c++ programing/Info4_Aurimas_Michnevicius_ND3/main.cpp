#include <iostream>
#include "sorts.h"
using namespace std;

int main()
{
    vector <int> Labas;

    Labas.push_back(3);
    Labas.push_back(2);
    Labas.push_back(8);
    Labas.push_back(1);
    //BubbleSort(Labas);
    MyOwnSort(Labas);
    cout << Labas[0];
    return 0;
}
