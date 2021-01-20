

#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <iostream>
#include <string.h>
#include <vector>

using namespace std;
template < class T >
void mergeSort(vector<T>&left, vector<T>& right, vector<T>& bars);
template < class T >
void sort(vector<T> & bar) {
    if (bar.size() <= 1) return;

    int mid = bar.size() / 2;
    vector<T> left;
    vector<T> right;

    for (size_t j = 0; j < mid;j++)
        left.push_back(bar[j]);
    for (size_t j = 0; j < (bar.size()) - mid; j++)
        right.push_back(bar[mid + j]);

    sort(left);
    sort(right);
    mergeSort(left, right, bar);
}
template< class T >
void mergeSort(vector<T>&left, vector<T>& right, vector<T>& bars)
{
    int nL = left.size();
    int nR = right.size();
    int i = 0, j = 0, k = 0;

    while (j < nL && k < nR)
    {
        if (left[j] < right[k]) {
            bars[i] = left[j];
            j++;
        }
        else {
            bars[i] = right[k];
            k++;
        }
        i++;
    }
    while (j < nL) {
        bars[i] = left[j];
        j++; i++;
    }
    while (k < nR) {
        bars[i] = right[k];
        k++; i++;
    }
}


// other includes and definitions

/* YOUR CODE HERE */

using namespace std;

template <class T>
void mySort(vector<T> &v){
	sort(v);
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

