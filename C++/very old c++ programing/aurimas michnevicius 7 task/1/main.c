#include <stdio.h>
#include <stdlib.h>
int isInRange(int number, int low, int high)
{
    int a = 1;
    int b = 0;
    if ( low <= high)
    {
        if(number >= low && number <= high)
        {
            return a;
        }
        else
        {

        return b;
        }
    }
    else
    {
        return b;
    }
}
int main()
{
    int number = 10, low = 15, high = 30;
    printf("%d\n", isInRange(number, low, high));
    if (isInRange(number, low, high))
    {
        printf("true");
    }
    else
    printf("false");
    return 0;
}
