#include <stdio.h>
#include <stdlib.h>

void splitData(int mas1[], int size1, int size2, int *firsthalf, int *secondhalf )
{
    if(size1> 0 && size2 < size1)
    {
    firsthalf = (int)malloc(size1*sizeof(int));
    secondhalf = (int)malloc((size1-size2)*sizeof(int));
        for (int i = 0; i < size2; i ++)
        {
            firsthalf[i] = mas1[i];
        }
        for(int j = 0; j < (size1-size2) ; j++)
        {
            secondhalf[j] = mas1[size2+j];
        }

    }

}
int main()
{

    int mas1[100]= {0};
    int size1 = 100;
    int size2 = 47;
    int *a = NULL;
    int *b = NULL;
    splitData(mas1, size1, size2, a, b);
    return 0;
}
