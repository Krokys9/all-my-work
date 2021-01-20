#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n;
    float sum = 0, average = 0;
    float max, min;
    scanf("%d", &n);
    float numbers[n];
    for ( int i = 0; i <n; i++)
    {
        scanf("%f", &numbers[i]);
        sum += numbers[i];
        if ( numbers[i-1] < numbers[i] && i != 0)
        {
            max = numbers[i];
        }
        if ( numbers[i-1] < numbers[i] && i != 0)
        {
            min = numbers[i-1];
        }

    }
    average = sum /n;
    printf ("%f        " "%f      " "%f   "" %f ", sum, average, max, min);
    return 0;
}
