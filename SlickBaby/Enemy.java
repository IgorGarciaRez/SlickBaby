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
    
    private boolean direct = false;
    
    public Enemy(int speed){
        this.speed = speed;
        health = 2;
    }
    
    public void act()
    {
        moveTowardsPlayer();
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
    
    public void takeDamage(int damage){
        health = health - damage;
        if(health <= 0){
            getWorld().removeObject(this);
        }
    }
}
