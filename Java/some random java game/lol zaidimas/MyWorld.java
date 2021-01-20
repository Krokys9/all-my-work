import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{
    static int level = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    GreenfootSound backgroundMusic = new GreenfootSound("D:\\User\\Desktop\\song.mp3");
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 700, 1); 
        backgroundMusic.playLoop();
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        enemy enemy = new enemy();
        addObject(enemy,93,51);
        enemy enemy2 = new enemy();
        addObject(enemy2,496,54);
        Platform platform = new Platform(950, 50);
        addObject(platform,432,611);
        platform.setLocation(470,549);

        enemy2.setLocation(790,77);
        enemy.setLocation(54,69);
        roof roof = new roof();
        addObject(roof,464,81);
        roof.setLocation(426,245);
        roof.setRotation(180);
        roof.setLocation(169,-32);
        roof.setLocation(106,25);
        roof.setLocation(97,4);
        roof.setLocation(196,28);
        roof roof2 = new roof();
        addObject(roof2,363,22);
        roof2.setRotation(180);
        roof2.setLocation(342,52);
        roof roof3 = new roof();
        addObject(roof3,589,42);
        roof3.setRotation(180);
        roof3.setLocation(566,25);
        roof2.setLocation(346,23);
        roof3.setLocation(568,4);
        enemy2.setLocation(785,61);
        roof roof4 = new roof();
        addObject(roof4,785,61);
        roof4.setRotation(180);
        roof4.setLocation(779,9);
        enemy2.setLocation(786,44);
        roof4.setLocation(789,11);
        roof2.setLocation(346,15);
        roof3.setLocation(561,13);
        roof.setLocation(116,-5);
        enemy2.setLocation(753,147);
        removeObject(enemy2);
        enemy.setLocation(41,74);
        removeObject(roof);
        removeObject(enemy);
        addObject(roof,138,97);
        roof.setRotation(180);
        roof.setLocation(123,5);
        roof2.setLocation(267,55);
        roof.setLocation(213,16);
        roof2.setLocation(357,32);
        roof3.setLocation(570,35);
        roof4.setLocation(793,51);
        roof2.setLocation(355,32);
        roof.setLocation(117,47);
        platform.setLocation(341,545);
        platform.setLocation(440,539);
        Score score = new Score();
        addObject(score,70,615);
        Score score2 = new Score();
        addObject(score2,71,645);
        score.setLocation(73,614);
        removeObject(score);
        score2.setLocation(81,667);
        score2.setLocation(100,668);

        timebar timebar = new timebar();
        addObject(timebar,450,602);
        timebartext timebartext = new timebartext();
        addObject (timebartext,450,602);
        level level = new level();
        addObject(level,719,665);
        player player = new player();
        addObject(player,436,504);
        healthText healthText = new healthText();
        addObject(healthText,318,663);
        healthText.setLocation(316,669);
        level.setLocation(740,668);
        healthText.setLocation(304,666);
        healthText.setLocation(304,666);
        health health = new health();
        addObject(health,377,664);
        health.setLocation(372,666);
        health.setLocation(389,660);
    }
}
