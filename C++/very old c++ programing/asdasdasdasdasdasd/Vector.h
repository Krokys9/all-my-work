#ifndef VECTOR_H
#define VECTOR_H

template < class T >
class MyVector
{
    int vsize, maxsize;
    T* array;
    void alloc_new();
    public:
        MyVector();
        MyVector(T);
        MyVector(const MyVector&);
        ~MyVector();
        void push_back(T);
        void remove_last();
        int get_size();
        int size();
        operator [](int);
        T at(int i);
        void print();
        void remove_value(int pos);
        void  add_pos_value ( int pos, T value);
        int maxsizeofvector();
        void sortas();

    protected:

    private:
};

#endif // VECTOR_H
