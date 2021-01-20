#include <stdio.h>
#include <stdlib.h>
#define CAPACITY 10000
int main()
{
    int s, n;
    int nepavyko = 0;
    int mas[CAPACITY] = {0};
    printf("iveskite s n \n");
    scanf(" %d %d" ,&s, &n);
    if ( n > CAPACITY )
    {
        printf("programa neveiks nes perlipo limitus");
    }
    else
    {
        for ( int i = 0; i < n; i++)
        {
            printf("iveskite %d indekso elementa \n", i);
            scanf("%d", &mas[i]);
            if (mas[i] <= 0 )
            {
                i--;
                nepavyko ++;
                if (nepavyko > 10)
                {
                    printf (" Reikia vesti tik teigiamus skaicius !!!!!!!! \n ") ;
                    nepavyko = 8;
                }
            }
        }
        for ( int i = 0 ; i < n ; i ++)
        {
            for ( int j = 0 ; j < n ; j ++)
            {
                 if ( s == mas[i] * mas[j])
                 {
                     printf ("%d * %d = %d \n", mas[i], mas[j] , s);
                 }
            }
        }
    }

    return 0;
}
