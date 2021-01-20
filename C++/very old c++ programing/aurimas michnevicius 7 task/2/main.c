#include <stdio.h>
#include <stdlib.h>

int factorial(int number)
{
    int factorialvalue = 1;
    if (number > 0 )

    if (number > 0)
    {
        for (int i = 1; i <= number; i++)
        {
            factorialvalue *=i;
        }
        if (factorialvalue > 0)
        {

            return factorialvalue;
        }
        else
        {
            return 0;
        }
    }

else
{
    return 0;
}

}
int main()
{
    printf("%d", factorial(8));
    return 0;
}
