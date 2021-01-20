#ifndef IMAGES_H_INCLUDED
#define IMAGES_H_INCLUDED
#include <SDL.h>
#include <iostream>
#include <vector>
#define fps 60
#include "Sprite.h"
#include "Sprite_group.h"
class images: public Sprite
{
    public:
    images(Uint32 color, int x, int y, int w , int h);
     void update_properties();
     void set_position(int x, int y);
     void set_image(const char filename[]);
};


#endif // IMAGES_H_INCLUDED
