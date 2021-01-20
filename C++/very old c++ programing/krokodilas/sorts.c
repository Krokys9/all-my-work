#include <stdio.h>
#include <stdlib.h>
#include "header.h"
int lygCount = 0;
int ifCount = 0;

int bubble_sort_a(int *mas, int sizeo)
{
    int temp;
    lygCount = 0;
    ifCount = 0;
    for ( int i = 0; i < sizeo; i ++)
    {
        for ( int j = 0; j < sizeo-1; j ++)
        {
            ifCount++;
            if ( mas[j] > mas[j+1])
            {
                lygCount+=3;
                temp = mas[j+1];
                mas[j+1] = mas[j];
                mas[j] = temp;
            }
        }
    }
    return mas;
}
int bubble_sort_b(int *mas, int sizeo)
{
    int temp;
    int boolas = 1;
    lygCount =0;
    ifCount = 0;
    for ( int i = 0; i < sizeo; i ++)
    {
        for ( int j = 0; j < sizeo-1; j ++)
        {
            boolas = 0;
            ifCount++;
            if ( mas[j] > mas[j+1])
            {
                lygCount+=3;
                temp = mas[j+1];
                mas[j+1] = mas[j];
                mas[j] = temp;
                boolas ++;
            }


        }
        if(boolas == 0)
        {
            break;
        }
    }

    return mas;
}
int bubble_sort_ac(int *mas, int sizeo)
{
    int temp;
    for ( int i = 0; i < sizeo/2; i ++)
    {
        for ( int j = i; j < sizeo-i-1; j ++)
        {
            ifCount++;
            if ( mas[j] > mas[j+1])
            {
                lygCount +=3;
                temp = mas[j];
                mas[j] = mas[j+1];
                mas[j+1] = temp;
            }
        }

        for ( int j = sizeo-2-i ; j>i ; j --)
        {
            ifCount++;
            if(mas[j]< mas[j-1])
            {
                temp = mas[j];
                mas[j] = mas[j-1];
                mas[j-1] = temp;
            }
        }
    }
    return mas;
}
int bubble_sort_random(int *mas, int sizeo)
{
    int max;
    int index;
    for (int i = 1; i < sizeo; i ++)
    {
        lygCount+=2;
            max = mas[i];
            index = i;
        for (int j = i  ; j < sizeo; j++)
        {
            if(mas[i] > max)
                lygCount++;
            {
                lygCount++;
                index = j;
            }
            mas[i] = mas[index];
        }
    }
    return mas;
}
int bubble_sort_d(int *mas, int sizeo)
{
    int reikalingas = 0;
    int temp;
    int j = sizeo;
    for ( int i = 0; i < j; i ++)
    {
        for ( j = 0; j < sizeo; j ++)
        {
            if ( mas[i] < mas[j])
            {
                reikalingas = j;
                temp = mas[i];
                mas[i] = mas[j];
                mas[j] = temp;
            }
        }
    }
    return mas;
}
int bubble_sort_af(int *mas, int sizeo)
{
    int temp;
    lygCount = 0;
    ifCount = 0;
    for ( int i = 0; i < sizeo; i ++)
    {
        for ( int j = 0; j < sizeo-1; j +=2)
        {
            ifCount++;
            if ( mas[j] > mas[j+1])
            {
                lygCount+=3;
                temp = mas[j+1];
                mas[j+1] = mas[j];
                mas[j] = temp;
            }
        }
        for( int j = sizeo-2; j > 0; j -=2)
        {
            ifCount++;
            if ( mas[j] > mas[j+1])
            {
                lygCount+=3;
                int temp;
                for ( int i = 0; i < sizeo/2; i ++)
                {
                    for ( int j = i; j < sizeo-i-1; j ++)
                    {
                        ifCount++;
                        if ( mas[j] > mas[j+1])
                        {
                            lygCount +=3;
                            temp = mas[j];
                            mas[j] = mas[j+1];
                            mas[j+1] = temp;
                        }
                    }

                    for ( int j = sizeo-2-i ; j>i ; j --)
                    {
                        ifCount++;
                        if(mas[j]< mas[j-1])
                        {
                            temp = mas[j];
                            mas[j] = mas[j-1];
                            mas[j-1] = temp;
                        }
                    }
                }
                return mas;
                temp = mas[j+1];
                mas[j+1] = mas[j];
                mas[j] = temp;
            }
        }
    }
    return mas;
}
int bubble_sort_bc(int *mas, int sizeo)
{
    int temp;
    int boolas = 1;
    lygCount =0;
    ifCount = 0;
    for ( int i = 0; i < sizeo-1; i ++)
    {
        for ( int j = 0;  j< sizeo-i-1; j ++)
        {
            boolas = 0;
            ifCount++;
            if ( mas[j] > mas[j+1])
            {
                lygCount+=4;
                temp = mas[j+1];
                mas[j+1] = mas[j];
                mas[j] = temp;
                boolas ++;
            }


        }
        if(boolas == 0)
        {
            break;
        }
    }

    return mas;
}
int bubble_sort_bce(int *mas, int sizeo)
{
    int temp;
    int boolas = 1;
    lygCount =0;
    ifCount = 0;
    for ( int i = 0; i < sizeo-1; i ++)
    {
        for ( int j = 0;  j< sizeo-i-1; j ++)
        {
            boolas = 0;
            ifCount++;
            if ( mas[j] > mas[j+1])
            {
                lygCount+=4;
                temp = mas[j+1];
                mas[j+1] = mas[j];
                mas[j] = temp;
                boolas ++;
            }


        }
        if(boolas == 0)
        {
            break;
        }
    }

    return mas;
}
