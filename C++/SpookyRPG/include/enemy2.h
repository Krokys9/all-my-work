#ifndef ENEMY2_H_INCLUDED
#define ENEMY2_H_INCLUDED
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

class enemy2 : public champion
{
private:
    int health;
public:
enemy2(int att, int hp,  char *nam);

void  print();

};

#endif // ENEMY2_H_INCLUDED
