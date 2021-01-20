#ifndef HEADER_FILE
#define HEADER_FILE
int saveCount;
int loadCount;
void saveToFile( int *mas, int sizeo, char *filename);
int* loadFromFile(char *filename);

#endif
