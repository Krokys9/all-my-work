#include <iostream>
#include <ctime>
#include <cstdlib>
using namespace std;

int main()
{
    int arr[3][12];
    /*
    0 2 3 4 5 | 6 7 8 9 10 11 12  0
    0 2 3 4 5 |6 7 8 9 10 11 12 1
    0 2 3 4 5 |6 7 8 9 10 11 12 2


    */
    srand(time(NULL)); //seed the generator
    int maximum =-6;
    for( int i = 0 ; i < 3; i++)
    {
       for( int j = 0 ; j < 12; j++)
    {
        arr[i][j] = (rand()%12)-5;
        if (j < 9 && j > 5 && maximum < arr[i][j] )
        {
            maximum = arr[i][j];
        }
        cout << " " << arr[i][j] << "|\t";
    }
     cout << endl;
    }
cout << "___________________________"  <<endl << "maximum: " << maximum;

    return 0;
}
