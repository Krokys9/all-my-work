#ifndef VOIDS_AND_FUNCTIONS_H_INCLUDED
#define VOIDS_AND_FUNCTIONS_H_INCLUDED
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

struct VariablesForFight
{
    int hpE;
    int hpP;
};
struct fightprops
{
    int Difficulity;
    bool victory;
};
void wait(int seconds);
fightprops fight(player var, champion vari, int difficulity);

#endif // VOIDS_AND_FUNCTIONS_H_INCLUDED
