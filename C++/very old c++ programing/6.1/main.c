#include <stdio.h>
#include <stdlib.h>
#define CAPACITY 10000
int main()
{
    int *a;
    int b;
    long int factorialvalue = 1;
    FILE *fp;

    printf("Factorial founding program \n");
    while (1)
    {
        printf("Enter a positive integer number \n");
        if ((scanf("%d", &a) == 1) &&  (getchar() == '\n'))
        {
            if (a > 0)
            {
                break;
            }
        }
        else
        {
            while (getchar() != '\n');
        }
    }
    for (int i = 1; i <=a; i ++)
    {
        factorialvalue *= i;
    }
    fp = fopen("Factorial.txt", "w");
    if (fp == NULL)
    {
        printf("error");
    }
    printf("%ld", factorialvalue);
    fprintf( fp, "%ld", factorialvalue);
    fclose(fp);


    return 0;
}
