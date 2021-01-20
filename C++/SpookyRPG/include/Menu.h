#ifndef MENU_H_INCLUDED
#define MENU_H_INCLUDED
#include <SDL.h>
#include <iostream>
#include <vector>
#define fps 60
#include "Sprite.h"
#include "Sprite_group.h"
#include "images.h"
#include "button.h"
#include "voids and functions.h"
#include "enemy.h"
#include "Champion.h"
#include "Player.h"
#include <time.h>
#include <string>

class menu
{
private:
    images picture_of_menu;
public :
    menu();
    void draw (SDL_Surface *screen);
    void quit_screen();
};
#endif // MENU_H_INCLUDED
