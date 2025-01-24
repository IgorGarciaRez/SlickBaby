import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        super(900, 600, 1);
        prepare();
    }
    
    private void prepare(){
        Restart restart = new Restart();
        Quit quit = new Quit();
        addObject(restart, getWidth()/2, 400);
        addObject(quit, getWidth()/2, 500);
    }
    
    public void started(){
        
    }
    
    public void stopped(){
        
    }
}
