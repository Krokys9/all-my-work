import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy2 extends priesai
{
    private double GRAVITY = 1.5;
     enemy2()
    {
        velocity = -12;
        constuctorSubsForBlue();
        
    }
    /**
     * Act - do whatever the enemy2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
     
        // Add your action code here.

               ballsMovement();
       Actor bullet;
       bullet = getOneObjectAtOffset(0,0,bullet.class);
               Actor roof;
        roof = getOneObjectAtOffset(100,100,roof.class);
                if (roof != null)
    {
       
        getWorld().removeObject(this);
        
    }
       if(bullet != null)
       {
           World detect;
           detect = getWorld();
           detect.removeObject(bullet);
           detect.removeObject(this);
           priesai.balls =priesai.balls -1;
           player.max--;
           player.score++;
           
        }
    }
            public void fall()
    {
        setLocation(getX(), getY() + (int)velocity);
        if (getY() > getWorld().getHeight()-50)
        {
            velocity = 0;
        }
        else
        {
            this.velocity += this.GRAVITY;
        }
    
    }
    public void jump()
    {
        this.velocity = -20;
    }
    public void ballsMovement()
    {
    fall();
    if (isOnSolidGround()) jump();
    
    if (getX() >= getWorld().getWidth ()-30 || getX() <= 30){
      speed = speed * -1;
    }
   
    move (speed);
           Actor bullet;
       bullet = getOneObjectAtOffset(0,0,bullet.class);
    }
}
