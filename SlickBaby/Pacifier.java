import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PAcifier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacifier extends Actor
{
    private int speed = 8;
    protected int damage;
    protected int timeToReload;
    
    public void act()
    {
        move(speed);
        if(verifyCollision() || isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    
    public int getTimeToReload(){
        return timeToReload;
    }
    
    public int getDamage(){
        return damage;
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public boolean verifyCollision(){
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if(enemy != null){
            enemy.takeDamage(damage);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean verifyCollisionPlayer(){
        Player player = (Player) getOneIntersectingObject(Player.class);
        if(player != null){
            return true;
        }else{
            return false;
        }
    }
}
