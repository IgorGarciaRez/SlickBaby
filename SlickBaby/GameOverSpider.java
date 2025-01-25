import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverSpider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverSpider extends World
{

    /**
     * Constructor for objects of class GameOverSpider.
     * 
     */
    public GameOverSpider()
    {    
        super(900, 600, 1);
        prepare();
    }
    
    private void prepare(){
        Restart restart = new Restart();
        Quit quit = new Quit();
        addObject(restart, getWidth()/2, 300);
        addObject(quit, getWidth()/2, 370);
    }
    
    public void started(){
        
    }
    
    public void stopped(){
        
    }
}
