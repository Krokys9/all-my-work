#include <stdio.h>
#include <stdlib.h>

int main ()
{
    FILE *fp;
    char number[50];
    int skaicius;
    int numberofsimbols;
    int numbersaftercomma;
    int temp;

    fp = fopen("input.txt","r");
    if(fp == NULL)
    {
        perror("Error in opening file");
        return(-1);
    }
    fgets(number,50, fp);
    fclose(fp);
    skaicius = atoi(number);
    numberofsimbols = strlen(number);
    temp = numberofsimbols;
    for( int i = 0; i < temp; i ++)
    {
        if (number[i] == ',')
        {
            numberofsimbols = numberofsimbols - 1 - i;
            numbersaftercomma = temp - 1 - i;
        }
    }
    if ( skaicius > 10 && skaicius < 1000 && numbersaftercomma <= 3 )
    {
     printf("%d" , (numberofsimbols+numbersaftercomma+1));
    }
    else
    {
        printf("ivestas nekorektiskas skaicius prasome pakeisti informacija" );
    }
        return(0);
}
