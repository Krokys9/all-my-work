#include "Vector.h"
#include <iostream>
template <class T>
MyVector<T>::MyVector()
{
    maxsize = 20;
    array = new T[maxsize];
    vsize = 0;
}
template <class T>
MyVector<T>::MyVector(T i)
{
    maxsize = 20;
    array = new T[maxsize];
    array[0] = i ;
    vsize = 0;
}
template <class T>
MyVector<T>::MyVector(const MyVector& v)
{
}
template <class T>
MyVector<T>::~MyVector()
{
    delete[] array;
}
template <class T>
void MyVector<T> :: push_back(T i)
{
    if (vsize+1 > maxsize)
    {
        alloc_new();

    }
    array[vsize] = i;
    vsize++;
}
template <class T>
 MyVector <T>:: operator[](int i)
{
    return array[i];
}
template <class T>
T MyVector <T>::  at(int i)
{
    if (i < vsize)
    {
     return array[i];
    }
    else
    return 0;

}
template <class T>
void MyVector <T>:: alloc_new()
{
    maxsize = vsize*2;
    T* temp = new T[maxsize];
    for (int i = 0 ; i < vsize; i ++)
    {
        temp[i] = array[i];

    }
    delete[] array;
    array =temp;

}
/*
        void remove_last();
        void get_last();
        void get_size();
*/
template <class T >
void MyVector<T> ::  remove_last()
{
    vsize --;
}
template < class T >
int MyVector <T> :: get_size()
{
    return vsize;
}
template < class T >
void MyVector<T> :: print()
{
    for(int i = 0 ; i < vsize; i++)
    {
        std :: cout << array[i] << " ";
    }
}
template <class T>
void MyVector <T> :: remove_value(int pos)
{
    for (int i = pos; i < vsize; i ++)
    {
       array[i]= array[i-1];
    }
    vsize--;

}
template <class T>
void MyVector <T> :: add_pos_value ( int pos, T value)
{
    if (vsize+1 > maxsize)
    {
        alloc_new();

    }
        for (int i = vsize; i > pos; i ++)
    {
       array[i+1]= array[i];
    }
    array[pos] = value;
    vsize++;


}
template < class T>
int MyVector<T> :: maxsizeofvector()
{
    return maxsize;
}
template <class T >
void MyVector<T> :: sortas()
{
        T temp = 0;
    bool swapas = false;
    for( unsigned int i = 0 ; i <vsize-1; i++)
    {
        swapas = false;
        for(unsigned int j =  0 ; j < vsize-1; j ++)
        {
            if (array[j] > array[j+1])
            {
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
    }
    }
}
/*

add value
add first
 add last

 remove
 remove value
 remove first
 remove last

 get
 getvalue
 get first
 getlast

*/
