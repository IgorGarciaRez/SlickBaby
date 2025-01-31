import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons extends Actor
{
    private boolean mouseOver = false;
    private final int maxTransparency = 255;
    
    private GreenfootSound hover = new GreenfootSound("hover.wav");
    private boolean alreadyPlayed = false;
    private GreenfootSound click = new GreenfootSound("click.wav");
    
    public void checkMouse(){
        if(Greenfoot.mouseMoved(null)){
            mouseOver = Greenfoot.mouseMoved(this);
        }
        if(mouseOver){
            adjTrans(maxTransparency/2);
            if(!alreadyPlayed){
                hover.play();
                alreadyPlayed = true;
            }
        }else{
            adjTrans(maxTransparency);
            alreadyPlayed = false;
        }
    }
    
    public void checkClick(World world){
        if(Greenfoot.mouseClicked(this)){
            click.play();
            Greenfoot.setWorld(world);
        }
    }
    
    public void adjTrans(int adjust){
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(adjust);
        setImage(tempImage);
    }
}
