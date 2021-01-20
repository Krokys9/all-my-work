import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy1 extends priesai
{
    protected final double GRAVITY = 2;
    private boolean uzknisoSitas = true;
    /**
     * Act - do whatever the enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    enemy1()
    {
        velocity = -12;
        constuctorSubsForBlue();
    }
    public void act() 
    {
       ballsMovement();
       Actor bullet;
       bullet = getOneObjectAtOffset(0,0,bullet.class);
             Actor roof;
       roof = getOneObjectAtOffset(100,100,roof.class);
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

               if (roof != null)
    {
       
        getWorld().removeObject(this);
        
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
