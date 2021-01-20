#include <stdio.h>
#include <stdlib.h>
#include "file.h"
int saveCount = 0;
int loadCount = 0;

void saveToFile(int *mas, int sizeo, char *filename)
{
    saveCount++;
    FILE *fp = fopen(filename, "wb");
    fseek(fp, 0, SEEK_SET);
    fwrite(&sizeo, sizeof(int), 1, fp);
    fwrite(mas,sizeof(int), sizeo, fp);
    fclose(fp);
    fflush(fp);

}
int* loadFromFile (char *filename)
{
    loadCount ++;
    FILE *fp = fopen(filename, "rb");
    fseek(fp, 0, SEEK_SET);
    int size, *mas;
    fread(&size, sizeof(int), 1, fp);
    mas = malloc(sizeof(int)*(size+1));
    fread(mas, sizeof(int), size, fp);
    fclose(fp);
    fflush(fp);

    return mas;
}
