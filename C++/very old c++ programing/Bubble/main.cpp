#include <iostream>
#include <stdio.h>
#include <iostream>
#include <string.h>
#include <vector>
using namespace std;
template <class T>
void mySort(vector <T> &v)
{
    T temp = 0;
    bool swapas = false;
    for( unsigned int i = 0 ; i < v.size(); i++)
    {
        swapas = false;
        for(unsigned int j = i ; j < v.size()-1-i; j ++)
        {
            if (v[j] < v[j+1])
            {
                temp = v[j];
                v[j] = v[j+1];
                v[j+1] = temp;
                swapas = true;
            }

        }
        if(swapas == false)
        {
            break;
        }
    }
}

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

