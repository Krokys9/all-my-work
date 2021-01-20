import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class timebar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class timebar extends Actor
{
    /**
     * Act - do whatever the timebar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     GreenfootImage image = getImage();
    public void act() 
    {
        if ( image.getWidth() >= 100 && level.levelInProgress)
        {
        image.scale(image.getWidth() - 1, image.getHeight());
        setImage(image);
    }
    else { 
        image.scale(1000,image.getHeight());
    }
    }    
}
