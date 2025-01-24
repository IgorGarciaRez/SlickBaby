import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Quit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Quit extends Buttons
{
    public void act()
    {
        checkMouse();
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.stop();
        }
    }
}
