#include <iostream>
#include <cstdlib>
#include "list.h"

using namespace std;
Konteineris :: Konteineris()
{
    head = NULL;
    curr = NULL;
    temp = NULL;
    Size = 0;
}
void Konteineris :: AddLast(int var)
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
void Konteineris :: DelNumber(int var)
{
    nodePtr delPtr = NULL;
    temp = head;
    curr = head;
    while ( curr != NULL && curr->data != var)
    {
        temp = curr;
        curr = curr->next;
    }
    if ( curr == NULL )
    {
        cout << var << " was not in the list\n";

    }
    else
    {
        delPtr = curr;
        curr = curr->next;
        temp -> next = curr;

    delete delPtr;
    cout << "succ Deleted\n";
    Size--;
}

}
void Konteineris :: PrintList()
{
    curr = head;
    while(curr != NULL)
    {
        cout << curr->data<< " | ";

        curr= curr->next;
    }
            cout << "Total of " << Size << "   elements" << endl;
}
int Konteineris :: getFirst()
{
    return head->data;
}
void Konteineris :: FindNumber(int var)
{
    nodePtr delPtr = NULL;
    temp = head;
    curr = head;
    where =1;
    cout << "is: " << endl;
    while ( curr != NULL)
    {
        temp = curr;
        curr = curr->next;
        where ++;
        if (temp->data == var)
        {
            cout   << where << "st/nd/th  |";
        }
    }
    if ( &curr == NULL )
    {
        cout << var << " was not in the list\n";

    }
}
