#ifndef SPRITE_GROUP_H_INCLUDED
#define SPRITE_GROUP_H_INCLUDED
#include <SDL.h>
#include <iostream>
#include <vector>
#define fps 60
#include "Sprite.h"

class SpriteGroup
{
private:
    std :: vector <Sprite*> sprites;
    int Sprites_size;
public:
    SpriteGroup copy();
    void add(Sprite *sprite );
    void remove(Sprite sprite_object);
    bool has (Sprite sprite_object);
    void update();
    void draw(SDL_Surface *destination);
    void empty();
    int size();
    std :: vector <Sprite*> get_sprites();
};
#endif // SPRITE_GROUP_H_INCLUDED
