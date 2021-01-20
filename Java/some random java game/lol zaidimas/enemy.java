import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy extends priesai
{
    private double GRAVITY = 1;
    public enemy() 
    {
        velocity = -12;
        constuctorSubsForBlue();
    }
    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       ballsMovement();
       Actor bullet;
       Actor roof;
       enemy1 enemyBlue = new enemy1();
       enemy1 enemyBlue1 = new enemy1();
       bullet = getOneObjectAtOffset(0,0,bullet.class);
       roof = getOneObjectAtOffset(100,100,roof.class);
       if(bullet != null)
       {
           World detect;
           detect = getWorld();
           detect.addObject(enemyBlue,this.getX(), this.getY());
           detect.addObject(enemyBlue1,this.getX(), this.getY());
           priesai.balls =priesai.balls +1;
           detect.removeObject(bullet);
           detect.removeObject(this);
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
