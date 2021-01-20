#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int createArray(int size, int low, int high)
{
    if(size > 1 && low < high )
    {

        int *A = (int*)malloc(size*sizeof(int));
        srand(time(NULL));
        for (int i = 0 ; i < size; i ++)
        {
            A[i] = (rand()%(high-low)) +(low);
        }
        return &A[0];
    }
    else
    {
        return (0);
    }

}
int main()
{
    printf("Hello world!\n");
    printf("%d",createArray(10,10,20));
    return 0;
}
