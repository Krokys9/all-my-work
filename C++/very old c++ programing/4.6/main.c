#include <stdio.h>
#include <stdlib.h>

int main()
{
    float number;
    float max = 0;
    scanf("%f", &number);
    max = number;
    // while(1)
     do
    //for ( int i = 0; i < 1; i)
    {
        scanf("%f", &number);

        if (max < number)
        {
            max = number;
        }
        if (number<=0)
        {
            break;
        }
    }
    while(1);
    printf("%f", max);
    return 0;
}
