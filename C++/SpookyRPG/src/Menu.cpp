#include <SDL.h>
#include <iostream>
#include "Menu.h"
using namespace std;

menu :: menu() : picture_of_menu(0, 0,0,500,500)
{
    picture_of_menu.set_image("download.bmp");
}
void menu :: draw (SDL_Surface *screen)
{
    picture_of_menu.draw(screen);
}
void menu :: quit_screen()
{

}
