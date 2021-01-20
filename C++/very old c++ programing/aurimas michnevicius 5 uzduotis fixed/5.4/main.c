#include <stdio.h>
#include <stdlib.h>
#define CAPACITY 10000
int main()
{
    int mas[CAPACITY] = {0};
    int range = 0 ;
    int value = 0;
    int pirminiai[CAPACITY]= {0};
    int index = 0, index2 = 0;
    int pirminiairange = 0;
    int atsmasyvas[CAPACITY];
    int bool = 1;
    for (int i = 0 ; i < 10000 ; i ++)
    {
        scanf("%d", &mas[i]);
        range ++;
        if (mas[i] <= 0)
        {
            range --;
            mas[i] = 0;
            break;

        }
    }

    for ( int i = 0; i < range ; i ++)
    {
        value = 0;
        for ( int j = 1 ; j <= mas[i]; j++)
        {
            if ( mas[i] % j == 0)
            {
                value ++;

            }

        }
        if ( value <= 2)
        {
            pirminiai[index] = mas[i];
            index ++;
            pirminiairange ++;
        }

    }
    for (int i = 0; i < pirminiairange+1; i ++ )
    {

        for (int j = i+1; j < pirminiairange+1 ; j++ )
        {
            if (pirminiai[i] == pirminiai[j])
            {
                bool = 0;
            }
        }
        if ( bool)
        {
            atsmasyvas[index2] = pirminiai[i];
            index2 ++;
        }
        bool = 1;
    }
    for ( int i = 0 ; i <= index2-2  ; i ++)
    {
        printf("%d \t", atsmasyvas[i]);
    }
    return 0;
}
