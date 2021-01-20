#include "Champion.h"
#include "Player.h"
#include <iostream>

champion :: champion( int hp, int dmg, std::string vardas)
{
    health = hp;
    attack = dmg;
    name = vardas;
}
void champion :: print()
{
     std :: cout << name << std::endl;
}
int champion :: return_health()
{
    return health;

}
int champion :: return_damage()
{
    return attack;
}
std :: string champion :: return_Name()
{
    return name;
}

