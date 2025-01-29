import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frog extends Actor
{
    private GreenfootImage[] idle = new GreenfootImage[2];
    private int frameIndex = 0;
    private int animCounter = 0;
    private int animSpeed = 16;
    
    public Frog(){
        idle[0] = new GreenfootImage("frog1.png");
        idle[1] = new GreenfootImage("frog2.png");
    }
    
    public void act()
    {
        setImage(idle[animate()]);
    }
    
    public int animate(){
        animCounter++;
        if (animCounter >= animSpeed) {
            animCounter = 0;
            frameIndex = (frameIndex + 1) % 2;
        }
        return frameIndex;
    }
}
