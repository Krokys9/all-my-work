#include <iostream>
#include "vector"
#include "time.h"
using namespace std;

template < class T>
void quicksort (vector <T> &v, int L , int R);
template <class T>
void swapas(vector<T> &v, int x, int y);

template < class T>
void quicksort(vector<T> &v, int L, int R) {
    int i, j, mid, piv;
    i = L;
    j = R;
    mid = L + (R - L) / 2;
    piv = v[mid];

    while (i<R || j>L) {
        while (v[i] < piv)
            i++;
        while (v[j] > piv)
            j--;

        if (i <= j) {
            swapas(v, i, j); //error=swap function doesnt take 3 arguments
                i++;
                j--;
        }
        else {
            if (i < R)
                quicksort<T>(v, i, R);
            if (j > L)
                quicksort<T>(v, L, j);
            return;
        }
    }
}
template < class T>
void swapas(vector<T> &v, int x, int y) {
    int temp = v[x];
    v[x] = v[y];
    v[y] = temp;

}
template <class T >
void Mano_sortas_NR2(vector<T> &v)
{
     for( int i = 0; i < v.size()-1; i+=3)
    {
        if(v[i] <= v[i+1])
        {
            swapas(v, i, i+1);
        }
    }
quicksort(v,0,v.size()-1);
}

int main() {
    vector<int> vec1;
    const int count = 10;

    for (int i = 0; i < count; i++) {
        vec1.push_back(10-i);
    }
        for (int i = 0; i < count; i++) {
        cout << vec1[i] << "  " << endl;
    }

    Mano_sortas_NR2(vec1);
    for (int i = 0; i < count; i++) {
        cout << vec1[i] << "  ";
    }
}
