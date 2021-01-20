#include <stdio.h>
#include <stdlib.h>

int biggestFile(int argc, char *argv[])
{
    int max_index = 1;
    int  max_filelong = 0;
    long temp;
    for(int i = 1; i < argc; i ++)
    {
    FILE *fp = fopen(argv[i],"rb");
    fseek(fp,0, SEEK_END);
    temp = ftell(fp);
        if(max_filelong < temp)
           {
               max_filelong = temp;
               max_index = i;
           }
           fflush(fp);
           fclose(fp);
    }
    return max_index;
}
int main(int argc, char *argv[])
{
    int max_index=biggestFile(argc,argv);
    printf("The biggest file is %s",argv[max_index]);
    return 0;
}

