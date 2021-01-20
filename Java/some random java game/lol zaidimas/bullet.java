import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bullet extends Actor
{
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
  
    public void act() 

    {
        setLocation(getX(), getY() - 10);
        bulletHitTop();
        
    }    
        private void bulletHitTop()
        {
            if(hitWall())
            {
               getWorld().removeObject(this);
               player.max -=1;
            }
            
        }
        private boolean hitWall()
        {
            if (getY() < 10) 
            {
                return true;
            }
            else return false;
        }
}

