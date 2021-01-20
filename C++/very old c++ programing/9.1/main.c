#include <stdio.h>
#include <stdlib.h>
#include <math.h>
typedef struct point
{
    double x;
    double y;
} point;
void printpoint(point p)
{
    printf("(%0.1f   %0.1f) \n", p.x, p.y);
}
point createPoint(double x, double y)
{
    point ats;
    ats.x = x;
    ats.y = y;
    return ats;
}
double getDistance(point a, point b)
{
    return sqrt(((-(pow(a.x,2)))+pow(b.x,2)+(pow(b.y,2)-(pow(a.y,2)))));
}
int main()
{
    printpoint(createPoint(2.0, -3.0));
    printpoint(createPoint(-4.0, 5.0));
    getDistance(createPoint(2.0, -3.0),createPoint(-4.0, 5.0));
    return 0;
}

