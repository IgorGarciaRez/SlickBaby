import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Foot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pillow extends Actor
{
    private int size = 100;
    private int lifeTime = 50;
    
    private GreenfootImage[] animation = new GreenfootImage[3];
    
    private int frameIndex = 0;
    private int animCounter = 0;
    private int animSpeed = 4;
    
    private GreenfootSound sound = new GreenfootSound("stomp.wav");
    private boolean soundPlayed = false;
    
    public Pillow(){
        initAnimationSprites();
    }
    
    public void act()
    {
        if (!soundPlayed) {
            ((MyWorld) getWorld()).shake();
            sound.play();
            soundPlayed = true;
        }
        setImage(animation[animate()]);
        verifyCollision();
        lifeTime--;
        if(lifeTime <= 0){
            getWorld().removeObject(this);
        }
    }
    
    public void verifyCollision(){
        Player player = (Player) getOneIntersectingObject(Player.class);
        if(player != null){   
            player.diePillow();
        }
    }
    
    public void initAnimationSprites(){
        for(int i = 0; i < 3; i++){
            animation[i] = new GreenfootImage("pillow"+(i+1)+".png");
        }
    }
    
    public int animate(){
        animCounter++;
        if (animCounter >= animSpeed) {
            animCounter = 0;
            if(frameIndex < 2){
                frameIndex++;
            }else{
                return frameIndex;
            }
        }
        return frameIndex;
    }
}
