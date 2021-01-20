#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a , b , c;
    int x, y, temp;
    scanf("%d %d %d", &a, &b, &c);
    y = b;
    x= a+b;
    for (int i = 2; i < c; i ++)
    {
        temp = y;
        y = x;
        x = y+temp;
    }

    printf("%d", x);
    return 0;
}
