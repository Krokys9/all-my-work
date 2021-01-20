#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a , b , c;
    int DBD = 1, temp = 0;
    int MBK = 1, temp1 = 0;
    int laikinas;
    scanf("%d %d %d", &a, &b, &c);
    for (int i = 0; i <= a; i ++)
    {
        temp ++;
        if (a%temp == 0 && b%temp == 0 && c%temp ==0 )
        {
            DBD = DBD * temp;
            a = a/temp;
            b = b/temp;
            c = c/temp;
        }


    }
    laikinas = a*DBD;
    while(1)
    {
        laikinas += a*DBD;
        if ((laikinas % (b*DBD)) == 0 && (laikinas % (c*DBD)) == 0)
        {
            MBK = laikinas;
            break;
        }
    }
    printf("%d" "   %d", DBD, MBK);
    return 0;
}
