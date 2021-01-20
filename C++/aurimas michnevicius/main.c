#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    //first_task();
    //second_task();
    //third_task();
    //fourth_task();
    //fifth_task();
    //sixth_task();
    return 0;
}
int first_task()
{
    printf("%c" "%c" "%c" "%c" "%c" "%c" "%c" "\n" , 65, 85, 82, 73, 77, 65, 83);
    return 0;
}
int second_task()
{
    // a) 183  81bf75  d04ae269
    // b) 1010110100000010 10011111000001001110000100001100  10101001000011000110010100010010111
    // c) 27  148   13013
    // d)100101 11110001 100110110111
    // e) 1762  60723  1193046
    // f) f3  9b3  1204
    return 0;
}
int third_task()
{
    printf ("%x  " "%x  " "%x  " "\n", 0b110000011, 0b100000011011111101110101, 0b1111010000010010101110001001101001);
    //c)
    printf ("%d  " "%d   " "%d  " "\n", 0b11011, 0b10010100, 0b11001011010101);
    //e
    printf("%d  " "%d  " "%d  " "\n" , 0x6E2, 0xED33, 0x123456);
    //f
    printf("%x  " "%x  " "%x  ""\n", 243, 2483, 4612);
    return 0;
}
int fourth_task()
{
    int a= 0;
    char *c = "labas";
    scanf ("%d",&a);
    c = (a%2==0) ? "lygine" : "nelygine";
    printf("%s ""\n", c);
    return 0;
}
int fifth_task()
{
    double x = 0, z = 0, y = 0;
    scanf("%lf""%lf""%lf", &x, &z, &y);
    printf("%f ""\n", x+4*y+ pow(z,3));
    printf("%f""\n", (x+y)*(pow(z,4) - sqrt(pow(z,2)) +46.3));
    return 0;
}
int sixth_task()
{
    int number1 = 0, number2 = 0, number3 = 0;
    scanf("%d""%d""%d", &number1, &number2, &number3);
    printf ("Maksimali ""%d""  Minimali " "%d""\n",(number1 > number2 && number1 > number3) ? (number1) : (( number2 > number3 ) ? (number2) : (number3)), (number1 < number2 && number1 < number3) ? (number1) : (( number2 < number3 ) ? (number2) : (number3)));

    return 0;
}
