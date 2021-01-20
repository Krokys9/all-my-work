#include <iostream>
#include <string>
#define maximum 100
#include "Untitled1.h"
using namespace std;

string sum( string num1, string num2)
{
    int convert[100]= {0};
    int convert2[100]= {0};
    int sum[101]= {0};
    int maxL = 0;
    int remeber = 0;
    int push = 0 ;
    string ToReturn;
    int start = 0;
    for(int i = 0 ; i < num1.length(); i ++)
    {
        convert[i] = num1[num1.length()-1-i]-'0';
    }
    for(int i = 0; i < num2.length(); i++)
    {
        convert2[i] = num2[num2.length()-1-i]-'0';
    }
    if (num1.length() > num2.length() )
    {
        maxL = num1.length();
    }
    else
    {
        maxL = num2.length();
    }
    for ( int i = 0; i < maxL; i ++ )
    {
        sum[i] = (convert[i] + convert2[i] + remeber)%10;
        if (convert[i] + convert2[i] + remeber >=10)
        {
            remeber = 1;

        }
        else
        {
            remeber = 0;
        }

    }

    if(remeber == 1)
    {
        sum[maxL] = remeber;
        cout << sum[maxL];
        maxL ++;
    }
    if ( sum[maxL] != 0)
    {
        start =1;
    }
    for ( int i = 0 ; i < maxL; i ++)
    {
        if(sum[maxL-i-1] != 0 || start==1)
        {
        ToReturn += sum[maxL-i-1] + '0';
        start = 1 ;
        }
    }
    return ToReturn;
}
string sub ( string num1, string num2)
{
    int convert[100]= {0};
    int convert2[100]= {0};
    int sum[101]= {0};
    int maxL = 0;
    int remeber = 0;
    string ToReturn;
    int start = 0;
    for(int i = 0 ; i < num1.length(); i ++)
    {
        convert[i] = num1[num1.length()-1-i]-'0';
    }
    for(int i = 0; i < num2.length(); i++)
    {
        convert2[i] = num2[num2.length()-1-i]-'0';
    }
    if (num1.length() > num2.length() )
    {
        maxL = num1.length();
    }
    else
    {
        maxL = num2.length();
    }
    for ( int i = 0; i < maxL; i ++ )
    {
        sum[i] = (convert[i] - convert2[i] + remeber)%10;
        if (convert[i] - convert2[i] + remeber < 0 )
        {
            remeber = 10;
            convert[i+1] --;
            i --;

        }
        else
        {
            remeber = 0;
        }

    }

    for ( int i = 0 ; i < maxL; i ++)
    {
        if(sum[maxL-i-1] != 0 || start==1)
        {
        ToReturn += sum[maxL-i-1] + '0';
        start =1;
        }
    }
    return ToReturn;
}
string multi ( std::string num1, string num2) /// NOT FINISHED
{
    int convert[100]= {0};
    int convert2[100]= {0};
    int sum[101]= {0};
    int maxL = 0;
    int remeber = 0;
    string ToReturn;
    int start = 0;
    for(int i = 0 ; i < num1.length(); i ++)
    {
        convert[i] = num1[num1.length()-1-i]-'0';
    }
    for(int i = 0; i < num2.length(); i++)
    {
        convert2[i] = num2[num2.length()-1-i]-'0';
    }
    if (num1.length() > num2.length() )
    {
        maxL = num1.length();
    }
    else
    {
        maxL = num2.length();
    }
    /*      111
           x 11
            ___
            111
           +
           111
           ____
           1221
*/


}
