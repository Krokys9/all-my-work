#include <iostream>
#include <time.h>
#include "list.h"
#include <stdlib.h>
using namespace std;
class HashEntry
{

private:

    int key;

    int value;

public:

    HashEntry(int key, int value)
    {

        this->key = key;

        this->value = value;

    }



    int getKey()
    {

        return key;

    }



    int getValue()
    {

        return value;

    }

};
const int TABLE_SIZE = 128;



class HashMap
{

private:

    HashEntry **table;

public:

    HashMap()
    {

        table = new HashEntry*[TABLE_SIZE];

        for (int i = 0; i < TABLE_SIZE; i++)

            table[i] = NULL;

    }



    int get(int key)
    {

        int hash = (key % TABLE_SIZE);

        while (table[hash] != NULL && table[hash]->getKey() != key)

            hash = (hash + 1) % TABLE_SIZE;

        if (table[hash] == NULL)

            return -1;

        else

            return table[hash]->getValue();

    }



    void put(int key, int value)
    {

        int hash = (key % TABLE_SIZE);

        while (table[hash] != NULL && table[hash]->getKey() != key)

            hash = (hash + 1) % TABLE_SIZE;

        if (table[hash] != NULL)

            delete table[hash];

        table[hash] = new HashEntry(key, value);

    }



    ~HashMap()
    {

        for (int i = 0; i < TABLE_SIZE; i++)

            if (table[i] != NULL)

                delete table[i];

        delete[] table;

    }

};

class hashtablefornames // asmeniskai kurta hash lentele kuri yra tik pradine .
{
private:
    Konteineris linked[100];
    int code; //asci
public:
    void puta ( int number)
    {
        linked[number %100].AddLast(number);
    }
    void findelement(int tofind)
    {
        linked[tofind%100].FindNumber(tofind);
        cout << " kolonoje numeris " << tofind%100 << endl;
    }
    void printhash()
    {
        for(int i = 0; i < 100; i ++)
        {
            linked[i].PrintList();
            cout << endl;
        }
    }


};
int main()
{
    srand(time(NULL));
    hashtablefornames test1;
    for ( int i = 0 ; i < 3000; i ++)
    {
        test1.puta(rand()%1000);
    }
    test1.printhash();
    test1.findelement(999);
    HashMap size128;
    for ( int i = 0 ; i <50; i ++)
    {
        size128.put(rand()/128, rand()/128);
    }
    for ( int i = 0; i < 128 ; i ++)
    {
            cout << size128.get(i) << "  " ;
    }

    return 0;
}
