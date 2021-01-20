#ifndef LIST_H_INCLUDED
#define LIST_H_INCLUDED

#include <iostream>
using namespace std;

template <class T>
class Konteineris
{
private:
    typedef struct node
    {
        T data;
        node* next;
    }*nodePtr;
    nodePtr head;
    nodePtr curr;
    nodePtr temp;
    int Size;
public:
    Konteineris();
    void AddLast(T var);
    void DelNumber(T var);
    void PrintList();
    T getFirst();
    int return_size();
};

#endif // LIST_H_INCLUDED
