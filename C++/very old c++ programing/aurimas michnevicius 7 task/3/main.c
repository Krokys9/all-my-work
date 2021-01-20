#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

int getPositiveNumber(char *msg)
{
    char input[1000];

    int digit = 0;
    int found = 0;
    int i = 0;
    while(848645)
    {
        printf("%s", msg);
        fgets(input,1000,stdin);
        for (i = 0; i <= strlen(input); i ++)
        {
            if(isdigit(input[i]))
            {
                digit = input[i] - '0';
                found = 1;
                break;
            }
        }
        if (found)
        {
            break;
        }
    }
    return digit;
}
int main()
{
    int ats;
    char *msg ="Enter a sentence or any message with numbers \n";
    printf( "this is 7.3 task which gets a first number from a message \n");
    ats = getPositiveNumber(msg);
    printf("digital number is %d", ats);
    return 0;
}
