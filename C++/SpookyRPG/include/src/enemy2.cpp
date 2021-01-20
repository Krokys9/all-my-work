#include <SDL.h>
#include <iostream>
#include <vector>
#define fps 60
#include "Sprite.h"
#include "Sprite_group.h"
#include "images.h"
#include "button.h"
#include "voids and functions.h"
#include "Champion.h"
#include "Player.h"
#include <time.h>
#include <string>
#include "enemy2.h"
using namespace std;
enemy2 :: enemy2(int att, int hp, string nam) : champion(hp, att, nam)
{
}
void enemy2 :: print()
{
     cout << " enemy tas kuris asdasfa   ";
}
