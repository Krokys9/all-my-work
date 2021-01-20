#ifndef SPRITE_H_INCLUDED
#define SPRITE_H_INCLUDED
#include <SDL.h>
#include <iostream>
#include <vector>
#define fps 60


class Sprite
{
protected:
    SDL_Surface *image;
    SDL_Rect rect;

    int origin_x, origin_y;
public:
        Sprite(Uint32 color, int x, int y, int w , int h);
    void draw(SDL_Surface *destination);
    SDL_Surface* get_image() const;
    bool operator == (const Sprite &other) const;
    void update();

};

#endif // SPRITE_H_INCLUDED
