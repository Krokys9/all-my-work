#include <stdio.h>
#include <stdlib.h>

int main()
{
    int  a, b, c;
    int CorrectNumber;

    scanf("%d%d%d" , &a, &b, &c);
    for (int i = a; i <= b; i++)
    {
       if ((i - 1)%c ==  0)
       {
           printf("%d ",i);
       }
    }
    return 0;
}
