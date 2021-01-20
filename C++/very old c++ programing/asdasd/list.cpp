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
        cout << curr->data <<" "<< endl;

        curr= curr->next;
    }
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
template <class T>
void Konteineris <T> :: add(int pos, T value)
{
    int tempas= 0;
    curr = head;
    temp = curr;
            nodePtr n = new node;
    if (pos == 0 )
    {
        temp = head;

        head =  n;
        n->next = temp;
        n->data = value;

    }
    else{
    while (tempas != pos && curr != NULL)
    {
        tempas++;
        temp=curr;
        curr = curr -> next;
    }
        if (curr == NULL )
        {
            AddLast(value);
        }
        else
        {


        temp->next = n;
        n->next = curr;
        n->data = value;
           }
}
}
template <class T >
void Konteineris <T> :: del_pos (int pos)
{
    nodePtr delPtr = NULL;
    temp = head;
    curr = head;
    int first = 0;
    while (first != pos && curr != NULL )
    {
        first++;
        temp = curr;
        curr = curr->next;
    }
    if ( curr == NULL )
    {
        cout << pos << " is out of range\n";

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
// nieko neistrina jei is out of rnage
}
template < class T>
T Konteineris<T> :: get(int pos)
{
    int tempas= 0;
    curr = head;
    temp = curr;
    if (pos == 0 )
    {
       return head->data;

    }
    else{
    while (tempas != pos && curr != NULL)
    {
        tempas++;
        temp=curr;
        curr = curr -> next;
    }
    if (curr != NULL)
        return curr->data;
        else
        return -1;
    }
}
