#include <vector>
#include <iostream>
#include "sorts.h"
void BubbleSort(std::vector <int> &ToSort)
{
    int temp = 0;
    for( int i = 0 ; i < ToSort.size(); i++)
    {
        for(int j = 0 ; j < ToSort.size(); j ++)
        {
            if (ToSort[i] < ToSort[j])
                {
                    temp = ToSort[i];
                    ToSort[i] = ToSort[j];
                    ToSort[j] = temp;
                }
        }
    }
}
void QuickSortas(std ::vector <int> &ToSort, int low, int high)
{
    int i = low;
    int j = high;
    int pivot = ToSort[(i + j) / 2];
    int temp;

    while (i <= j)
    {
        while (ToSort[i] < pivot)
            i++;
        while (ToSort[j] > pivot)
            j--;
        if (i <= j)
        {
            temp = ToSort[i];
            ToSort[i] = ToSort[j];
            ToSort[j] = temp;
            i++;
            j--;
        }
    }
    if (j > low)
        QuickSortas(ToSort, low, j);
    if (i < high)
        QuickSortas(ToSort, i, high);
}
void PrintVector(std ::vector <int> ToPrint)
{
    for (int i = 0; i < ToPrint.size(); i ++)
    std :: cout << ToPrint[i]<< "  ";

    std :: cout << std ::endl;
}
void MyOwnSort( std ::vector <int> &ToSort)
{
    int temp = 0;
    int lyg=0;
    for( int i = 0; i < ToSort.size()-1; i+=3)
    {
        if(ToSort[i] <= ToSort[i+1])
        {
                    temp = ToSort[i];
                    ToSort[i] = ToSort[i+1];
                    ToSort[i+1] = temp;
        }
    }
    QuickSortas(ToSort,0, ToSort.size()-1);
}
