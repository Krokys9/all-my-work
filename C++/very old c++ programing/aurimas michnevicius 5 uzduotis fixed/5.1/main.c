#include <stdio.h>
#include <stdlib.h>

int main()
{
    int mas[10]= {0,0,0,0,0,0,0,0,0,0};
    mas[0]= 1;
    mas[3] = 2;
    mas[9] = 3;
    int x, y;
    for (int i = 2; i < 9; i++)
    {
        mas[i] = mas[i+1];
    }
    mas[6] = 4;
    printf("\n");
    printf("iveskite du skaicius kuri elementa pakeisti ir kokia reiksme priskirti 0 <= x <= 9 \n");
    scanf("%d %d", &x,&y);
    mas[x] = y;
    printf("\n");
    printf("iveskite i kuri elementa norite iterpti ir kokia reiksme \n");
    scanf("%d %d", &x, &y);
    for (int i = 8; i > x ; i--)
    {
        mas[i+1] = mas[i];
    }
    mas[x]= y;
    for (int i = 0; i <=9; i++)
    {
        printf("%d ; ", mas[i]);
    }
    printf("\n");
    return 0;
}
