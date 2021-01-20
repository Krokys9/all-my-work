#include <stdio.h>
#include <stdlib.h>
#include "file.h"
#include <time.h>
void fillArray (int *mas, int max, int size)
{
    int i =0;
    for (i = 0; i < size; i++)
    {
        mas[i] =  rand()%max;
    }
}
void printArray(int *mas, int size)
{
    int i = 0;
    for(i= 0; i < size; i++)
    {
        printf("%d  ", mas[i]);
    }
    printf("\n");
}
int main()
{
    srand(time(NULL));
    int max = 10, size = 10, *m1, *m2, *m3;
    int a;
    m1 = malloc(sizeof(int)* size);
    fillArray(m1, max, size);
    printArray(m1, size);
    saveToFile(m1, size, "f1.txt");
    m2 = loadFromFile("f1.txt");
    printArray( m2, size);
    for (int i = 0; i < size; i++)
    {
        if ( m2[i] != m1[i])
        {
            printf("something wrong\n ");
            printf("%d    %d   ", m2[i], m1[i]);
            break;
        }
        else
        {
            a = 1;
        }
    }
        if (a == 1)
        {
            printf("all good\n");
        }


    printf("antra uzduotis : \n \n");
    // 2 uzduotis prasideda
    saveCount = 0;
    loadCount = 0;
    m2 = malloc(sizeof(int) * size);
    m3 = malloc(sizeof(int) * size);
    fillArray(m1, max, size);
    fillArray(m2, max, size);
    fillArray(m3, max, size);
    saveToFile(m1, size, "f2.txt");
    saveToFile(m3, size, "f2.txt");
    m1 = loadFromFile("f2.txt");
    saveToFile(m2, size, "f3.txt");
    m3 = loadFromFile("f3.txt");
    m2 = loadFromFile("f2.txt");
    if(saveCount ==3 && loadCount == 3)
    {
        printf("all good\n");
        printf("%d <- save count\n", saveCount);
        printf("%d <- loadcount", loadCount);
    }
    else
    {
        printf("something wrong");
    }

    return 15;
}
