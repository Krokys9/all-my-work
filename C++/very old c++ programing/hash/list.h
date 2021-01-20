#ifndef LIST_H_INCLUDED
#define LIST_H_INCLUDED

#include <iostream>
using namespace std;

class Konteineris
{
private:
    typedef struct node
    {
        int data;
        node* next;
    }*nodePtr;
    nodePtr head;
    nodePtr curr;
    nodePtr temp;
    int Size;
    int where;
public:
    Konteineris();
    void AddLast(int var);
    void DelNumber(int var);
    void FindNumber(int var);
    void PrintList();
    int getFirst();
};

#endif // LIST_H_INCLUDED
