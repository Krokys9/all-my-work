import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class healthText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class healthText extends Actor
{
    /**
     * Act - do whatever the healthText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Health:  " + player.health, 30,Color.GREEN, Color.RED));
    }    
}
