#ifndef PLAYER_H_INCLUDED
#define PLAYER_H_INCLUDED
#include <iostream>
#include "Champion.h"
class player
{
private:
    champion User;
    struct properties {
    std :: string item_name; /// still unused;
    int item_type;
    /*
    1- Attack weapon.
    2- Suit
    3- Helmet
    4- Boots
    */
    int item_properties;
    // Damage or Defense
    };

public:
    player(champion bo);
    void Equip_Arrmor( int type , int prop);
    void printinfo();
    int return_damage();
    int return_health();
    std :: string return_Name();
};


#endif // PLAYER_H_INCLUDED
