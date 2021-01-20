
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class level extends Actor
{
    static int level = 1;
    player player = new player ();
    enemy enemy4 = new enemy(); // pilkas
    enemy enemy5 = new enemy();// pilkas
    enemy1 enemy1 = new enemy1(); // melynas
    enemy1 enemy2  = new enemy1(); // melynas
    enemy2 enemy3 = new enemy2(); // violetinis
    enemy3 enemy6 = new enemy3(); // suo
    enemy3 enemy7 = new enemy3(); // suo 
    static boolean levelInProgress = false;
    /**
     * Act - do whatever the level wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        levels();
        setImage(new GreenfootImage("LEVEL : " + level, 30,Color.GREEN, Color.RED));
    } 
    public void levels()
    {
        if (!levelInProgress)
        switch(level)
        {
            case 1:
            getWorld().addObject(enemy1,   100, 250);
            getWorld().addObject(enemy2,   400, 250); 
            levelInProgress = true;
            priesai.balls = 2;
            break;
            case 2:
            getWorld().addObject(enemy1,   100, 250); 
            getWorld().addObject(enemy2,   700, 250);
            getWorld().addObject(enemy3,   400, 250);
            levelInProgress = true;
            priesai.balls = 3;
            break;
            case 3:
            getWorld().addObject(enemy1,   100, 250); 
            getWorld().addObject(enemy2,   700, 250);
            getWorld().addObject(enemy3,   400, 250);
            getWorld().addObject(enemy4,   250, 250);
            levelInProgress = true;
            priesai.balls = 4;
            break;
            case 4:
            getWorld().addObject(enemy4,   100, 250); 
            getWorld().addObject(enemy5,   700, 250);
            levelInProgress = true;
            priesai.balls = 2;
            break;
            case 5:
            getWorld().addObject(enemy6,   100, 250); 
            levelInProgress = true;
            priesai.balls = 1;
            break;
            case 6:
            getWorld().addObject(enemy6,   822, 250);
            getWorld().addObject(enemy1,   700, 250);
            getWorld().addObject(enemy2,   100, 250);
            levelInProgress = true;
            priesai.balls = 3;
            break;
            case 7:
            getWorld().addObject(enemy6,   265, 250); 
            getWorld().addObject(enemy7,   343, 250);
            getWorld().addObject(enemy5,   692, 250); 
            levelInProgress = true;
            priesai.balls = 3;
            break;
            case 8 : 
            getWorld().addObject(enemy6,   700, 250); 
            getWorld().addObject(enemy7,   300, 250);
            getWorld().addObject(enemy5,   500, 250); 
            getWorld().addObject(enemy4,   100, 250);
            levelInProgress = true;
            priesai.balls = 3;
            break;
        }
        else if ( priesai.balls <=0 && levelInProgress ) 
        {
            level = level+ 1;
            levelInProgress = false;
        }
        
    }
}
