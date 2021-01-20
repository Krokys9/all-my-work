import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class priesai here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class priesai extends Actor
{
  protected final double GRAVITY = 0.6;
   protected double velocity;
    protected  int speed = 2;
    private int x;
    private int y;
    static int blueCount = 1;
    static boolean blueMovement = true;
    static int balls = 0;
    private boolean EndRound =false;
    
    enemy1 blueBall;
    
    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    
    }    

    public boolean isOnSolidGround()
    {
        boolean isOnGround = false;
        if(getY() > getWorld().getHeight()-50) isOnGround = true;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if(getOneObjectAtOffset(imageWidth / -2, imageHeight/2, Platform.class) != null ||
        getOneObjectAtOffset(imageWidth / 2, imageHeight/2, Platform.class) != null)
       {
        isOnGround = true;
    }
        return isOnGround;
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
    void constuctorSubsForBlue()
    {
        if ( priesai.blueMovement)
        {
            priesai.blueMovement = false;

        }
        else
        {
            priesai.blueMovement = true;
            speed = speed * -1;
        }
    }

}
