#include <SDL.h>
#include <iostream>
#include <vector>
#define fps 60
#include "Sprite.h"

Sprite :: Sprite(Uint32 color, int x, int y, int w, int h)
{
    image = SDL_CreateRGBSurface(0, w, h, 32, 0,0,0,0);
    SDL_FillRect (image, NULL, color);
    rect = image->clip_rect;
    origin_x = 0;
    origin_y = 0;
    rect.x= x;
    rect.y= y;
}
void Sprite ::  draw(SDL_Surface *destination)
{
    SDL_BlitSurface( image, NULL, destination, &rect);
}
SDL_Surface* Sprite :: get_image() const
{
    return image;
}
bool Sprite :: operator == (const Sprite &other) const
{
    return (image == other.get_image());
}
void Sprite :: update()
{

}
