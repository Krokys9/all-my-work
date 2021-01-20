#include <stdio.h>
#include <stdlib.h>

int main()
{
    int mas[] = {6,2,3,1,9,10,15,13,12,17};
    int n = 1000;
    int i, key, j;
    int swap;
    int position = 0;
    /*for (i = 1; i < n; i++)
    {
        key = mas[i];
        j = i-1;
        while (j >= 0 && mas[j] > key)
        {
            mas[j+1] = mas[j];
            j = j-1;
        }
        mas[j+1] = key;
    }
    */

    for ( int i = 0 ; i < ( n - 1 ) ; i++ )
    {
        position = i;

        for (int d = i + 1 ; d < n ; d++ )
        {
            if ( mas[position] > mas[d] )
                position = d;
        }
        if ( position != i )
        {
            swap = mas[i];
            mas[i] = mas[position];
            mas[position] = swap;
        }
        for(i = 0;i < 10;i++) printf("%d ",mas[i]);
        printf("Hello world!\n");
        return 0;
    }
}
