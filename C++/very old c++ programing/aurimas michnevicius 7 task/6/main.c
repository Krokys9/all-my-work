#include <stdio.h>
#include <stdlib.h>
int showMenu(char *menuTitle, char *menuOptions[], int menuSize, char *inputMsg)
{
    printf("%s", menuTitle);
    while(1)
    {
        int temp;
        int option;
        for(int i = 0; i < menuSize; i ++)
        {
            printf(" %s\n", menuOptions[i]);
        }
        printf("%s\n", inputMsg);
        if ((scanf("%d", &temp) == 1) &&  (getchar() == '\n') && temp < menuSize && temp >= 0)
        {
            return temp;
        }

    }
}
int main()
{
    char *menuTitle = " This is the title of menu\n";
    char *menuOptions[4] = {"labai gerai", "gerai", "blogai", "labai blogai"};
    int menuSize = 4;
    char *inputMsg = "please select section where you want to go or what to do.\n";
    printf("%d\n", showMenu(menuTitle, menuOptions, menuSize, inputMsg));
    return 0;
}
