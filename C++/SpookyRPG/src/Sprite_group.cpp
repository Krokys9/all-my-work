#include <SDL.h>
#include <iostream>
#include <vector>
#define fps 60
#include "Sprite.h"
#include "Sprite_group.h"
    SpriteGroup SpriteGroup ::  copy()
    {
        SpriteGroup new_group;

        for (int i = 0; i < Sprites_size; i++)
       {
            new_group.add(sprites[i]);
       }
        return new_group;
    }
    void SpriteGroup:: add(Sprite *sprite )
    {
        sprites.push_back(sprite);
        Sprites_size = sprites.size();
    }
void SpriteGroup:: remove(Sprite sprite_object)
    {
        for (int i = 0 ; i < Sprites_size ; i++)
        {
            if (*sprites[i] == sprite_object)
            {
                sprites.erase(sprites.begin()+i);
            }
        }
        Sprites_size = sprites.size();
    }
    bool SpriteGroup:: has (Sprite sprite_object)
    {

    }
    void  SpriteGroup:: update()
    {
        if(!sprites.empty())
        {

            for (int i = 0 ; i < Sprites_size ; i++)
            {
                sprites[i]-> update();
            }
        }
    }

    void SpriteGroup:: draw(SDL_Surface *destination)
    {
        if(!sprites.empty())
        {

            for (int i = 0 ; i < Sprites_size ; i++)
            {
                sprites[i] -> draw(destination);
            }
        }
    }
    void SpriteGroup:: empty()
    {
        sprites.clear();
        Sprites_size = sprites.size();
    }
    int SpriteGroup:: size()
    {
        return Sprites_size;

    }
    std:: vector<Sprite*> SpriteGroup:: get_sprites()
    {
        return sprites;
    }
