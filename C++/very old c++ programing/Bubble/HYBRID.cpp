#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <iostream>
#include <string.h>
#include <vector>


// other includes and definitions
template < class T >
void QuickSortas(std ::vector<T> &v, int low, int high)
{
    int i = low;
    int j = high;
    T pivot = v[(i + j) / 2];
    T temp;

    while (i <= j)
    {
        while (v[i] < pivot)
            i++;
        while (v[j] > pivot)
            j--;
        if (i <= j)
        {
            temp = v[i];
            v[i] = v[j];
            v[j] = temp;
            i++;
            j--;
        }
    }
    if (j > low)
        QuickSortas<T>(v, low, j);
    if (i < high)
        QuickSortas<T>(v, i, high);
}
using namespace std;

template <class T>
void mySort(vector<T> &v){
    T temp = 0;
    T lyg=0;
    for( int i = 0; i < v.size()-1; i+=3)
    {
        if(v[i] <= v[i+1])
        {
                    temp = v[i];
                    v[i] = v[i+1];
                    v[i+1] = temp;
        }
    }
    QuickSortas<T>(v,0, v.size()-1);
}



/* DO NOT MODIFY CODE BELOW */

int main(){
	int x = -1;
	while(1){
		cin >> x;
		if (x == 0){
			break;
		} else {
			int n;
			cin >> n;

			switch(x){
				case 1:	{
					vector <int> v1;
					for (int i = 0; i < n; ++i){
						int y1;
						cin >> y1;
						v1.push_back(y1);
					}
					mySort<int>(v1);
					for (int i = 0; i < n; ++i){
						cout << v1[i] << endl;
					}
					break;
				}
				case 2:	{
					vector <string> v2;
					for (int i = 0; i < n; ++i){
						string y2;
						cin >> y2;
						v2.push_back(y2);
					}
					mySort<string>(v2);
					for (int i = 0; i < n; ++i){
						cout << v2[i] << endl;
					}
					break;
				}
			}
			//cout << endl;
		}
	}
	return 0;
}
