#include <iostream>
#include "Player.h"
#include "Champion.h"
player :: player(int hp, int dmg, char* vardas) : champion(hp,dmg,vardas)
{
    // tures lygi;
}
void player:: printinfo()
{
      champion :: print();

}
int player::  return_health()
{
      std :: cout << "zaidejo gyvybes ";
    return champion :: return_health();


}
int player::  return_damage()
{
    return champion :: return_damage();
}
std :: string player :: return_Name()
{
    return champion :: return_Name();
}
