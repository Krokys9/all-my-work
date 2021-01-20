#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define CAPACITY 1000

int main()
{
    int a, b, c;
    int mas[CAPACITY] = {0};
    srand(time(NULL));
    printf("iveskite tris skaicius a b c :\n");
       scanf("%d %d %d", &a, &b, &c);

    for ( int i = 0; i <= c ; i++)
    {
        if ( b > 0)
        {

        mas[i] = a +  (((rand())) % (b-a));
        printf("%d \t" , mas[i]);
        }
        if (b <0)
        {
        mas[i] = a + (((rand())) % (a + abs(b)));
        printf("%d \t" , mas[i]);
        }
    }



    return 0;
}
