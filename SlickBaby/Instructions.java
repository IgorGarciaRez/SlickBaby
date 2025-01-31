import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{    
    public Instructions()
    {    
        super(900, 600, 1); 
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new Intro());
        }
    }
}
