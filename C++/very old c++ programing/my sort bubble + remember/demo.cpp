#include <iostream>
#include <vector>

#define sizeo 6
using namespace std;
template<class T >
void mySort( vector <T> &v)
{

    int maxnum;
    int minnum;
    int fix = 0;
    while ( v.size()+fix <=2)
    {
        fix++;
        cout << fix;
    }
    for (unsigned int i =0 ; i < (v.size()-1+fix)/2; i++)
    {
        cout << i << endl;


        maxnum =  v.size()-1-i;
        minnum = i ;
        for (unsigned int j =i; j < v.size()-1-i; j++)
        {
            cout << j << "    " ;

            for(int i = 0 ; i < sizeo ; i ++)
            {
                cout << v[i] << "   " ;
            }
            cout <<  " in head  min = " <<v[minnum] << " maximum  = " << v[maxnum]  <<  endl;


            if (v[j+1] < v[minnum] )
            {
                swap(v[j+1], v[minnum]);
            }
            else if (v[j+1] > v[maxnum])
            {
                swap ( v[j+1], v[maxnum]);
            }
            if ( v[j] > v[j+1])
            {
                swap (v[j], v[j+1]);
            }

        }
    }
}

int main()
{
    vector <int> a;
    a.push_back(5);
    a.push_back(4);
    a.push_back(2);
    a.push_back(8);
    a.push_back(10000);
    a.push_back(7);
    mySort(a);
    for(int i = 0 ; i < sizeo ; i ++)
    {
        cout << a[i] << "  " ;
    }
    return 0;
}

