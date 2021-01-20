#include <stdio.h>
#include <stdlib.h>

long getFileSize(char *fileName)
{
    FILE *fp = fopen(fileName,"r");
    fseek(fp,0, SEEK_END);
    return ftell(fp);
    fclose(fp);

}
int main()
{
    printf("this program gets size of file, if something goes wrong it returns -1 \n");
    printf("file size is %ld if size is -1 error reading it or another error", getFileSize("labas.txt"));
    return 0;
}
