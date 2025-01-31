import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    private GreenfootSound bgMusic = new GreenfootSound("happysong.wav");
    
    public TitleScreen()
    {    
        super(900, 600, 1);
        prepare();
        //bgMusic.playLoop();
        bgMusic.setVolume(50);
    }
    
    private void prepare(){
        Start start = new Start();
        Quit quit = new Quit();
        addObject(start, 250, 300);
        addObject(quit, 210, 400);
    }
}
