#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "header.h"
void fillArray (int *mas, int max, int size)
{
    int i =0;
    for (i = 0; i < size; i++)
    {
        mas[i] =  rand()%max+i+1;
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
void checkIfCorrect(int *mas, int size);
int main()
{
    srand(time(NULL));
    int mas[10];
    int size = 10;
    fillArray(mas, 1, size);
    printArray(mas, size);
    //checkIfCorrect(mas,size);
   ///bubble_sort_a(mas, size); printArray(mas, size);
    ///bubble_sort_b(mas, size); printArray(mas, size);
    /// bubble_sort_ab(mas, size); printArray(mas, size);
    ///bubble_sort_ac(mas, size); printArray(mas,size);
    ///bubble_sort_af(mas, size); printArray(mas,size);
   /// bubble_sort_bc(mas, size); printArray(mas,size);
   /// bubble_sort_random(mas, size); printArray(mas,size);
   /// bubble_sort_bcf

    printf("%d   %d ", ifCount, lygCount);
    //checkIfCorrect(mas,size);
    return 0;
}

void checkIfCorrect(int *mas, int size)
{
    int program = 0;
    int boolas = 1;
    int overall = 0;
    printf ( " pasirinkite koki norite tikrinti buda: 1 = mazejimo, 2 = didejimo, 3 = masyvas lygus \n jei norite tikrinti kokia tvarka rasykite: -1 \n");
    scanf("%d", &program);
    if ( program == 1 || program == -1)
    {

        for (int i = 0; i < (size-1); i ++)
        {
            if ( mas[i] < mas[i+1])
            {
                boolas = 0;
            }

        }
        if (boolas == 1 )
        {
            printf("taip, tai yra mazejimo\n");
        }
        else
        {
            printf("ne, elementai nera mazejimo\n");
            overall ++;
        }

        boolas = 1;
    }

    if (program == 2 || program == -1)
    {

        for ( int i = 0; i < (size-1); i ++)
        {
            if ( mas[i] > mas[i+1])
            {
                boolas = 0;
            }
        }
        if (boolas == 1 )
        {
            printf("taip, tai yra didejimo\n");
        }
        else
        {
            printf("ne, elementia nera didejimo tvarkos\n");
            overall ++;
        }
        boolas = 1;
    }
    if (program == 3 || program == -1)
    {

        for ( int i = 0; i < (size-1); i ++)
        {
            if ( mas[i] < mas[i+1] || mas[i] > mas[i+1])
            {
                boolas = 0;
            }
        }
        if (boolas == 1 )
        {
            printf("taip elementai yra visi lygus.\n");
        }
        else
        {
            printf("ne, elementai nera lygus\n");
            overall ++;
        }
        boolas = 1;
    }
    if (overall == 3 && program == -1)
    {
        printf("neiviena is virsuje isvardintu\n");
    }
    if (program !=1  && program != 2 && program != 3 && program != -1)
    {

        printf("something wrong");
    }
}
