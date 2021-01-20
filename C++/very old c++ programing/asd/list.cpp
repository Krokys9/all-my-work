#include <iostream>
#include <cstdlib>
#include "list.h"

using namespace std;
template < class T>
Konteineris <T>:: Konteineris()
{
    head = NULL;
    curr = NULL;
    temp = NULL;
    Size = 0;
}
template < class T>
void Konteineris<T> :: AddLast(T var)
{
    nodePtr n = new node;
    n->next = NULL;
    n->data = var;
    Size++;

    if ( head!= NULL)
    {
        curr = head;
        while(curr->next != NULL)
        {
            curr = curr->next;
        }
        curr->next = n;
    }
    else
    {
        head = n;
    }
}
template < class T>
void Konteineris <T>:: DelNumber(T var)
{
    nodePtr delPtr = NULL;
    temp = head;
    curr = head;
    int first = 0;
    while ( curr != NULL && curr->data != var)
    {
        first++;
        temp = curr;
        curr = curr->next;
    }
    if ( curr == NULL )
    {
        cout << var << " was not in the list\n";

    }
    else if (first == 0)
    {
        delPtr = head;
        head = head->next;
        temp->next = head;
        delete delPtr;
        Size--;

    }
    else
    {
delPtr = curr;
        curr = delPtr->next;
        temp -> next = curr;

    delete delPtr;
    Size--;
}

}
template < class T>
void Konteineris<T> :: PrintList()
{
    curr = head;
    while(curr != NULL)
    {
        cout << curr->data << endl;

        curr= curr->next;
    }
            cout << "Total of " << Size << "   elements" << endl;
}
template < class T>
T Konteineris<T> :: getFirst()
{
    return head->data;
}
template <class T>
int Konteineris <T> ::  return_size()
{
    return Size;
}
