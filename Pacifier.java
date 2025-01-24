import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chupeta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacifier extends Actor
{
    private int speed;
    private int damage;
    
    public Pacifier(int s){
        speed = s;
        damage = 1;
    }
    
    public int getDamage(){
        return damage;
    }
    
    public int getSpeed(){
        return speed;
    }
    
    public void act()
    {
        move(speed);
        if(verifyCollision() || isAtEdge()){
            getWorld().removeObject(this);
        }
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
}
