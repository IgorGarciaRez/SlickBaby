import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int speed;
    private int health;
    
    private GreenfootImage[] movingSprites = new GreenfootImage[2];
    
    private boolean direct = false;
    
    private int frameIndex = 0;
    private int animCounter = 0;
    private int animSpeed = 8;
    
    public Enemy(int speed){
        this.speed = speed;
        health = 2;
        initAnimationSprites();
    }
    
    public void act()
    {
        moveTowardsPlayer();
        setImage(movingSprites[animate()]);
        verifyCollision();
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    
    private void moveTowardsPlayer(){
        Player player = (Player) getWorld().getObjects(Player.class).get(0);
        if(player != null){
            int pX = player.getX();
            int pY = player.getY();
            int angle = (int) Math.toDegrees(Math.atan2(pY - getY(), pX - getX()));
            setRotation(angle);
            move(speed);
        }
    }
    
    public void verifyCollision(){
        Player player = (Player) getOneIntersectingObject(Player.class);
        if(player != null){
            player.dieSpider();
        }
    }
    
    public void takeDamage(int damage){
        health = health - damage;
        if(health <= 0){
            getWorld().removeObject(this);
        }
    }
    
    public int animate(){
        animCounter++;
        if (animCounter >= animSpeed) {
            animCounter = 0;
            frameIndex = (frameIndex + 1) % 2;
        }
        return frameIndex;
    }
    
    public void initAnimationSprites(){
        for(int i = 0; i < 2; i++){
            movingSprites[i] = new GreenfootImage("spider"+(i+1)+".png");
        }
    }
}
