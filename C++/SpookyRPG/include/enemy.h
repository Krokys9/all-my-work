#ifndef ENEMY_H_INCLUDED
#define ENEMY_H_INCLUDED
#include <iostream>
#include "Champion.h"
#include "Player.h"
#include <time.h>
#include <string>
#include <stdlib.h>
class enemy : public champion
{
private:
    int health;
public:
enemy(int att, int hp, std :: string nam);

void  print();

};

#endif // ENEMY_H_INCLUDED
