#ifndef CHAMPION_H_INCLUDED
#define CHAMPION_H_INCLUDED
#include <iostream>
class champion
{
private:
    int health;
    int attack;
    std::string name;

public:
    champion(int hp, int dmg, std::string vardas);
    void print();
    void sethealth(int hp);
    void setattack(int att);
    int return_health();
    int return_damage();
    void setname(std:: string nam);
    std :: string return_Name();
};


#endif // CHAMPION_H_INCLUDED
