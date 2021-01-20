#include <iostream>
#include "Champion.h"
#include "Player.h"
#include "voids and functions.h"
#include <time.h>
#include <string>
#include <stdlib.h>
using namespace std;
void wait ( int seconds )
{
  clock_t endwait;
  endwait = clock () + seconds * CLOCKS_PER_SEC ;
  while (clock() < endwait) {}
}
void printresult(int health, int damageDealt, string name)
{
cout << name << " Took " << damageDealt << " and now has " << health <<" health"<<  endl;
}

fightprops fight(player var, champion vari, int difficulity, SDL_Surface *background, SDL_Window*  wnd)
{

    VariablesForFight ChangeNameAfter;
    ChangeNameAfter.hpE = vari.return_health();
    ChangeNameAfter.hpP = var.return_health();
    images priesas(0,800,400,0,0);
    images zaidejas(0,100,200,0,0);
    zaidejas.set_image("nasus.bmp");
    priesas.set_image("flee.bmp");
    zaidejas.draw(background);
    priesas.draw(background);
    SDL_UpdateWindowSurface(wnd);
    bool fight = true;
    fightprops to_return;
    to_return.victory = true;
    to_return.Difficulity = difficulity;
    while (fight)
    {
        ChangeNameAfter.hpE = ChangeNameAfter.hpE - var.return_damage();
        printresult(ChangeNameAfter.hpE, vari.return_damage(), vari.return_Name());
        if ( ChangeNameAfter.hpE <= 0 )
        {
            fight = false;
        }
        ChangeNameAfter.hpP = ChangeNameAfter.hpP - vari.return_damage();
        printresult(ChangeNameAfter.hpP, var.return_damage(), var.return_Name());
        if (ChangeNameAfter.hpP <= 0 )
        {
            fight = false;
            to_return.victory = false;
        }
    }
    if (to_return.victory)
    {
        cout << " Victory !!" << endl;
    }
    else
    {
        cout << " Defeat" << endl;
    }
    return to_return;
}
