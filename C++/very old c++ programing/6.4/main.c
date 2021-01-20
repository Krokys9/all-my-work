#include <stdio.h>
#include <stdlib.h>
#define CAPACITY 256

int wday( int year, int  month, int day)
{
 int t[CAPACITY] = {0, 3, 2, 5, 0,3 , 5 , 1 , 4 , 6 , 2 , 4  };
 year -= month < 3;
 return (year + year/4 - year/100 + year/400 + t[month-1] + day)%7;

}
int main()
{
    FILE *fp = fopen("week.txt", "r");
    char Date[35]= {0};
    char year[5] = {0};
    char day[3]= {0};
    char month[3]= {0};
    printf("iveskite data, ir si programa ismes kelintadienis yra ta diena. \n");
    scanf("%s", Date);
    for (int i = 0 ; i <4; i ++)
    {
        year[i] = Date[i];
    }
    for (int i = 5; i < 7; i ++)
    {
        month[i-5] = Date[i];
    }
    for (int i = 8 ; i < 10; i++)
    {
        day[i-8] = Date[i];
    }
     puts(year);
    puts(month);
    puts(day);
    printf("%d", wday(atoi(year), atoi(month), atoi(day)));
    fgets()
    return 0;
}
