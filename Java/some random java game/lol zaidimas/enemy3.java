import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy3 extends priesai
{
        enemy3()
    {
        velocity = -7;
        constuctorSubsForBlue();
        
    }
    /**
     * Act - do whatever the enemy3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

       ballsMovement();
       Actor bullet;
       enemy enemyTwo = new enemy();
       enemy enemyTwo1 = new enemy();
       bullet = getOneObjectAtOffset    (0,0,bullet.class);
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
           detect.addObject(enemyTwo, this.getX(), this.getY());
           detect.addObject(enemyTwo1, this.getX(), this.getY());
           priesai.balls =priesai.balls +1;
           detect.removeObject(bullet);
           detect.removeObject(this);
           player.max--;
           player.score++;
           
        }
    }    
}
