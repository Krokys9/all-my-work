#include <stdio.h>
#include <stdlib.h>

int main()
{
    char number[1000];
    char number1[100] = {0}, number2[100] = {0}, number3[100] = {0};
    int temporyforconverting = 0;
    int n;
    int  firstnumberlenght, index1, thirdnumberlenght, secondnumberlenght = 1, temp, index2, index3;
    int firstnumber, secondnumber, thirdnumber;
    FILE *fp = fopen("hey.txt", "w");
    printf("iveskite trys skaicius kurios skyria kabletaskiai\n");
    scanf("%s", number);
    temp = strlen(number);
    for (int i = 0 ; i < temp; i ++)
        if (number[i] == ';')
        {
            firstnumberlenght = i;
            index1 = 0;
            break;
        }
    for (int i = firstnumberlenght+1 ; i < temp; i ++)
        if (number[i] == ';')
        {
            thirdnumberlenght = temp - i - 1;
            index3 = i+1 ;
        }
    for (int i = firstnumberlenght+1; i < index3-1; i++)
    {
        secondnumberlenght ++;
        index2 = firstnumberlenght + 2;

    }
    for ( int i = index1 ; i < (index1 + firstnumberlenght) ; i ++)
    {
        number1[i] = number[i];
    }
    n = index2 + secondnumberlenght;
    for ( int i = index2-1 ; i < n-2 ; i ++)
    {
        number2[temporyforconverting] = number[i];
        temporyforconverting ++;
    }
    temporyforconverting = 0;
    for ( int i  = index3 ; i < (index3+thirdnumberlenght) ; i ++)
    {
        number3[temporyforconverting] = number[i];
        temporyforconverting++;
    }

    firstnumber = atoi(number1);
    secondnumber = atoi(number2);
    thirdnumber = atoi(number3);
    if ( firstnumber > secondnumber && firstnumber > thirdnumber)
    {
        fputs(number1, fp);
    }
    else if ( secondnumber > thirdnumber)
    {
        fputs(number2, fp);

    }
    else if (thirdnumber > secondnumber)
    {
        fputs(number3, fp);
    }
    else
    {
        fputs("visi lygus", fp);
    }
    fclose(fp);
    return 0;
}
