import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends World
{
    Pacifier1 pacifier1 = new Pacifier1();
    Pacifier2 pacifier2 = new Pacifier2();

    public Intro()
    {    
        super(900, 600, 1);
        //fillBackgroundWithSprite("grass.png");
        prepare();
    }
    
    public void act(){
        if(pacifier1.verifyCollisionPlayer()){
            Greenfoot.setWorld(new MyWorld("pink"));
        }else if(pacifier2.verifyCollisionPlayer()){
            Greenfoot.setWorld(new MyWorld("blue"));
        }
    }

    private void fillBackgroundWithSprite(String spriteName) {
        GreenfootImage sprite = new GreenfootImage(spriteName);
        sprite.scale(sprite.getWidth()*3, sprite.getHeight()*3);
        GreenfootImage background = new GreenfootImage(getWidth(), getHeight());

        int spriteWidth = sprite.getWidth();
        int spriteHeight = sprite.getHeight();

        for (int y = 0; y < getHeight(); y += spriteHeight) {
            for (int x = 0; x < getWidth(); x += spriteWidth) {
                background.drawImage(sprite, x, y);
            }
        }

        setBackground(background);
    }
    
    public void prepare(){
        Player player = new Player("pink");
        addObject(player, super.getWidth()/2, 500);
        Frog frog = new Frog();
        addObject(frog, super.getWidth()/2, super.getHeight()/2);
        ChatPacifier chatPacifier = new ChatPacifier();
        addObject(chatPacifier,630,220);
        addObject(pacifier1,250,400);
        pacifier1.setSpeed(0);
        addObject(pacifier2,650,400);
        pacifier2.setSpeed(0);
    }
}
