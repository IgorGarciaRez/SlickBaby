import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        prepare();
    }
    
    private void prepare(){
        Start start = new Start();
        Quit quit = new Quit();
        addObject(start, getWidth()/2, 400);
        addObject(quit, getWidth()/2, 500);
    }
    
    public void started(){
        
    }
    
    public void stopped(){
        
    }
}
