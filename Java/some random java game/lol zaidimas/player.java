import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    static int speed = 3;
    private int maxBullets = 0;
    private bullet gunFire = new bullet();
    static int max = 0;
    static int score = 0;
    static int health = 5;
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        player player = new player();
        if(Greenfoot.isKeyDown("D"))
        {
            move(speed);
        }
        if(Greenfoot.isKeyDown("A"))
        {
            move(-speed);
        }
        if (Greenfoot.isKeyDown("Space"))
        {
            fire();

        }
               Actor priesai;
       priesai = getOneObjectAtOffset(0,0,priesai.class);
       if(priesai != null)
       {
           health -=1;
           if ( health >= 0)
           {
           getWorld().addObject(player, 436,504);
        }
        else if(health == -1)
        {
            level.level = 1; 
            player.score = 0;
            level.levelInProgress = false;
            player.health = 5;
            getWorld().addObject(player, 436,504);
        }
           World detect;
           detect = getWorld();
           detect.removeObject(this);
           player.max--;
           

        }

    } 
          private void fire ()
        {
            
            if (!bulletsLimitReached())
            {
            getWorld().addObject(gunFire, getX(), getY());
            player.max +=1;
        }
            
            
        }
        private boolean bulletsLimitReached()
        {
            if (player.max <1)
           return false; 
           else
           return true;
        }
        int health()
        {
            return this.health;
        }

}
