#include <iostream>
#include "Player.h"
#include "Champion.h"
player :: player(champion bo)
: User(bo)
{
    User = bo;
}
void player:: printinfo()
{
       User.print();

}
int player::  return_health()
{
    return User.return_health();

}
int player::  return_damage()
{
    return User.return_damage();
}
std :: string player :: return_Name()
{
    return User.return_Name();
}
