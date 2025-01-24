import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Foot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shadow extends Actor
{
    private int currentSize = 1;
    private int finalSize = 100;
    private Pillow foot;
    
    public void act()
    {
        if(currentSize < finalSize){
            currentSize+=2;
            updateSize();
        }else{
            updateToFoot();
        }
    }
    
    public void updateSize(){
        GreenfootImage img = new GreenfootImage(currentSize, currentSize);
        img.setColor(new Color(0, 0, 0, 128));
        img.fillOval(0, 0, currentSize, currentSize);
        setImage(img);
    }
    
    public void updateToFoot(){
        World world = getWorld();
        foot = new Pillow();
        world.addObject(new Pillow(), getX(), getY());
        world.removeObject(this);
    }
}
