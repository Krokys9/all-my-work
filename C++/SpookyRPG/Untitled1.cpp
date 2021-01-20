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
#include "enemy2.h"
#include "Menu.h"

using namespace std;

int main(int argc, char *argv[])
{
    fightprops Rezultatas;
    menu Mrnu();
    bool open_menu = true;
    SDL_Init(SDL_INIT_EVERYTHING);

    SDL_Window* wnd = SDL_CreateWindow("Mano Zaidimas",
                                       SDL_WINDOWPOS_CENTERED,
                                       SDL_WINDOWPOS_CENTERED,
                                       1200,
                                       900,
                                       SDL_WINDOW_OPENGL);
    bool IQ = true;
    int i =100;
    SDL_Surface *background = SDL_GetWindowSurface(wnd);
    Uint32 white = SDL_MapRGB(background->format, 255, 255, 255 );
    Uint32 red = SDL_MapRGB(background->format, 255, 0, 0 );
    SpriteGroup active_group;
    images background2(white, 0, 0, 0, 0 );
    background2.set_image("images.bmp");
    active_group.add(&background2);
    SDL_FillRect(background, NULL, red);
    images image(white,0,0,0,0);
    image.set_image("download.bmp");
    image.set_position(100,50);
    champion *eminem = new enemy2(100,100,"TADAS");


    player Player(10000, 10, "Gerietis Jonas");;
    champion Player2(10000, 10, "Lukas");
    Player.print();


    active_group.draw(background);
    SDL_UpdateWindowSurface(wnd);
    Uint32 starting_tick;
    bool is_fighting = true;
    while(IQ)
    {

        active_group.draw(background);
        if(open_menu)

        {
            Mrnu.draw(background);
        }
        SDL_UpdateWindowSurface(wnd);
        starting_tick = SDL_GetTicks();
        SDL_Event event;
        while(SDL_PollEvent(&event))

        {

            if(event.type == SDL_QUIT)
            {
                IQ = false;
            }
            else if ( event.type == SDL_KEYDOWN)
            {
                switch(event.key.keysym.sym)
                {
                case SDLK_x:
                    Rezultatas = fight(Player, Player2,0, background, wnd);
                    if ( Rezultatas.victory)
                    {
                        eminem->print();

                        active_group.add(&image);
                        active_group.draw(background);
                        SDL_UpdateWindowSurface(wnd);
                        wait(3);
                        active_group.remove(image);
                        active_group.draw(background);
                        SDL_UpdateWindowSurface(wnd);

                    }

                    break;
                case SDLK_z:
                    open_menu = true;
                    break;
                case SDLK_c:
                    open_menu = false;
                    break;
                }
            }
        }
        if ((1000/fps)> SDL_GetTicks() - starting_tick )
        {
            SDL_Delay(1000/fps- (SDL_GetTicks() - starting_tick));
        }
    }

    SDL_Quit();
}
