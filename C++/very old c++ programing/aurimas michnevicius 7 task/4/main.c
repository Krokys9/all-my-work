#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void generateArray(int data[], int size, int low, int high)
{
    srand(time(NULL));
    for (int i = 0 ; i < size; i ++)
    {
        data[i] = (rand()%(high-low)) +(low);
    }

}
int main()
{
    int mas[200];
    int size = 200;
    int low = 50;
    int high = 100;
    generateArray(mas, size, low, high);
    return 0;
}
