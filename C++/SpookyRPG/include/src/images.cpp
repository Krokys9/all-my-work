#include <SDL.h>
#include <iostream>
#include <vector>
#define fps 60
#include "Sprite.h"
#include "Sprite_group.h"
#include "images.h"

   images :: images (Uint32 color, int x, int y, int w , int h):
        Sprite :: Sprite(color, x, y, w,h )
    {
        update_properties();

    }

    void images:: update_properties()
    {
        origin_x =0;
        origin_y = 0;
        set_position(rect.x, rect.y);
    }
    void images::set_position(int x, int y)
    {
        rect.x = x - origin_x;
        rect.y = y - origin_y;

    }

    void images:: set_image(const char filename[])
    {
        if(filename != NULL)
        {
            SDL_Surface * loaded_image = NULL;
            loaded_image = SDL_LoadBMP(filename);
            if(loaded_image != NULL)
            {
                image = loaded_image;

                int old_x = rect.x;
                int old_y= rect.y;
                rect = image->clip_rect;
                rect.x = old_x;
                rect.y = old_y;
                update_properties();
            }
        }
    }
