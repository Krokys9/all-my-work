#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a, b, c;
    int diskrim;
    double x1 = 0, x2 = 0;
    scanf("%d""%d""%d", &a, &b, &c);
    diskrim = sqrt(pow(b,2)-(4*a*c));
    if(diskrim == 0)
    {
        x1 = (((-1)*b))/((2*a));
        printf("%f", x1);
    }
    else if(diskrim>0)
    {
        x1 = (((-1)*b)+diskrim)/(2*a);
        x2 = (((-1)*b)-diskrim)/(2*a);
        printf("%f %f", x1, x2);

    }
    else {
        printf("nera sprendiniu");
    }


    return 0;
}
