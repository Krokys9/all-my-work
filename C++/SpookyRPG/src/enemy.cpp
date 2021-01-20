#include <iostream>
#include "Champion.h"
#include "Player.h"
#include <time.h>
#include <string>
#include <stdlib.h>
#include "enemy.h"
using namespace std;
enemy :: enemy(int att, int hp, string nam) : champion(hp, att, nam)
{
}
void enemy :: print()
{
     cout << " tavo priesas tADASWD";
}
